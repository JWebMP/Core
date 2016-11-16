package za.co.mmagon.jwebswing.components.c3;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.components.d3.D3JavascriptReferencePool;

/**
 * Adds on a ToolTip, String for custom text using header theme, Div for custom contents
 *
 * @author MMagon
 * @since 2013/01/16
 * @version 1.0
 */
public class C3Feature extends Feature<C3Options, C3Feature> implements C3Features, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private final Component forComponent;
    private C3Options options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public C3Feature(Component forComponent)
    {
        super("Blank");
        this.forComponent = forComponent;
        getJavascriptReferences().add(D3JavascriptReferencePool.D3DrawingLibrary.getReference());
        getJavascriptReferences().add(C3JavascriptReferencePool.C3GraphCore.getReference());
        getCssReferences().add(C3CSSReferencePool.C3GraphCore.getReference());
    }

    /**
     * Returns all the tooltip options
     * <p>
     * @return
     */
    @Override
    public C3Options getOptions()
    {
        if (options == null)
        {
            options = new C3Options(forComponent);
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        String requiredString = "c3.generate(" + getNewLine();
        requiredString += getOptions().toString();
        requiredString += ");" + getNewLine();
        addQuery(requiredString);

    }
}
