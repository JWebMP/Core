package za.co.mmagon.jwebswing.base.servlets.interfaces;

import javax.servlet.http.HttpSession;
import za.co.mmagon.jwebswing.base.servlets.JWebSwingServlet;

/**
 *
 * @author Marc Magon
 */
public interface IPage
{

    public JWebSwingServlet getServlet();

    public void setServlet(JWebSwingServlet servlet);

    public void setSession(HttpSession session);

    public HttpSession getSession();
}
