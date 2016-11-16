package za.co.mmagon.jwebswing.components.pools.jquery;

import za.co.mmagon.jwebswing.base.references.JavascriptReference;

/**
 * The JQuery Atmosphere JavaScript
 * <p>
 * @since 2014/12/09
 * @version 1.0
 * @author MMagon
 *
 * I have moved these from the features to make it easier to specify remote or local references.
 * <p>
 */
class AtmosphereReference extends JavascriptReference
{

    private static final long serialVersionUID = 1L;

    /**
     * Uses local until cloudfare puts up the latest version.
     */
    public AtmosphereReference()
    {
        super("AtmosphereFramework", 2.4, "bower_components/atmosphere.js/atmosphere.js");//, "https://cdnjs.cloudflare.com/ajax/libs/atmosphere/2.2.12/atmosphere.js");
        setSortOrder(600000);
    }
}
