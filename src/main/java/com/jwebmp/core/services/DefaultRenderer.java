package com.jwebmp.core.services;

import com.jwebmp.core.Page;

import java.util.Comparator;

/**
 * Default implementation for renderers
 *
 * @param <J>
 * 		A default render type for tree sorting etc
 */
public interface DefaultRenderer<J extends DefaultRenderer<J>>
		extends Comparator<J>, Comparable<J>
{
	/**
	 * Renders for the given page
	 *
	 * @return The generated string
	 */
	StringBuilder render(Page<?> page);

	/**
	 * Method compareTo ...
	 *
	 * @param object
	 * 		of type J
	 *
	 * @return int
	 */
	@Override
	default int compareTo(J object)
	{
		if (getClass().equals(object.getClass()))
		{
			return 0;
		}
		int result = sortOrder().compareTo(object.sortOrder());
		if (result == 0)
		{
			return 1;
		}
		return result;
	}

	/**
	 * Method sortOrder ...
	 *
	 * @return Long default 100
	 */
	default Long sortOrder()
	{
		return 100L;
	}

	/**
	 * Method compare ...
	 *
	 * @param o1
	 * 		of type J
	 * @param o2
	 * 		of type J
	 *
	 * @return int
	 */
	@Override
	default int compare(J o1, J o2)
	{
		if (o1 == null && o2 == null)
		{
			return -1;
		}
		return o1.sortOrder()
		         .compareTo(o2.sortOrder());
	}

}
