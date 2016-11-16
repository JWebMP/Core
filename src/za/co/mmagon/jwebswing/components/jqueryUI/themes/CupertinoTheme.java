package za.co.mmagon.jwebswing.components.jqueryUI.themes;

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
class CupertinoTheme extends Theme
{

    public CupertinoTheme()
    {
        super("Cupertino", "uicupertino", "css/theming/images/theme_30_cupertino.png", "", "css/theming/images/theme_90_cupertino.png");
        getCssReferences().add(new CSSReference("CupertinoTheme", 1.114, "css/theming/ui_cupertino_theme.css", "https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/cupertino/jquery-ui.css"));
    }

}
