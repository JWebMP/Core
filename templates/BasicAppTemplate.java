package za.co.mmagon.helloworld;

import com.google.inject.Singleton;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.servlets.JWebSwingServlet;

@Singleton
public class AppTemplate extends JWebSwingServlet
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
        return new Page();
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
