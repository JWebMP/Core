package com.jwebmp.core.services;

import com.guicedee.guicedinjection.interfaces.IDefaultService;
import com.jwebmp.core.Page;

/**
 * Designates an error page
 */
@SuppressWarnings("MissingClassJavaDoc")
@FunctionalInterface
public interface IErrorPage extends IDefaultService<IErrorPage>
{
	/**
	 * Renders the page
	 *
	 * @return The completed string to send back to the client
	 */
	@SuppressWarnings("unused")
	Page<?> renderPage(Throwable T);
}
