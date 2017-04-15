/*
 * Copyright (C) 2017 Marc Magon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package za.co.mmagon.jwebswing.generics;

import com.armineasy.injection.GuiceContext;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import za.co.mmagon.jwebswing.base.html.interfaces.NamedPair;
import za.co.mmagon.jwebswing.base.servlets.enumarations.RequirementsPriority;
import za.co.mmagon.logger.LogFactory;

/**
 * Denotes a specific Web Reference, either remotely or locally
 *
 * @param <T> The type implementation
 *
 * @since Forever
 * @version 2.0
 * @author MMagon
 *
 * 2.0 Added Sorting
 */
public class WebReference<T extends WebReference> implements NamedPair<String, String>, Serializable, Comparator<WebReference>
{

    private static final long serialVersionUID = 1L;
    /**
     * The left side
     */
    @JsonIgnore
    private String left;
    /**
     * The right side
     */
    @JsonIgnore
    private String right;
    /**
     * If this must reference with the left side only
     */
    @JsonIgnore
    private boolean leftOnly = true;
    /**
     * If the reference is local
     */
    private static boolean isLocal = true;
    /**
     * The ridiculous sort order
     */
    @JsonIgnore
    private Integer sortOrder = 500000;
    /**
     * To use min at the end or not
     */
    @JsonIgnore
    private static boolean useMinAtEndOfExtension = false;
    /**
     * The default priority
     */
    @JsonIgnore
    private RequirementsPriority priority = RequirementsPriority.DontCare;
    /**
     * If the client can minify at the remote source
     */
    @JsonIgnore
    private boolean canMinifyAtRemote = true;
    /**
     * If this reference is a cordova reference, e.g. does it render in the dynamic site loader
     */
    private boolean cordovaRequired = false;
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
     *
     * @return
     */
    public T setLeft(String left)
    {
        this.left = left;
        this.localReference = left;
        return (T) this;
    }

    /**
     * Sets the remote reference
     *
     * @param right
     *
     * @return
     */
    public T setRight(String right)
    {
        this.right = right;
        this.remoteReference = right;
        return (T) this;
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
     *
     * @return
     */
    public T setLeftOnly(boolean leftOnly)
    {
        this.leftOnly = leftOnly;
        return (T) this;
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
     *
     * @return
     */
    public T setName(String name)
    {
        this.name = name;
        return (T) this;
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
     *
     * @return
     */
    public T setVersion(Double version)
    {
        this.version = version;
        return (T) this;
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
     *
     * @return
     */
    public T setLocalReference(String localReference)
    {
        setLeft(localReference);
        this.localReference = localReference;
        return (T) this;
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
     *
     * @return
     */
    public T setRemoteReference(String remoteReference)
    {
        setRight(remoteReference);
        this.remoteReference = remoteReference;
        return (T) this;
    }

    private static final Logger LOG = LogFactory.getInstance().getLogger("Web Reference");

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
     *
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
     * 0 - Root (JQuery) 5 - Core 10 - Core Accompanied 15 - Stand Alone Components 20 - Complex Components 500k - Default 600k - Atmosphere Reserved
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
     * 0 - Root (JQuery) 5 - Core 10 - Core Accompanied 15 - Stand Alone Components 20 - Complex Components 500k - Default 600k - Atmosphere Reserved
     * <p>
     * @param sortOrder
     *
     * @return
     */
    public final T setSortOrder(Integer sortOrder)
    {
        this.sortOrder = sortOrder;
        return (T) this;
    }

    /**
     * Sorts an Array List of References
     *
     * @param arrayList
     *
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
     *
     * @return
     */
    public T setPriority(RequirementsPriority priority)
    {
        this.priority = priority;
        return (T) this;
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
     *
     * @return
     */
    public T setCanMinifyAtRemote(boolean canMinifyAtRemote)
    {
        this.canMinifyAtRemote = canMinifyAtRemote;
        return (T) this;
    }

    /**
     * If this reference is a cordova reference, e.g. does it render in the dynamic site loader
     *
     * @return
     */
    public boolean isCordovaRequired()
    {
        return cordovaRequired;
    }

    /**
     * If this reference is a cordova reference, e.g. does it render in the dynamic site loader
     *
     * @param cordovaRequired
     *
     * @return
     */
    public T setCordovaRequired(boolean cordovaRequired)
    {
        this.cordovaRequired = cordovaRequired;
        return (T) this;
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

            try
            {
                if (!GuiceContext.isBuildingInjector())
                {
                    HttpServletRequest request = GuiceContext.inject().getInstance(HttpServletRequest.class);
                    if (request != null)
                    {
                        StringBuffer url = request.getRequestURL();
                        String realUrl = url.substring(0, url.lastIndexOf("/"));
                        realUrl += "/";
                        sb = sb.insert(0, realUrl);
                        sb = new StringBuilder(sb.toString());
                    }
                }
            }
            catch (com.google.inject.ProvisionException e)
            {
                //Intentional
            }
            catch (NoClassDefFoundError | Exception e)
            {
                LOG.log(Level.WARNING, "Error in getting url to append to the web reference", e);
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
