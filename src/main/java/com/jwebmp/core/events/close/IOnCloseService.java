package com.jwebmp.core.events.close;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnCloseService<J extends IOnCloseService<J>>
		extends IOnEventServiceBase<J>
{

}
