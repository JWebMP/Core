package za.co.mmagon.jwebswing.components.jquerylayout.layout.events;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.components.jquerylayout.layout.JQLayoutDiv;
import za.co.mmagon.jwebswing.htmlbuilder.css.composer.CSSBlock;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author MMagon
 * @since 23 Sep 2013
 * @version 1.0
 */
public class AddPinButtonFeature extends Feature<JavaScriptPart, Feature>
{

    private static final long serialVersionUID = 1L;

    private final JQLayoutDiv divToOpen;
    private final Component pinButton;
    private CSSBlock pinButtonCSSBlock;

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
