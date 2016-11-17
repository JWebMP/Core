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
class SwankyPurseTheme extends Theme
{

    public SwankyPurseTheme()
    {
        super("Swanky Purse", "uiswankypurse", "css/theming/images/theme_30_swanky_purse.png", "", "css/theming/images/theme_90_swanky_purse.png");
        getCssReferences().add(new CSSReference("swankypurseTheme", 1.114, "css/theming/ui_swankypurse_theme.css", "https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/swanky-purse/jquery-ui.css"));
    }

}
