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
package com.jwebmp.core.base.html;

import com.jwebmp.core.Component;
import com.jwebmp.core.base.html.attributes.AudioAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.NoNewLineBeforeClosingTag;
import com.jwebmp.core.base.html.interfaces.NoNewLineForRawText;
import com.jwebmp.core.base.html.interfaces.children.AudioChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage
 * <p>
 * <p>
 * The audio tag defines sound, such as music or other audio streams.<p>
 * <p>
 * Currently, there are 3 supported file formats for the audio element: MP3,
 * <p>
 * Wav, and Ogg: Browser MP3 Wav Ogg Internet Explorer YES NO NO Chrome YES YES<p>
 * YES Firefox NO Update: Firefox 21 running on<p>
 * Windows 7, Windows 8, Windows Vista, and Android now supports MP3 YES YES<p>
 * Safari YES YES NO Opera NO YES YES MIME Types for Audio Formats Format<p>
 * MIME-type MP3 audio/mpeg Ogg audio/ogg Wav audio/wav<p>
 * <p>
 * Browser Support<p>
 * <p>
 * The numbers in the table specify the first browser version that fully<p>
 * supports the element. Element<p>
 * audio 4.0 9.0 3.5 4.0 10.5
 * <p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The audio tag is new in HTML5. Tips and Notes<p>
 * <p>
 * Tip: Any text inside the between audio&lt; and &gt;/audio&lt; will be<p>
 * displayed in browsers that do not support the &gt;audio&lt; tag.<p>
 * <p>
 *
 * @param <J>
 *
 * @author MMagon
 * @version 1.0
 * @since 2014/10/26
 */
public class Audio<J extends Audio<J>>
		extends Component<AudioChildren, AudioAttributes, GlobalFeatures, GlobalEvents, J>
		implements NoNewLineBeforeClosingTag, NoNewLineForRawText
{
	/**
	 * Constructs a new instance of audio
	 */
	public Audio()
	{
		this(null);
	}

	/**
	 * The audio source of the file
	 * <p>
	 *
	 * @param src
	 */
	public Audio(String src)
	{
		super(ComponentTypes.Audio);
		addAttribute(AudioAttributes.Src, src);
	}

}
