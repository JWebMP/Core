package za.co.mmagon.jwebswing.components.jqueryUI.themes;

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.htmlbuilder.css.themes.Theme;

/**
 * Implements the UI dotluv Theme
 *
 * @since 2014/07/05
 * @version 1.0
 * @author MMagon
 *
 *
 */
class DotLuvTheme extends Theme
{

    public DotLuvTheme()
    {
        super("Dot Luv", "uidotluv", "css/theming/images/theme_30_dot_luv.png", "", "css/theming/images/theme_90_dot_luv.png");
        getCssReferences().add(new CSSReference("dotluvTheme", 1.114, "css/theming/ui_dotluv_theme.css", "https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/dot-luv/jquery-ui.css"));
    }

}
