package za.co.mmagon.jwebswing.base.angular.forms;

import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.angular.AngularPageConfigurator;
import za.co.mmagon.jwebswing.base.angular.forms.enumerations.InputErrorValidations;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.InputTextType;
import za.co.mmagon.jwebswing.generics.TopOrBottom;
import za.co.mmagon.jwebswing.plugins.jquery.JQueryPageConfigurator;

class AngularFormTest
{
	@Test
	public void testAForm()
	{
		AngularForm form = new AngularForm();
		InputTextType textInput = new InputTextType();
		form.addInput(textInput, new AngularInputMessages(form, textInput)
				                         .addMessage(InputErrorValidations.required, "Required Test")
				                         .addMessage(InputErrorValidations.max, "Max Test")
				                         .addMessage(InputErrorValidations.maxlength, "Max LengthTest")
				, true, TopOrBottom.Top);
		System.out.println(form.toString(0));


		JQueryPageConfigurator.setRequired(false);
		AngularPageConfigurator.setRequired(false);
		AngularPageConfigurator.setAngularMessagesRequired(false);
	}

	@Test
	public void testAFormBottom()
	{
		AngularForm form = new AngularForm();
		InputTextType textInput = new InputTextType();
		form.addInput(textInput, new AngularInputMessages(form, textInput)
				                         .addMessage(InputErrorValidations.required, "Required Test")
				                         .addMessage(InputErrorValidations.max, "Max Test")
				                         .addMessage(InputErrorValidations.maxlength, "Max LengthTest")
				, true, TopOrBottom.Bottom);
		System.out.println(form.toString(0));

		JQueryPageConfigurator.setRequired(false);
		AngularPageConfigurator.setRequired(false);
		AngularPageConfigurator.setAngularMessagesRequired(false);
	}

	@Test
	public void testAFormNull()
	{
		AngularForm form = new AngularForm();
		InputTextType textInput = new InputTextType();
		form.addInput(textInput, new AngularInputMessages(form, textInput)
				                         .addMessage(InputErrorValidations.required, "Required Test")
				                         .addMessage(InputErrorValidations.max, "Max Test")
				                         .addMessage(InputErrorValidations.maxlength, "Max LengthTest")
				, true, null);
		System.out.println(form.toString(0));

		JQueryPageConfigurator.setRequired(false);
		AngularPageConfigurator.setRequired(false);
		AngularPageConfigurator.setAngularMessagesRequired(false);
	}

	@Test
	public void testAFormNullSubmitEvent()
	{
		AngularForm form = new AngularForm();
		InputTextType textInput = new InputTextType();
		form.addInput(textInput, new AngularInputMessages(form, textInput)
				                         .addMessage(InputErrorValidations.required, "Required Test")
				                         .addMessage(InputErrorValidations.max, "Max Test")
				                         .addMessage(InputErrorValidations.maxlength, "Max LengthTest")
				, true, null);

		textInput.addEvent(new AngularFormSubmitEvent(form));

		System.out.println(form.toString(0));

		JQueryPageConfigurator.setRequired(false);
		AngularPageConfigurator.setRequired(false);
		AngularPageConfigurator.setAngularMessagesRequired(false);
	}

	@Test
	public void testAFormBottomSubmitEvent()
	{
		AngularForm form = new AngularForm();
		InputTextType textInput = new InputTextType();
		form.addInput(textInput, new AngularInputMessages(form, textInput)
				                         .addMessage(InputErrorValidations.required, "Required Test")
				                         .addMessage(InputErrorValidations.max, "Max Test")
				                         .addMessage(InputErrorValidations.maxlength, "Max LengthTest")
				, true, TopOrBottom.Bottom);
		Div d = new Div();
		form.addSubmitEvent(d, new AngularFormSubmitEvent(form));

		System.out.println(form.toString(0));

		JQueryPageConfigurator.setRequired(false);
		AngularPageConfigurator.setRequired(false);
		AngularPageConfigurator.setAngularMessagesRequired(false);
	}

	@Test
	public void testAFormNullSubmitEventPage()
	{
		Page p = new Page();
		AngularForm form = new AngularForm();
		InputTextType textInput = new InputTextType();
		form.addInput(textInput, new AngularInputMessages(form, textInput)
				                         .addMessage(InputErrorValidations.required, "Required Test")
				                         .addMessage(InputErrorValidations.max, "Max Test")
				                         .addMessage(InputErrorValidations.maxlength, "Max LengthTest")
				, true, null);

		Div d = new Div();
		form.addSubmitEvent(d, new AngularFormSubmitEvent(form));
		p.add(form);

		System.out.println(p.toString(0));

		JQueryPageConfigurator.setRequired(false);
		AngularPageConfigurator.setRequired(false);
		AngularPageConfigurator.setAngularMessagesRequired(false);
	}
}
