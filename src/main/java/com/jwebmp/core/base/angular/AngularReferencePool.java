/*
 * Copyright (C) 2017 Marc Magon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.core.base.angular;

import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.base.references.JavascriptReference;
import com.jwebmp.core.base.servlets.enumarations.RequirementsPriority;

/**
 * The base angular JavaScript references
 *
 * @author GedMarc
 * @since 16 Apr 2016
 */
public enum AngularReferencePool
{
	Angular1(new JavascriptReference("Angular1", 1.68, "bower_components/angular/angular.min.js", "https://ajax.googleapis.com/ajax/libs/angularjs/1.6.8/angular.min.js", 6), null,
	         5),
	Angular1Sanitize(
			new JavascriptReference("Angular1Sanitize", 1.55, "javascript/angular/angular.js", "https://ajax.googleapis.com/ajax/libs/angularjs/1.6.8/angular-sanitize.js", 5),
			null, 5),
	Angular1Events(new JavascriptReference("Angular1Events", 1.0, "javascript/jwebswing/jwangular.js", 5), null, 5),
	Angular1NGMessages(new JavascriptReference("Angular1Messages", 1.0, "bower_components/angular-messages/angular-messages.min.js",
	                                           "https://ajax.googleapis.com/ajax/libs/angularjs/1.6.8/angular-messages.js", 7), null, 6),

	AngularDynamicScript(new JavascriptReference("AngularDynamicScript", 1.0, "as", 5), null, 5),
	Angular2RX(new JavascriptReference("Angular2RX", 2.0, "javascript/angular/Rx.js", "https://cdnjs.cloudflare.com/ajax/libs/angular.js/2.0.0-beta.15/Rx.umd.js", 5), null, 5),
	Angular2Polyfills(new JavascriptReference("Angular2Polyfills", 2.0, "javascript/angular/angular2-polyfills.js",
	                                          "https://cdnjs.cloudflare.com/ajax/libs/angular.js/2.0.0-beta.15/angular2-polyfills.js", 8), null, 5),
	Angular2AllUMD(
			new JavascriptReference("Angular2", 2.0, "javascript/angular/angular2.sfx.js", "https://cdnjs.cloudflare.com/ajax/libs/angular.js/2.0.0-beta.15/angular2-all.umd.js",
			                        12), null, 5),;

	/**
	 * The JS Reference
	 */
	private JavascriptReference jsReference;
	/**
	 * The CSS Reference
	 */
	private CSSReference cssReferece;
	/**
	 * The applicable sort order
	 */
	private int sortOrder;

	/**
	 * Constructs with the given new values. no null allowed
	 *
	 * @param jsReference
	 * @param cssReferece
	 * @param sortOrder
	 */
	AngularReferencePool(JavascriptReference jsReference, CSSReference cssReferece, int sortOrder)
	{
		this.jsReference = jsReference;
		this.jsReference.setPriority(RequirementsPriority.Fourth);
		this.cssReferece = cssReferece;
		this.sortOrder = sortOrder;
	}

	/**
	 * Returns the JavaScript Reference
	 *
	 * @return
	 */
	public JavascriptReference getJavaScriptReference()
	{
		return jsReference;
	}

	/**
	 * Sets the JavaScript reference
	 *
	 * @param jsReference
	 */
	public void setJavaScriptReference(JavascriptReference jsReference)
	{
		this.jsReference = jsReference;
	}

	/**
	 * Gets the CSS Reference
	 *
	 * @return
	 */
	public CSSReference getCssReferece()
	{
		return cssReferece;
	}

	/**
	 * Sets the CSS Reference
	 *
	 * @param cssReferece
	 */
	public void setCssReferece(CSSReference cssReferece)
	{
		this.cssReferece = cssReferece;
	}

	/**
	 * Gets the references sort order
	 *
	 * @return
	 */
	public int getSortOrder()
	{
		return sortOrder;
	}

	/**
	 * Sets the references sort order
	 *
	 * @param sortOrder
	 */
	public void setSortOrder(int sortOrder)
	{
		this.sortOrder = sortOrder;
	}

}
