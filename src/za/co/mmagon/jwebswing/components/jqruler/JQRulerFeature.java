package za.co.mmagon.jwebswing.components.jqruler;

import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.components.pools.jqruler.JQRulerReferencePool;

/**
 * Adds on a ToolTip, String for custom text using header theme, Div for custom contents
 *
 * @author MMagon
 * @since 2013/01/16
 * @version 1.0
 */
public class JQRulerFeature extends Feature<JQRulerOptions, JQRulerFeature> implements JQRulerFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private final JQRuler forComponent;
    private JQRulerOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public JQRulerFeature(JQRuler forComponent)
    {
        super("JQRuler");
        this.forComponent = forComponent;
        getJavascriptReferences().add(JQRulerReferencePool.Event.getJavaScriptReference());
        getCssReferences().add(JQRulerReferencePool.DragDrop.getCssReference());
        getCssReferences().add(JQRulerReferencePool.Core.getCssReference());
    }

    /**
     * Returns all the tooltip options
     * <p>
     * @return
     */
    @Override
    public JQRulerOptions getOptions()
    {
        if (options == null)
        {
            options = new JQRulerOptions();
        }
        return options;
    }
}
