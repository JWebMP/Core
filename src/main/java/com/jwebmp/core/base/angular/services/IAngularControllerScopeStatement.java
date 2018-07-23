package com.jwebmp.core.base.angular.services;

/**
 * Service Locator for Angular Directives
 * <p>
 * Part of the change to compile all found directives, removing the need to register directives on events
 */
public interface IAngularControllerScopeStatement<J extends IAngularControllerScopeStatement<J>>
		extends IAngularDefaultService<J>
{
	/**
	 * Returns the given statement
	 *
	 * @return The string builder containing the statement
	 */
	StringBuilder getStatement();

}
