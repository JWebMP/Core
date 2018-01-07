package za.co.mmagon.jwebswing.base.angular.forms;

import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.events.submit.SubmitAdapter;

public class AngularFormSubmitEvent extends SubmitAdapter
{
	public AngularFormSubmitEvent(AngularForm component)
	{
		super(component);
	}

	@Override
	public void onClick(AjaxCall call, AjaxResponse response)
	{
		System.out.println("On Submit");
	}
}
