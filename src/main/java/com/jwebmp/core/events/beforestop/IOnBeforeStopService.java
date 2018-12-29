package com.jwebmp.core.events.beforestop;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnBeforeStopService<J extends IOnBeforeStopService<J>>
		extends IOnEventServiceBase<J>
{
}
