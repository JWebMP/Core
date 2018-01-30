package za.co.mmagon.jwebswing.base.angular;

import za.co.mmagon.jwebswing.Event;

import java.io.Serializable;

import static za.co.mmagon.jwebswing.utilities.StaticStrings.*;

/**
 * Denotes an angular variable to watch with an event class mapped
 */
public class AngularVariableWatcher implements Serializable
{

	private static final long serialVersionUID = 1L;
	private String watchName;
	private String variableName;
	private Class<? extends AngularChangeEvent<?>> eventClass;

	public AngularVariableWatcher(String watchName, String variableName, Class<? extends AngularChangeEvent<?>> eventClass)
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

	public void setEventClass(Class<? extends AngularChangeEvent<?>> eventClass)
	{
		this.eventClass = eventClass;
	}

	@Override
	public String toString()
	{
		String returnable = "$scope.$watch('" + variableName + "'," + "function(newValue,oldValue){" + "if (newValue == oldValue){" + "}"
				                    + "else " + "{" + "$scope.angularchangeeventobject= {'old':oldValue,'new':newValue};" + "jw.env" +
				                    ".controller" + ".jw.isLoading || jw.env" + ".controller.perform(null" + "," + "['angularchangeeventobject']," + "'AngularWatchEvent'," + "'" + eventClass.getCanonicalName()
						                                                                                                                                                                    .replace(
								                                                                                                                                                                    CHAR_DOT,
								                                                                                                                                                                    CHAR_UNDERSCORE) + "');";
		returnable += "}" + "});" + STRING_NEWLINE_TEXT;
		return returnable;
	}
}
