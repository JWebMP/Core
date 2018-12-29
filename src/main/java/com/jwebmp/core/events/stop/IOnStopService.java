package com.jwebmp.core.events.stop;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnStopService<J extends IOnStopService<J>>
		extends IOnEventServiceBase<J>
{

}
