package com.jwebmp.core.databind;

import com.jwebmp.core.Event;
import com.jwebmp.core.events.change.ChangeAdapter;

import jakarta.validation.constraints.NotNull;

/**
 * A specification for notifications of client variable changes (on client data change)
 */
public abstract class ClientVariableWatcher
		implements IClientVariableWatcher
{
	/**
	 * The name of the watcher (for replacement)
	 */
	private String watchName;
	/**
	 * The name of the variable in dot syntax variable.name
	 */
	private String variableName;
	/**
	 * The class that this event will fire on change
	 */
	private Class<? extends ChangeAdapter<?>> eventClass;

	/**
	 * Constructor ClientVariableWatcher creates a new ClientVariableWatcher instance.
	 *
	 * @param watchName
	 * 		of type String
	 * @param variableName
	 * 		of type String
	 * @param eventClass
	 * 		of type Class ? extends ChangeAdapter
	 */
	public ClientVariableWatcher(@NotNull String watchName, @NotNull String variableName, @NotNull Class<? extends ChangeAdapter<?>> eventClass)
	{
		this.watchName = watchName;
		this.variableName = variableName;
		this.eventClass = eventClass;
	}

	/**
	 * Method getVariableName returns the variableName of this ClientVariableWatcher object.
	 * <p>
	 * The name of the variable in dot syntax variable.name
	 *
	 * @return the variableName (type String) of this ClientVariableWatcher object.
	 */
	public String getVariableName()
	{
		return variableName;
	}

	/**
	 * Method setVariableName sets the variableName of this ClientVariableWatcher object.
	 * <p>
	 * The name of the variable in dot syntax variable.name
	 *
	 * @param variableName
	 * 		the variableName of this ClientVariableWatcher object.
	 */
	public void setVariableName(@NotNull String variableName)
	{
		this.variableName = variableName;
	}

	/**
	 * Method getEventClass returns the eventClass of this ClientVariableWatcher object.
	 * <p>
	 * The class that this event will fire on change
	 *
	 * @return the eventClass (type Class ? extends Event ?, ? ) of this ClientVariableWatcher object.
	 */
	public Class<? extends Event<?, ?>> getEventClass()
	{
		return eventClass;
	}

	/**
	 * Method setEventClass sets the eventClass of this ClientVariableWatcher object.
	 * <p>
	 * The class that this event will fire on change
	 *
	 * @param eventClass
	 * 		the eventClass of this ClientVariableWatcher object.
	 */
	public void setEventClass(@NotNull Class<? extends ChangeAdapter<?>> eventClass)
	{
		this.eventClass = eventClass;
	}

	/**
	 * Method hashCode ...
	 *
	 * @return int
	 */
	@Override
	public int hashCode()
	{
		return getWatchName().hashCode();
	}

	/**
	 * Method getWatchName returns the watchName of this ClientVariableWatcher object.
	 * <p>
	 * The name of the watcher (for replacement)
	 *
	 * @return the watchName (type String) of this ClientVariableWatcher object.
	 */
	public String getWatchName()
	{
		return watchName;
	}

	/**
	 * Method setWatchName sets the watchName of this ClientVariableWatcher object.
	 * <p>
	 * The name of the watcher (for replacement)
	 *
	 * @param watchName
	 * 		the watchName of this ClientVariableWatcher object.
	 */
	public void setWatchName(@NotNull String watchName)
	{
		this.watchName = watchName;
	}

	/**
	 * Method equals ...
	 *
	 * @param o
	 * 		of type Object
	 *
	 * @return boolean
	 */
	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		ClientVariableWatcher that = (ClientVariableWatcher) o;
		return getWatchName().equals(that.getWatchName());
	}

	/**
	 * Returns the script to add the variable watcher
	 *
	 * @return The java script
	 */
	@Override
	public String toString()
	{
		return this.onClientVariableRequest(watchName, variableName, eventClass);
	}
}
