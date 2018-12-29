package com.jwebmp.core.events.complete;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnCompleteService<J extends IOnCompleteService<J>>
		extends IOnEventServiceBase<J>
{

}
