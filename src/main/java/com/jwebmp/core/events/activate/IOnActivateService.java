package com.jwebmp.core.events.activate;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnActivateService<J extends IOnActivateService<J>>
		extends IOnEventServiceBase<J>
{

}
