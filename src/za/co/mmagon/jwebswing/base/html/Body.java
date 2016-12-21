package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.logger.LogFactory;
import java.util.logging.*;
import java.util.logging.*;
import za.co.mmagon.jwebswing.*;
import za.co.mmagon.jwebswing.base.*;
import za.co.mmagon.jwebswing.base.angular.*;
import za.co.mmagon.jwebswing.base.client.*;
import za.co.mmagon.jwebswing.base.html.attributes.*;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.children.*;
import za.co.mmagon.jwebswing.base.html.interfaces.events.*;
import za.co.mmagon.jwebswing.base.references.*;
import za.co.mmagon.jwebswing.base.servlets.enumarations.*;
import za.co.mmagon.jwebswing.base.servlets.interfaces.*;
import za.co.mmagon.jwebswing.components.bootstrap.*;
import za.co.mmagon.jwebswing.components.bootstrap.dialog.*;
import za.co.mmagon.jwebswing.components.modernizr.*;
import za.co.mmagon.jwebswing.components.pace.*;
import za.co.mmagon.jwebswing.components.pace.preloadedThemes.*;
import za.co.mmagon.jwebswing.components.pools.jquery.*;
import za.co.mmagon.jwebswing.components.pools.jqueryui.*;

/**
 * Browser Support<p>
 * <p>
 * Internet Explorer FireFox Opera Google Chrome Safari<p>
 * <p>
 * The body tag is supported in all major browsers.<p>
 * <p>
 * Definition and Usage<p>
 * <p>
 * The body tag defines the document's body.<p>
 * <p>
 * The body element contains all the contents of an HTML document, such as text,
 * <p>
 * hyperlinks, images, tables, lists, etc.<p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * All layout attributes is removed from HTML5.<p>
 * <p>
 * All layout attributes is deprecated in HTML 4.01
 * .<p>
 * <p>
 * @param <L> A loader type
 * @param <F> Features Base
 *
 * @since 2013/11/20
 * @author Marc Magon
 * @version 1.0
 */
