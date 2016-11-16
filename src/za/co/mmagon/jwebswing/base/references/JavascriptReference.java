package za.co.mmagon.jwebswing.base.references;

import za.co.mmagon.jwebswing.base.servlets.enumarations.RequirementsPriority;
import za.co.mmagon.jwebswing.generics.WebReference;

/**
 * This class is a Java Reference
 *
 *
 * @since 2014/12/09
 * @version 1.0
 * @author MMagon
 *
 *
 */
public class JavascriptReference extends WebReference
{

    /**
     *
     * @param name            The name of the reference
     * @param version         The version of the reference
     * @param localReference  The local reference
     * @param remoteReference The remote reference
     */
    public JavascriptReference(String name, Double version, String localReference, String remoteReference)
    {
        super(name, version, localReference, remoteReference);
    }

    /**
     *
     * @param name           The name of the reference
     * @param version        The version of the reference
     * @param localReference The local reference
     */
    public JavascriptReference(String name, Double version, String localReference)
    {
        super(name, version, localReference, localReference);
    }

    /**
     *
     * @param name           The name of the reference
     * @param version        The version of the reference
     * @param localReference The local reference
     */
    public JavascriptReference(String name, Double version, String localReference, RequirementsPriority priority)
    {
        super(name, version, localReference, localReference);
        setPriority(priority);
    }

    /**
     *
     * @param name           The name of the reference
     * @param version        The version of the reference
     * @param localReference The local reference
     * @param sortOrder      Default Sort Order
     * <p>
     * 0 - Root (JQuery)
     * 5 - Core
     * 10 - Core Accompanied
     * 15 - Stand Alone Components
     * 20 - Complex Components
     * 500k - Default
     * 600k - Atmosphere Reserved
     *
     */
    public JavascriptReference(String name, Double version, String localReference, Integer sortOrder)
    {
        super(name, version, localReference, localReference);
        setSortOrder(sortOrder);
    }

    /**
     *
     * @param name            The name of the reference
     * @param version         The version of the reference
     * @param localReference  The local reference
     * @param remoteReference The remote reference
     * @param sortOrder       Default Sort Order
     * <p>
     * 0 - Root (JQuery)
     * 5 - Core
     * 10 - Core Accompanied
     * 15 - Stand Alone Components
     * 20 - Complex Components
     * 500k - Default
     * 600k - Atmosphere Reserved
     *
     */
    public JavascriptReference(String name, Double version, String localReference, String remoteReference, Integer sortOrder)
    {
        super(name, version, localReference, remoteReference);
        setSortOrder(sortOrder);
    }
    
    /**
     *
     * @param name            The name of the reference
     * @param version         The version of the reference
     * @param localReference  The local reference
     * @param remoteReference The remote reference
     * @param sortOrder       Default Sort Order
     * <p>
     * 0 - Root (JQuery)
     * 5 - Core
     * 10 - Core Accompanied
     * 15 - Stand Alone Components
     * 20 - Complex Components
     * 500k - Default
     * 600k - Atmosphere Reserved
     *
     */
    public JavascriptReference(String name, Double version, String localReference, String remoteReference, Integer sortOrder, RequirementsPriority priority)
    {
        super(name, version, localReference, remoteReference);
        setSortOrder(sortOrder);
        setPriority(priority);
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof JavascriptReference)
        {
            if (o.toString().equals(toString()))
            {
                return true;
            }

            return getName().equalsIgnoreCase(JavascriptReference.class.cast(o).getName());
        }
        else
        {
            return false;
        }
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        return hash;
    }

}
