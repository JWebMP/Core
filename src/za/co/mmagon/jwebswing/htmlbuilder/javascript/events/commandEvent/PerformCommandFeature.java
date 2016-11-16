package za.co.mmagon.jwebswing.htmlbuilder.javascript.events.commandEvent;

import java.util.ArrayList;
import java.util.Iterator;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * Executes the JavaScript lines of code directly after the component is executed
 *
 * @since 2012-12-30
 * @author MMagon
 */
public abstract class PerformCommandFeature extends Feature<JavaScriptPart, Feature>
{

    public ArrayList<String> javascriptLinesToExecuteAfterLoad;
    private String commandName;
    private Component assignedComponent;

    public PerformCommandFeature()
    {
        super("JWPerformCommand");
        this.commandName = getName();
    }

    /*
     * public PerformCommandFeature(String name)
     * {
     * super(name);
     * setIncludeComponentIdentify(false);
     * setRenderOnLoad(false);
     * this.commandName = name;
     * }
     */
    public PerformCommandFeature(String commandName, Component assignedComponent, String name)
    {
        super(name);
        this.commandName = commandName;
        this.assignedComponent = assignedComponent;
    }

    public abstract ArrayList<String> getJQueryValuesForCommand();

    @Override
    public void assignFunctionsToComponent()
    {
        ArrayList<String> queries = new ArrayList();
        for (Iterator<String> it = getJQueryValuesForCommand().iterator(); it.hasNext();)
        {
            String string = it.next();

            String showDiv = "$('" + this.assignedComponent.getID() + "').show();" + (assignedComponent.isTiny() ? "" : "\n");
            addQuery(showDiv);
            String jQuery = "performCommand('" + this.assignedComponent.getID() + "','" + getName() + "'," + string + ");";
            addQuery(jQuery);
        }

    }
}
