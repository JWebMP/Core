package com.jwebmp.core.events.remove;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnRemoveService<J extends IOnRemoveService<J>>
		extends IOnEventServiceBase<J>
{

}
