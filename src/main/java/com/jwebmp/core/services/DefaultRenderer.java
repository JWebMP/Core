package com.jwebmp.core.services;

import com.guicedee.guicedinjection.interfaces.IDefaultService;
import com.jwebmp.core.Page;

import java.util.Comparator;

/**
 * Default implementation for renderers
 *
 * @param <J>
 * 		A default render type for tree sorting etc
 */
@FunctionalInterface
public interface DefaultRenderer<J extends DefaultRenderer<J>>
		extends IDefaultService<J>
{
	/**
	 * Renders for the given page
	 *
	 * @return The generated string
	 */
	StringBuilder render(Page<?> page);
}
