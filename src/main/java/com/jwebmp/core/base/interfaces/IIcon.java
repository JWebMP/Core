package com.jwebmp.core.base.interfaces;

import com.jwebmp.core.base.ComponentHierarchyBase;

/**
 * Interface that denotes the type of Icon
 */
public interface IIcon<J extends IIcon<J>>
{
	/**
	 * If the string class or a component should be used.
	 * Determined is string class is null
	 *
	 * @return
	 */
	default boolean isCssClass()
	{
		return getClassName() == null;
	}

	/**
	 * A class name to be applied
	 *
	 * @return
	 */
	String getClassName();

	/**
	 * A component to render that is the actual icon
	 *
	 * @return
	 */
	ComponentHierarchyBase getIconComponent();
}
