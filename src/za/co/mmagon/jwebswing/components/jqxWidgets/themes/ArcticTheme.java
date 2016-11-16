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
public class ArcticTheme extends Theme
{

    public ArcticTheme()
    {
        super("Arctic Theme", "jqxarctic");
        getCssReferences().add(new CSSReference("JQXarcticTheme", 3.91, "bower_components/jqwidgets/jqwidgets/styles/jqx.arctic.css", "https://jqwidgets.com/public/jqwidgets/styles/jqx.arctic.css"));

    }

}
