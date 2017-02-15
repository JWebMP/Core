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
package za.co.mmagon.jwebswing.components.modernizr;

/**
 *
 * @author GedMarc
 * @since Nov 21, 2016
 * @version 1.0
 *
 */
public class ModernizrJSDto extends ModernizrCapabilitiesDto
{

    private Boolean es5array;
    private Boolean es5object;
    private Boolean es5function;
    private Boolean es5string;
    private Boolean strictmode;
    private Boolean es6array;
    private Boolean es5undefined;
    private Boolean generators;
    private Boolean es6number;
    private Boolean es6object;
    private Boolean es6string;
    private Boolean devicemotion;
    private Boolean deviceorientation;
    private Boolean filereader;
    private Boolean contains;
    private Boolean contextmenu;
    private Boolean cssall;
    private Boolean willchange;
    private Boolean classlist;
    private Boolean documentfragment;
    private Boolean audio;
    private Boolean canvas;
    private Boolean canvastext;
    private Boolean contenteditable;
    private Boolean emoji;
    private Boolean olreversed;
    private Boolean userdata;
    private Boolean video;
    private Boolean vml;
    private Boolean webanimations;
    private Boolean webgl;
    private Boolean adownload;
    private Boolean audioloop;
    private Boolean canvasblending;
    private Boolean todataurljpeg;
    private Boolean todataurlpng;
    private Boolean todataurlwebp;
    private Boolean canvaswinding;
    private Boolean bgpositionshorthand;
    private Boolean multiplebgs;
    private Boolean csspointerevents;
    private Boolean regions;
    private Boolean cssremunit;
    private Boolean rgba;
    private Boolean preserve3d;
    private Boolean progressbar;
    private Boolean meter;
    private Boolean time;

    public ModernizrJSDto()
    {

    }

    /**
     * Is ES 5 enabled
     *
     * @return
     */
    public Boolean isEs5array()
    {
        return es5array;
    }

    /**
     * Sets if es5 is enabled
     *
     * @param es5array
     */
    protected void setEs5array(Boolean es5array)
    {
        this.es5array = es5array;
    }

    /**
     * Is ES 5 objects allowed
     *
     * @return
     */
    public Boolean isEs5object()
    {
        return es5object;
    }

    /**
     * Sets if ES 5 objects are allowed
     *
     * @param es5object
     */
    protected void setEs5object(Boolean es5object)
    {
        this.es5object = es5object;
    }

    /**
     * Is ES 5 Functioning
     *
     * @return
     */
    public Boolean isEs5function()
    {
        return es5function;
    }

    /**
     * Sets if ES 5 is functioning
     *
     * @param es5function
     */
    protected void setEs5function(Boolean es5function)
    {
        this.es5function = es5function;
    }

    /**
     * Is ES 5 string
     *
     * @return
     */
    public Boolean isEs5string()
    {
        return es5string;
    }

    /**
     * Sets if ES 5 is a string
     *
     * @param es5string
     */
    protected void setEs5string(Boolean es5string)
    {
        this.es5string = es5string;
    }

    /**
     * Is in strict mode
     *
     * @return
     */
    public Boolean isStrictmode()
    {
        return strictmode;
    }

    /**
     * Sets strict mode
     *
     * @param strictmode
     */
    protected void setStrictmode(Boolean strictmode)
    {
        this.strictmode = strictmode;
    }

    /**
     * Is es 6 arrays enabled
     *
     * @return
     */
    public Boolean isEs6array()
    {
        return es6array;
    }

    /**
     * Is ES 6 enabled
     *
     * @param es6array
     */
    protected void setEs6array(Boolean es6array)
    {
        this.es6array = es6array;
    }

    /**
     * Is ES 5 undefined
     *
     * @return
     */
    public Boolean isEs5undefined()
    {
        return es5undefined;
    }

    /**
     * Is ES 5 undefined
     *
     * @param es5undefined
     */
    protected void setEs5undefined(Boolean es5undefined)
    {
        this.es5undefined = es5undefined;
    }

    /**
     * Does support generators
     *
     * @return
     */
    public Boolean isGenerators()
    {
        return generators;
    }

    /**
     * Does support generators
     *
     * @param generators
     */
    protected void setGenerators(Boolean generators)
    {
        this.generators = generators;
    }

