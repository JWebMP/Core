package com.jwebmp.core.events;

import com.jwebmp.core.Event;
import com.jwebmp.guicedinjection.interfaces.IDefaultService;

import javax.validation.constraints.NotNull;

/**
 * This event can be used to configure any events that are created
 *
 * @param <J>
 */
public interface IEventConfigurator<J extends IEventConfigurator<J>>
		extends IDefaultService<J>
{
	/**
	 * Configures the event
	 *
	 * @param event
	 * 		The vent to configure
	 *
	 * @return A not null event
	 */
	@SuppressWarnings("UnusedReturnValue")
	@NotNull Event<?, ?> configureEvent(Event<?, ?> event);
}
