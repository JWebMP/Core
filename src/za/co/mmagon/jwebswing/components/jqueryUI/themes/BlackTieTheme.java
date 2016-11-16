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
class BlackTieTheme extends Theme
{

    public BlackTieTheme()
    {
        super("Black Tie", "uiblacktie", "css/theming/images/theme_30_black_tie.png", "", "css/theming/images/theme_90_black_tie.png");
        getCssReferences().add(new CSSReference("BlackTieTheme", 1.114, "css/theming/ui_blacktie_theme.css", "https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/black-tie/jquery-ui.css"));
    }

}
