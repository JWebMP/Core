package com.jwebmp.core.events.focus;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnFocusService<J extends IOnFocusService<J>>
		extends IOnEventServiceBase<J>
{

}
