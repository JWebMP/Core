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
class EggplantTheme extends Theme
{

    public EggplantTheme()
    {
        super("Eggplant", "uieggplant", "css/theming/images/theme_30_eggplant.png", "", "css/theming/images/theme_90_eggplant.png");
        getCssReferences().add(new CSSReference("eggplantTheme", 1.114, "css/theming/ui_eggplant_theme.css", "https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/eggplant/jquery-ui.css"));
    }

}
