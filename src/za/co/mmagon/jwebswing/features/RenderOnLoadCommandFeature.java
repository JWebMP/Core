package za.co.mmagon.jwebswing.features;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.commandEvent.PerformCommandFeature;

/**
 *
 * @author MMagon
 */
public class RenderOnLoadCommandFeature extends PerformCommandFeature
{

    private String nextComponentID;
    private String currentComponentID;

    public RenderOnLoadCommandFeature(String currentComponentID, String nextComponentID)
    {
        super("RenderOnLoad", null, "RenderOnLoad");
        this.nextComponentID = nextComponentID;
        this.currentComponentID = currentComponentID;
    }

    @Override
    public ArrayList<String> getJQueryValuesForCommand()
    {
        ArrayList<String> jQueries = new ArrayList();
        addQuery("'" + nextComponentID + "'");
        return jQueries;
    }
}
