package za.co.mmagon.jwebswing.base.angular.forms;

import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.angular.AngularAttributes;
import za.co.mmagon.jwebswing.base.angular.AngularPageConfigurator;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.Form;
import za.co.mmagon.jwebswing.base.html.Input;
import za.co.mmagon.jwebswing.base.html.Span;
import za.co.mmagon.jwebswing.base.html.attributes.FormAttributes;
import za.co.mmagon.jwebswing.base.html.attributes.InputTypes;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.events.submit.SubmitAdapter;
import za.co.mmagon.jwebswing.generics.TopOrBottom;
import za.co.mmagon.jwebswing.plugins.jquery.JQueryPageConfigurator;
import za.co.mmagon.jwebswing.utilities.StaticStrings;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

import static za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes.Type;

public class AngularForm<J extends AngularForm<J>> extends Form<J>
{
	/**
	 * Constructs a new angular form tag
	 */
	public AngularForm()
	{
		setTag("ng-form");
		addAttribute(FormAttributes.NoValidate, StaticStrings.STRING_EMPTY);
		JQueryPageConfigurator.setRequired(true);
		AngularPageConfigurator.setRequired(true);
		AngularPageConfigurator.setAngularMessagesRequired(true);
	}

	@SuppressWarnings("unchecked")
	@NotNull
	public Div addInput(@NotNull Input inputComponent, AngularInputMessages messages)
	{
		return addInput(inputComponent, messages, false);
	}

	@SuppressWarnings("unchecked")
	@NotNull
	public Div addInput(@NotNull Input inputComponent, AngularInputMessages messages, boolean onBlur)
	{
		return addInput(inputComponent, messages, onBlur, null);
	}

	@SuppressWarnings("unchecked")
	@NotNull
	public Div addInput(@NotNull Input inputComponent, AngularInputMessages messages, boolean onBlur, @Nullable TopOrBottom topOrBottom)
	{
		Div inputDiv = new Div();
		if (topOrBottom == TopOrBottom.Top)
		{
			inputDiv.add(messages);
		}

		if (topOrBottom == null)
		{
			Span inline = new Span();
			inline.add(inputComponent);
			inline.add(messages);
			messages.setTag(ComponentTypes.Span.getComponentTag());
			for (Object o : messages.getChildren())
			{
				ComponentHierarchyBase c = (ComponentHierarchyBase) o;
				c.setTag(ComponentTypes.Span.getComponentTag());
			}
			add(inline);
		}
		else
		{
			inputDiv.add(inputComponent);
			add(inputDiv);
		}
		if (topOrBottom == TopOrBottom.Bottom)
		{
			inputDiv.add(messages);
		}
		if (onBlur)
		{
			inputComponent.addAttribute(AngularAttributes.ngModelOptions, "{updateOn:'blur'}");
		}
		return inputDiv;
	}


	@SuppressWarnings("unchecked")
	@NotNull
	public J addInputGroup(@NotNull Input inputComponent, AngularInputMessages messages, boolean onBlur)
	{
		return (J) this;
	}

	/**
	 * Sets the tag to input and the type to submit,
	 *
	 * @param submitButton
	 * @param onSubmit
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J addSubmitEvent(ComponentHierarchyBase submitButton, SubmitAdapter onSubmit)
	{
		submitButton.setTag(ComponentTypes.Input.getComponentTag());
		submitButton.addAttribute(Type, InputTypes.Submit.toString());
		addEvent(onSubmit);
		add(submitButton);
		return (J) this;
	}
}
