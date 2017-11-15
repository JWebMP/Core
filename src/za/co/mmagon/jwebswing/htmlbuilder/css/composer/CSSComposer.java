package za.co.mmagon.jwebswing.htmlbuilder.css.composer;

import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.ComponentStyleBase;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSImpl;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSPropertiesFactory;
import za.co.mmagon.jwebswing.htmlbuilder.css.enumarations.CSSTypes;
import za.co.mmagon.logger.LogFactory;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static za.co.mmagon.jwebswing.utilities.StaticStrings.*;

/**
 * This class specifically build CSS according to a JWebSwing component
 *
 * @author MMagon
 * @version 1.0
 * @since 07 Apr 2012
 */
public class CSSComposer
{

	protected static Logger log = LogFactory.getInstance().getLogger("CSSComposer");
	/**
	 * The block master instance
	 */
	private final CSSBlockMaster blockMaster;
	private final CSSPropertiesFactory<java.lang.annotation.Annotation> propertiesFactory;

	/**
	 * Constructs a new instance of this ComponentCSSComposer.
	 * <p>
	 * For best usage, have one composer per full page render. This will combine and merge CSS blocks to use less space
	 */
	public CSSComposer()
	{
		super();
		this.blockMaster = new CSSBlockMaster();
		this.propertiesFactory = new CSSPropertiesFactory<>();
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
			Set<ComponentHierarchyBase> comp = o.getChildrenHierarchy(true);
			Set<ComponentStyleBase> compti = new LinkedHashSet<>();

			comp.forEach(co ->
			             {
				             if (ComponentStyleBase.class.isAssignableFrom(co.getClass()))
				             {
					             ComponentStyleBase chb = ComponentStyleBase.class.cast(co);
					             compti.add(chb);
				             }
			             });

			compti.forEach(a -> addComponent(a, list).forEach(a2 ->
			                                                  {
				                                                  if (!list.contains(a2))
				                                                  {
					                                                  list.add(a2);
				                                                  }
			                                                  }));
		}
		else
		{
			addComponent(o, list);
		}

		list.forEach(getBlockMaster()::addBlock);
		return list;
	}

	public final List<CSSBlock> addComponent(ComponentStyleBase o)
	{
		return addComponent(o, new ArrayList<>());
	}

	/**
	 * Add a component to this object to render for
	 *
	 * @param o
	 * 		The component to render CSS for as well as this object
	 * @param componentBlocks
	 *
	 * @return True or False
	 */
	@SuppressWarnings("all")
	public final List<CSSBlock> addComponent(ComponentStyleBase o, List<CSSBlock> componentBlocks)
	{
		CSSBlock annotatedCssBlocks = getPropertiesFactory().getCSSBlock(o.getID(), CSSTypes.None, getPropertiesFactory().getCSS(o), CSSBlockIdentifier.Class);

		String output = annotatedCssBlocks.getCssLines().toString().replace(STRING_BRACES_OPEN, STRING_EMPTY).replace(STRING_BRACES_CLOSE, STRING_EMPTY);
		if (!output.isEmpty())
		{
			o.addClass(annotatedCssBlocks.getIdOfBlock());
			if (!componentBlocks.contains(annotatedCssBlocks))
			{
				componentBlocks.add(annotatedCssBlocks);
			}
		}


		Map<CSSTypes, CSSImpl> css = o.getCssTypeHashMap();
		List<CSSBlock> blocks = new ArrayList<>();
		css.forEach((key, value) ->
		            {
			            Map<StringBuilder, Object> typeCss = value.getMap();
			            CSSBlock declaredCssBlocks = propertiesFactory.getCSSBlock(o.getID() + key.getCssName(), key, typeCss, CSSBlockIdentifier.Id);
			            blocks.add(declaredCssBlocks);
		            });
		blocks.forEach(e ->
		               {
			               if (!componentBlocks.contains(e))
			               {
				               componentBlocks.add(e);
			               }
		               });

		List<Field> fields = new ArrayList<>(Arrays.asList(o.getClass().getDeclaredFields()));
		fields.forEach((Field field) ->
		               {
			               field.setAccessible(true);
			               Object fieldObject = null;
			               try
			               {
				               fieldObject = field.get(o);
			               }
			               catch (IllegalAccessException e)
			               {
				               log.log(Level.WARNING, "Unable to read field object " + field.getName(), e);
			               }
			               if (Objects.nonNull(fieldObject) && ComponentStyleBase.class.isAssignableFrom(fieldObject.getClass()))
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
	@NotNull
	public CSSBlockMaster getBlockMaster()
	{
		return blockMaster;
	}

	/**
	 * Properties factory builder
	 *
	 * @return
	 */
	@NotNull
	public CSSPropertiesFactory<java.lang.annotation.Annotation> getPropertiesFactory()
	{
		return propertiesFactory;
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
