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
package com.jwebmp.interception.services;

import com.guicedee.guicedinjection.interfaces.IDefaultService;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;

/**
 * Intercepts on the sites first call. Local Storage Session Storage and other items are not available
 *
 * @author GedMarc
 * @since 10 Apr 2017
 */
public interface SiteCallIntercepter<J extends SiteCallIntercepter<J>>
		extends IDefaultService<J>
{
	void intercept(AjaxCall<?> call, AjaxResponse<?> response);
}
