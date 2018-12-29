package com.jwebmp.core.events.dropout;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnDropOutService<J extends IOnDropOutService<J>>
		extends IOnEventServiceBase<J>
{

}
