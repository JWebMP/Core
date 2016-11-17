package za.co.mmagon.jwebswing.components.jqmetro.metro;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.components.jqmetro.metro.references.JQMetroCSSReference;
import za.co.mmagon.jwebswing.components.jqmetro.metro.references.JQMetroJavascriptReference;

/**
 * Adds on a ToolTip, String for custom text using header theme, Div for custom contents
 *
 * @author MMagon
 * @since 2013/01/16
 * @version 1.0
 */
public class JQMetroFeature extends Feature<JQMetroOptions, JQMetroFeature> implements JQMetroFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;
    
    @JsonIgnore
    private final JQMetroTiles forComponent;
    private JQMetroOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public JQMetroFeature(JQMetroTiles forComponent)
    {
        super("JQMetroFeature");
        this.forComponent = forComponent;
        getJavascriptReferences().add(new JQMetroJavascriptReference());
        getCssReferences().add(new JQMetroCSSReference());
    }

    /**
     * Returns all the tooltip options
     * <p>
     * @return
     */
    @Override
    public JQMetroOptions getOptions()
    {
        if (options == null)
        {
            options = new JQMetroOptions();
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        String requiredString = "$('.live-tile').liveTile(";
        requiredString += getOptions().toString();
        requiredString += ");" + getNewLine();
        addQuery(requiredString);

    }
}
