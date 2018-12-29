package com.jwebmp.core.events.open;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnOpenService<J extends IOnOpenService<J>>
		extends IOnEventServiceBase<J>
{

}
