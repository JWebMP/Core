package com.jwebmp.core.events.spin;

import com.jwebmp.core.events.IOnEventServiceBase;

@FunctionalInterface
public interface IOnSpinService<J extends IOnSpinService<J>>
		extends IOnEventServiceBase<J>
{

}
