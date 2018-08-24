package com.jwebmp.core.services;

import com.jwebmp.core.Page;

/**
 * Designates an error page
 */
@SuppressWarnings("MissingClassJavaDoc")
@FunctionalInterface
public interface IErrorPage
{
	/**
	 * Renders the page
	 *
	 * @return The completed string to send back to the client
	 */
	@SuppressWarnings("unused")
	Page<?> renderPage(Throwable T);
}
