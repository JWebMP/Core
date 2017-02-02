package za.co.mmagon;

import com.google.inject.Singleton;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.servlets.JWebSwingServlet;

@Singleton
public class HelloWorldCustomDependancies extends JWebSwingServlet
{

    private static final long serialVersionUID = 1L;

    /**
     * The page to be displayed.
     *
     * @return
     */
    @Override
    public Page getPage()
    {
        Page p = new Page();
        p.getBody().add("Hello World");

        //Add or Remove external dependancies to any built component at any point of the app
        p.getBody().getCssReferences().add(new CSSReference("CSSRef1", 1.0, "style.css"));
        p.getBody().getJavascriptReferences().add(new JavascriptReference("JSRef1", 1.0, "app.js"));

        return p;
    }

    /**
     * Relative path to context
     *
     * @return
     */
    @Override
    public String getUrl()
    {
        return "/";
    }
}
