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
class HotSneaksTheme extends Theme
{

    public HotSneaksTheme()
    {
        super("Hot Sneaks", "uihotsneaks", "css/theming/images/theme_30_hot_sneaks.png", "", "css/theming/images/theme_90_hot_sneaks.png");
        getCssReferences().add(new CSSReference("hotsneaksTheme", 1.114, "css/theming/ui_hotsneaks_theme.css", "https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/hot-sneaks/jquery-ui.css"));
    }

}
