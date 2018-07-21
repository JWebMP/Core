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
package com.jwebmp.core.base.ajax;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @author GedMarc
 * @since Nov 9, 2016
 */
class AlwaysEmptySerializer
		extends JsonSerializer<Object>
{
	/**
	 * Always serialize as an empty serialization
	 */
	public AlwaysEmptySerializer()
	{
		//Nothing required here
	}

	@Override
	public void serialize(Object t, JsonGenerator jg, SerializerProvider sp) throws IOException
	{
		jg.writeNull();
	}
}