    /**
     * Is ES 6 number
     *
     * @return
     */
    public Boolean isEs6number()
    {
        return es6number;
    }

    /**
     * Is ES 6 number
     *
     * @param es6number
     */
    protected void setEs6number(Boolean es6number)
    {
        this.es6number = es6number;
    }

    /**
     * Is ES 6 object
     *
     * @return
     */
    public Boolean isEs6object()
    {
        return es6object;
    }

    /**
     * Is ES 6 Object
     *
     * @param es6object
     */
    protected void setEs6object(Boolean es6object)
    {
        this.es6object = es6object;
    }

    /**
     * Is ES 6 String
     *
     * @return
     */
    public Boolean isEs6string()
    {
        return es6string;
    }

    /**
     * Sets ES 6 String
     *
     * @param es6string
     */
    protected void setEs6string(Boolean es6string)
    {
        this.es6string = es6string;
    }

    /**
     * Is device motion reading enabled
     *
     * @return
     */
    public Boolean isDevicemotion()
    {
        return devicemotion;
    }

    /**
     * Sets device motion
     *
     * @param devicemotion
     */
    protected void setDevicemotion(Boolean devicemotion)
    {
        this.devicemotion = devicemotion;
    }

    /**
     * Is device Orientation
     *
     * @return
     */
    public Boolean isDeviceorientation()
    {
        return deviceorientation;
    }

    /**
     * Sets device orientation
     *
     * @param deviceorientation
     */
    protected void setDeviceorientation(Boolean deviceorientation)
    {
        this.deviceorientation = deviceorientation;
    }

    /**
     * Is File Reader
     *
     * @return
     */
    public Boolean isFilereader()
    {
        return filereader;
    }

    /**
     * Is File Reader
     *
     * @param filereader
     */
    protected void setFilereader(Boolean filereader)
    {
        this.filereader = filereader;
    }

    /**
     * Is Contains Enabled
     *
     * @return
     */
    public Boolean isContains()
    {
        return contains;
    }

    /**
     * Is Contains enabled
     *
     * @param contains
     */
    protected void setContains(Boolean contains)
    {
        this.contains = contains;
    }

    /**
     * Is Context Menu
     *
     * @return
     */
    public Boolean isContextmenu()
    {
        return contextmenu;
    }

    /**
     * Is Context Menu
     *
     * @param contextmenu
     */
    protected void setContextmenu(Boolean contextmenu)
    {
        this.contextmenu = contextmenu;
    }

    /**
     * Is CSS All allowed
     *
     * @return
     */
    public Boolean isCssall()
    {
        return cssall;
    }

    /**
     * Is CSS All allowed
     *
     * @param cssall
     */
    protected void setCssall(Boolean cssall)
    {
        this.cssall = cssall;
    }

    /**
     * Is will change allowed
     *
     * @return
     */
    public Boolean isWillchange()
    {
        return willchange;
    }

    /**
     * Is will change allowed
     *
     * @param willchange
     */
    protected void setWillchange(Boolean willchange)
    {
        this.willchange = willchange;
    }

    /**
     * Is class list allowed
     *
     * @return
     */
    public Boolean isClasslist()
    {
        return classlist;
    }

    /**
     * Is class list enabled
     *
     * @param classlist
     */
    protected void setClasslist(Boolean classlist)
    {
        this.classlist = classlist;
    }

    /**
     * Is document fragment allowed
     *
     * @return
     */
    public Boolean isDocumentfragment()
    {
        return documentfragment;
    }

    /**
     * Sets document fragment
     *
     * @param documentfragment
     */
    protected void setDocumentfragment(Boolean documentfragment)
    {
        this.documentfragment = documentfragment;
    }

    /**
     * Is audio allowed
     *
     * @return
     */
    public Boolean isAudio()
    {
        return audio;
    }

    /**
     * Set audio
     *
     * @param audio
     */
    protected void setAudio(Boolean audio)
    {
        this.audio = audio;
    }

    /**
     * Is canvas
     *
     * @return
     */
    public Boolean isCanvas()
    {
        return canvas;
    }

    /**
     * Sets canvas allowed or not
     *
     * @param canvas
     */
    protected void setCanvas(Boolean canvas)
    {
        this.canvas = canvas;
    }

