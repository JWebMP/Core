package za.co.mmagon.jwebswing.base.angular;

import za.co.mmagon.jwebswing.Event;

import java.io.Serializable;

import static za.co.mmagon.jwebswing.utilities.StaticStrings.CHAR_DOT;
import static za.co.mmagon.jwebswing.utilities.StaticStrings.CHAR_UNDERSCORE;

/**
 * Denotes an angular variable to watch with an event class mapped
 */
public class AngularVariableWatcher implements Serializable
{

	private static final long serialVersionUID = 1L;
	private String watchName;
	private String variableName;
	private Class<? extends Event<?>> eventClass;

	public AngularVariableWatcher(String watchName, String variableName, Class<? extends Event<?>> eventClass)
	{
		this.watchName = watchName;
		this.variableName = variableName;
		this.eventClass = eventClass;
	}

	public String getWatchName()
	{
		return watchName;
	}

	public void setWatchName(String watchName)
	{
		this.watchName = watchName;
	}

	public String getVariableName()
	{
		return variableName;
	}

	public void setVariableName(String variableName)
	{
		this.variableName = variableName;
	}

	public Class<? extends Event<?>> getEventClass()
	{
		return eventClass;
	}

	public void setEventClass(Class<? extends Event<?>> eventClass)
	{
		this.eventClass = eventClass;
	}

	@Override
	public String toString()
	{
		return "$scope.$watch(" +
				       "function(scope){return scope." + variableName + ";}," +
				       "function(newValue,oldValue){" +

				       "jwCntrl.jw.isLoading || jwCntrl.perform(null" +
				       ",[{'old':oldValue,'new':newValue}]," +
				       "'AngularWatchEvent'," +
				       "'" + eventClass.getCanonicalName().replace(CHAR_DOT, CHAR_UNDERSCORE) + "');" +
				       "});";
	}
}
