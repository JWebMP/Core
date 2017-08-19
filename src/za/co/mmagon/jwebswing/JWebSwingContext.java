package za.co.mmagon.jwebswing;

import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

import java.util.ArrayList;
import java.util.List;

/**
 * Session Context for Web Apps
 *
 * @author GedMarc
 * @since 2017/08/16
 */
public final class JWebSwingContext extends JavaScriptPart<JWebSwingContext>
{
	/**
	 * Version 1
	 */
	private static final long serialVersionUID = 1L;
	
	private Page currentPage;
	private List<Event> knownEvents;
	private List<ComponentHierarchyBase> knownComponents;
	
	/**
	 * Returns the current associated page with the session
	 * @return
	 */
	public Page getCurrentPage()
	{
		return currentPage;
	}
	
	/**
	 * Sets the current page for the session
	 * @param currentPage
	 */
	public void setCurrentPage(Page currentPage)
	{
		this.currentPage = currentPage;
	}
	
	/**
	 * Returns a list of known events for the session
	 * @return
	 */
	public List<Event> getKnownEvents()
	{
		if(knownEvents == null)
			knownEvents = new ArrayList<>();
		return knownEvents;
	}
	
	/**
	 * Sets the known events for the session
	 * @param knownEvents
	 */
	public void setKnownEvents(List<Event> knownEvents)
	{
		this.knownEvents = knownEvents;
	}
	
	/**
	 * Get's a list of known components for the session
	 * @return
	 */
	public List<ComponentHierarchyBase> getKnownComponents()
	{
		if(knownComponents == null)
			knownComponents = new ArrayList<>();
		return knownComponents;
	}
	
	/**
	 * Sets the list of known components
	 * @param knownComponents
	 */
	public void setKnownComponents(List<ComponentHierarchyBase> knownComponents)
	{
		this.knownComponents = knownComponents;
	}
}
