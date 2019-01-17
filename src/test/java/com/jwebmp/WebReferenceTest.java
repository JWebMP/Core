/*
 * Copyright (C) 2017 GedMarc
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
package com.jwebmp;

import com.jwebmp.core.generics.WebReference;
import com.jwebmp.core.plugins.ajaxenabler.AjaxEnablerReferencePool;
import com.jwebmp.core.plugins.jquery.JQueryReferencePool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author GedMarc
 */
public class WebReferenceTest
{

	public WebReferenceTest()
	{
	}

	/**
	 * Test of setLeft method, of class WebReference.
	 */
	@Test
	public void testSetLeft()
	{
	}

	@Test
	public void testSort()
	{
		WebReference.setIsLocal(true);
		List<WebReference> w = new LinkedList<>();
		// w.add(AtmosphereReferencePool.JQueryAtmospherePush.getJavaScriptReference());
		w.add(JQueryReferencePool.JQueryV2.getJavaScriptReference()
		                                  .setSortOrder(0));// new JQueryReferenceV2());

		//w.add(AtmosphereReferencePool.JQueryAtmospherePush.getJavaScriptReference());
		w.add(AjaxEnablerReferencePool.AjaxEnabler.getJavaScriptReference()
		                                          .setSortOrder(0));

		WebReference.sort(w);
		System.out.println(w);

		String expected = "[bower_components/jquery/dist/jquery.min.js, javascript/jwebswing/ajax-enabler.js]";
		String result = w.toString();

		Assertions.assertEquals(expected, result);

	}
}
