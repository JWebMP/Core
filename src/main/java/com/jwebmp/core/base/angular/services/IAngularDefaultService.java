package com.jwebmp.core.base.angular.services;

import java.util.Comparator;

public interface IAngularDefaultService<J extends IAngularDefaultService<J>>
		extends Comparable<J>, Comparator<J>
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

	default int compare(J o1, J o2)
	{
		return o1.getSortOrder()
		         .compareTo(o2.getSortOrder());
	}

	/**
	 * Returns any applicable sort order or 0 is assumed
	 *
	 * @return The sort order
	 */
	default Integer getSortOrder()
	{
		return 100;
	}

	default int compareTo(J o)
	{
		if (o == null)
		{
			return -1;
		}
		return getSortOrder().compareTo(o.getSortOrder());
	}

}
