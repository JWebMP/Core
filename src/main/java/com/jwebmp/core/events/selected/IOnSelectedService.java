package com.jwebmp.core.events.selected;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnSelectedService<J extends IOnSelectedService<J>>
		extends IOnEventServiceBase<J>
{

}
