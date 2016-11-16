package za.co.mmagon.jwebswing.base.servlets;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Logger;
import za.co.mmagon.LoggerFactory;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.ajax.exceptions.MissingComponentException;
import za.co.mmagon.jwebswing.base.client.Browsers;
import za.co.mmagon.jwebswing.base.html.Body;
import za.co.mmagon.jwebswing.utilities.TextUtilities;

/**
 * The base Servlet for the JWebSwing environment. Constructs each page on call
 *
 * @author Marc Magon
 * @version 1.1
 * @since 2012/10/09
 */
@Singleton
public abstract class JWebSwingServlet extends JWDefaultServlet
{

    /**
     * The logger for the swing Servlet
     */
    private static final Logger LOG = LoggerFactory.getInstance().makeNewLoggerInstance("JWebSwingServlet");
    /**
     * The logger for the session handler Servlet
     */
    private static final Logger SESSION_LOG = LoggerFactory.getInstance().makeNewLoggerInstance("SessionHandler");

    /**
     * Version 1
     */
    private static final long serialVersionUID = 1L;

    /**
     * All the current sessions and their pages. Static for direct reference
     */
    private static HashMap<String, JWebSwingServlet> sessionPages;

    /**
     * The User Agent Parser
     */
    private static final UserAgentStringParser userAgentParser = UADetectorServiceFactory.getResourceModuleParser();

    /**
     * Constructs a new JWebSwing Servlet that is not session aware
     */
    public JWebSwingServlet()
    {
    }

    /**
     * Returns the number of sessions
     *
     * @return
     */
    public int getNumberOfSessions()
    {
        return getSessionPages().size();
    }

    /**
     * Reads the variables into the HTTP session
     *
     * @param request
     * @throws MissingComponentException
     */
    private void readRequestVariables(HttpServletRequest request) throws MissingComponentException
    {
        Page currentPage = getNewPage(request.getSession().getId());
        request.getSession().setAttribute("jwpage", currentPage);
        if (currentPage == null)
        {
            throw new MissingComponentException("[No Page]-[getPage() returning null in servlet class]");
        }
        getCurrentPage(request.getSession()).setServlet(this);
        if (request.getSession().isNew())
        {
            getSessionPages().put(request.getSession().getId(), this);
            SESSION_LOG.trace("[SessionID]-[" + request.getSession().getId() + "];[Name]-[User Login];[Action]-[Session Added];" + "[Session Count]-[" + getNumberOfSessions() + "]");
        }
    }

    /**
     * Reads the user agent header into the browser object and places it for the page to render
     *
     * @param request
     */
    private void readBrowserInformation(HttpServletRequest request)
    {
        String headerInformation = request.getHeader("User-Agent");
        ReadableUserAgent agent = userAgentParser.parse(headerInformation);
        getCurrentPage(request.getSession()).setUserAgent(agent);
        Browsers b;
        if (agent.getVersionNumber().getMajor().isEmpty() && agent.getVersionNumber().getMinor().isEmpty())
        {
            b = Browsers.getBrowserFromNameAndVersion("Edge", 13);
        }
        else
        {
            b = Browsers.getBrowserFromNameAndVersion(agent.getName(), Double.parseDouble(agent.getVersionNumber().getMajor() + "." + agent.getVersionNumber().getMinor()));
        }
        getCurrentPage(request.getSession()).setBrowser(b);
        if (agent.getVersionNumber().getMajor() == null || agent.getVersionNumber().getMajor().isEmpty())
        {
            LOG.trace("[SessionID]-[" + request.getSession().getId() + "];" + "[Browser]-[" + b.getBrowserGroup().toString() + "];[Version]-[" + b.getBrowserVersion() + "];[Operating System]-[" + agent.getOperatingSystem().getName() + "];[Device Category]-[" + agent.getDeviceCategory().getCategory() + "];[Device]-[" + agent.getDeviceCategory().getName() + "];" + "[CSS]-[" + b.getCapableCSSVersion() + "];[HTML]-[" + b.getHtmlVersion() + "];");
        }
        else
        {
            LOG.trace("[SessionID]-[" + request.getSession().getId() + "];" + "[Browser]-[" + agent.getName() + "];[Version]-[" + agent.getVersionNumber().getMajor() + "." + agent.getVersionNumber().getMinor() + "];[Operating System]-[" + agent.getOperatingSystem().getName() + "];[Device Category]-[" + agent.getDeviceCategory().getCategory() + "];[Device]-[" + agent.getDeviceCategory().getName() + "];" + "[CSS]-[" + b.getCapableCSSVersion() + "];[HTML]-[" + b.getHtmlVersion() + "];");
        }
    }

