package za.co.mmagon.jwebswing.components.jquerylayout.layout.events;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.components.jquerylayout.layout.JQLayoutDiv;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * Adds a pin button for the layout side to the given component
 *
 * @author MMagon
 * @since 23 Sep 2013
 * @version 1.0
 */
public class AddPinButtonFeature extends Feature<JavaScriptPart, Feature>
{

    private static final long serialVersionUID = 1L;
    /**
     * The layout div to open
     */
    private final JQLayoutDiv divToOpen;
    /**
     * The component to make a pin button
     */
    private final Component pinButton;

    /**
     * Adds a pin button for the layout side to the given component
     *
     * @param layoutDiv
     * @param pinButton
     */
    public AddPinButtonFeature(JQLayoutDiv layoutDiv, Component pinButton)
    {
        super("JWLayoutPinButtonFeature");
        this.pinButton = pinButton;
        divToOpen = layoutDiv;

    }

    @Override
    public void assignFunctionsToComponent()
    {
        String openDivFunction = divToOpen.getLayout().getVariableID() + ".addPinBtn('#" + pinButton.getID() + "',\"" + divToOpen.getArea().toString().toLowerCase() + "\");" + getNewLine();
        addQuery(openDivFunction);
    }
}
