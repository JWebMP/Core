package za.co.mmagon.jwebswing.components.jqxWidgets.themes;

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.htmlbuilder.css.themes.Theme;

/**
 * Implements the UI Darkness Theme
 *
 * @since 2014/07/05
 * @version 1.0
 * @author MMagon
 *
 *
 */
public class BlackberryTheme extends Theme
{

    public BlackberryTheme()
    {
        super("Blackberry Theme", "jqxblackberry");
        getCssReferences().add(new CSSReference("JQXblackberryTheme", 3.91, "bower_components/jqwidgets/jqwidgets/styles/jqx.blackberry.css", "https://jqwidgets.com/public/jqwidgets/styles/jqx.blackberry.css"));

    }
}
