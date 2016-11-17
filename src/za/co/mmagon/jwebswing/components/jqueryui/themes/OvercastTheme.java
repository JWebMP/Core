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
class OvercastTheme extends Theme
{

    public OvercastTheme()
    {
        super("Overcast", "uiovercast", "css/theming/images/theme_30_overcast.png", "", "css/theming/images/theme_90_overcast.png");
        getCssReferences().add(new CSSReference("overcastTheme", 1.114, "css/theming/ui_overcast_theme.css", "https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/overcast/jquery-ui.css"));
    }

}
