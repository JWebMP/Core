package com.jwebmp.core.events.dropover;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnDropOverService<J extends IOnDropOverService<J>>
		extends IOnEventServiceBase<J>
{

}
