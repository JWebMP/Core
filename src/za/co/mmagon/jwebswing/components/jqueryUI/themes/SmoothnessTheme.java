package za.co.mmagon.jwebswing.components.jqueryUI.themes;

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.htmlbuilder.css.themes.Theme;

/**
 * The Smoothness theme from JQuery UI
 *
 * @since 2014/07/05
 * @version 1.0
 * @author MMagon
 *
 *
 */
class SmoothnessTheme extends Theme
{

    public SmoothnessTheme()
    {
        super("Smoothness", "uismoothness", "css/theming/images/theme_30_smoothness.png", "", "css/theming/images/theme_90_smoothness.png");
        getCssReferences().add(new CSSReference("smoothnessTheme", 1.114, "css/theming/ui_smoothness_theme.css", "https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css"));
    }

}
