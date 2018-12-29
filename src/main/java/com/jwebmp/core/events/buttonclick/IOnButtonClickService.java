package com.jwebmp.core.events.buttonclick;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnButtonClickService<J extends IOnButtonClickService<J>>
		extends IOnEventServiceBase<J>
{

}
