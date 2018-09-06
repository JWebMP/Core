package com.jwebmp.core.base.angular.forms;

import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.angular.forms.enumerations.InputErrorValidations;
import com.jwebmp.core.base.html.Form;
import com.jwebmp.core.base.html.inputs.InputEmailType;
import com.jwebmp.core.base.html.inputs.InputFileType;
import com.jwebmp.core.base.html.inputs.InputPasswordType;
import com.jwebmp.core.base.html.inputs.InputTextType;
import com.jwebmp.core.events.click.ClickAdapter;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import org.junit.jupiter.api.Test;

class AngularFormTest
{
	@Test
	void testMe()
	{
		AngularForm<?> form = new AngularForm<>();
		form.setNoValidate(true);

		form.setSuccessClass("supergreen")
		    .setErrorClass("superred");

		InputTextType itt = new InputTextType();
		form.add(itt);
		form.add(new AngularInputMessages(form, itt)
				         .addMessageDefault("This field is just errored", false)
				         .addMessage(InputErrorValidations.pattern, "Pattern wrong", false)
				         .addMessage(InputErrorValidations.min, "Min wrong", false)
				         .addMessage(InputErrorValidations.minLength, "Min Length wrong", false)
				         .addMessage(InputErrorValidations.date, "date invalid", false)
				         .addMessage(InputErrorValidations.maxlength, "date invalid", false)
		        );

		form.add(new InputEmailType());
		form.add(new InputPasswordType());

		form.applyClassesToAngularMessages();

		System.out.println(form.toString(0));
	}

	@Test
	void testBindings()
	{
		Form form = new Form<>();
		form.addDto("formVariable", new JavaScriptPart<>());

		InputTextType<?> bindable = new InputTextType<>();
		bindable.bind("formVariable.bindable");
		InputFileType<?> file = new InputFileType();
		file.bind("formVariable.file");

		form.add(bindable);
		form.add(file);

		System.out.println(form.toString(0));
	}

	class DataMapping
			extends JavaScriptPart<DataMapping>
	{
		private String bindable;
		private byte[] file;
	}

	class FormReader
			extends ClickAdapter
	{
		public FormReader()
		{
			this(null);
		}

		public FormReader(ComponentHierarchyBase component)
		{
			super(component);
			returnVariable("formVariable");
		}

		@Override
		public void onClick(AjaxCall call, AjaxResponse response)
		{
			DataMapping returnedForm = call.getVariable("formVariable")
			                               .as(DataMapping.class);

		}
	}
}
