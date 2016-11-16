package za.co.mmagon.jwebswing.components.jqueryLayout.layout.events;

import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.components.jqueryLayout.layout.JQLayoutDiv;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * This maps an Open Div feature to a component
 *
 * @author MMagon
 * @since 23 Sep 2013
 * @version 1.0
 */
public class OpenLayoutDivFeature extends Feature<JavaScriptPart, OpenLayoutDivFeature>
{

    private JQLayoutDiv divToOpen;

    public OpenLayoutDivFeature(JQLayoutDiv layoutDiv)
    {
        super("JWLayoutOpenDiv");
        divToOpen = layoutDiv;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        String openDivFunction = divToOpen.getLayout().getVariableID() + ".open('" + divToOpen.getArea().name().toLowerCase() + "');";
        addQuery(openDivFunction);
    }
}
