package za.co.mmagon.jwebswing.components.jqxWidgets.themes;

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.htmlbuilder.css.themes.Theme;

/**
 * Implements the UI-Lightness Theme from JQuery UI Theme Roller
 *
 * @since 2014/07/05
 * @version 1.0
 * @author MMagon
 *
 */
public class FreshTheme extends Theme
{

    public FreshTheme()
    {
        super("Fresh Theme", "jqxfresh");
        getCssReferences().add(new CSSReference("JQXfreshTheme", 3.91, "bower_components/jqwidgets/jqwidgets/styles/jqx.fresh.css", "https://jqwidgets.com/public/jqwidgets/styles/jqx.fresh.css"));

    }

}
