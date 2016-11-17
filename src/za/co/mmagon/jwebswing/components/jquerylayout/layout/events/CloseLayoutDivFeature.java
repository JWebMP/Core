package za.co.mmagon.jwebswing.components.jquerylayout.layout.events;

import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.components.jquerylayout.layout.JQLayoutDiv;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * This maps an Open Div feature to a component
 *
 * @author MMagon
 * @since 23 Sep 2013
 * @version 1.0
 */
public class CloseLayoutDivFeature extends Feature<JavaScriptPart, CloseLayoutDivFeature>
{

    private JQLayoutDiv divToClose;

    public CloseLayoutDivFeature(JQLayoutDiv layoutDiv)
    {
        super("JWLayoutOpenDiv");
        divToClose = layoutDiv;

    }

    @Override
    public void assignFunctionsToComponent()
    {

        String openDivFunction = divToClose.getLayout().getVariableID() + ".close('" + divToClose.getArea().name().toLowerCase() + "');";
        addQuery(openDivFunction);

    }
}
