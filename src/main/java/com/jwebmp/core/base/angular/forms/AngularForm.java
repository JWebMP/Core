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

package com.jwebmp.core.base.angular.forms;

import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.base.angular.AngularPageConfigurator;
import com.jwebmp.core.base.angular.modules.AngularMessagesModule;
import com.jwebmp.core.base.html.Form;
import com.jwebmp.core.base.html.Input;
import com.jwebmp.core.plugins.jquery.JQueryPageConfigurator;
import com.jwebmp.core.utilities.StaticStrings;

import javax.validation.constraints.NotNull;

/**
 * Attaches angular form control to a form tag for validation and constraints
 *
 * @param <J>
 * 		Always this object type
 */
@SuppressWarnings({"MissingClassJavaDoc", "UnusedReturnValue", "WeakerAccess", "unused"})
public class AngularForm<J extends AngularForm<J>>
		extends Form<J>
{
	/**
	 * The class to be used during success operations
	 */
	private String successClass;
	/**
	 * The class to be used for feedback success operations
	 */
	private String successFeedbackClass;
	/**
	 * The class to be used for the error class
	 */
	private String errorClass;
	/**
	 * The class for the error feedback text
	 */
	private String errorFeedbackClass;

	/**
	 * Constructs a new angular form tag
	 */
	public AngularForm()
	{
		JQueryPageConfigurator.setRequired(true);
		AngularPageConfigurator.setRequired(true);
		AngularMessagesModule.setMesssgesModuleEnabled(true);
	}

	/**
	 * Gets the success feedback classes
	 *
	 * @return the allocated success feedback
	 */
	public String getSuccessFeedbackClass()
	{
		return successFeedbackClass;
	}

	/**
	 * Sets the success feedback callback class
	 *
	 * @param successFeedbackClass
	 * 		the new class to apply
	 *
	 * @return this object
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSuccessFeedbackClass(String successFeedbackClass)
	{
		this.successFeedbackClass = successFeedbackClass;
		return (J) this;
	}

	/**
	 * Gets the error feedback class
	 *
	 * @return The error feedback class
	 */
	public String getErrorFeedbackClass()
	{
		return errorFeedbackClass;
	}

	/**
	 * Sets the error feedback classes
	 *
	 * @param errorFeedbackClass
	 * 		The error feedback class
	 *
	 * @return Always this object
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setErrorFeedbackClass(String errorFeedbackClass)
	{
		this.errorFeedbackClass = errorFeedbackClass;
		return (J) this;
	}

	/**
	 * Protected method to call when all inputs are available to apply the classes
	 *
	 * @return Always this object
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	protected J applyClassesToAngularMessages()
	{
		getChildrenHierarchy(true).forEach(a ->
		                                   {
			                                   if (Input.class.isAssignableFrom(a.getClass()))
			                                   {
				                                   Input input = (Input) a;
				                                   input.addAttribute(AngularAttributes.ngClass, buildValidationClass(input));
			                                   }
		                                   });
		return (J) this;
	}

	/**
	 * Builds the validation for the input
	 *
	 * @param input
	 * 		The input to build a validation for
	 *
	 * @return The generated validation class
	 */
	@NotNull
	public String buildValidationClass(@NotNull Input input)
	{
		return buildValidationClass(input, StaticStrings.STRING_EMPTY);
	}

	/**
	 * Builds the validation for the input
	 *
	 * @param input
	 * 		The input to build a validatoin for
	 *
	 * @return Any prepending classes to use
	 */
	@NotNull
	public String buildValidationClass(@NotNull Input input, String prependClass)
	{
		String finalOutput = "{";

		String formInputIdentifier = (prependClass.isEmpty() ? StaticStrings.STRING_EMPTY : StaticStrings.STRING_SPACE) + getID() + "." + input.getID() + ".";

		String errorOuput = prependClass + formInputIdentifier + "$invalid && " + formInputIdentifier + "$dirty && !" + formInputIdentifier + "$pristine";
		errorOuput = "'" + getErrorClass() + "':" + errorOuput + "";

		String successOutput = prependClass + getID() + "." + input.getID() + ".$valid && " + formInputIdentifier + "$dirty && !" + formInputIdentifier + "$pristine";
		successOutput = "'" + getSuccessClass() + "':" + successOutput + "";

		finalOutput += errorOuput + "," + successOutput + "}";

		return finalOutput;
	}

	/**
	 * Returns the error class for validation
	 *
	 * @return The error class
	 */
	public String getErrorClass()
	{
		return errorClass;
	}

	/**
	 * Method setErrorClass sets the errorClass of this AngularForm object.
	 * <p>
	 * The class to be used for the error class
	 *
	 * @param errorClass
	 * 		the errorClass of this AngularForm object.
	 *
	 * @return J
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setErrorClass(String errorClass)
	{
		this.errorClass = errorClass;
		return (J) this;
	}

	/**
	 * Gets the success class to use for validation
	 *
	 * @return The success class
	 */
	public String getSuccessClass()
	{
		return successClass;
	}

	/**
	 * Sets the success class to use for validation
	 *
	 * @param successClass
	 * 		The success class to use
	 *
	 * @return J
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSuccessClass(String successClass)
	{
		this.successClass = successClass;
		return (J) this;
	}

	/**
	 * Method hashCode ...
	 *
	 * @return int
	 */
	@SuppressWarnings("InconsistentJavaDoc")
	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	/**
	 * Method equals ...
	 *
	 * @param o
	 * 		of type Object
	 *
	 * @return boolean
	 */
	@SuppressWarnings("InconsistentJavaDoc")
	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}
}
