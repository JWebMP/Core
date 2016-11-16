package za.co.mmagon.jwebswing.base.servlets.enumarations;

/**
 * Configures the global generation type
 *
 * @since 2013/11/20
 * @version 1.0
 * @author mmagon
 *
 *
 */
public enum DevelopmentEnvironments
{
    /**
     * Forces tiny HTML to be rendered
     */
    Production,
    /**
     * PreProduction Environment
     */
    PreProduction,
    /**
     * UI Test Environment
     */
    UITest,
    /**
     * Allows for pretty print of HTML
     */
    QA,
    /**
     * Always pretty print HTML
     */
    Development,
    /**
     * Lots of commenting
     */
    Sandbox,
    /**
     * All commenting and everything
     */
    Local
}
