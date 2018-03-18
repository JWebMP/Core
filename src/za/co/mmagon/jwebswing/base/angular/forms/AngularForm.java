package za.co.mmagon.jwebswing.base.angular.forms;

import za.co.mmagon.jwebswing.base.angular.AngularAttributes;
import za.co.mmagon.jwebswing.base.angular.AngularPageConfigurator;
import za.co.mmagon.jwebswing.base.html.Form;
import za.co.mmagon.jwebswing.base.html.Input;
import za.co.mmagon.jwebswing.plugins.jquery.JQueryPageConfigurator;

import javax.validation.constraints.NotNull;

import static za.co.mmagon.jwebswing.utilities.StaticStrings.STRING_EMPTY;
import static za.co.mmagon.jwebswing.utilities.StaticStrings.STRING_SPACE;

public class AngularForm<J extends AngularForm<J>>
		extends Form<J>
{
	private String successClass;
	private String successFeedbackClass;
	private String errorClass;
	private String errorFeedbackClass;


	/**
	 * Constructs a new angular form tag
	 */
	public AngularForm()
	{
		setTag("ng-form");
		JQueryPageConfigurator.setRequired(true);
		AngularPageConfigurator.setRequired(true);
	}

	/**
	 * Gets the success feedback classes
	 *
	 * @return
	 */
	public String getSuccessFeedbackClass()
	{
		return successFeedbackClass;
	}

	/**
	 * Sets the success feedback callback class
	 *
	 * @param successFeedbackClass
	 *
	 * @return
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
	 * @return
	 */
	public String getErrorFeedbackClass()
	{
		return errorFeedbackClass;
	}

	/**
	 * Sets the error feedback classes
	 *
	 * @param errorFeedbackClass
	 *
	 * @return
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
	 * @return
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
	 *
	 * @return
	 */
	@NotNull
	protected String buildValidationClass(@NotNull Input input)
	{
		return buildValidationClass(input, STRING_EMPTY);
	}

	/**
	 * Builds the validation for the input
	 *
	 * @param input
	 *
	 * @return
	 */
	@NotNull
	protected String buildValidationClass(@NotNull Input input, String prependClass)
	{

		String finalOutput = "{";

		String formInputIdentifier = (prependClass.isEmpty() ? STRING_EMPTY : STRING_SPACE) + getID() + "." + input.getID() + ".";

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
	 * @return
	 */
	public String getErrorClass()
	{
		return errorClass;
	}

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
	 * @return
	 */
	public String getSuccessClass()
	{
		return successClass;
	}

	/**
	 * Sets the success class to use for validation
	 *
	 * @param successClass
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSuccessClass(String successClass)
	{
		this.successClass = successClass;
		return (J) this;
	}
}
