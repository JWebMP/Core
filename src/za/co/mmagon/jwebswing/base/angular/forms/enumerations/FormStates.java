package za.co.mmagon.jwebswing.base.angular.forms.enumerations;

/**
 * The available form states an angular frm
 */
public enum FormStates
{
	/**
	 * No fields have been modified yet
	 */
	$pristine,
	/**
	 * One or more have been modified
	 */
	$dirty,
	/**
	 * The form content is not valid
	 */
	$invalid,
	/**
	 * The form context is valid
	 */
	$valid,
	/**
	 * The form context has been submitted
	 */
	$submitted
}
