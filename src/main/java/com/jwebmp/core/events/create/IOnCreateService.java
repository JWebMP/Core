package com.jwebmp.core.events.create;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnCreateService<J extends IOnCreateService<J>>
		extends IOnEventServiceBase<J>
{

}
