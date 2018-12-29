package com.jwebmp.core.events.selecting;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnSelectingService<J extends IOnSelectingService<J>>
		extends IOnEventServiceBase<J>
{

}
