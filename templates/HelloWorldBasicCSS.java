package za.co.mmagon;

import com.google.inject.Singleton;
import za.co.mmagon.jwebswing.CSSComponent;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.html.Paragraph;
import za.co.mmagon.jwebswing.base.servlets.JWebSwingServlet;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.backgrounds.BackgroundCSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourCSSImpl;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourNames;
import za.co.mmagon.jwebswing.htmlbuilder.css.interfaces.LinkCSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.text.TextAlignments;
import za.co.mmagon.jwebswing.htmlbuilder.css.text.TextCSS;

//CSS implementations are divided as per W3.org or W3Schools. http://www.w3schools.com/css/
@Singleton
public class HelloWorldBasicCSS extends JWebSwingServlet
{

    private static final long serialVersionUID = 1L;
    //Way One - Annotate your CSS
    @CSS(Text = @TextCSS(Color$ = ColourNames.Aquamarine))
    //Use the link css to support different CSS states
    @LinkCSS(hover = @CSS,
            active = @CSS,
            link = @CSS,
            visited = @CSS)
    private Paragraph helloThree;

    /**
     * The page to be displayed.
     *
     * @return
     */
    @Override
    public Page getPage()
    {
        Page p = new Page();

        helloThree = new Paragraph("Hello World CSS Injected via Annotation");

        Paragraph paragraph = new Paragraph("Hello World");
        //Way Two - Direct Implementation on the object
        paragraph.getCss().getText().setColor$(ColourNames.Coral);
        //Assign values according to hex, RGBA, or RGB, or use the enumerations
        paragraph.getCss().getText().setColor(new ColourCSSImpl("#ffffff"));
        paragraph.getHoverCss().getText().setColor(new ColourCSSImpl("#ffffff")); //Hover effect
        paragraph.getLinkCss().getText().setColor(new ColourCSSImpl("#ffffff")); //link effect
        paragraph.getVisitedCss().getText().setColor(new ColourCSSImpl("#ffffff")); //visited effect

        //Way Three - Assign a CSS Class
        Paragraph cssHelloWorld = new Paragraph("Hello World with CSS Class");
        cssHelloWorld.addClass(new HelloWorldCSS());

        p.getBody().add(paragraph);
        p.getBody().add(helloThree);
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

    //Assign css classes
    @CSS(Background = @BackgroundCSS(BackgroundColor$ = ColourNames.Aqua),
            Text = @TextCSS(TextAlign = TextAlignments.Justify))
    class HelloWorldCSS extends CSSComponent
    {

        private static final long serialVersionUID = 1L;

        public HelloWorldCSS()
        {
            super("helloworld");
        }
    }
}
