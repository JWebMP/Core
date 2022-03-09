package com.jwebmp.core.databind;

import com.guicedee.guicedinjection.interfaces.*;
import com.jwebmp.core.base.*;

public interface IOnComponentHtmlRender<J extends IOnComponentHtmlRender<J>> extends IDefaultService<J>
{
	/**
	 * intercepts the html render and provides a return value on whether children should be rendered
	 * @param component
	 * @return whether or not to render children
	 */
	boolean onHtmlRender(ComponentHierarchyBase<?, ?, ?, ?, ?> component);
}
