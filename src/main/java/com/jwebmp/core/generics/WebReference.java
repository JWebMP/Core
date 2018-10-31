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
package com.jwebmp.core.generics;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.core.SessionHelper;
import com.jwebmp.core.base.html.interfaces.NamedPair;
import com.jwebmp.core.base.servlets.enumarations.RequirementsPriority;
import com.jwebmp.core.utilities.StaticStrings;
import com.jwebmp.logger.LogFactory;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Denotes a specific Web Reference, either remotely or locally
 *
 * @param <J>
 * 		The type implementation
 *
 * @author MMagon
 * 		<p>
 * 		2.0 Added Sorting
 * @version 2.0
 * @since Forever
 */
@SuppressWarnings("unused")
public class WebReference<J extends WebReference>
		implements NamedPair<String, String>, Serializable, Comparator<WebReference>, Comparable<WebReference>
{

	private static final Logger LOG = LogFactory.getInstance()
	                                            .getLogger("Web Reference");

	/**
	 * The dummy reference for the sorting
	 */
	private static final WebReference dummyReference = new WebReference(null, null, null, null);
	/**
	 * If the reference is local
	 */
	private static boolean isLocal = true;
	/**
	 * To use min at the end or not
	 */
	private static boolean useMinAtEndOfExtension = false;
	/**
	 * If the version number should be appended for caching
	 */
	private static boolean useVersionIdentifier = false;
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
	 * The ridiculous sort order
	 */
	@JsonIgnore
	private Integer sortOrder;
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
	 * A specified class name that can identify these classes on the html
	 */
	@JsonIgnore
	private String specifiedClassName;

	private Set<String> additionalOptions;

	/**
	 * Sets this JavaScript Reference with the Name, the Version
	 *
	 * @param name
	 * 		The Name of the Plugin
	 * @param version
	 * 		The version of the Plugin
	 * @param localReference
	 * 		The local Reference
	 * @param remoteReference
	 * 		The Remote Reference
	 */
	public WebReference(String name, Double version, String localReference, String remoteReference)
	{
		this(name, version, localReference, remoteReference, 500000);
	}

	/**
	 * Sets this JavaScript Reference with the Name, the Version
	 *
	 * @param name
	 * 		The Name of the Plugin
	 * @param version
	 * 		The version of the Plugin
	 * @param localReference
	 * 		The local Reference
	 * @param remoteReference
	 * 		The Remote Reference
	 * @param sortOrder
	 * 		The Sorting Order for the Reference
	 */
	public WebReference(String name, Double version, String localReference, String remoteReference, int sortOrder)
	{
		left = localReference;
		right = remoteReference;

		this.name = name;
		this.version = version;
		this.localReference = localReference;
		this.remoteReference = remoteReference;

		this.sortOrder = sortOrder;
	}

	/**
	 * Sets whether or not to use "min.js" or use a folder for the min directory
	 *
	 * @return if min is used
	 */
	public static boolean isUseMinAtEndOfExtension()
	{
		return useMinAtEndOfExtension;
	}

	/**
	 * Sets whether or not to append min into the filename
	 *
	 * @param useMinAtEndOfExtension
	 * 		if min is used
	 */
	public static void setUseMinAtEndOfExtension(boolean useMinAtEndOfExtension)
	{
		WebReference.useMinAtEndOfExtension = useMinAtEndOfExtension;
	}

	/**
	 * Sorts an Array List of References
	 *
	 * @param arrayList
	 * 		The list to apply
	 *
	 * @return the sorted list
	 */
	@SuppressWarnings("unchecked")
	public static List<? extends WebReference> sort(List<? extends WebReference> arrayList)
	{
		arrayList.sort(dummyReference);
		return arrayList;
	}

	/**
	 * Returns a dummy reference for the sorting array
	 *
	 * @return A dummy sortable
	 */
	public static WebReference<?> getDummyReference()
	{
		return dummyReference;
	}

	/**
	 * Gets the local reference
	 *
	 * @return A dummy sortable
	 */
	@Override
	public String getLeft()
	{
		return localReference;
	}

	/**
	 * Sets the local reference
	 *
	 * @param left
	 * 		Left side, local reference
	 *
	 * @return Always this
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setLeft(String left)
	{
		this.left = left;
		localReference = left;
		return (J) this;
	}

	/**
	 * Sets the local reference
	 *
	 * @return Right side remote reference
	 */
	@Override
	public String getRight()
	{
		return remoteReference;
	}

	/**
	 * Sets the remote reference
	 *
	 * @param right
	 * 		The remote reference
	 *
	 * @return Always this
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setRight(String right)
	{
		this.right = right;
		remoteReference = right;
		return (J) this;
	}

	/**
	 * Returns if this pair is set to validate on the left field only
	 *
	 * @return Local only
	 */
	public boolean isLeftOnly()
	{
		return leftOnly;
	}

	/**
	 * Sets if this pair should validate on the left pair only
	 *
	 * @param leftOnly
	 * 		if local only
	 *
	 * @return always this
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setLeftOnly(boolean leftOnly)
	{
		this.leftOnly = leftOnly;
		return (J) this;
	}

	/**
	 * Gets the double version of this reference
	 *
	 * @return the version double
	 */
	public Double getVersion()
	{
		return version;
	}

	/**
	 * Sets the double version of this reference
	 *
	 * @param version
	 * 		the version of the reference
	 *
	 * @return Always this
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setVersion(Double version)
	{
		this.version = version;
		return (J) this;
	}

	/**
	 * Compares two references to each other on sort order
	 *
	 * @param o1
	 * 		Compares
	 * @param o2
	 * 		Copmares
	 *
	 * @return 0,-1,or 1
	 */
	@Override
	public int compare(WebReference o1, WebReference o2)
	{
		if (o1.getSortOrder()
		      .compareTo(o2.getSortOrder()) == 0)
		{
			return o1.toString()
			         .compareTo(o2.toString());
		}
		return o1.getSortOrder()
		         .compareTo(o2.getSortOrder());
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
	 * 600k -  Atmosphere Reserved
	 *
	 * @return The current sort order
	 */
	public Integer getSortOrder()
	{
		return sortOrder;
	}

	/**
	 * Default Sort Order
	 * <p>
	 * 0 - Root (JQuery) 5 - Core 10 - Core Accompanied 15 - Stand Alone Components 20 - Complex Components 500k - Default 600k -
	 * Atmosphere Reserved
	 * <p>
	 *
	 * @param sortOrder The sort order to apply
	 *
	 * @return Always this
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public final J setSortOrder(Integer sortOrder)
	{
		this.sortOrder = sortOrder;
		return (J) this;
	}

	/**
	 * Returns either the local or remote reference depending on configuration
	 * <p>
	 *
	 * @return Always this
	 */
	@Override
	@JsonProperty("reference")
	public final String toString()
	{
		StringBuilder sb = new StringBuilder();
		if (isIsLocal())
		{
			sb.append(getLocalReference());
			if (useMinAtEndOfExtension && !sb.toString()
			                                 .contains(".min."))
			{
				sb.insert(sb.lastIndexOf(StaticStrings.STRING_DOT), ".min");
			}

			try
			{
				if ((!(sb.toString()
				         .toLowerCase()
				         .startsWith("http://") || sb.toString()
				                                     .toLowerCase()
				                                     .startsWith("https://") || sb.toString()
				                                                                  .startsWith("//"))))
				{
					sb = renderUrlString(sb);
				}

			}
			catch (NoClassDefFoundError | Exception e)
			{
				LOG.log(Level.WARNING, "Error in getting url to append to the web reference", e);
			}
		}
		else
		{
			sb.append(getRemoteReference());
			if (useMinAtEndOfExtension && isCanMinifyAtRemote() && !sb.toString()
			                                                          .contains(".min."))
			{
				sb.insert(sb.lastIndexOf(StaticStrings.STRING_DOT), ".min");
			}
		}
		if (isUseVersionIdentifier())
		{
			sb.append("?v=")
			  .append(Double.toString(version));
		}

		return sb.toString();
	}

	/**
	 * Whether or not to return the local reference or the remote reference
	 *
	 * @return Always this
	 */
	@JsonProperty("local")
	public static boolean isIsLocal()
	{
		return isLocal;
	}

	/**
	 * Sets whether this reference should be local or remote
	 *
	 * @param isLocal If local references must be used
	 */
	public static void setIsLocal(boolean isLocal)
	{
		WebReference.isLocal = isLocal;
	}

	/**
	 * Gets the physical local reference
	 *
	 * @return The local reference
	 */
	public String getLocalReference()
	{
		return localReference;
	}

	/**
	 * Sets the physical local reference
	 *
	 * @param localReference The local reference
	 *
	 * @return Always this
	 */
	@NotNull
	@SuppressWarnings({"unchecked", "UnusedReturnValue"})
	public J setLocalReference(String localReference)
	{
		setLeft(localReference);
		this.localReference = localReference;
		return (J) this;
	}

	/**
	 * Renders the actual URL String
	 *
	 * @param sb The string builder
	 *
	 * @return The url to build
	 */
	private StringBuilder renderUrlString(StringBuilder sb)
	{
		try
		{
			String url = SessionHelper.getServerPath();
			if (url == null)
			{
				url = StaticStrings.STRING_EMPTY;
			}
			else
			{
				url += StaticStrings.STRING_EMPTY;
			}
			sb = sb.insert(0, url);
			return sb;
		}
		catch (Exception e)
		{
			LOG.log(Level.WARNING, "Error in getting url reference", e);
		}
		return sb;
	}

	/**
	 * Gets the physical remote reference
	 *
	 * @return The remote reference
	 */
	public String getRemoteReference()
	{
		return remoteReference;
	}

	/**
	 * Sets the remote physical reference
	 *
	 * @param remoteReference The remote reference
	 *
	 * @return Always this
	 */
	@NotNull
	@SuppressWarnings({"unchecked", "UnusedReturnValue"})
	public J setRemoteReference(String remoteReference)
	{
		setRight(remoteReference);
		this.remoteReference = remoteReference;
		return (J) this;
	}

	/**
	 * Specifies if the remote has a min file
	 *
	 * @return if minify with remote reference is allowed
	 */
	@SuppressWarnings("WeakerAccess")
	public boolean isCanMinifyAtRemote()
	{
		return canMinifyAtRemote;
	}

	/**
	 * If the version number should be appended for caching
	 *
	 * @return if version identification is enabled
	 */
	@SuppressWarnings("WeakerAccess")
	public static boolean isUseVersionIdentifier()
	{
		return useVersionIdentifier;
	}

	/**
	 * If the version number should be appended for caching
	 *
	 * @param useVersionIdentifier If version identification is enabled
	 */
	public static void setUseVersionIdentifier(boolean useVersionIdentifier)
	{
		WebReference.useVersionIdentifier = useVersionIdentifier;
	}

	/**
	 * Specifies if the remote has a min file
	 *
	 * @param canMinifyAtRemote If verifying on remote is allowed
	 *
	 * @return Always this
	 */
	@NotNull
	@SuppressWarnings({"unchecked", "UnusedReturnValue"})
	public J setCanMinifyAtRemote(boolean canMinifyAtRemote)
	{
		this.canMinifyAtRemote = canMinifyAtRemote;
		return (J) this;
	}

	/**
	 * Return the priority of the reference
	 *
	 * @return The current priority
	 */
	public RequirementsPriority getPriority()
	{
		return priority;
	}

	/**
	 * Sets the priority of the reference
	 *
	 * @param priority The given priority to apply
	 *
	 * @return Always this
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setPriority(RequirementsPriority priority)
	{
		this.priority = priority;
		return (J) this;
	}

	/**
	 * If this reference is a cordova reference, e.g. does it render in the dynamic site loader
	 *
	 * if cordova is required
	 */
	public boolean isCordovaRequired()
	{
		return cordovaRequired;
	}

	/**
	 * If this reference is a cordova reference, e.g. does it render in the dynamic site loader
	 *
	 * @param cordovaRequired If cordova is requierd
	 *
	 * @return Always this
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setCordovaRequired(boolean cordovaRequired)
	{
		this.cordovaRequired = cordovaRequired;
		return (J) this;
	}

	/**
	 * A specified class name that can identify these classes on the html
	 *
	 * @return A name to apply to the "class" attribute
	 */
	public String getSpecifiedClassName()
	{
		return specifiedClassName;
	}

	/**
	 * A specified class name that can identify these classes on the html
	 *
	 * @param specifiedClassName A class string to add
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSpecifiedClassName(String specifiedClassName)
	{
		this.specifiedClassName = specifiedClassName;
		return (J) this;
	}

	@Override
	@SuppressWarnings("all")
	public int compareTo(WebReference o)
	{
		if (o == null)
		{
			return 1;
		}
		if (getSortOrder().compareTo(o.getSortOrder()) == 0)
		{
			return getName().compareTo(o.getName());
		}
		return getSortOrder().compareTo(o.getSortOrder());
	}

	/**
	 * Gets the name of this reference
	 *
	 * @return the name of this reference
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the name of this reference
	 *
	 * @param name The name of this reference
	 *
	 * @return Always this
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setName(String name)
	{
		this.name = name;
		return (J) this;
	}

	/**
	 * Returns any additional items in the tag that should be rendered
	 *
	 * @return The set
	 */
	@NotNull
	public Set<String> getAdditionalOptions()
	{
		if (additionalOptions == null)
		{
			additionalOptions = new LinkedHashSet<>();
		}
		return additionalOptions;
	}

	/**
	 * Sets the options to something specific
	 *
	 * @param additionalOptions
	 * 		The options to add to the tag
	 *
	 * @return The tag
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public WebReference<J> setAdditionalOptions(Set<String> additionalOptions)
	{
		this.additionalOptions = additionalOptions;
		return this;
	}
}
