package com.jwebmp.core.events.drop;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnDropService<J extends IOnDropService<J>>
		extends IOnEventServiceBase<J>
{

}
