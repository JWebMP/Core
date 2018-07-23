package com.jwebmp.core.base.angular.services;

/**
 * Service Locator for Angular Directives
 * <p>
 * Part of the change to compile all found directives, removing the need to register directives on events
 */
public interface IAngularModule<J extends IAngularModule<J>>
		extends IAngularDefaultService<J>
{
	/**
	 * If this module is enabled by default
	 *
	 * @return
	 */
	default boolean enabled()
	{
		return true;
	}
}
