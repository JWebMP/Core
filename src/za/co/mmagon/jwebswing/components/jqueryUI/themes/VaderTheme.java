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
class VaderTheme extends Theme
{

    public VaderTheme()
    {
        super("Vader", "uivader", "css/theming/images/theme_30_vader.png", "", "css/theming/images/theme_90_vader.png");
        getCssReferences().add(new CSSReference("vaderTheme", 1.114, "css/theming/ui_vader_theme.css", "https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/vader/jquery-ui.css"));
    }

}
