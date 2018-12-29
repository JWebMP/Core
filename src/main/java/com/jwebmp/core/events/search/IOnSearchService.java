package com.jwebmp.core.events.search;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnSearchService<J extends IOnSearchService<J>>
		extends IOnEventServiceBase<J>
{

}
