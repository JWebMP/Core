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
class LeFrogTheme extends Theme
{

    public LeFrogTheme()
    {
        super("LeFrog", "uilefrog", "css/theming/images/theme_30_le_frog.png", "", "css/theming/images/theme_90_le_frog.png");
        getCssReferences().add(new CSSReference("lefrogTheme", 1.114, "css/theming/ui_lefrog_theme.css", "https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/le-frog/jquery-ui.css"));

    }

}
