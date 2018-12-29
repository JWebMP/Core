package com.jwebmp.core.events.receive;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnReceiveService<J extends IOnReceiveService<J>>
		extends IOnEventServiceBase<J>
{

}
