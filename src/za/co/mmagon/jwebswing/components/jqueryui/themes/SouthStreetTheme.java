package za.co.mmagon.jwebswing.components.jqueryui.themes;

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.htmlbuilder.css.themes.Theme;

/**
 * Implements the UI-Lightness Theme from JQuery UI Theme Roller
 *
 * @since 2014/07/05
 * @version 1.0
 * @author MMagon
 *
 */
class SouthStreetTheme extends Theme
{

    public SouthStreetTheme()
    {
        super("South Street", "uisouthstreet", "css/theming/images/theme_30_south_street.png", "", "css/theming/images/theme_90_south_street.png");
        getCssReferences().add(new CSSReference("southstreetTheme", 1.114, "css/theming/ui_southstreet_theme.css", "https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/south-street/jquery-ui.css"));

    }

}
