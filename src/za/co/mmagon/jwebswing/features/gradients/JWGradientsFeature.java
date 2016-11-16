package za.co.mmagon.jwebswing.features.gradients;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.children.ImageMapFeatures;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @since Forver
 * @author mmagon
 * @version 1.0
 */
public class JWGradientsFeature extends Feature<JavaScriptPart, JWGradientsFeature> implements ImageMapFeatures
{

    private String fromColour = "000000";
    private String toColour = "ffffff";
    private String direction = "horizontal";
    private String position = "top";
    private String length;
    private Component componentToApply;

    public JWGradientsFeature(Component componentToApply)
    {
        super("JWGradientsFeature");
        this.componentToApply = componentToApply;
        getJavascriptReferences().add(new JWGradientsJavascriptReference());
    }

    public JWGradientsFeature(Component componentToApply, String fromColour, String toColour, String direction)
    {
        this(componentToApply);
        this.componentToApply = componentToApply;
        this.fromColour = fromColour;
        this.toColour = toColour;
        this.direction = direction;
        this.position = position;
        this.length = length;
    }

    public String getFromColour()
    {
        return fromColour;
    }

    public void setFromColour(String fromColour)
    {
        this.fromColour = fromColour;
    }

    public String getToColour()
    {
        return toColour;
    }

    public void setToColour(String toColour)
    {
        this.toColour = toColour;
    }

    public String getGradientDirection()
    {
        return direction;
    }

    public void setDirection(String direction)
    {
        this.direction = direction;
    }

    public String getPositionString()
    {
        return position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    public String getLength()
    {
        return length;
    }

    public void setLength(String length)
    {
        this.length = length;
    }

    public Component getComponentToApply()
    {
        return componentToApply;
    }

    public void setComponentToApply(Component componentToApply)
    {
        this.componentToApply = componentToApply;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        addQuery("$('#" + componentToApply.getID() + "').gradient({from: '" + fromColour + "', to: '" + toColour + "', direction: '" + direction + "'});");
    }
}
