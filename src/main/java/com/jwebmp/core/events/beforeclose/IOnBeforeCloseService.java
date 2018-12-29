package com.jwebmp.core.events.beforeclose;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnBeforeCloseService<J extends IOnBeforeCloseService<J>>
		extends IOnEventServiceBase<J>
{

}
