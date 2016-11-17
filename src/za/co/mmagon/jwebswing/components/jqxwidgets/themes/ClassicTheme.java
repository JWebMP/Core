package za.co.mmagon.jwebswing.components.jqxwidgets.themes;

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
public class ClassicTheme extends Theme
{

    public ClassicTheme()
    {
        super("Classic Theme", "jqxclassic");
        getCssReferences().add(new CSSReference("JQXclassicTheme", 3.91, "bower_components/jqwidgets/jqwidgets/styles/jqx.classic.css", "https://jqwidgets.com/public/jqwidgets/styles/jqx.classic.css"));

    }

}
