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
class HumanityTheme extends Theme
{

    public HumanityTheme()
    {
        super("Humanity", "uihumanity", "css/theming/images/theme_30_humanity.png", "", "css/theming/images/theme_90_humanity.png");
        getCssReferences().add(new CSSReference("humanityTheme", 1.114, "css/theming/ui_humanity_theme.css", "https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/humanity/jquery-ui.css"));
    }

}
