package za.co.mmagon.jwebswing.base.angular;

import za.co.mmagon.jwebswing.Event;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;

public abstract class AngularChangeEvent<J extends AngularChangeEvent<J>> extends Event<J>
{
	public AngularChangeEvent(ComponentHierarchyBase component)
	{
		super(component);
	}

	public AngularChangeEvent()
	{
		super("AngularChangeEvent");
	}

	public AngularChangeDto getChangeDto(AjaxCall call)
	{
		return call.getVariable("angularchangeeventobject")
				       .as(AngularChangeDto.class);
	}

	@Override
	public void fireEvent(AjaxCall call, AjaxResponse response)
	{
		onChange(call, response);
		super.fireEvent(call, response);
	}

	public abstract void onChange(AjaxCall call, AjaxResponse response);
}
