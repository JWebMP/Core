package za.co.mmagon.jwebswing.components.jqueryui.position;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.components.pools.jqueryui.JQUIReferencePool;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @since Forever
 * @version 1.0
 * @author MMagon
 *
 * <p>
 */
public class JQUIPositionFeature extends Feature<JavaScriptPart, JQUIPositionFeature>
{

    private static final long serialVersionUID = 1L;
    private final Position position;
    private final Component positionComponent;

    public JQUIPositionFeature(Component positionComponent, Position position)
    {
        super("JWPosition");
        this.positionComponent = positionComponent;
        this.position = position;
        getJavascriptReferences().add(JQUIReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Widget.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Core.getCssReference());
        getCssReferences().add(JQUIReferencePool.Widget.getCssReference());

        getJavascriptReferences().add(JQUIReferencePool.Position.getJavaScriptReference());
    }

    @Override
    public void assignFunctionsToComponent()
    {
        addQuery("$('#" + this.positionComponent.getID() + "').position(" + position.toString() + ");");
    }
}
