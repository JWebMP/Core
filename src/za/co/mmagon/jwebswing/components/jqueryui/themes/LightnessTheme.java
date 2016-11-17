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
class LightnessTheme extends Theme
{

    public LightnessTheme()
    {
        super("UI-Lightness", "uilightness", "css/theming/images/theme_30_ui_light.png", "", "css/theming/images/theme_90_ui_light.png");
        getCssReferences().add(new CSSReference("lightnessTheme", 1.114, "css/theming/ui_lightness_theme.css", "https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/ui-lightness/jquery-ui.css"));
    }

}
