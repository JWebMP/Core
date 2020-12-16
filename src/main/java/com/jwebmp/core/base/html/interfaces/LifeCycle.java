package com.jwebmp.core.base.html.interfaces;

/**
 * LifeCycle implementation of the given object
 */
public interface LifeCycle
{
	/**
	 * Initializes
	 */
	void init();

	/**
	 * Preconfigures
	 */
	void preConfigure();

	/**
	 * Is Configured
	 *
	 * @return if it is configured
	 */

	boolean isConfigured();

	/**
	 * If it is initialized
	 *
	 * @return if the component has been initialized
	 */
	boolean isInitialized();

	/**
	 * What happens on destroy
	 */
	void destroy();
}
