package za.co.mmagon.jwebswing.components.jqxWidgets.themes;

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.htmlbuilder.css.themes.Theme;

/**
 * The Dark Hive theme to JQuery UI
 *
 * @since 2012/02/04
 * @version
 * @author MMagon
 *
 */
public class AndroidTheme extends Theme
{

    public AndroidTheme()
    {
        super("Android Theme", "jqxandroid");
        getCssReferences().add(new CSSReference("JQXAndroidTheme", 3.91, "bower_components/jqwidgets/jqwidgets/styles/jqx.android.css", "https://jqwidgets.com/public/jqwidgets/styles/jqx.android.css"));

    }
}
