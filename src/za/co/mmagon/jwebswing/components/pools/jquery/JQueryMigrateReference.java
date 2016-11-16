package za.co.mmagon.jwebswing.components.pools.jquery;

import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.servlets.enumarations.RequirementsPriority;

/**
 * The JQuery JavaScript Reference
 *
 * @since 2014/12/09
 * @version 1.0
 * @author MMagon
 *
 * I have moved these from the features to make it easier to specify remote or local references.
 *
 */
class JQueryMigrateReference extends JavascriptReference
{

    public JQueryMigrateReference()
    {
        super("JQueryMigrate", 1.21, "bower_components/jquery-migrate/jquery-migrate.js", "http://code.jquery.com/jquery-migrate-1.4.1.js");
        setSortOrder(2);
        setPriority(RequirementsPriority.Second);
    }
}
