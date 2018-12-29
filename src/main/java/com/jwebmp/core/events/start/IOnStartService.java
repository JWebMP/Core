package com.jwebmp.core.events.start;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnStartService<J extends IOnStartService<J>>
		extends IOnEventServiceBase<J>
{

}
