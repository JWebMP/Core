package za.co.mmagon.jwebswing.components.jqxWidgets.themes;

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.components.pools.jqxWidgets.JQXReferencePool;
import za.co.mmagon.jwebswing.htmlbuilder.css.themes.Theme;

/**
 * The Dark Hive theme to JQuery UI
 *
 * @since 2012/02/04
 * @version
 * @author MMagon
 *
 */
public class MetroDarkTheme extends Theme
{

    public MetroDarkTheme()
    {
        super("Metro Dark Theme", "metrodark");
        getCssReferences().add(JQXReferencePool.Core.getCssReference());
        getCssReferences().add(new CSSReference("JQXmetrodarkTheme", 3.91, "bower_components/jqwidgets/jqwidgets/styles/jqx.metrodark.css", "https://jqwidgets.com/public/jqwidgets/styles/jqx.metrodark.css"));

    }

}
