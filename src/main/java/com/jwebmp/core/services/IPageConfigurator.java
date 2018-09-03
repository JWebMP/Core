package com.jwebmp.core.services;

import com.jwebmp.core.Page;

import javax.validation.constraints.NotNull;
import java.util.Comparator;

/**
 * A service for configuration built pages
 */
public interface IPageConfigurator
		extends Comparator<IPageConfigurator>, Comparable<IPageConfigurator>
{
	/**
	 * Configures the given page for the parameters
	 *
	 * @param page
	 * 		The page incoming
	 *
	 * @return The original page incoming or a new page, never null
	 */
	@NotNull
	Page<?> configure(Page<?> page);

	@Override
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

	/**
	 * If this page configurator is enabled
	 *
	 * @return if the configuration must run
	 */
	boolean enabled();
}
