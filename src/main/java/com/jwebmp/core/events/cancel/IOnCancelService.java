package com.jwebmp.core.events.cancel;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnCancelService<J extends IOnCancelService<J>>
		extends IOnEventServiceBase<J>
{

}
