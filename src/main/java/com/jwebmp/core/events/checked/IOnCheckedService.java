package com.jwebmp.core.events.checked;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnCheckedService<J extends IOnCheckedService<J>>
		extends IOnEventServiceBase<J>
{

}
