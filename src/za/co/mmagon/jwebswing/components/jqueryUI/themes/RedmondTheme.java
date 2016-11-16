package za.co.mmagon.jwebswing.components.jqueryUI.themes;

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
class RedmondTheme extends Theme
{

    public RedmondTheme()
    {
        super("Redmond", "uiredmond", "css/theming/images/theme_30_redmond.png", "", "css/theming/images/theme_90_redmond.png");
        getCssReferences().add(new CSSReference("redmondTheme", 1.114, "css/theming/ui_redmond_theme.css", "https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/redmond/jquery-ui.css"));

    }

}
