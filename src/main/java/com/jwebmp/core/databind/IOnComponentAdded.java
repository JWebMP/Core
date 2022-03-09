package com.jwebmp.core.databind;

import com.guicedee.guicedinjection.interfaces.*;
import com.jwebmp.core.base.*;
import com.jwebmp.core.base.html.interfaces.*;

public interface IOnComponentAdded<J extends IOnComponentAdded<J>> extends IDefaultService<J>
{
	/**
	 * intercepts the html render and provides a return value on whether children should be rendered
	 *
	 * @param component
	 * @return
	 */
	void onComponentAdded(ComponentHierarchyBase<GlobalChildren, ?, ?, ?, ?> parent, ComponentHierarchyBase<GlobalChildren, ?, ?, ?, ?> component);
}
