package com.jwebmp.core.services;

import com.jwebmp.core.Page;
import com.guicedee.guicedinjection.interfaces.IDefaultService;
import com.guicedee.guicedinjection.interfaces.IServiceEnablement;

import javax.validation.constraints.NotNull;

/**
 * A service for configuration built pages
 */
public interface IPageConfigurator<J extends IPageConfigurator<J>>
		extends IDefaultService<J>, IServiceEnablement<J>
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
}
