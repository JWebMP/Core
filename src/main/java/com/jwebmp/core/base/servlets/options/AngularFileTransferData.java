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
package com.jwebmp.core.base.servlets.options;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.inject.servlet.RequestScoped;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.*;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;

/**
 * @author GedMarc
 * @since 05 Apr 2017
 */
@RequestScoped
@JsonAutoDetect(fieldVisibility = ANY,
		getterVisibility = NONE,
		setterVisibility = NONE)
@JsonInclude(NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AngularFileTransferData<J extends AngularFileTransferData<J>>
		extends JavaScriptPart<J>
{


	/**
	 * If this transfer is part of a multipart
	 */
	private boolean multiPart;
	/**
	 * If this transfer is part of a multipart
	 */
	private boolean finalPart;

	/**
	 * The bytes in the transfer (so far)
	 */
	private byte[] bytes;
	/**
	 * The mime type sent with the transfer
	 */
	private String mimeType;

	/*
	 * Constructs a new AngularDataServletInitData
	 */
	public AngularFileTransferData()
	{
		//Nothing needed
	}

	/**
	 * If this file transfer is a multi part chunked transfer
	 *
	 * @return
	 */
	public boolean isMultiPart()
	{
		return multiPart;
	}

	/**
	 * If this transfer is a multi part transfer
	 *
	 * @param multiPart
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setMultiPart(boolean multiPart)
	{
		this.multiPart = multiPart;

		return (J) this;
	}

	/**
	 * If this is the final part of the multi part transfer
	 *
	 * @return
	 */
	public boolean isFinalPart()
	{
		return finalPart;
	}

	/**
	 * If this is the final part of the multipart transfer
	 *
	 * @param finalPart
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setFinalPart(boolean finalPart)
	{
		this.finalPart = finalPart;
		return (J) this;
	}

	public byte[] getBytes()
	{
		return bytes;
	}

	public void setBytes(byte[] bytes)
	{
		this.bytes = bytes;
	}

	public String getMimeType()
	{
		return mimeType;
	}

	public void setMimeType(String mimeType)
	{
		this.mimeType = mimeType;
	}
}