    /**
     * Sets if canvas text is allowed
     *
     * @return
     */
    public Boolean isCanvastext()
    {
        return canvastext;
    }

    /**
     * Sets canvas text
     *
     * @param canvastext
     */
    protected void setCanvastext(Boolean canvastext)
    {
        this.canvastext = canvastext;
    }

    /**
     * Is content editable
     *
     * @return
     */
    public Boolean isContenteditable()
    {
        return contenteditable;
    }

    /**
     * Is content editable
     *
     * @param contenteditable
     */
    protected void setContenteditable(Boolean contenteditable)
    {
        this.contenteditable = contenteditable;
    }

    /**
     * Can use emoji's
     *
     * @return
     */
    public Boolean isEmoji()
    {
        return emoji;
    }

    /**
     * Sets can use emoji's
     *
     * @param emoji
     */
    protected void setEmoji(Boolean emoji)
    {
        this.emoji = emoji;
    }

    /**
     * Sets OL Reversed
     *
     * @return
     */
    public Boolean isOlreversed()
    {
        return olreversed;
    }

    /**
     * Sets OL Reversed
     *
     * @param olreversed
     */
    protected void setOlreversed(Boolean olreversed)
    {
        this.olreversed = olreversed;
    }

    /**
     * Return the user data enabled
     *
     * @return
     */
    public Boolean isUserdata()
    {
        return userdata;
    }

    /**
     * Sets User Data as enabled
     *
     * @param userdata
     */
    protected void setUserdata(Boolean userdata)
    {
        this.userdata = userdata;
    }

    /**
     * Returns if video is enabled
     *
     * @return
     */
    public Boolean isVideo()
    {
        return video;
    }

    /**
     * Sets if video is enabled
     *
     * @param video
     */
    protected void setVideo(Boolean video)
    {
        this.video = video;
    }

    /**
     * Is VML
     *
     * @return
     */
    public Boolean isVml()
    {
        return vml;
    }

    /**
     * Is VML
     *
     * @param vml
     */
    protected void setVml(Boolean vml)
    {
        this.vml = vml;
    }

    /**
     * If animations are allowed
     *
     * @return
     */
    public Boolean isWebanimations()
    {
        return webanimations;
    }

    /**
     * If web animations are allowed
     *
     * @param webanimations
     */
    protected void setWebanimations(Boolean webanimations)
    {
        this.webanimations = webanimations;
    }

    /**
     * Is Web GL allowed
     *
     * @return
     */
    public Boolean isWebgl()
    {
        return webgl;
    }

    /**
     * If web gl is allowed
     *
     * @param webgl
     */
    protected void setWebgl(Boolean webgl)
    {
        this.webgl = webgl;
    }

    /**
     * Is a download allowed
     *
     * @return
     */
    public Boolean isAdownload()
    {
        return adownload;
    }

    /**
     * Is a download allowed
     *
     * @param adownload
     */
    protected void setAdownload(Boolean adownload)
    {
        this.adownload = adownload;
    }

    /**
     * Is audio loop allowed
     *
     * @return
     */
    public Boolean isAudioloop()
    {
        return audioloop;
    }

    /**
     * Sets if audio loop is allowed
     *
     * @param audioloop
     */
    protected void setAudioloop(Boolean audioloop)
    {
        this.audioloop = audioloop;
    }

    /**
     * Is canvas blending allowed
     *
     * @return
     */
    public Boolean isCanvasblending()
    {
        return canvasblending;
    }

    /**
     * If canvas blending is allowed
     *
     * @param canvasblending
     */
    protected void setCanvasblending(Boolean canvasblending)
    {
        this.canvasblending = canvasblending;
    }

    /**
     * If data jpegs are allowed
     *
     * @return
     */
    public Boolean isTodataurljpeg()
    {
        return todataurljpeg;
    }

    /**
     * If data jpegs are allowed
     *
     * @param todataurljpeg
     */
    protected void setTodataurljpeg(Boolean todataurljpeg)
    {
        this.todataurljpeg = todataurljpeg;
    }

    /**
     * If data png's are allowed
     *
     * @return
     */
    public Boolean isTodataurlpng()
    {
        return todataurlpng;
    }

