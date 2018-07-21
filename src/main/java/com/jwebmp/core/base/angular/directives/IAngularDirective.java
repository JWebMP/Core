package com.jwebmp.core.base.angular.directives;

import java.io.Serializable;

/**
 * Service Locator for Angular Directives
 * <p>
 * Part of the change to compile all found directives, removing the need to register directives on events
 */
public interface IAngularDirective
		extends Serializable
{
	/**
	 * Returns the unique reference name of the directive
	 *
	 * @return
	 */
	String getReferenceName();

	/**
	 * Renders the function to be added to the angular auto-generated script
	 *
	 * @return
	 */
	String renderFunction();

	/**
	 * Returns any applicable sort order or 0 is assumed
	 *
	 * @return
	 */
	Integer getSortOrder();
}
