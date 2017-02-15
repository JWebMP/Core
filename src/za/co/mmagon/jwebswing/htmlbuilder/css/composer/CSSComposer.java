package za.co.mmagon.jwebswing.htmlbuilder.css.composer;

import java.lang.reflect.Field;
import java.util.*;
import java.util.logging.Logger;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.ComponentStyleBase;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSImpl;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSPropertiesFactory;
import za.co.mmagon.jwebswing.htmlbuilder.css.enumarations.CSSTypes;
import za.co.mmagon.jwebswing.utilities.ComponentUtils;
import za.co.mmagon.logger.LogFactory;

/**
 * This class specifically build CSS according to a JWebSwing component
 *
 * @author MMagon
 * @since 07 Apr 2012
 * @version 1.0
 */
public class CSSComposer
{

    protected static Logger log = LogFactory.getInstance().getLogger("CSSComposer");
    private CSSBlockMaster blockMaster;
    private CSSPropertiesFactory propertiesFactory;

    /**
     * Constructs a new instance of this ComponentCSSComposer.
     * <p>
     * For best usage, have one composer per full page render. This will combine and merge CSS blocks to use less space
     */
    public CSSComposer()
    {
        super();
        this.blockMaster = new CSSBlockMaster();
        this.propertiesFactory = new CSSPropertiesFactory();
    }

    /**
     * Adds a component to be registered with the block master
     *
     * @param o
     * @param includeChildren
     *
     * @return
     */
    public List<CSSBlock> addComponent(ComponentStyleBase o, boolean includeChildren)
    {
        ArrayList<CSSBlock> list = new ArrayList<>();
        if (includeChildren)
        {
            List<ComponentHierarchyBase> comp = o.getChildrenHierarchy(true);
            ArrayList<ComponentStyleBase> compti = new ArrayList<>();
            comp.stream().filter(a -> a != null).forEach(co ->
            {
                if (ComponentStyleBase.class.isAssignableFrom(co.getClass()))
                {
                    ComponentStyleBase chb = ComponentStyleBase.class.cast(co);
                    if (!compti.contains(chb))
                    {
                        compti.add(chb);
                    }
                }
            });
            compti.stream().forEach(a ->
            {
                addComponent(a, list).stream().forEach(a2 ->
                {
                    if (!list.contains(a2))
                    {
                        list.add(a2);
                    }
                });

            });
        }
        else
        {
            addComponent(o, list);
        }

        list.forEach(getBlockMaster()::addBlock);
        return list;
    }

    public final ArrayList<CSSBlock> addComponent(ComponentStyleBase o)
    {
        return addComponent(o, new ArrayList());
    }

    /**
     * Add a component to this object to render for
     *
     * @param o               The component to render CSS for as well as this object
     * @param componentBlocks
     *
     * @return True or False
     */
    public final ArrayList<CSSBlock> addComponent(ComponentStyleBase o, ArrayList<CSSBlock> componentBlocks)
    {
        CSSBlock annotatedCssBlocks = getPropertiesFactory().getCSSBlock(o.getID(), CSSTypes.None, getPropertiesFactory().getCSS(o), CSSBlockIdentifier.Class);
        String output = annotatedCssBlocks.getCssLines().toString().replace("{", "").replace("}", "");
        if (!output.isEmpty())
        {
            o.addClass(annotatedCssBlocks.getIdOfBlock());
            if (!componentBlocks.contains(annotatedCssBlocks))
            {
                componentBlocks.add(annotatedCssBlocks);
            }
        }
        Map<CSSTypes, CSSImpl> css = o.getCssTypeHashMap();
        css.entrySet().stream().map(entry ->
        {
            CSSTypes key = entry.getKey();
            CSSImpl value = entry.getValue();
            CSSBlock declaredCssBlocks = getPropertiesFactory().getCSSBlock(o.getID() + key.getCssName(), key, getPropertiesFactory().getCSS(value), CSSBlockIdentifier.Id);
            return declaredCssBlocks;
        }).forEachOrdered(e ->
        {
            if (!componentBlocks.contains(e))
            {
                componentBlocks.add(e);
            }
        });

        ArrayList<Field> fields = new ArrayList<>(Arrays.asList(o.getClass().getDeclaredFields()));
        fields.stream().filter(a -> ComponentUtils.fieldGet(a, o) != null).forEach((Field field) ->
        {
            field.setAccessible(true);
            Object fieldObject = ComponentUtils.fieldGet(field, o);
            if (ComponentStyleBase.class.isAssignableFrom(fieldObject.getClass()))
            {
                ComponentStyleBase c = (ComponentStyleBase) fieldObject;
                CSSBlock newFieldBlock = getPropertiesFactory().getCSSBlock(c.getID(), CSSTypes.None, getPropertiesFactory().getCSS(field, o), CSSBlockIdentifier.Id);
                newFieldBlock.setBlockIdentifer(CSSBlockIdentifier.Id);
                componentBlocks.add(newFieldBlock);
            }
        });

        componentBlocks.forEach(getBlockMaster()::addBlock);

        return componentBlocks;

    }

    /**
     * Returns the block master handler
     *
     * @return
     */
    public CSSBlockMaster getBlockMaster()
    {
        if (blockMaster == null)
        {
            this.blockMaster = new CSSBlockMaster();
        }
        return blockMaster;
    }

    /**
     * Sets the block master to a new master
     *
     * @param blockMaster
     */
    public void setBlockMaster(CSSBlockMaster blockMaster)
    {
        this.blockMaster = blockMaster;
    }

    /**
     * Properties factory builder
     *
     * @return
     */
    public CSSPropertiesFactory getPropertiesFactory()
    {
        if (propertiesFactory == null)
        {
            propertiesFactory = new CSSPropertiesFactory();
        }
        return propertiesFactory;
    }

    /**
     * Properties factory builder
     *
     * @param propertiesFactory
     */
    public void setPropertiesFactory(CSSPropertiesFactory propertiesFactory)
    {
        this.propertiesFactory = propertiesFactory;
    }

    /**
     * Output the CSS Blocks rendered. Updates all block pretty print value to the page instance Tiny HTML
     *
     * @return
     */
    @Override
    public String toString()
    {
        return getBlockMaster().toString();
    }
}
