package za.co.mmagon.jwebswing.base.servlets;

import com.armineasy.injection.GuiceContext;
import com.google.inject.*;
import com.google.inject.name.Named;
import com.google.inject.servlet.RequestScoped;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.ajax.exceptions.MissingComponentException;
import za.co.mmagon.jwebswing.base.client.Browsers;
import za.co.mmagon.jwebswing.base.html.Base;
import za.co.mmagon.jwebswing.base.html.Body;
import za.co.mmagon.jwebswing.base.html.attributes.*;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.generics.DynamicLoadingPage;
import za.co.mmagon.jwebswing.utilities.TextUtilities;
import za.co.mmagon.logger.LogFactory;

/**
 * The base Servlet for the JWebSwing environment. Constructs each page on call
 *
 * @author Marc Magon
 * @version 1.1
 * @since 2012/10/09
 */
@Singleton
public abstract class JWebSwingServlet extends JWDefaultServlet implements Provider<Page>
{

    /**
     * The logger for the swing Servlet
     */
    private static final Logger LOG = LogFactory.getInstance().getLogger("JWebSwingServlet");
    /**
     * The logger for the session handler Servlet
     */
    private static final Logger SESSION_LOG = LogFactory.getInstance().getLogger("SessionHandler");

    /**
     * Version 1
     */
    private static final long serialVersionUID = 1L;

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
     * Reads the variables into the HTTP session
     *
     * @param request
     *
     * @throws MissingComponentException
     */
    private void readRequestVariables(HttpServletRequest request) throws MissingComponentException
    {
        Page currentPage = getPage();
        HttpSession session = GuiceContext.Injector().getInstance(HttpSession.class);
        session.setAttribute("jwpage", currentPage);
        if (currentPage == null)
        {
            throw new MissingComponentException("[No Page]-[getPage() returning null in servlet class]");
        }
        if (request.getSession().isNew())
        {
            SESSION_LOG.log(Level.FINE, "[SessionID]-[{0}];[Name]-[User Login];[Action]-[Session Added];", request.getSession().getId());
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
        HttpSession session = GuiceContext.Injector().getInstance(HttpSession.class);
        getPage().setUserAgent(agent);
        Browsers b;
        if (agent.getVersionNumber().getMajor().isEmpty() && agent.getVersionNumber().getMinor().isEmpty())
        {
            b = Browsers.getBrowserFromNameAndVersion("Edge", 13);
        }
        else
        {
            b = Browsers.getBrowserFromNameAndVersion(agent.getName(), Double.parseDouble(agent.getVersionNumber().getMajor() + "." + agent.getVersionNumber().getMinor()));
        }
        getPage().setBrowser(b);
        if (agent.getVersionNumber().getMajor() == null || agent.getVersionNumber().getMajor().isEmpty())
        {
            LOG.log(Level.INFO, "[SessionID]-[{0}];[Browser]-[{1}];[Version]-[{2}];[Operating System]-[{3}];[Device Category]-[{4}];[Device]-[{5}];[CSS]-[{6}];[HTML]-[{7}];", new Object[]
            {
                request.getSession().getId(), b.getBrowserGroup().toString(), b.getBrowserVersion(), agent.getOperatingSystem().getName(), agent.getDeviceCategory().getCategory(), agent.getDeviceCategory().getName(), b.getCapableCSSVersion(), b.getHtmlVersion()
            });
        }
        else
        {
            LOG.log(Level.INFO, "[SessionID]-[{0}];[Browser]-[{1}];[Version]-[{2}.{3}];[Operating System]-[{4}];[Device Category]-[{5}];[Device]-[{6}];[CSS]-[{7}];[HTML]-[{8}];", new Object[]
            {
                request.getSession().getId(), agent.getName(), agent.getVersionNumber().getMajor(), agent.getVersionNumber().getMinor(), agent.getOperatingSystem().getName(), agent.getDeviceCategory().getCategory(), agent.getDeviceCategory().getName(), b.getCapableCSSVersion(), b.getHtmlVersion()
            });
        }
    }

    /**
     * Sends the page out
     *
     * @param request
     * @param response
     *
     * @throws IOException
     */
    private void sendPage(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try
        {
            Date startDate = new Date();
            StringBuilder output = new StringBuilder();

            Page page = getPage();

            if (page.getOptions().isLocalStorage())
            {
                DynamicLoadingPage p = GuiceContext.Injector().getInstance(DynamicLoadingPage.class);
                if (!p.isRequirementsConfigured())
                {
                    p.setPage(page);
                }

                if (page.getOptions().isGoogleMapsJSApi())
                {
                    p.getBody().addJavaScriptReference(new JavascriptReference("Google Maps API Reference", 1.0, "https://maps.googleapis.com/maps/api/js?key=" + page.getOptions().getGoogleMapsJSApi()).setCordovaRequired(true));
                }
                if (page.getPageFields().getTitle() != null)
                {
                    p.getPageFields().setTitle(page.getPageFields().getTitle().getTitle());
                }
                if (page.getPageFields().getAuthor() != null)
                {
                    p.getPageFields().setAuthor(page.getPageFields().getAuthor().getAttribute(MetaAttributes.Content));
                }
                if (page.getPageFields().getApplicationName() != null)
                {
                    p.getPageFields().setApplicationNameMeta(page.getPageFields().getApplicationName().getAttribute(MetaAttributes.Content));
                }
                if (page.getPageFields().getCacheControl() != null)
                {
                    p.getPageFields().setCacheControl(page.getPageFields().getCacheControl().getAttribute(MetaAttributes.Content, Boolean.FALSE));
                }
                if (page.getPageFields().getFavIconLink() != null)
                {
                    p.getPageFields().setFavIcon(page.getPageFields().getFavIconLink().getAttribute(CSSLinkAttributes.HRef));
                }
                p.getPageFields().setGenerator("JWebSwing");
                if (page.getPageFields().getKeywords() != null)
                {
                    p.getPageFields().setKeywords(page.getPageFields().getKeywords().getAttribute(MetaAttributes.Content));
                }
                Base base = new Base();
                base.addAttribute(BaseAttributes.HRef, request.getRequestURL().toString());
                p.getPageFields().setBase(base);
                output.append(p.toString(true));
            }
            else
            {
                if (page.getOptions().isGoogleMapsJSApi())
                {
                    page.getBody().addJavaScriptReference(new JavascriptReference("Google Maps API Reference", 1.0, "https://maps.googleapis.com/maps/api/js?key=" + page.getOptions().getGoogleMapsJSApi()));
                }
                output = getPageHTML(request.getSession());
            }

            Date endDate = new Date();
            Date transferStart = new Date();
            out = response.getWriter();
            out.println(output);
            Date dataTransferDate = new Date();
            LOG.log(Level.FINE, "[SessionID]-[{0}];[Render Time]-[{1}];[Data Size]-[{2}];[Transer Time]=[{3}]", new Object[]
            {
                request.getSession().getId(), endDate.getTime() - startDate.getTime(), output.length(), dataTransferDate.getTime() - transferStart.getTime()
            });
            //pre render page for next call
            if (page.getOptions().isLocalStorage())
            {
                page.toString(true);
            }
        }
        catch (IOException ex)
        {
            LOG.log(Level.SEVERE, "[Network]-[Connection Dead]", ex);
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
                LOG.log(Level.SEVERE, "Can't send page", e);
            }
        }
    }

