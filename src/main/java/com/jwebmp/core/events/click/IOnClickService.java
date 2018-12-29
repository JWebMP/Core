package com.jwebmp.core.events.click;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnClickService<J extends IOnClickService<J>>
		extends IOnEventServiceBase<J>
{

}
