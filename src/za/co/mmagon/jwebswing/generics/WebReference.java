package za.co.mmagon.jwebswing.generics;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import org.apache.log4j.Logger;
import za.co.mmagon.LoggerFactory;
import za.co.mmagon.jwebswing.base.html.interfaces.NamedPair;
import za.co.mmagon.jwebswing.base.servlets.enumarations.RequirementsPriority;

/**
 * Denotes a specific Web Reference, either remotely or locally
 *
 * @since Forever
 * @version 2.0
 * @author MMagon
 *
 * 2.0 Added Sorting
 */
public class WebReference implements NamedPair<String, String>, Serializable, Comparator<WebReference>
{

    private static final long serialVersionUID = 1L;
    @JsonIgnore
    private String left;
    @JsonIgnore
    private String right;
    @JsonIgnore
    private boolean leftOnly = true;
    private static boolean isLocal = true;
    @JsonIgnore
    private Integer sortOrder = 500000;
    @JsonIgnore
    private static boolean useMinAtEndOfExtension = false;
    @JsonIgnore
    private RequirementsPriority priority = RequirementsPriority.DontCare;
    @JsonIgnore
    private boolean canMinifyAtRemote = true;

    /**
     * The name of the reference
     */
    private String name;
    /**
     * The specified version
     */
    private Double version;

    /**
     * The local reference
     */
    @JsonIgnore
    private String localReference;
    /**
     * The remote reference
     */
    @JsonIgnore
    private String remoteReference;

    /**
     * The dummy reference for the sorting
     */
    private static final WebReference dummyReference = new WebReference(null, null, null, null);

    /**
     * Sets this JavaScript Reference with the Name, the Version
     *
     * @param name            The Name of the Plugin
     * @param version         The version of the Plugin
     * @param localReference  The local Reference
     * @param remoteReference The Remote Reference
     * @param sortOrder       The Sorting Order for the Reference
     */
    public WebReference(String name, Double version, String localReference, String remoteReference, int sortOrder)
    {
        this.left = localReference;
        this.right = remoteReference;

        this.name = name;
        this.version = version;
        this.localReference = localReference;
        this.remoteReference = remoteReference;
    }

    /**
     * Sets this JavaScript Reference with the Name, the Version
     *
     * @param name            The Name of the Plugin
     * @param version         The version of the Plugin
     * @param localReference  The local Reference
     * @param remoteReference The Remote Reference
     */
    public WebReference(String name, Double version, String localReference, String remoteReference)
    {
        this(name, version, localReference, remoteReference, 500000);
    }

    /**
     * Sets the local reference
     *
     * @param left
     */
    public void setLeft(String left)
    {
        this.left = left;
        this.localReference = left;
    }

    /**
     * Sets the remote reference
     *
     * @param right
     */
    public void setRight(String right)
    {
        this.right = right;
        this.remoteReference = right;
    }

    /**
     * Gets the local reference
     *
     * @return
     */
    @Override
    public String getLeft()
    {
        return localReference;
    }

    /**
     * Sets the local reference
     *
     * @return
     */
    @Override
    public String getRight()
    {
        return remoteReference;
    }

