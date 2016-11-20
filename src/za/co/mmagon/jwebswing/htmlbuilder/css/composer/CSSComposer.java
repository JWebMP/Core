package za.co.mmagon.jwebswing.htmlbuilder.css.composer;

import java.lang.reflect.*;
import java.util.*;
import org.apache.log4j.*;
import za.co.mmagon.*;
import za.co.mmagon.jwebswing.base.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.enumarations.*;

/**
 * This class specifically build CSS according to a JWebSwing component
 *
 * @author MMagon
 * @since 07 Apr 2012
 * @version 1.0
 */
public class CSSComposer
{

    protected static Logger log = LoggerFactory.getInstance().makeNewLoggerInstance("CSSComposer");
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
     */
    public void addComponent(ComponentStyleBase o, boolean includeChildren)
    {
        if (includeChildren)
        {
            List<ComponentHierarchyBase> comp = o.getChildrenHierarchy();
            ArrayList<ComponentStyleBase> compti = new ArrayList<>();
            comp.forEach(co ->
            {
                if (co.getClass().isAssignableFrom(ComponentHierarchyBase.class))
                {
                    ComponentStyleBase b = ComponentStyleBase.class.cast(co);
                    compti.add((ComponentStyleBase) co);
                }
            });

            compti.stream().forEach(this::addComponent);
        }
        else
        {
            addComponent(o);
        }
    }

    /**
     * Add a component to this object to render for
     *
     * @param o The component to render CSS for as well as this object
     * @return True or False
     */
    public final boolean addComponent(ComponentStyleBase o)
    {
        CSSBlock annotatedCssBlocks = propertiesFactory.getCSSBlock(o.getID(), CSSTypes.None, propertiesFactory.getCSS(o), CSSBlockIdentifier.Id);
        getBlockMaster().addBlock(annotatedCssBlocks);
        
        
        Map<CSSTypes, CSSImpl> css = o.getCssTypeHashMap();
        css.entrySet().stream().map(entry ->
        {
            CSSTypes key = entry.getKey();
            CSSImpl value = entry.getValue();
            CSSBlock declaredCssBlocks = propertiesFactory.getCSSBlock(key.getCssName(), key, propertiesFactory.getCSS(value),CSSBlockIdentifier.Class);
            return declaredCssBlocks;
        }).forEachOrdered(getBlockMaster()::addBlock);
        for (Field field : o.getClass().getDeclaredFields())
        {
            try
            {
                field.setAccessible(true);
                Object fieldObject = field.get(o);
                if (fieldObject == null)
                {
                    continue;
                }
                if ((fieldObject) instanceof ComponentStyleBase)
                {
                    ComponentStyleBase c = (ComponentStyleBase) fieldObject;
                    CSSBlock newFieldBlock = propertiesFactory.getCSSBlock(c.getID(), CSSTypes.None, propertiesFactory.getCSS(field, o), CSSBlockIdentifier.Id);
                    newFieldBlock.setBlockIdentifer(CSSBlockIdentifier.Id);
                    blockMaster.addBlock(newFieldBlock);
                }
            }
            catch (IllegalArgumentException | IllegalAccessException ex)
            {
                log.trace(ex);
            }
        }
        return true;
    }

    /**
     * Returns the block master handler
     *
     * @return
     */
    public CSSBlockMaster getBlockMaster()
    {
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
     * Output the CSS Blocks rendered.
     * Updates all block pretty print value to the page instance Tiny HTML
     *
     * @return
     */
    @Override
    public String toString()
    {
        StringBuilder cssScript = new StringBuilder();
        List<CSSBlock> allCurrentBlocks = getBlockMaster().getAllCSSBlocks();
        allCurrentBlocks.stream().forEach((block)
                ->
        {
            String script = block.toString();
            if (!(script == null || script.trim().isEmpty()))
            {
                cssScript.append(block);
            }
        });
        return cssScript.toString();
    }
}
