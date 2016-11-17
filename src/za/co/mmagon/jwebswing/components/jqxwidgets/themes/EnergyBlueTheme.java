package za.co.mmagon.jwebswing.components.jqxwidgets.themes;

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.htmlbuilder.css.themes.Theme;

/**
 * A default theme for a web site Very monochrome stock standard stuff
 *
 * @author Marc Magon
 */
public class EnergyBlueTheme extends Theme
{

    public EnergyBlueTheme()
    {
        super("Energy Blue Theme", "jqxenergyblue");
        getCssReferences().add(new CSSReference("JQXenergyblueTheme", 3.91, "bower_components/jqwidgets/jqwidgets/styles/jqx.energyblue.css", "https://jqwidgets.com/public/jqwidgets/styles/jqx.energyblue.css"));

    }

}
