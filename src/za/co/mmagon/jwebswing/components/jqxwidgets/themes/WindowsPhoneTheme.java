package za.co.mmagon.jwebswing.components.jqxwidgets.themes;

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.htmlbuilder.css.themes.Theme;

/**
 * The Smoothness theme from JQuery UI
 *
 * @since 2014/07/05
 * @version 1.0
 * @author MMagon
 *
 *
 */
public class WindowsPhoneTheme extends Theme
{

    public WindowsPhoneTheme()
    {
        super("Windows Phone Theme", "jqxwindowsphone");
        getCssReferences().add(new CSSReference("JQXwindowsphoneTheme", 3.91, "bower_components/jqwidgets/jqwidgets/styles/jqx.windowsphone.css", "https://jqwidgets.com/public/jqwidgets/styles/jqx.windowsphone.css"));

    }

}
