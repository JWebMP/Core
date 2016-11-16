package za.co.mmagon.jwebswing.components.jqxWidgets.themes;

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.htmlbuilder.css.themes.Theme;

/**
 * Implements the Bootstrap Minimum Theme
 *
 * @since 2016/04/16
 * @version 1.0
 * @author MMagon
 *
 *
 */
public class BootStrapTheme extends Theme
{

    public BootStrapTheme()
    {
        super("Bootstrap Theme", "jqxbootstrap");
        getCssReferences().add(new CSSReference("JQXbootstrapTheme", 3.91, "bower_components/jqwidgets/jqwidgets/styles/jqx.bootstrap.css", "https://jqwidgets.com/public/jqwidgets/styles/jqx.bootstrap.css"));

    }
}
