package za.co.mmagon.helloworld;

import com.google.inject.Singleton;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.servlets.JWebSwingServlet;

@Singleton
public class BasicAppTemplate extends JWebSwingServlet
{

    @Override
    public Page getPage()
    {
        return new Page();
    }

    @Override
    public String getUrl()
    {
        return "/";
    }
}
