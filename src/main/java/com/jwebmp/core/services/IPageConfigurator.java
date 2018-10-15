package com.jwebmp.core.services;

import com.jwebmp.core.Page;
import com.jwebmp.guicedinjection.interfaces.IDefaultService;

import javax.validation.constraints.NotNull;

/**
 * A service for configuration built pages
 */
public interface IPageConfigurator<J extends IPageConfigurator<J>>
		extends IDefaultService<J>
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

	/**
	 * If this page configurator is enabled
	 *
	 * @return if the configuration must run
	 */
	boolean enabled();
}
