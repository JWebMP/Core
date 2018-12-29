package com.jwebmp.core.events.beforeload;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnBeforeLoadService<J extends IOnBeforeLoadService<J>>
		extends IOnEventServiceBase<J>
{

}
