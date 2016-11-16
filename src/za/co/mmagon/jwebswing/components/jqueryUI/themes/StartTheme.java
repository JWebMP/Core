package za.co.mmagon.jwebswing.components.jqueryUI.themes;

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.htmlbuilder.css.themes.Theme;

/**
 * The Start Theme from JQuery Theme Roller
 *
 * @since 2014/07/05
 * @version 1.0
 * @author MMagon
 *
 *
 */
class StartTheme extends Theme
{

    public StartTheme()
    {
        super("Start", "uistart", "css/theming/images/theme_30_start_menu.png", "", "css/theming/images/theme_90_start_menu.png");
        getCssReferences().add(new CSSReference("startTheme", 1.114, "css/theming/ui_start_theme.css", "https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/start/jquery-ui.css"));
    }
}
