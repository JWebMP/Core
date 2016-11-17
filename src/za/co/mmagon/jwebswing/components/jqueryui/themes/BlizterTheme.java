package za.co.mmagon.jwebswing.components.jqueryui.themes;

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
class BlizterTheme extends Theme
{

    public BlizterTheme()
    {
        super("Blitzer", "uiblitzer", "css/theming/images/theme_30_blitzer.png", "", "css/theming/images/theme_90_blitzer.png");
        getCssReferences().add(new CSSReference("BlitzerTheme", 1.114, "css/theming/ui_blitzer_theme.css", "https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/blitzer/jquery-ui.css"));
    }

}