    /**
     * If data png's are allowed
     *
     * @param todataurlpng
     */
    protected void setTodataurlpng(Boolean todataurlpng)
    {
        this.todataurlpng = todataurlpng;
    }

    /**
     * If to data url web p is allowed
     *
     * @return
     */
    public Boolean isTodataurlwebp()
    {
        return todataurlwebp;
    }

    /**
     * If data URL web p is allowed
     *
     * @param todataurlwebp
     */
    protected void setTodataurlwebp(Boolean todataurlwebp)
    {
        this.todataurlwebp = todataurlwebp;
    }

    /**
     * If canvas winding is allowed
     *
     * @return
     */
    public Boolean isCanvaswinding()
    {
        return canvaswinding;
    }

    /**
     * If canvas winding is allowed
     *
     * @param canvaswinding
     */
    protected void setCanvaswinding(Boolean canvaswinding)
    {
        this.canvaswinding = canvaswinding;
    }

    /**
     * Is bg position shorthand allowed
     *
     * @return
     */
    public Boolean isBgpositionshorthand()
    {
        return bgpositionshorthand;
    }

    /**
     * Is bg position shorthand allowed
     *
     * @param bgpositionshorthand
     */
    protected void setBgpositionshorthand(Boolean bgpositionshorthand)
    {
        this.bgpositionshorthand = bgpositionshorthand;
    }

    /**
     * Is multiple background allowed
     *
     * @return
     */
    public Boolean isMultiplebgs()
    {
        return multiplebgs;
    }

    /**
     * Is multiple backgrounds allowed
     *
     * @param multiplebgs
     */
    protected void setMultiplebgs(Boolean multiplebgs)
    {
        this.multiplebgs = multiplebgs;
    }

    /**
     * Is CSS Pointer Events allowed
     *
     * @return
     */
    public Boolean isCsspointerevents()
    {
        return csspointerevents;
    }

    /**
     * Is CSS Pointer Events Allowed
     *
     * @param csspointerevents
     */
    protected void setCsspointerevents(Boolean csspointerevents)
    {
        this.csspointerevents = csspointerevents;
    }

    /**
     * Are regions allowed
     *
     * @return
     */
    public Boolean isRegions()
    {
        return regions;
    }

    /**
     * Are regions allowed
     *
     * @param regions
     */
    protected void setRegions(Boolean regions)
    {
        this.regions = regions;
    }

    /**
     * Is CSS rem Unit allowed
     *
     * @return
     */
    public Boolean isCssremunit()
    {
        return cssremunit;
    }

    /**
     * Is CSS Rem Units Allowed
     *
     * @param cssremunit
     */
    protected void setCssremunit(Boolean cssremunit)
    {
        this.cssremunit = cssremunit;
    }

    /**
     * Are RGBA Values allowed
     *
     * @return
     */
    public Boolean isRgba()
    {
        return rgba;
    }

    /**
     * Are RGBA values allowed
     *
     * @param rgba
     */
    protected void setRgba(Boolean rgba)
    {
        this.rgba = rgba;
    }

    /**
     * Is preserve 3D enabled
     *
     * @return
     */
    public Boolean isPreserve3d()
    {
        return preserve3d;
    }

    /**
     * Is preserve 3d enabled
     *
     * @param preserve3d
     */
    protected void setPreserve3d(Boolean preserve3d)
    {
        this.preserve3d = preserve3d;
    }

    /**
     * Is progress bar allowed
     *
     * @return
     */
    public Boolean isProgressbar()
    {
        return progressbar;
    }

    /**
     * Is progress bar allowed
     *
     * @param progressbar
     */
    protected void setProgressbar(Boolean progressbar)
    {
        this.progressbar = progressbar;
    }

    /**
     * Is meter allowed
     *
     * @return
     */
    public Boolean isMeter()
    {
        return meter;
    }

    /**
     * Is meter allowed
     *
     * @param meter
     */
    protected void setMeter(Boolean meter)
    {
        this.meter = meter;
    }

    /**
     * Is time allowed
     *
     * @return
     */
    public Boolean isTime()
    {
        return time;
    }

    /**
     * Is time allowed
     *
     * @param time
     */
    protected void setTime(Boolean time)
    {
        this.time = time;
    }

}
