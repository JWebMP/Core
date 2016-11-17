package za.co.mmagon.jwebswing.components.jqxwidgets.loader;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineBeforeClosingTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineForRawText;
import za.co.mmagon.jwebswing.base.html.interfaces.children.BodyChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.interfaces.Loader;

/**
 * The jqxLoader represents a jQuery widget which displays the built-in loading element.
 * The loading element can be icon only, text only or combination of icon and text.
 * <p>
 * It can be used to display loading element until the widget's data is loaded.
 *
 * @author MMagon
 */
public class JQXLoader extends Div<GlobalChildren, NoAttributes, GlobalFeatures, GlobalEvents, JQXLoader> implements BodyChildren, NoNewLineForRawText, NoNewLineBeforeClosingTag, Loader
{

    private JQXLoaderFeature feature;

    public JQXLoader()
    {
        setID("JWLoader");
        addFeature(feature = new JQXLoaderFeature(this));

        //add("loader div");
    }

    public static void main(String... args)
    {
        JQXLoader loader = new JQXLoader();
        //loader.
        /*
         * System.out.println(loader.toString(true));
         * System.out.println(loader.renderJavascripts(0));
         * System.out.println(loader.renderComponentCSS(0));
         */
    }

    @Override
    public JQXLoaderOptions getOptions()
    {
        return feature.getOptions();
    }

}
