package za.co.mmagon;

import com.google.inject.Singleton;
import za.co.mmagon.jwebswing.Event;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.Paragraph;
import za.co.mmagon.jwebswing.base.servlets.JWebSwingServlet;
import za.co.mmagon.jwebswing.events.blur.BlurAdapter;
import za.co.mmagon.jwebswing.events.click.ClickAdapter;
import za.co.mmagon.jwebswing.events.focus.FocusAdapter;
import za.co.mmagon.jwebswing.events.rightclick.RightClickAdapter;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourNames;

@Singleton
public class HelloWorldClick extends JWebSwingServlet
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
        Paragraph hello = new Paragraph("Hello World Clickable");

        //Basic Click Functionality
        hello.addEvent(new ClickAdapter(hello)
        {
            @Override
            public void onClick(AjaxCall call, AjaxResponse response)
            {
                hello.setText("I have been clicked I have");
                response.addComponent(hello);
            }
        });

        //Right Click Example
        hello.addEvent(new RightClickAdapter(hello)
        {
            @Override
            public void onRightClick(AjaxCall call, AjaxResponse response)
            {
                hello.setText("I have been right clicked I have");
                hello.getCss().getText().setColor$(ColourNames.Magenta);
                response.addComponent(hello);
            }
        });

        //On Blur Example
        hello.addEvent(new BlurAdapter(hello)
        {
            @Override
            public void onBlur(AjaxCall call, AjaxResponse response)
            {
                hello.setText("Oooo blured");
                hello.getCss().getText().setColor$(ColourNames.PeachPuff);
                response.addComponent(hello);
            }
        });

        //Perform custom query on server side that responds with client side javascript
        hello.addEvent(new FocusAdapter(hello)
        {
            @Override
            public void onFocus(AjaxCall call, AjaxResponse response)
            {
                hello.setText("I have been focussed");
                response.addComponent(hello);
                getOnDemandQueries().add(new Event("basic alert box")
                {
                    @Override
                    protected void assignFunctionsToComponent()
                    {
                        getQueries().add("alert('custom stuff for on focus');");
                    }
                });
            }
        });

        //Custom client side event
        hello.addEvent(new Event("Custom", hello)
        {
            @Override
            protected void assignFunctionsToComponent()
            {
                getQueries().add(getComponent().getJQueryID() + "on('click',function(){alert('client side event');});");
            }
        });

        p.getBody().add(hello);
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

    public static void main(String[] args)
    {
        System.out.println(new HelloWorldClick().getPage().toString(true));
    }
}
