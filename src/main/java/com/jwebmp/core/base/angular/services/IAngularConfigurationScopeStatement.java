package com.jwebmp.core.base.angular.services;

/**
 * Service Locator for Angular Directives
 * <p>
 * Part of the change to compile all found directives, removing the need to register directives on events
 */
public interface IAngularConfigurationScopeStatement<J extends IAngularConfigurationScopeStatement<J>>
		extends IAngularDefaultService<J>
{
	StringBuilder getStatement();
}
