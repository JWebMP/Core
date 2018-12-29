package com.jwebmp.core.events.beforeactivate;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnBeforeActivateService<J extends IOnBeforeActivateService<J>>
		extends IOnEventServiceBase<J>
{

}