    @Override
    public int hashCode()
    {
        return left.hashCode() ^ right.hashCode();
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null)
        {
            return false;
        }
        if (!(o instanceof WebReference))
        {
            return false;
        }
        WebReference pairo = (WebReference) o;
        return this.left.equals(pairo.getLeft())
                && (!leftOnly
                && this.right.equals(pairo.getRight()));
    }

    /**
     * Returns if this pair is set to validate on the left field only
     *
     * @return
     */
    public boolean isLeftOnly()
    {
        return leftOnly;
    }

    /**
     * Sets if this pair should validate on the left pair only
     *
     * @param leftOnly
     */
    public void setLeftOnly(boolean leftOnly)
    {
        this.leftOnly = leftOnly;
    }

    /**
     * Whether or not to return the local reference or the remote reference
     *
     * @return
     */
    @JsonProperty("local")
    public static boolean isIsLocal()
    {
        return isLocal;
    }

    /**
     * Sets whether this reference should be local or remote
     *
     * @param isLocal
     */
    public static void setIsLocal(boolean isLocal)
    {
        WebReference.isLocal = isLocal;
    }

    /**
     * Gets the name of this reference
     *
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of this reference
     *
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the double version of this reference
     *
     * @return
     */
    public Double getVersion()
    {
        return version;
    }

    /**
     * Sets the double version of this reference
     *
     * @param version
     */
    public void setVersion(Double version)
    {
        this.version = version;
    }

    /**
     * Gets the physical local reference
     *
     * @return
     */
    public String getLocalReference()
    {
        return localReference;
    }

    /**
     * Sets the physical local reference
     *
     * @param localReference
     */
    public void setLocalReference(String localReference)
    {
        setLeft(localReference);
        this.localReference = localReference;
    }

    /**
     * Gets the physical remote reference
     *
     * @return
     */
    public String getRemoteReference()
    {
        return remoteReference;
    }

    /**
     * Sets the remote physical reference
     *
     * @param remoteReference
     */
    public void setRemoteReference(String remoteReference)
    {
        setRight(remoteReference);
        this.remoteReference = remoteReference;
    }

    private static final Logger LOG = LoggerFactory.getInstance().makeNewLoggerInstance("Web Reference");

    /**
     * Sets whether or not to use "min.js" or use a folder for the min directory
     *
     * @return
     */
    public static final boolean isUseMinAtEndOfExtension()
    {
        return useMinAtEndOfExtension;
    }

    /**
     * Sets whether or not to append min into the filename
     *
     * @param useMinAtEndOfExtension
     */
    public static final void setUseMinAtEndOfExtension(boolean useMinAtEndOfExtension)
    {
        WebReference.useMinAtEndOfExtension = useMinAtEndOfExtension;
    }

    /**
     * Compares two references to each other on sort order
     *
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(WebReference o1, WebReference o2)
    {
        return o1.getSortOrder().compareTo(o2.getSortOrder());
    }

    /**
     * Default Sort Order
     * <p>
     * 0 - Root (JQuery)
     * 5 - Core
     * 10 - Core Accompanied
     * 15 - Stand Alone Components
     * 20 - Complex Components
     * 500k - Default
     * 600k - Atmosphere Reserved
     *
     * @return
     */
    public Integer getSortOrder()
    {
        return sortOrder;
    }

    /**
     * Default Sort Order
     * <p>
     * 0 - Root (JQuery)
     * 5 - Core
     * 10 - Core Accompanied
     * 15 - Stand Alone Components
     * 20 - Complex Components
     * 500k - Default
     * 600k - Atmosphere Reserved
     * <p>
     */
    public final void setSortOrder(Integer sortOrder)
    {
        this.sortOrder = sortOrder;
        //return;
    }

    /**
     * Sorts an Array List of References
     *
     * @param arrayList
     * @return
     */
    public static ArrayList<? extends WebReference> sort(ArrayList<? extends WebReference> arrayList)
    {
        arrayList.sort(dummyReference);
        return arrayList;
    }

    /**
     * Returns a dummy reference for the sorting array
     *
     * @return
     */
    public static WebReference getDummyReference()
    {
        return dummyReference;
    }

    /**
     * Return the priority of the reference
     *
     * @return
     */
    public RequirementsPriority getPriority()
    {
        return priority;
    }

    /**
     * Sets the priority of the reference
     *
     * @param priority
     */
    public void setPriority(RequirementsPriority priority)
    {
        this.priority = priority;
    }

    /**
     * Specifies if the remote has a min file
     *
     * @return
     */
    public boolean isCanMinifyAtRemote()
    {
        return canMinifyAtRemote;
    }

    /**
     * Specifies if the remote has a min file
     *
     * @param canMinifyAtRemote
     */
    public void setCanMinifyAtRemote(boolean canMinifyAtRemote)
    {
        this.canMinifyAtRemote = canMinifyAtRemote;
    }

    /**
     * Returns either the local or remote reference depending on configuration
     * <p>
     * @return
     */
    @Override
    @JsonProperty("reference")
    public final String toString()
    {
        if (isIsLocal())
        {
            StringBuilder sb = new StringBuilder(getLocalReference());
            if (useMinAtEndOfExtension)
            {
                if (!sb.toString().contains(".min."))
                {
                    sb.insert(sb.lastIndexOf("."), ".min");
                }
            }
            return sb.toString();
        }
        else
        {
            StringBuilder sb = new StringBuilder(getRemoteReference());
            if (useMinAtEndOfExtension && isCanMinifyAtRemote())
            {
                if (!sb.toString().contains(".min."))
                {
                    sb.insert(sb.lastIndexOf("."), ".min");
                }
            }
            return sb.toString();
        }
    }
}
