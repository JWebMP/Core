package za.co.mmagon.jwebswing.base.html.interfaces;

import javax.validation.constraints.NotNull;

/**
 * An input type that designates a choice - checkbox/radio
 */
@FunctionalInterface
public interface InputChoiceType<J>
{
	@SuppressWarnings("unchecked")
	@NotNull
	J setChecked(boolean checked);
}
