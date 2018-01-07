package za.co.mmagon.jwebswing.base.angular.forms.enumerations;

/**
 * Valid $error identification fields
 */
public enum InputErrorValidations
{
	required,
	email,
	max,
	maxlength,
	min,
	minLength,
	number,
	pattern,
	url,
	date,
	datetimelocal,
	time,
	week,
	month;

	public String toFullString()
	{
		return "$error." + name();
	}

	@Override
	public String toString()
	{
		return name();
	}
}
