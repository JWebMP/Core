package com.jwebmp.core.events.select;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnSelectService<J extends IOnSelectService<J>>
		extends IOnEventServiceBase<J>
{

}
