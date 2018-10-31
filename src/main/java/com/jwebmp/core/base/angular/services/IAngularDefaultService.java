package com.jwebmp.core.base.angular.services;

import com.jwebmp.guicedinjection.interfaces.IDefaultService;

public interface IAngularDefaultService<J extends IAngularDefaultService<J>>
		extends IDefaultService<J>
{
	/**
	 * Returns the unique reference name of the directive
	 *
	 * @return The given reference name
	 */
	String getReferenceName();

	/**
	 * Renders the function to be added to the angular auto-generated script
	 *
	 * @return The given rendering function
	 */
	String renderFunction();

	@Override
	default int compareTo(J o)
	{
		if (o == null)
		{
			return -1;
		}
		if (getClass().equals(o.getClass()))
		{
			return 0;
		}
		int result = sortOrder().compareTo(o.sortOrder());
		return result == 0 ? 1 : result;
	}

}
