package com.jwebmp.htmlbuilder.css.composer;

import com.jwebmp.base.ComponentHierarchyBase;
import com.jwebmp.base.ComponentStyleBase;
import com.jwebmp.htmlbuilder.css.CSSImpl;
import com.jwebmp.htmlbuilder.css.CSSPropertiesFactory;
import com.jwebmp.htmlbuilder.css.enumarations.CSSTypes;
import com.jwebmp.logger.LogFactory;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.jwebmp.utilities.StaticStrings.*;

/**
 * This class specifically build CSS according to a JWebSwing component
 *
 * @author MMagon
 * @version 1.0
 * @since 07 Apr 2012
 */
public class CSSComposer
{

	protected static Logger log = LogFactory.getInstance()
	                                        .getLogger("CSSComposer");
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
		blockMaster = new CSSBlockMaster();
		propertiesFactory = new CSSPropertiesFactory<>();
	}

	/**
	 * Adds a component to be registered with the block master
	 *
	 * @param o
	 * @param includeChildren
	 *
	 * @return
	 */
	public Set<CSSBlock> addComponent(ComponentHierarchyBase o, boolean includeChildren)
	{
		Set<CSSBlock> list = new HashSet<>();
		if (includeChildren)
		{
			Set<ComponentHierarchyBase> comp = o.getChildrenHierarchy(true);
			comp.forEach(co ->
			             {
				             if (ComponentHierarchyBase.class.isAssignableFrom(co.getClass()))
				             {
					             ComponentHierarchyBase chb = ComponentHierarchyBase.class.cast(co);
					             addComponent(chb, list);
				             }
			             });
		}
		else
		{
			addComponent(o, list);
		}

		list.forEach(getBlockMaster()::addBlock);
		return list;
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
	public final Set<CSSBlock> addComponent(ComponentHierarchyBase o, Set<CSSBlock> componentBlocks)
	{
		CSSBlock annotatedCssBlocks = getPropertiesFactory().getCSSBlock(o.getID(), CSSTypes.None, getPropertiesFactory().getCSS(o), CSSBlockIdentifier.Class);

		String output = annotatedCssBlocks.getCssLines()
		                                  .toString()
		                                  .replace(STRING_BRACES_OPEN, STRING_EMPTY)
		                                  .replace(STRING_BRACES_CLOSE, STRING_EMPTY);
		if (!output.isEmpty())
		{
			o.addClass(annotatedCssBlocks.getIdOfBlock());
			if (!componentBlocks.contains(annotatedCssBlocks))
			{
				componentBlocks.add(annotatedCssBlocks);
			}
		}

		if (ComponentStyleBase.class.isAssignableFrom(o.getClass()))
		{
			ComponentStyleBase csb = (ComponentStyleBase) o;
			Map<CSSTypes, CSSImpl> css = csb.getCssTypeHashMap();
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
		}

		List<Field> fields = new ArrayList<>(Arrays.asList(o.getClass()
		                                                    .getDeclaredFields()));
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
			               if (Objects.nonNull(fieldObject) && ComponentHierarchyBase.class.isAssignableFrom(fieldObject.getClass()))
			               {
				               ComponentHierarchyBase c = (ComponentHierarchyBase) fieldObject;
				               CSSBlock newFieldBlock = getPropertiesFactory().getCSSBlock(c.getID(), CSSTypes.None, getPropertiesFactory().getCSS(field, o),
				                                                                           CSSBlockIdentifier.Id);
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

	public final Set<CSSBlock> addComponent(ComponentHierarchyBase o)
	{
		return addComponent(o, new LinkedHashSet<>());
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
