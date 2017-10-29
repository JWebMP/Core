package za.co.mmagon.jwebswing.htmlbuilder.javascript.events.commandevent;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

import java.util.Iterator;
import java.util.List;

/**
 * Executes the JavaScript lines of code directly after the component is executed
 *
 * @author MMagon
 * @since 2012-12-30
 */
public abstract class PerformCommandFeature extends Feature<JavaScriptPart, PerformCommandFeature>
{

	private static final long serialVersionUID = 1L;
	/**
	 * The given command name to execute
	 */
	private String commandName;

	/**
	 * Tells the server to send something to the client
	 */
	public PerformCommandFeature()
	{
		super("JWPerformCommand");
		this.commandName = getName();
	}

	/*
	 * Constructs a new command feature
	 */
	public PerformCommandFeature(String commandName, Component assignedComponent, String name)
	{
		super(name);
		this.commandName = commandName;
		setComponent(assignedComponent);
	}

	@Override
	public void assignFunctionsToComponent()
	{
		for (Iterator<String> it = getJQueryValuesForCommand().iterator(); it.hasNext(); )
		{
			String string = it.next();

			String showDiv = "$('" + this.getComponent().getID() + "').show();" + (getComponent().isTiny() ? "" : "\n");
			addQuery(showDiv);
			String jQuery = "performCommand('" + this.getComponent().getID() + "','" + getName() + "'," + string + ");";
			addQuery(jQuery);
		}
	}

	public abstract List<String> getJQueryValuesForCommand();

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof PerformCommandFeature))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		PerformCommandFeature that = (PerformCommandFeature) o;

		return getCommandName() != null ? getCommandName().equals(that.getCommandName()) : that.getCommandName() == null;
	}

	/**
	 * Returns a given command name
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	public String getCommandName()
	{
		return commandName;
	}

	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + (getCommandName() != null ? getCommandName().hashCode() : 0);
		return result;
	}
}
