package com.jwebmp.core.events.change;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnChangeService<J extends IOnChangeService<J>>
		extends IOnEventServiceBase<J>
{

}
