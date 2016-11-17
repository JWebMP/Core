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
class PepperGrinderTheme extends Theme
{

    public PepperGrinderTheme()
    {
        super("Pepper Grinder", "uipeppergrinder", "css/theming/images/theme_30_pepper_grinder.png", "", "css/theming/images/theme_90_pepper_grinder.png");
        getCssReferences().add(new CSSReference("peppergrinderTheme", 1.114, "css/theming/ui_peppergrinder_theme.css", "https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/pepper-grinder/jquery-ui.css"));

    }

}