public class Body<L extends ComponentFeatureBase & Loader & GlobalChildren, F extends BodyFeatures>
        extends Component<GlobalChildren, BodyAttributes, F, NoEvents, Body>
        implements PageChildren, HtmlChildren, LayoutHandler, ContainerType, IBody<L>
{

    private static final Logger LOG = LogFactory.getInstance().getLogger("BODY");

    private static final long serialVersionUID = 1L;

    private L loader;

    private boolean bootstrapConfigured;

    private boolean bootstrap4;

    private boolean jquery3 = true;

    /**
     * The object for the pace loader
     */
    private PaceLoader pace;

    /**
     * Constructs a new Body with the given Page input
     *
     * @param page
     */
    public Body(Page page)
    {
        super(ComponentTypes.Body);
        setPage(page);
        setID("body");
    }

    /**
     * Returns the component in its smallest form
     *
     * @return
     */
    public IBody asMe()
    {
        return this;
    }

    /**
     * Will configure for Angular 1
     */
    @Override
    public void configureAngular()
    {
        if (getPage().getOptions().isAngularEnabled())
        {
            //getPage().getOptions().setPaceEnabled(true);
            //configurePace();
            getPage().getOptions().setjQueryEnabled(true);
            configureJQuery();
            //getPage().getOptions().setBootstrapEnabled(true);
            //configureBootstrap();

            getJavascriptReferences().add(AngularReferencePool.Angular1.getJavaScriptReference());
        }
    }

    /**
     *
     * The 3 meta tags *must* come first in the head; any other head content must come *after* these tags
     * <p>
     * HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries WARNING: Respond.js doesn't work if you view the page via file://
     */
    @Override
    public void configureBootstrap()
    {
        if (isBootstrapConfigured())
        {
            return;
        }
        else
        {
            setBootstrapConfigured(true);
        }
        getPage().getOptions().setjQueryEnabled(true);
        configureJQuery();

        Meta charMeta = new Meta();
        charMeta.addAttribute(MetaAttributes.Charset, "utf-16");

        Meta viewportMeta = new Meta();
        viewportMeta.addAttribute(GlobalAttributes.Name, "viewport");
        if (isBootstrap4())
        {
            viewportMeta.addAttribute(MetaAttributes.Content, "width=device-width, initial-scale=1, shrink-to-fit=no");
        }
        else
        {
            viewportMeta.addAttribute(MetaAttributes.Content, "width=device-width, initial-scale=1");
        }

        //created again for positioning, not sorted yet TODO
        Meta compatMeta = new Meta();
        compatMeta.addAttribute(MetaAttributes.Http_Equiv, "X-UA-Compatible");
        compatMeta.addAttribute(MetaAttributes.Content, "IE=Edge");

        getPage().getHead().add(charMeta);
        getPage().getHead().add(compatMeta);
        getPage().getHead().add(viewportMeta);

        if (getPage().getOptions().isBootstrapEnabled())
        {
            if (isBootstrap4())
            {
                addJavaScriptReference(BootstrapReferencePool.Bootstrap4TetherReference.getJavaScriptReference());
                addJavaScriptReference(BootstrapReferencePool.Bootstrap4CoreReference.getJavaScriptReference());
                addCssReference(BootstrapReferencePool.Bootstrap4CoreReference.getCssReference());
            }
            else
            {
                addJavaScriptReference(BootstrapReferencePool.BootstrapCoreReference.getJavaScriptReference());
                addCssReference(BootstrapReferencePool.BootstrapCoreReference.getCssReference());
            }
            //always add the dialog for server responses
            addFeature(new BootstrapDialogFeature(this));
        }

        if (getPage().getBrowser().compareTo(Browsers.InternetExplorer8) < 1)
        {
            addJavaScriptReference(new JavascriptReference("html5shim", 1.0, "https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js", RequirementsPriority.Fourth));
            addJavaScriptReference(new JavascriptReference("html5shimrespond", 1.0, "https://oss.maxcdn.com/respond/1.4.2/respond.min.js", RequirementsPriority.Fourth));
        }

    }

    @Override
    public void configureJQueryUI()
    {
        getPage().getOptions().setjQueryEnabled(true);
        configureJQuery();

        if (getPage().getOptions().isjQueryUIEnabled())
        {
            addJavaScriptReference(JQueryUIReferencePool.Core.getJavaScriptReference());
            addCssReference(JQueryUIReferencePool.Core.getCssReference());

            addJavaScriptReference(JQueryUIReferencePool.Widget.getJavaScriptReference());
            addCssReference(JQueryUIReferencePool.Widget.getCssReference());

            addJavaScriptReference(JQueryUIReferencePool.Mouse.getJavaScriptReference());
        }
    }

    /**
     * Configures pace for use
     */
    @Override
    public void configurePace()
    {

        if (getPage().getOptions().isPaceEnabled())
        {
            removeFeature((F) getLoader());
            pace = new PaceLoader(PaceTheme.Flash);
            setLoader((L) pace);
            addFeature(getLoader());
        }
    }

    /**
     * Configures pace for use
     *
     * @param pace
     */
    @Override
    public void configurePace(PaceLoader pace)
    {

        if (getPage().getOptions().isPaceEnabled())
        {
            removeFeature((F) getLoader());
            setLoader((L) pace);
            addFeature(getLoader());
        }
    }

    @Override
    public void configureModernizr()
    {
        if (getPage().getOptions().isModernizrEnabled())
        {
            addFeature(new ModernizrFeature(this));
        }
    }

    /**
     * Adds JQuery Accordingly
     */
    public void configureJQuery()
    {
        if (getPage() != null)
        {
            if (getPage().getOptions().isjQueryEnabled())
            {
                if (getPage().getBrowser() != null)
                {
                    if (getPage().getBrowser().getBrowserGroup() == BrowserGroups.InternetExplorer)
                    {
                        if (getPage().getBrowser().getBrowserVersion() < 9)
                        {
                            removeJavaScriptReference(JQueryReferencePool.JQueryV2.getJavaScriptReference());
                            removeJavaScriptReference(JQueryReferencePool.JQueryV3.getJavaScriptReference());
                            removeJavaScriptReference(JQueryReferencePool.JQueryMigrate.getJavaScriptReference());
                            addJavaScriptReference(JQueryReferencePool.JQuery.getJavaScriptReference());
                        }
                    }
                    else
                    {
                        removeJavaScriptReference(JQueryReferencePool.JQuery.getJavaScriptReference());
                        if (isJquery3())
                        {
                            addJavaScriptReference(JQueryReferencePool.JQueryV3.getJavaScriptReference());
                            addJavaScriptReference(JQueryReferencePool.JQueryMigrate.getJavaScriptReference());
                        }
                        else
                        {
                            addJavaScriptReference(JQueryReferencePool.JQueryV2.getJavaScriptReference());
                            //addJavaScriptReference(JQueryReferencePool.JQueryMigrate.getJavaScriptReference());
                        }
                    }
                }
                else if (isJquery3())
                {
                    addJavaScriptReference(JQueryReferencePool.JQueryV3.getJavaScriptReference());
                    addJavaScriptReference(JQueryReferencePool.JQueryMigrate.getJavaScriptReference());
                }
                else
                {
                    addJavaScriptReference(JQueryReferencePool.JQueryV2.getJavaScriptReference());
                    //addJavaScriptReference(JQueryReferencePool.JQueryMigrate.getJavaScriptReference());
                }
            }
        }
    }

    /*
     * @Override public void preConfigure() { super.preConfigure(); configurePace(); configureJQuery(); }
     */
    @Override
    protected StringBuilder renderHTML(int tabCount)
    {
        return super.renderHTML(tabCount);
    }

    /**
     * Returns this Body AJAX JQXLoader
     *
     * @return The loader associated with this Body object
     */
    @Override
    public L getLoader()
    {
        return loader;
    }

    /**
     * Sets this bodies loader
     * <p>
     * @param loader The loader to set
     */
    @Override
    public void setLoader(L loader)
    {
        this.loader = loader;
    }

    /**
     * Returns if bootstrap is configured
     *
     * @return
     */
    @Override
    public boolean isBootstrapConfigured()
    {
        return bootstrapConfigured;
    }

    /**
     * Sets the bootstrap configured flag
     *
     * @param bootstrapConfigured
     */
    @Override
    public void setBootstrapConfigured(boolean bootstrapConfigured)
    {
        this.bootstrapConfigured = bootstrapConfigured;
    }

    /**
     * Gets the pace loader associated with this application
     *
     * @return
     */
    @Override
    public PaceLoader getPace()
    {
        return pace;
    }

    /**
     * Sets the pace loader for this application
     *
     * @param pace The PaceLoader
     */
    @Override
    public void setPace(PaceLoader pace)
    {
        this.pace = pace;
    }

    /*
     * If we are using bootstrap 4
     */
    @Override
    public boolean isBootstrap4()
    {
        return bootstrap4;
    }

    /**
     * If we are using bootstrap 3
     *
     * @param bootstrap4
     */
    @Override
    public void setBootstrap4(boolean bootstrap4)
    {
        this.bootstrap4 = bootstrap4;
    }

    /**
     * Sets if this page must use JQuery 3 or 2
     *
     * @return
     */
    @Override
    public boolean isJquery3()
    {
        return jquery3;
    }

    /**
     * Sets if this page must use JQuery 3 or 2
     *
     * @param jquery3
     */
    @Override
    public void setJquery3(boolean jquery3)
    {
        this.jquery3 = jquery3;
    }

}
