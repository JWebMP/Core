package com.jwebmp.core.events.update;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnUpdateService<J extends IOnUpdateService<J>>
		extends IOnEventServiceBase<J>
{

}
