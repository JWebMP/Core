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
class DarknessTheme extends Theme
{

    public DarknessTheme()
    {
        super("UI-Darkness", "uidarkness", "css/theming/images/theme_30_ui_dark.png", "", "css/theming/images/theme_90_ui_dark.png");
        getCssReferences().add(new CSSReference("darknessTheme", 1.114, "css/theming/ui_darkness_theme.css", "https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/ui-darkness/jquery-ui.css"));
    }

}