    /**
     * Processes requests for the WebSwing Servlet.
     *
     * @param request  The Default Servlet request
     * @param response The Default Servlet response
     *
     * @throws ServletException if a Servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
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
            LOG.log(Level.SEVERE, "No Page For Servlet", mce);
            Page p = new Page();
            p.getBody().add("No Page or Body Configured for the JWebSwingServlet. [getPage()] returned nothing");
            response.getWriter().write(p.toString(true));
        }
        catch (IOException | NumberFormatException ex)
        {

            LOG.log(Level.SEVERE, "Couldn't Render Page in Servlet. Fatal Error.", ex);
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = null;
            try
            {
                out = response.getWriter();
                out.println(getErrorPageHtml(ex).toString(true));
            }
            catch (IOException ex1)
            {
                LOG.log(Level.SEVERE, "Unable to generate page html to return!", ex1);
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
                    LOG.log(Level.SEVERE, null, e);
                }
            }
        }
        catch (Error | Exception t)
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
                LOG.log(Level.SEVERE, "Unable to generate page html to return!", ex1);
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
                    LOG.log(Level.SEVERE, null, e);
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
        html = new StringBuilder(getPage().toString(true));
        return html;
    }

    /**
     * In the event of any error return this page.
     *
     * @param t The exception thrown
     *
     * @return The rendered HTML.
     */
    protected Page getErrorPageHtml(Throwable t)
    {
        Page p = new Page();
        p.getPageFields().setTitle("Exception occured in application");
        p.getPageFields().setAuthor("Marc Magon");
        p.getPageFields().setDescription("JWebSwing Error Generated Page");
        p.getPageFields().setGenerator("JWebSwing - https://sourceforge.net/projects/jwebswing/");
        Body b = p.getBody();
        b.add("The following error was encountered during render<br/><hr/>");
        b.add(TextUtilities.stackTraceToString(t));
        return p;
    }

    /**
     * In the event of any error return this page.
     *
     * @param t The exception thrown
     *
     * @return The rendered HTML.
     */
    @Provides
    @Named("ErrorPage")
    @RequestScoped
    protected Page getErrorPageHtml(Error t)
    {
        Page p = new Page();
        p.getPageFields().setTitle("ERROR : Error occured in application");
        p.getPageFields().setAuthor("Marc Magon");
        p.getPageFields().setDescription("JWebSwing Error Generated Page");
        p.getPageFields().setGenerator("JWebSwing - https://sourceforge.net/projects/jwebswing/");
        Body b = p.getBody();
        b.add("The following error was encountered during render<br/><hr/>");
        b.add(TextUtilities.stackTraceToString(t));
        return p;
    }

    /**
     * Return the Mobile Page HTML
     *
     * @param session
     *
     * @return
     */
    @Provides
    @Named("MobilePage")
    @RequestScoped
    protected StringBuilder getPageMobileHTML(HttpSession session)
    {
        LOG.log(Level.FINE, "Started Rendering Mobile HTML");
        StringBuilder html;
        html = new StringBuilder(getPage().toString(true));
        return html;
    }

    /**
     * The initial page for this Servlet
     *
     * @return A Page for the Servlet
     */
    @Provides
    @RequestScoped
    public abstract Page getPage();

    /**
     * Returns the get page method
     *
     * @return
     */
    @Override
    public Page get()
    {
        return getPage();
    }

    /**
     * Returns the URL associated with this Servlet
     *
     * @return
     */
    @Provides
    @Named("URLPath")
    public abstract String getUrl();

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  Servlet request
     * @param response Servlet response
     *
     * @throws ServletException if a Servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            super.doGet(request, response);
            if (request.getHeader("Content-Type") == null || request.getHeader("Content-Type").isEmpty())
            {
                processRequest(request, response);
            }
        }
        catch (IOException | ServletException ex)
        {
            LOG.log(Level.SEVERE, "SwingServlet", ex);
        }
    }

    /**
     * Returns if the user is logged in or not
     *
     * @return
     */
    public boolean isUserLoggedIn()
    {
        return false;
    }

}
