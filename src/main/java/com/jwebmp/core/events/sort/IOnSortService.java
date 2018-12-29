package com.jwebmp.core.events.sort;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnSortService<J extends IOnSortService<J>>
		extends IOnEventServiceBase<J>
{

}
