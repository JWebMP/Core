package com.jwebmp.core.events;

import com.jwebmp.core.Event;
import com.guicedee.guicedinjection.interfaces.IDefaultService;

public interface IOnEventServiceBase<J extends IOnEventServiceBase<J>>
		extends IDefaultService<J>
{
	/**
	 * Occurs when the event is called
	 */
	void onCreate(Event<?, ?> e);

	/**
	 * Occurs when the event is called
	 */
	void onCall(Event<?, ?> e);
}
