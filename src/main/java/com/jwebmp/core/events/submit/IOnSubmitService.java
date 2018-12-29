package com.jwebmp.core.events.submit;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnSubmitService<J extends IOnSubmitService<J>>
		extends IOnEventServiceBase<J>
{

}
