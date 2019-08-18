/*
 * Copyright (C) 2017 GedMarc
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
package com.jwebmp.core.base.servlets.interfaces;

import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.base.references.JavascriptReference;

import java.io.Serializable;

/**
 * @author GedMarc
 * @since Oct 24, 2016
 */
public interface IReferencePool<J extends IReferencePool<J>>
		extends Serializable
{

	/**
	 * Gets the CSS Reference
	 * <p>
	 *
	 * @return
	 */
	CSSReference getCssReference();

	/**
	 * Sets the CSS Reference
	 * <p>
	 *
	 * @param cssReference
	 */
	void setCssReference(CSSReference cssReference);

	/**
	 * Gets the JavaScript reference
	 * <p>
	 *
	 * @return
	 */
	JavascriptReference getJavaScriptReference();

	/**
	 * Sets the JavaScript reference
	 * <p>
	 *
	 * @param javaScriptReference
	 */
	void setJavaScriptReference(JavascriptReference javaScriptReference);

}
