package com.jwebmp.core.events.load;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnLoadService<J extends IOnLoadService<J>>
		extends IOnEventServiceBase<J>
{

}
