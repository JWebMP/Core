package com.jwebmp.core.events.click;

import com.jwebmp.core.base.angular.services.IAngularDirective;

public class ClickDisabledDirective
		implements IAngularDirective<ClickDisabledDirective>
{
	public ClickDisabledDirective()
	{
		super();
	}

	@Override
	public String getReferenceName()
	{
		return "ClickDisabledDirective";
	}

	@Override
	public String renderFunction()
	{
		return "$('*[ng-click]').on('click',function(event) {" +
		       "var $el = $(event.target);" +
		       "if($el.attr('disabled')) {" +
		       "event.stopPropagation();" +
		       "}" +
		       "});";
	}
}
