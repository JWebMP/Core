package com.jwebmp.core.services;

import com.jwebmp.core.Page;

import java.util.Comparator;

/**
 * A service for configuration built pages
 */
public interface IPageConfigurator
		extends Comparator<IPageConfigurator>, Comparable<IPageConfigurator>
{
	Page<?> configure(Page<?> page);

	default int compare(IPageConfigurator o1, IPageConfigurator o2)
	{
		return o1.sortOrder()
		         .compareTo(o2.sortOrder());
	}

	/**
	 * Sort order for startup, Default 100.
	 *
	 * @return the sort order never null
	 */
	default Integer sortOrder()
	{
		return 100;
	}

	@Override
	default int compareTo(IPageConfigurator o)
	{
		if (o == null)
		{
			return -1;
		}
		int result = sortOrder().compareTo(o.sortOrder());
		if (getClass().equals(o.getClass()))
		{
			return 0;
		}
		return result == 0 ? 1 : result;
	}

}
