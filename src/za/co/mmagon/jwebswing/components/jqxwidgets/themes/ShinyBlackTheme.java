package za.co.mmagon.jwebswing.components.jqxwidgets.themes;

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
public class ShinyBlackTheme extends Theme
{

    public ShinyBlackTheme()
    {
        super("Shiny Black Theme", "jqxshinyblack");
        getCssReferences().add(new CSSReference("JQXshinyblackTheme", 3.91, "bower_components/jqwidgets/jqwidgets/styles/jqx.shinyblack.css", "https://jqwidgets.com/public/jqwidgets/styles/jqx.shinyblack.css"));

    }

}