    /**
     * Sends the page out
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private void sendPage(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try
        {
            Date startDate = new Date();
            StringBuilder sb = getPageHTML(request.getSession());
            Date endDate = new Date();
            Date transferStart = new Date();
            out = response.getWriter();
            out.println(sb);
            Date dataTransferDate = new Date();
            LOG.trace("[SessionID]-[" + request.getSession().getId() + "];" + "[Render Time]-[" + (endDate.getTime() - startDate.getTime()) + "];[Data Size]-[" + sb.length() + "];[Transer Time]=[" + (dataTransferDate.getTime() - transferStart.getTime()) + "]");
        }
        catch (IOException ex)
        {
            LOG.fatal("[Network]-[Connection Dead]", ex);
            throw ex;
        }
        finally
        {
            try
            {
                if (out != null)
                {
                    out.close();
                }
            }
            catch (Exception e)
            {
                LOG.error(e);
            }
        }
    }

    /**
     * Processes requests for the WebSwing Servlet.
     *
     * @param request The Default Servlet request
     * @param response The Default Servlet response
     * @throws ServletException if a Servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            readRequestVariables(request);
            readBrowserInformation(request);
            sendPage(request, response);
        }
        catch (MissingComponentException mce)
        {
            LOG.fatal("No Page For Servlet", mce);
            Page p = new Page();
            p.getBody().add("No Page or Body Configured for the JWebSwingServlet. [getPage()] returned nothing");
            response.getWriter().write(p.toString(true));
        }
        catch (IOException | NumberFormatException ex)
        {

            LOG.fatal("Couldn't Render Page in Servlet. Fatal Error.", ex);
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = null;
            try
            {
                out = response.getWriter();
                out.println(getErrorPageHtml(ex).toString(true));
            }
            catch (IOException ex1)
            {
                LOG.fatal("Unable to generate page html to return!", ex1);
            }
            finally
            {
                try
                {
                    if (out != null)
                    {
                        out.close();
                    }
                }
                catch (Exception e)
                {
                    LOG.fatal(e);
                }
            }
        }
        catch (Exception t)
        {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = null;
            try
            {
                out = response.getWriter();
                out.println(getErrorPageHtml(t).toString(true));
            }
            catch (IOException ex1)
            {
                LOG.fatal("Unable to generate page html to return!", ex1);
            }
            finally
            {
                try
                {
                    if (out != null)
                    {
                        out.close();
                    }
                }
                catch (Exception e)
                {
                    LOG.fatal(e);
                }
            }
        }
    }

    /**
     * Generates the Page HTML
     *
     * @return
     */
    private StringBuilder getPageHTML(HttpSession session)
    {
        StringBuilder html;
        html = new StringBuilder(getCurrentPage(session).toString(true));
        return html;
    }

    /**
     * In the event of any error return this page.
     *
     * @param t The exception thrown
     * @return The rendered HTML.
     */
    protected Page getErrorPageHtml(Exception t)
    {
        Page p = new Page();
        p.setTitle("Exception occured in application");
        p.setAuthor("Marc Magon");
        p.setDescription("JWebSwing Error Generated Page");
        p.setGenerator("JWebSwing - https://sourceforge.net/projects/jwebswing/");
        Body b = new Body(p);
        b.add("The following error was encountered during render<br/><hr/>");
        b.add(TextUtilities.stackTraceToString(t));
        return p;
    }

    /**
     * In the event of any error return this page.
     *
     * @param t The exception thrown
     * @return The rendered HTML.
     */
    protected Page getErrorPageHtml(Error t)
    {
        Page p = new Page();
        p.setTitle("ERROR : Error occured in application");
        p.setAuthor("Marc Magon");
        p.setDescription("JWebSwing Error Generated Page");
        p.setGenerator("JWebSwing - https://sourceforge.net/projects/jwebswing/");
        Body b = new Body(p);
        b.add("The following error was encountered during render<br/><hr/>");
        b.add(TextUtilities.stackTraceToString(t));
        return p;
    }

    /**
     * Return the Mobile Page HTML
     *
     * @param session
     * @return
     */
    protected StringBuilder getPageMobileHTML(HttpSession session)
    {
        LOG.trace("Started Rendering Mobile HTML");
        StringBuilder html;
        html = new StringBuilder(getCurrentPage(session).toString(true));
        return html;
    }

    /**
     * Return a custom log appender. Is appended on application start
     *
     * @return The type required to operate.
     */
    public AppenderSkeleton getLogAppender()
    {
        return null;
    }

    /**
     * The initial page for this Servlet
     *
     * @param sessionId The session to return the current page
     * @return A Page for the Servlet
     */
    public abstract Page getNewPage(String sessionId);

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request Servlet request
     * @param response Servlet response
     * @throws ServletException if a Servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        super.doGet(request, response);
        if (request.getHeader("Content-Type") == null || request.getHeader("Content-Type").isEmpty())
        {
            processRequest(request, response);
        }
    }

    /**
     * Returns a session's JWebSwing's Servlet
     *
     * @param sessionID The session ID
     * @return The session Servlet
     */
    public static final JWebSwingServlet getSessionServlet(String sessionID)
    {
        return getSessionPages().get(sessionID);
    }

    /**
     * Receives all Session Pages
     *
     * @return
     */
    public static HashMap<String, JWebSwingServlet> getSessionPages()
    {
        if (sessionPages == null)
        {
            sessionPages = new HashMap<>();
        }
        return sessionPages;
    }

    /**
     * Returns if the user is logged in or not
     *
     * @return
     */
    public boolean isUserLoggedIn()
    {
        return true;
    }

    /**
     * Returns the current page being displayed with this Servlet
     *
     * @param session
     * @return
     */
    @Inject
    public Page getCurrentPage(HttpSession session)
    {
        return (Page) session.getAttribute("jwpage");
    }

    @Override
    public void init() throws ServletException
    {
        AppenderSkeleton as = getLogAppender();
        if (as != null)
        {
            LoggerFactory.getInstance().addLogAppender(getLogAppender());
            LOG.trace("[Log Appender]-[" + getLogAppender().getClass().getSimpleName() + " Added]");
        }
        LOG.trace("[JWebSwingServlet]-[Constructed];");
        super.init();
    }
}
