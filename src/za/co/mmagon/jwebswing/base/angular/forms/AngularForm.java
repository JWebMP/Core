package za.co.mmagon.jwebswing.base.angular.forms;

import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.angular.AngularAttributes;
import za.co.mmagon.jwebswing.base.angular.AngularPageConfigurator;
import za.co.mmagon.jwebswing.base.html.Form;
import za.co.mmagon.jwebswing.base.html.Input;
import za.co.mmagon.jwebswing.base.html.Span;
import za.co.mmagon.jwebswing.base.html.attributes.FormAttributes;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.generics.TopOrBottom;
import za.co.mmagon.jwebswing.plugins.jquery.JQueryPageConfigurator;
import za.co.mmagon.jwebswing.utilities.StaticStrings;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

public class AngularForm<J extends AngularForm<J>>
		extends Form<J>
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
	}


	@SuppressWarnings("unchecked")
	@NotNull
	public ComponentHierarchyBase applyMessages(ComponentHierarchyBase formGroup, AngularInputMessages messages,
	                                            @Nullable TopOrBottom topOrBottom)
	{
		if (topOrBottom == TopOrBottom.Top)
		{
			formGroup.add(messages);
		}

		if (topOrBottom == null)
		{
			Span inline = new Span();
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
			add(formGroup);
		}
		if (topOrBottom == TopOrBottom.Bottom)
		{
			formGroup.add(messages);
		}
		return formGroup;
	}

	@SuppressWarnings("unchecked")
	@NotNull
	public J updateOnBlur(Input inputComponent)
	{
		inputComponent.addAttribute(AngularAttributes.ngModelOptions, "{updateOn:'blur'}");
		return (J) this;
	}


}
