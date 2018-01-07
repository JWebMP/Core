package za.co.mmagon.jwebswing.base.angular.forms;

import za.co.mmagon.jwebswing.base.angular.forms.enumerations.InputErrorValidations;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.DivSimple;
import za.co.mmagon.jwebswing.base.html.Form;
import za.co.mmagon.jwebswing.base.html.Input;

import javax.validation.constraints.NotNull;

import static za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes.Name;
import static za.co.mmagon.jwebswing.utilities.StaticStrings.STRING_DOT;

/**
 * Default angular messages div
 * <p>
 * https://docs.angularjs.org/api/ngMessages/directive/ngMessages
 *
 * @param <J>
 */
public class AngularInputMessages<J extends AngularInputMessages<J>> extends DivSimple<J>
{
	/**
	 * Constructs a new angular block for the given inputFields and Names
	 *
	 * @param formToApply
	 * 		The form to apply to
	 * @param formInputName
	 * 		The name applied to the input field (attribute name)
	 */
	public AngularInputMessages(Form formToApply, Input formInputName)
	{
		addAttribute("ng-messages", formToApply.getID() +
				                            STRING_DOT + formInputName.getAttribute(Name) +
				                            STRING_DOT +
				                            "$error");
		addAttribute("role", "alert");
		setRenderIDAttibute(false);
	}

	/**
	 * Adds a message for the given error form
	 *
	 * @param forError
	 * @param message
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J addMessage(@NotNull InputErrorValidations forError, String message)
	{
		Div d = new Div();
		d.setRenderIDAttibute(false);
		d.addAttribute("ng-message", forError.toString());
		d.setText(message);
		add(d);
		return (J) this;
	}
}
