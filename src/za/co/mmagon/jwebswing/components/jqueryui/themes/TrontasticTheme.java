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
class TrontasticTheme extends Theme
{

    public TrontasticTheme()
    {
        super("Trontastic", "uitrontastic", "css/theming/images/theme_30_trontastic.png", "", "css/theming/images/theme_90_trontastic.png");
        getCssReferences().add(new CSSReference("trontasticTheme", 1.114, "css/theming/ui_trontastic_theme.css", "https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/trontastic/jquery-ui.css"));
    }

}
