package za.co.mmagon.jwebswing.components.jqueryui.themes;

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.htmlbuilder.css.themes.Theme;

/**
 * The Dark Hive theme to JQuery UI
 *
 * @since 2012/02/04
 * @version
 * @author MMagon
 *
 */
class FlickTheme extends Theme
{

    public FlickTheme()
    {
        super("Flick", "uiflick", "css/theming/images/theme_30_flick.png", "", "css/theming/images/theme_90_flick.png");
        getCssReferences().add(new CSSReference("flickTheme", 1.114, "css/theming/ui_flick_theme.css", "https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/flick/jquery-ui.css"));

    }

}
