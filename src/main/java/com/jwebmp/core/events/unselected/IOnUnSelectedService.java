package com.jwebmp.core.events.unselected;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnUnSelectedService<J extends IOnUnSelectedService<J>>
		extends IOnEventServiceBase<J>
{

}
