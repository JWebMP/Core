package com.jwebmp.core.events.response;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnResponseService<J extends IOnResponseService<J>>
		extends IOnEventServiceBase<J>
{

}
