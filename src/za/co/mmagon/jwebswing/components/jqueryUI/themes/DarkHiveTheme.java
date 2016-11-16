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
class DarkHiveTheme extends Theme
{

    public DarkHiveTheme()
    {
        super("Dark Hive", "darkhive", "css/theming/images/theme_30_dark_hive.png", "", "css/theming/images/theme_90_dark_hive.png");
        getCssReferences().add(new CSSReference("DarkHiveTheme", 1.114, "css/theming/ui_darkhive_theme.css", "https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/dark-hive/jquery-ui.css"));

    }

}
