package com.jwebmp.core.events.deactivate;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnDeActivateService<J extends IOnDeActivateService<J>>
		extends IOnEventServiceBase<J>
{

}
