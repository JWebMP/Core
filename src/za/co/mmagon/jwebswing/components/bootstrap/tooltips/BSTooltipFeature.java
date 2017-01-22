package za.co.mmagon.jwebswing.components.bootstrap.tooltips;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.components.bootstrap.popovers.BSPopOverFeatures;
import za.co.mmagon.jwebswing.components.bootstrap.popovers.BSPopOverOptions;

/**
 * Adds on a ToolTip, String for custom text using header theme, Div for custom contents
 *
 * @author MMagon
 * @since 2013/01/16
 * @version 1.0
 */
public class BSTooltipFeature extends Feature<BSPopOverOptions, BSTooltipFeature> implements BSPopOverFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private BSPopOverOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public BSTooltipFeature(Component forComponent)
    {
        super("BootstrapPopoverFeature");
        setComponent(forComponent);
    }

    /**
     * Returns all the tooltip options
     * <p>
     * @return
     */
    @Override
    public BSPopOverOptions getOptions()
    {
        if (options == null)
        {
            options = new BSPopOverOptions();
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        String requiredString = getComponent().getJQueryID()
                + "tooltip(" + getOptions() + ");" + getNewLine();
        addQuery(requiredString);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 79 * hash + (this.getID().hashCode());
        return hash;
    }
}
