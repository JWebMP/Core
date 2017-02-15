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

import com.fasterxml.jackson.annotation.*;

/**
 * The Modernizr Information returned in DTO Format
 *
 * @author GedMarc
 * @since Nov 9, 2016
 *
 */
public class ModernizrDto extends ModernizrJSDto
{

    private ModernizrInputDto input;
    private ModernizrInputTypesDto inputtypes;

    private Boolean cssvmaxunit;
    private Boolean cssvminunit;
    private Boolean cssvwunit;
    private Boolean details;
    private Boolean mediaqueries;
    private Boolean pointerevents;
    private Boolean fileinputdirectory;
    private Boolean textshadow;
    private Boolean batteryapi;
    @JsonProperty(value = "battery-api")
    private Boolean battery_api;
    private Boolean crypto;
    private Boolean dart;
    private Boolean forcetouch;
    private Boolean fullscreen;
    private Boolean gamepads;
    private Boolean indexeddb;
    private Boolean intl;
    private Boolean pagevisibility;
    private Boolean performance;
    private Boolean pointerlock;
    private Boolean quotamanagement;
    private Boolean requestanimationframe;
    private Boolean raf;
    private Boolean vibrate;
    private Boolean webintents;
    private Boolean lowbattery;
    private Boolean getrandomvalues;
    private Boolean backgroundblendmode;
    private Boolean objectfit;
    @JsonProperty(value = "object-fit")
    private Boolean object_fit;
    private Boolean wrapflow;
    private Boolean filesystem;
    private Boolean ligatures;
    private Boolean cssanimations;
    private Boolean csspseudoanimations;
    private Boolean appearance;
    private Boolean backdropfilter;
    private Boolean backgroundcliptext;
    private Boolean bgpositionxy;
    private Boolean bgrepeatround;
    private Boolean bgrepeatspace;
    private Boolean backgroundsize;
    private Boolean bgsizecover;
    private Boolean borderimage;
    private Boolean borderradius;
    private Boolean boxshadow;
    private Boolean boxsizing;
    private Boolean csscolumns;
    private Boolean displayrunin;
    @JsonProperty(value = "display-runin")
    private Boolean display_runin;
    private Boolean ellipsis;
    private Boolean cssfilters;
    private Boolean flexbox;
    private Boolean flexboxlegacy;
    private Boolean flexboxtweener;
    private Boolean flexwrap;
    private Boolean cssmask;
    private Boolean overflowscrolling;
    private Boolean cssreflections;
    private Boolean cssresize;
    private Boolean scrollsnappoints;
    private Boolean shapes;
    private Boolean textalignlast;
    private Boolean csstransforms;
    private Boolean csstransforms3d;
    private Boolean csstransitions;
    private Boolean csspseudotransitions;
    private Boolean userselect;
    private Boolean outputelem;
    private Boolean picture;
    private Boolean ruby;
    private Boolean template;
    private Boolean texttrackapi;
    private Boolean track;
    private Boolean unknownelements;
    private Boolean es5date;
    private Boolean es5syntax;
    private Boolean es5;
    private Boolean es6collections;
    private Boolean es6math;
    private Boolean promises;
    private Boolean oninput;
    private Boolean capture;
    private Boolean formattribute;
    private Boolean placeholder;
    private Boolean requestautocomplete;
    private Boolean formvalidation;
    private Boolean localizednumber;
    private Boolean sandbox;
    private Boolean seamless;
    private Boolean srcdoc;
    private Boolean imgcrossorigin;
    private Boolean sizes;
    private Boolean srcset;
    private Boolean inputformaction;
    @JsonProperty(value = "input-formaction")
    private Boolean input_formaction;
    private Boolean inputformenctype;
    @JsonProperty(value = "input-formenctype")
    private Boolean input_formenctype;
    private Boolean inputformmethod;
    private Boolean inputformtarget;
    @JsonProperty(value = "input-formtarget")
    private Boolean input_formtarget;
    private Boolean beacon;
    private Boolean lowbandwidth;
    private Boolean eventsource;
    private Boolean fetch;
    private Boolean xhrresponsetype;
    private Boolean xhr2;
    private Boolean scriptasync;
    private Boolean scriptdefer;
    private Boolean speechrecognition;
    private Boolean speechsynthesis;
    private Boolean localstorage;
    private Boolean sessionstorage;
    private Boolean websqldatabase;
    private Boolean stylescoped;
    private Boolean svgasimg;
    private Boolean svgfilters;
    private Boolean inlinesvg;
    private Boolean textareamaxlength;
    private Boolean bloburls;
    private Boolean urlparser;
    private Boolean videoloop;
    private Boolean webglextensions;
    private Boolean videopreload;
    private Boolean getusermedia;
    private Boolean peerconnection;
    private Boolean datachannel;
    private Boolean websocketsbinary;
    private Boolean atobbtoa;
    @JsonProperty(value = "atob-btoa")
    private Boolean atob_btoa;
    private Boolean framed;
    private Boolean matchmedia;
    private Boolean sharedworkers;
    private Boolean webworkers;
    private Boolean transferables;
    private Boolean xhrresponsetypearraybuffer;
    private Boolean xhrresponsetypeblob;
    private Boolean xhrresponsetypedocument;
    private Boolean xhrresponsetypejson;
    private Boolean xhrresponsetypetext;
    private Boolean svgclippaths;
    private Boolean svgforeignobject;
    private Boolean smil;
    private Boolean proximity;
    private Boolean csshyphens;
    private Boolean softhyphens;
    private Boolean softhyphensfind;
    private Boolean blobworkers;
    private Boolean dataworkers;
    private Boolean jpeg2000;
    private Boolean jpegxr;
    private Boolean webpalpha;
    private Boolean webpanimation;
    private Boolean webplossless;
    private Boolean webp;
    private Boolean exiforientation;
    private Boolean apng;
    private Boolean audiopreload;
    private Boolean videoautoplay;
    private Boolean datauri;
    private Boolean indexeddbblob;

    /**
     * A new instance of modernizr
     */
    public ModernizrDto()
    {

    }

    /**
     * Returns the input portion
     *
     * @return
     */
    public ModernizrInputDto getInput()
    {
        return input;
    }

    /**
     * Sets the input portion
     *
     * @param input
     */
    public void setInput(ModernizrInputDto input)
    {
        this.input = input;
    }

    /**
     * Gets the input types
     *
     * @return
     */
    public ModernizrInputTypesDto getInputtypes()
    {
        return inputtypes;
    }

    /**
     * Sets the input types
     *
     * @param inputtypes
     */
    public void setInputtypes(ModernizrInputTypesDto inputtypes)
    {
        this.inputtypes = inputtypes;
    }

    /**
     * Is CSS VMax Unit Allowed
     *
     * @return
     */
    public Boolean isCssvmaxunit()
    {
        return cssvmaxunit;
    }

    /**
     * Is CSS VMax Unit Allowed
     *
     * @param cssvmaxunit
     */
    protected void setCssvmaxunit(Boolean cssvmaxunit)
    {
        this.cssvmaxunit = cssvmaxunit;
    }

    /**
     * Is CSS VMin unit allowed
     *
     * @return
     */
    public Boolean isCssvminunit()
    {
        return cssvminunit;
    }

    /**
     * Is CSS VMin Units alloweod
     *
     * @param cssvminunit
     */
    protected void setCssvminunit(Boolean cssvminunit)
    {
        this.cssvminunit = cssvminunit;
    }

    /**
     * Is CSS VW Units allowed
     *
     * @return
     */
    public Boolean isCssvwunit()
    {
        return cssvwunit;
    }

    /**
     * Is CSS VWUnits allowed
     *
     * @param cssvwunit
     */
    protected void setCssvwunit(Boolean cssvwunit)
    {
        this.cssvwunit = cssvwunit;
    }

    /**
     * Is Details allowed
     *
     * @return
     */
    public Boolean isDetails()
    {
        return details;
    }

    /**
     * Is details allowed
     *
     * @param details
     */
    protected void setDetails(Boolean details)
    {
        this.details = details;
    }

    /**
     * Is media queries allowed
     *
     * @return
     */
    public Boolean isMediaqueries()
    {
        return mediaqueries;
    }

    /**
     * Is media queries allowed
     *
     * @param mediaqueries
     */
    protected void setMediaqueries(Boolean mediaqueries)
    {
        this.mediaqueries = mediaqueries;
    }

    /**
     * is pointer events allowed
     *
     * @return
     */
    public Boolean isPointerevents()
    {
        return pointerevents;
    }

    /**
     * sets the pointer events
     *
     * @param pointerevents
     */
    protected void setPointerevents(Boolean pointerevents)
    {
        this.pointerevents = pointerevents;
    }

    /**
     * Is file input directory allowed
     *
     * @return
     */
    public Boolean isFileinputdirectory()
    {
        return fileinputdirectory;
    }

    /**
     * Is file input directories allowed
     *
     * @param fileinputdirectory
     */
    protected void setFileinputdirectory(Boolean fileinputdirectory)
    {
        this.fileinputdirectory = fileinputdirectory;
    }

    /**
     * Is text shadows allowed
     *
     * @return
     */
    public Boolean isTextshadow()
    {
        return textshadow;
    }

    /**
     * Is text shadows allowed
     *
     * @param textshadow
     */
    protected void setTextshadow(Boolean textshadow)
    {
        this.textshadow = textshadow;
    }

    /**
     * Is the Battery API allowed
     *
     * @return
     */
    public Boolean isBatteryapi()
    {
        return batteryapi;
    }

    /**
     * Is the battery api allowed
     *
     * @param batteryapi
     */
    protected void setBatteryapi(Boolean batteryapi)
    {
        this.batteryapi = batteryapi;
    }

    /**
     * Is the battery API allowed
     *
     * @return
     */
    public Boolean isBatteryApi()
    {
        return battery_api;
    }

    /**
     * Is the battery API allowed
     *
     * @param battery_api
     */
    protected void setBatteryApi(Boolean battery_api)
    {
        this.battery_api = battery_api;
    }

    /**
     * Is the crypto library allowed
     *
     * @return
     */
    public Boolean isCrypto()
    {
        return crypto;
    }

    /**
     * Is the crypto library allowed
     *
     * @param crypto
     */
    protected void setCrypto(Boolean crypto)
    {
        this.crypto = crypto;
    }

    /**
     * Is the dart library allowed
     *
     * @return
     */
    public Boolean isDart()
    {
        return dart;
    }

    /**
     * Is the dart library allowed
     *
     * @param dart
     */
    protected void setDart(Boolean dart)
    {
        this.dart = dart;
    }

    /**
     * Is force touch enabled
     *
     * @return
     */
    public Boolean isForcetouch()
    {
        return forcetouch;
    }

    /**
     * Is force touch enabled
     *
     * @param forcetouch
     */
    protected void setForcetouch(Boolean forcetouch)
    {
        this.forcetouch = forcetouch;
    }

    /**
     * Is full screen enabled
     *
     * @return
     */
    public Boolean isFullscreen()
    {
        return fullscreen;
    }

    /**
     * Is full screen enabled
     *
     * @param fullscreen
     */
    protected void setFullscreen(Boolean fullscreen)
    {
        this.fullscreen = fullscreen;
    }

    /**
     * Are game pads enabled
     *
     * @return
     */
    public Boolean isGamepads()
    {
        return gamepads;
    }

    /**
     * Are game pads enabled
     *
     * @param gamepads
     */
    protected void setGamepads(Boolean gamepads)
    {
        this.gamepads = gamepads;
    }

    /**
     * Is Indexed DB Available
     *
     * @return
     */
    public Boolean isIndexeddb()
    {
        return indexeddb;
    }

    /**
     * Is Indexed DB Available
     *
     * @param indexeddb
     */
    protected void setIndexeddb(Boolean indexeddb)
    {
        this.indexeddb = indexeddb;
    }

    /**
     * Is intl available
     *
     * @return
     */
    public Boolean isIntl()
    {
        return intl;
    }

    /**
     * Is intl available
     *
     * @param intl
     */
    protected void setIntl(Boolean intl)
    {
        this.intl = intl;
    }

    /**
     * Is page visibility available
     *
     * @return
     */
    public Boolean isPagevisibility()
    {
        return pagevisibility;
    }

    /**
     * Is page visibility available
     *
     * @param pagevisibility
     */
    protected void setPagevisibility(Boolean pagevisibility)
    {
        this.pagevisibility = pagevisibility;
    }

    /**
     * Is performance available
     *
     * @return
     */
    public Boolean isPerformance()
    {
        return performance;
    }

    /**
     * Is performance available
     *
     * @param performance
     */
    protected void setPerformance(Boolean performance)
    {
        this.performance = performance;
    }

    /**
     * Is pointer lock available
     *
     * @return
     */
    public Boolean isPointerlock()
    {
        return pointerlock;
    }

    /**
     * is pointer lock available
     *
     * @param pointerlock
     */
    protected void setPointerlock(Boolean pointerlock)
    {
        this.pointerlock = pointerlock;
    }

    /**
     * Is Quota Management enabled
     *
     * @return
     */
    public Boolean isQuotamanagement()
    {
        return quotamanagement;
    }

    /**
     * Is quota management enabled
     *
     * @param quotamanagement
     */
    protected void setQuotamanagement(Boolean quotamanagement)
    {
        this.quotamanagement = quotamanagement;
    }

    /**
     * Is request animation frame enabled
     *
     * @return
     */
    public Boolean isRequestanimationframe()
    {
        return requestanimationframe;
    }

    /**
     * Is request animation frame enabled
     *
     * @param requestanimationframe
     */
    protected void setRequestanimationframe(Boolean requestanimationframe)
    {
        this.requestanimationframe = requestanimationframe;
    }

    /**
     * Is RAF enabled
     *
     * @return
     */
    public Boolean isRaf()
    {
        return raf;
    }

    /**
     * Is RAF Enabled
     *
     * @param raf
     */
    protected void setRaf(Boolean raf)
    {
        this.raf = raf;
    }

    /**
     * Is vibrate enabled
     *
     * @return
     */
    public Boolean isVibrate()
    {
        return vibrate;
    }

    /**
     * Is allowed to vibrate
     *
     * @param vibrate
     */
    protected void setVibrate(Boolean vibrate)
    {
        this.vibrate = vibrate;
    }

    /**
     * Is web Intents
     *
     * @return
     */
    public Boolean isWebintents()
    {
        return webintents;
    }

    /**
     * Is Web Intents
     *
     * @param webintents
     */
    protected void setWebintents(Boolean webintents)
    {
        this.webintents = webintents;
    }

    /**
     * Is low battery
     *
     * @return
     */
    public Boolean isLowbattery()
    {
        return lowbattery;
    }

    /**
     * Is low battery
     *
     * @param lowbattery
     */
    protected void setLowbattery(Boolean lowbattery)
    {
        this.lowbattery = lowbattery;
    }

    /**
     * Are random values allowed
     *
     * @return
     */
    public Boolean isGetrandomvalues()
    {
        return getrandomvalues;
    }

    /**
     * Are random values allowed
     *
     * @param getrandomvalues
     */
    protected void setGetrandomvalues(Boolean getrandomvalues)
    {
        this.getrandomvalues = getrandomvalues;
    }

    /**
     * Is background blend mode allowed
     *
     * @return
     */
    public Boolean isBackgroundblendmode()
    {
        return backgroundblendmode;
    }

    /**
     * Sets background blend mode
     *
     * @param backgroundblendmode
     */
    protected void setBackgroundblendmode(Boolean backgroundblendmode)
    {
        this.backgroundblendmode = backgroundblendmode;
    }

    /**
     * Is object fit allowed
     *
     * @return
     */
    public Boolean isObjectfit()
    {
        return objectfit;
    }

    /**
     * Is object fit allowed
     *
     * @param objectfit
     */
    protected void setObjectfit(Boolean objectfit)
    {
        this.objectfit = objectfit;
    }

    /**
     * Is object fit allowed
     *
     * @return
     */
    public Boolean isObjectFit()
    {
        return object_fit;
    }

    /**
     * Is object fit allowed
     *
     * @param object_fit
     */
    protected void setObjectFit(Boolean object_fit)
    {
        this.object_fit = object_fit;
    }

    /**
     * Is wrap flow allowed
     *
     * @return
     */
    public Boolean isWrapflow()
    {
        return wrapflow;
    }

    /**
     * Sets if wrap flow is allowed
     *
     * @param wrapflow
     */
    protected void setWrapflow(Boolean wrapflow)
    {
        this.wrapflow = wrapflow;
    }

    /**
     * Is file system allowed
     *
     * @return
     */
    public Boolean isFilesystem()
    {
        return filesystem;
    }

    /**
     * Is file system allowed
     *
     * @param filesystem
     */
    protected void setFilesystem(Boolean filesystem)
    {
        this.filesystem = filesystem;
    }

    /**
     * Is ligatures allowed
     *
     * @return
     */
    public Boolean isLigatures()
    {
        return ligatures;
    }

    /**
     * Is ligatures allowed
     *
     * @param ligatures
     */
    protected void setLigatures(Boolean ligatures)
    {
        this.ligatures = ligatures;
    }

    /**
     * Is CSS Animations allowed
     *
     * @return
     */
    public Boolean isCssanimations()
    {
        return cssanimations;
    }

    /**
     * Is CSS Animations allowed
     *
     * @param cssanimations
     */
    protected void setCssanimations(Boolean cssanimations)
    {
        this.cssanimations = cssanimations;
    }

    /**
     * Is psuedo animations allowed
     *
     * @return
     */
    public Boolean isCsspseudoanimations()
    {
        return csspseudoanimations;
    }

    /**
     * Is Pseudo elements allowed
     *
     * @param csspseudoanimations
     */
    protected void setCsspseudoanimations(Boolean csspseudoanimations)
    {
        this.csspseudoanimations = csspseudoanimations;
    }

    /**
     * Is appearance calls allowed
     *
     * @return
     */
    public Boolean isAppearance()
    {
        return appearance;
    }

    /**
     * Is appearance calls allowed
     *
     * @param appearance
     */
    protected void setAppearance(Boolean appearance)
    {
        this.appearance = appearance;
    }

    /**
     * Are backdrop filters allowed
     *
     * @return
     */
    public Boolean isBackdropfilter()
    {
        return backdropfilter;
    }

    /**
     * Are backdrop filters allowed
     *
     * @param backdropfilter
     */
    protected void setBackdropfilter(Boolean backdropfilter)
    {
        this.backdropfilter = backdropfilter;
    }

    /**
     * Is background clip text allowed
     *
     * @return
     */
    public Boolean isBackgroundcliptext()
    {
        return backgroundcliptext;
    }

    /**
     * Is background clip text allowed
     *
     * @param backgroundcliptext
     */
    protected void setBackgroundcliptext(Boolean backgroundcliptext)
    {
        this.backgroundcliptext = backgroundcliptext;
    }

    /**
     * Is bg position xy allowed
     *
     * @return
     */
    public Boolean isBgpositionxy()
    {
        return bgpositionxy;
    }

    /**
     * Is bg position xy allowed
     *
     * @param bgpositionxy
     */
    protected void setBgpositionxy(Boolean bgpositionxy)
    {
        this.bgpositionxy = bgpositionxy;
    }

    /**
     * Is bg reapeat round allowed
     *
     * @return
     */
    public Boolean isBgrepeatround()
    {
        return bgrepeatround;
    }

    /**
     * Is bg repeat round allowed
     *
     * @param bgrepeatround
     */
    protected void setBgrepeatround(Boolean bgrepeatround)
    {
        this.bgrepeatround = bgrepeatround;
    }

    /**
     * If bg repeat space allowed
     *
     * @return
     */
    public Boolean isBgrepeatspace()
    {
        return bgrepeatspace;
    }

    /**
     * Is bg repeat space alloweod
     *
     * @param bgrepeatspace
     */
    protected void setBgrepeatspace(Boolean bgrepeatspace)
    {
        this.bgrepeatspace = bgrepeatspace;
    }

    /**
     * Is background size allowed
     *
     * @return
     */
    public Boolean isBackgroundsize()
    {
        return backgroundsize;
    }

    /**
     * Is background size allowed
     *
     * @param backgroundsize
     */
    protected void setBackgroundsize(Boolean backgroundsize)
    {
        this.backgroundsize = backgroundsize;
    }

    /**
     * Is bg cover allowed
     *
     * @return
     */
    public Boolean isBgsizecover()
    {
        return bgsizecover;
    }

    /**
     * Is bg size cover allowed
     *
     * @param bgsizecover
     */
    protected void setBgsizecover(Boolean bgsizecover)
    {
        this.bgsizecover = bgsizecover;
    }

    /**
     * Is border image allowed
     *
     * @return
     */
    public Boolean isBorderimage()
    {
        return borderimage;
    }

    /**
     * Is border image allowed
     *
     * @param borderimage
     */
    protected void setBorderimage(Boolean borderimage)
    {
        this.borderimage = borderimage;
    }

    /**
     * Is border radius allowed
     *
     * @return
     */
    public Boolean isBorderradius()
    {
        return borderradius;
    }

    /**
     * Is border radius allowed
     *
     * @param borderradius
     */
    protected void setBorderradius(Boolean borderradius)
    {
        this.borderradius = borderradius;
    }

    /**
     * Is box shadow allowed
     *
     * @return
     */
    public Boolean isBoxshadow()
    {
        return boxshadow;
    }

    /**
     * Is box shadow allowed
     *
     * @param boxshadow
     */
    protected void setBoxshadow(Boolean boxshadow)
    {
        this.boxshadow = boxshadow;
    }

    /**
     * Is box sizing allowed
     *
     * @return
     */
    public Boolean isBoxsizing()
    {
        return boxsizing;
    }

    /**
     * Is box sizing allowed
     *
     * @param boxsizing
     */
    protected void setBoxsizing(Boolean boxsizing)
    {
        this.boxsizing = boxsizing;
    }

    /**
     * Is CSS Columns allowed
     *
     * @return
     */
    public Boolean isCsscolumns()
    {
        return csscolumns;
    }

    /**
     * Is css columns allowed
     *
     * @param csscolumns
     */
    protected void setCsscolumns(Boolean csscolumns)
    {
        this.csscolumns = csscolumns;
    }

    /**
     * Get display run in
     *
     * @return
     */
    public Boolean isDisplayrunin()
    {
        return displayrunin;
    }

    /**
     * Get display run in
     *
     * @param displayrunin
     */
    protected void setDisplayrunin(Boolean displayrunin)
    {
        this.displayrunin = displayrunin;
    }

    /**
     * Display run in
     *
     * @return
     */
    public Boolean isDisplayRunin()
    {
        return display_runin;
    }

    /**
     * Display run in
     *
     * @param display_runin
     */
    protected void setDisplayRunin(Boolean display_runin)
    {
        this.display_runin = display_runin;
    }

    /**
     * Are ellipsis allowed
     *
     * @return
     */
    public Boolean isEllipsis()
    {
        return ellipsis;
    }

    /**
     * Are ellipsis allowed
     *
     * @param ellipsis
     */
    protected void setEllipsis(Boolean ellipsis)
    {
        this.ellipsis = ellipsis;
    }

    /**
     * Are CSS Filters allowed
     *
     * @return
     */
    public Boolean isCssfilters()
    {
        return cssfilters;
    }

    /**
     * Are CSS filters allowed
     *
     * @param cssfilters
     */
    protected void setCssfilters(Boolean cssfilters)
    {
        this.cssfilters = cssfilters;
    }

    /**
     * Is flex box allowed
     *
     * @return
     */
    public Boolean isFlexbox()
    {
        return flexbox;
    }

    /**
     * Is flex box allowed
     *
     * @param flexbox
     */
    protected void setFlexbox(Boolean flexbox)
    {
        this.flexbox = flexbox;
    }

    /**
     * Is flex box legacy allowed
     *
     * @return
     */
    public Boolean isFlexboxlegacy()
    {
        return flexboxlegacy;
    }

    /**
     * Is flex box legacy allowed
     *
     * @param flexboxlegacy
     */
    protected void setFlexboxlegacy(Boolean flexboxlegacy)
    {
        this.flexboxlegacy = flexboxlegacy;
    }

    /**
     * Is flex box tweener allowed
     *
     * @return
     */
    public Boolean isFlexboxtweener()
    {
        return flexboxtweener;
    }

    /**
     * Is flex box tweener allowed
     *
     * @param flexboxtweener
     */
    protected void setFlexboxtweener(Boolean flexboxtweener)
    {
        this.flexboxtweener = flexboxtweener;
    }

    /**
     * Is flex wrap allowed
     *
     * @return
     */
    public Boolean isFlexwrap()
    {
        return flexwrap;
    }

    /**
     * Is flex wrap allowed
     *
     * @param flexwrap
     */
    protected void setFlexwrap(Boolean flexwrap)
    {
        this.flexwrap = flexwrap;
    }

    /**
     * Is CSS Mask enabled
     *
     * @return
     */
    public Boolean isCssmask()
    {
        return cssmask;
    }

    /**
     * Set CSS Mask
     *
     * @param cssmask
     */
    protected void setCssmask(Boolean cssmask)
    {
        this.cssmask = cssmask;
    }

    /**
     * Is overflow scrolling allowed
     *
     * @return
     */
    public Boolean isOverflowscrolling()
    {
        return overflowscrolling;
    }

    /**
     * Is overflow scrolling allowed
     *
     * @param overflowscrolling
     */
    protected void setOverflowscrolling(Boolean overflowscrolling)
    {
        this.overflowscrolling = overflowscrolling;
    }

    /**
     * Is CSS Reflections allowed
     *
     * @return
     */
    public Boolean isCssreflections()
    {
        return cssreflections;
    }

    /**
     * Is CSS Reflections allowed
     *
     * @param cssreflections
     */
    protected void setCssreflections(Boolean cssreflections)
    {
        this.cssreflections = cssreflections;
    }

    /**
     * Is CSS Resize Allowed
     *
     * @return
     */
    public Boolean isCssresize()
    {
        return cssresize;
    }

    /**
     * Is CSS Resize allowed
     *
     * @param cssresize
     */
    protected void setCssresize(Boolean cssresize)
    {
        this.cssresize = cssresize;
    }

    /**
     * Is scroll snap points allowed
     *
     * @return
     */
    public Boolean isScrollsnappoints()
    {
        return scrollsnappoints;
    }

    /**
     * Is scroll snap points allowed
     *
     * @param scrollsnappoints
     */
    protected void setScrollsnappoints(Boolean scrollsnappoints)
    {
        this.scrollsnappoints = scrollsnappoints;
    }

    /**
     * Is shapes allowed?
     *
     * @return
     */
    public Boolean isShapes()
    {
        return shapes;
    }

    /**
     * Sets shapes allowed
     *
     * @param shapes
     */
    protected void setShapes(Boolean shapes)
    {
        this.shapes = shapes;
    }

    /**
     * Is text align last allowed
     *
     * @return
     */
    public Boolean isTextalignlast()
    {
        return textalignlast;
    }

    /**
     * Is text align last enabled
     *
     * @param textalignlast
     */
    protected void setTextalignlast(Boolean textalignlast)
    {
        this.textalignlast = textalignlast;
    }

    /**
     * Is CSS Transforms allowed
     *
     * @return
     */
    public Boolean isCsstransforms()
    {
        return csstransforms;
    }

    /**
     * Is CSS Transforms allowed
     *
     * @param csstransforms
     */
    protected void setCsstransforms(Boolean csstransforms)
    {
        this.csstransforms = csstransforms;
    }

    /**
     * Is CSS Transforms 3d allowed
     *
     * @return
     */
    public Boolean isCsstransforms3d()
    {
        return csstransforms3d;
    }

    /**
     * Is CSS Transforms 3d allowed
     *
     * @param csstransforms3d
     */
    protected void setCsstransforms3d(Boolean csstransforms3d)
    {
        this.csstransforms3d = csstransforms3d;
    }

    /**
     * Is CSS Transitions allowed
     *
     * @return
     */
    public Boolean isCsstransitions()
    {
        return csstransitions;
    }

    /**
     * Is CSS Transitions Allowed
     *
     * @param csstransitions
     */
    protected void setCsstransitions(Boolean csstransitions)
    {
        this.csstransitions = csstransitions;
    }

    /**
     * Are pseudo transitions allowed
     *
     * @return
     */
    public Boolean isCsspseudotransitions()
    {
        return csspseudotransitions;
    }

    /**
     * Are pseudo transitions allowed
     *
     * @param csspseudotransitions
     */
    protected void setCsspseudotransitions(Boolean csspseudotransitions)
    {
        this.csspseudotransitions = csspseudotransitions;
    }

    /**
     * Is user selections allowed
     *
     * @return
     */
    public Boolean isUserselect()
    {
        return userselect;
    }

    /**
     * Is user selections allowed
     *
     * @param userselect
     */
    protected void setUserselect(Boolean userselect)
    {
        this.userselect = userselect;
    }

    /**
     * Is output elements allowed
     *
     * @return
     */
    public Boolean isOutputelem()
    {
        return outputelem;
    }

    /**
     * Is output elements allowed
     *
     * @param outputelem
     */
    protected void setOutputelem(Boolean outputelem)
    {
        this.outputelem = outputelem;
    }

    /**
     * Is picture allowed
     *
     * @return
     */
    public Boolean isPicture()
    {
        return picture;
    }

    /**
     * Is picture allowed
     *
     * @param picture
     */
    protected void setPicture(Boolean picture)
    {
        this.picture = picture;
    }

    /**
     * Is ruby allowed
     *
     * @return
     */
    public Boolean isRuby()
    {
        return ruby;
    }

    /**
     * Is ruby allowed
     *
     * @param ruby
     */
    protected void setRuby(Boolean ruby)
    {
        this.ruby = ruby;
    }

    /**
     * Is template allowed
     *
     * @return
     */
    public Boolean isTemplate()
    {
        return template;
    }

    /**
     * Is template allowed
     *
     * @param template
     */
    protected void setTemplate(Boolean template)
    {
        this.template = template;
    }

    /**
     * Is text track api enabled
     *
     * @return
     */
    public Boolean isTexttrackapi()
    {
        return texttrackapi;
    }

    /**
     * Is text track api enabled
     *
     * @param texttrackapi
     */
    protected void setTexttrackapi(Boolean texttrackapi)
    {
        this.texttrackapi = texttrackapi;
    }

    /**
     * Is track enabled
     *
     * @return
     */
    public Boolean isTrack()
    {
        return track;
    }

    /**
     * Is track enabled
     *
     * @param track
     */
    protected void setTrack(Boolean track)
    {
        this.track = track;
    }

    /**
     * Is unknown elements enabled
     *
     * @return
     */
    public Boolean isUnknownelements()
    {
        return unknownelements;
    }

    /**
     * Is unknown elements
     *
     * @param unknownelements
     */
    protected void setUnknownelements(Boolean unknownelements)
    {
        this.unknownelements = unknownelements;
    }

    /**
     * Is es 5 dates enabled
     *
     * @return
     */
    public Boolean isEs5date()
    {
        return es5date;
    }

    /**
     * Is es 5 dates enabled
     *
     * @param es5date
     */
    protected void setEs5date(Boolean es5date)
    {
        this.es5date = es5date;
    }

    /**
     * Is es 5 syntax enabled
     *
     * @return
     */
    public Boolean isEs5syntax()
    {
        return es5syntax;
    }

    /**
     * Is es 5 syntax enabled
     *
     * @param es5syntax
     */
    protected void setEs5syntax(Boolean es5syntax)
    {
        this.es5syntax = es5syntax;
    }

    /**
     * Is es 5 enabled
     *
     * @return
     */
    public Boolean isEs5()
    {
        return es5;
    }

    /**
     * is es 5 enabled
     *
     * @param es5
     */
    protected void setEs5(Boolean es5)
    {
        this.es5 = es5;
    }

    /**
     * ES 6 collections allowed
     *
     * @return
     */
    public Boolean isEs6collections()
    {
        return es6collections;
    }

    /**
     * Is ES 6 collection allowed
     *
     * @param es6collections
     */
    protected void setEs6collections(Boolean es6collections)
    {
        this.es6collections = es6collections;
    }

    /**
     * Is ES 6 math allowed
     *
     * @return
     */
    public Boolean isEs6math()
    {
        return es6math;
    }

    /**
     * Is es 6 math allowed
     *
     * @param es6math
     */
    protected void setEs6math(Boolean es6math)
    {
        this.es6math = es6math;
    }

    /**
     * Are promises allowed
     *
     * @return
     */
    public Boolean isPromises()
    {
        return promises;
    }

    /**
     * Are promises allowed
     *
     * @param promises
     */
    protected void setPromises(Boolean promises)
    {
        this.promises = promises;
    }

    /**
     * Is on Input allowed
     *
     * @return
     */
    public Boolean isOninput()
    {
        return oninput;
    }

    /**
     * Set on input allowed
     *
     * @param oninput
     */
    protected void setOninput(Boolean oninput)
    {
        this.oninput = oninput;
    }

    /**
     * Is capture allowed
     *
     * @return
     */
    public Boolean isCapture()
    {
        return capture;
    }

    /**
     * Sets capture allowed
     *
     * @param capture
     */
    protected void setCapture(Boolean capture)
    {
        this.capture = capture;
    }

    /**
     * Is form attribute allowed
     *
     * @return
     */
    public Boolean isFormattribute()
    {
        return formattribute;
    }

    /**
     * Sets form attribute allowed
     *
     * @param formattribute
     */
    protected void setFormattribute(Boolean formattribute)
    {
        this.formattribute = formattribute;
    }

    /**
     * Is place holder allowed
     *
     * @return
     */
    public Boolean isPlaceholder()
    {
        return placeholder;
    }

    /**
     * Set place holder allowed
     *
     * @param placeholder
     */
    protected void setPlaceholder(Boolean placeholder)
    {
        this.placeholder = placeholder;
    }

    /**
     * Is request auto complete allowed
     *
     * @return
     */
    public Boolean isRequestautocomplete()
    {
        return requestautocomplete;
    }

    /**
     * Sets request auto complete allowed
     *
     * @param requestautocomplete
     */
    protected void setRequestautocomplete(Boolean requestautocomplete)
    {
        this.requestautocomplete = requestautocomplete;
    }

    /**
     * Is form validation allowed
     *
     * @return
     */
    public Boolean isFormvalidation()
    {
        return formvalidation;
    }

    /**
     * Sets form validation allowed
     *
     * @param formvalidation
     */
    protected void setFormvalidation(Boolean formvalidation)
    {
        this.formvalidation = formvalidation;
    }

    /**
     * Is localized number allowed
     *
     * @return
     */
    public Boolean isLocalizednumber()
    {
        return localizednumber;
    }

    /**
     * Sets if localized number is allowed
     *
     * @param localizednumber
     */
    protected void setLocalizednumber(Boolean localizednumber)
    {
        this.localizednumber = localizednumber;
    }

    /**
     * Is sandbox allowed
     *
     * @return
     */
    public Boolean isSandbox()
    {
        return sandbox;
    }

    /**
     * Sets if sandboxing is allowed
     *
     * @param sandbox
     */
    protected void setSandbox(Boolean sandbox)
    {
        this.sandbox = sandbox;
    }

    /**
     * Is seamless allowed
     *
     * @return
     */
    public Boolean isSeamless()
    {
        return seamless;
    }

    /**
     * Sets if seamless is allowed
     *
     * @param seamless
     */
    protected void setSeamless(Boolean seamless)
    {
        this.seamless = seamless;
    }

    /**
     * Is src doc allowed
     *
     * @return
     */
    public Boolean isSrcdoc()
    {
        return srcdoc;
    }

    /**
     * Sets if src docs are allowed
     *
     * @param srcdoc
     */
    protected void setSrcdoc(Boolean srcdoc)
    {
        this.srcdoc = srcdoc;
    }

    /**
     * Is image cross origin allowed
     *
     * @return
     */
    public Boolean isImgcrossorigin()
    {
        return imgcrossorigin;
    }

    /**
     * Sets if img cross origins are allowed
     *
     * @param imgcrossorigin
     */
    protected void setImgcrossorigin(Boolean imgcrossorigin)
    {
        this.imgcrossorigin = imgcrossorigin;
    }

    /**
     * Are sizes allowed
     *
     * @return
     */
    public Boolean isSizes()
    {
        return sizes;
    }

    /**
     * Sets if sizes are allowed
     *
     * @param sizes
     */
    protected void setSizes(Boolean sizes)
    {
        this.sizes = sizes;
    }

    /**
     * Is src set allowed
     *
     * @return
     */
    public Boolean isSrcset()
    {
        return srcset;
    }

    /**
     * Sets if src sets are allowed
     *
     * @param srcset
     */
    protected void setSrcset(Boolean srcset)
    {
        this.srcset = srcset;
    }

    /**
     * Is Input Form Actions allowed
     *
     * @return
     */
    public Boolean isInputformaction()
    {
        return inputformaction;
    }

    /**
     * Sets if Input Form actions are allowed
     *
     * @param inputformaction
     */
    protected void setInputformaction(Boolean inputformaction)
    {
        this.inputformaction = inputformaction;
    }

    /**
     * Is input form action allowed
     *
     * @return
     */
    public Boolean isInputFormaction()
    {
        return input_formaction;
    }

    /**
     * Sets if input form actions are allowed
     *
     * @param input_formaction
     */
    protected void setInputFormaction(Boolean input_formaction)
    {
        this.input_formaction = input_formaction;
    }

    /**
     * Is form enc types allowed
     *
     * @return
     */
    public Boolean isInputformenctype()
    {
        return inputformenctype;
    }

    /**
     * Sets input form enc types
     *
     * @param inputformenctype
     */
    protected void setInputformenctype(Boolean inputformenctype)
    {
        this.inputformenctype = inputformenctype;
    }

    /**
     * Is input form enc type allowed
     *
     * @return
     */
    public Boolean isInpuFormEnctype()
    {
        return input_formenctype;
    }

    /**
     * Is input form encoding type allowed
     *
     * @param input_formenctype
     */
    protected void setInputFormEnctype(Boolean input_formenctype)
    {
        this.input_formenctype = input_formenctype;
    }

    /**
     * Is input form method allowed
     *
     * @return
     */
    public Boolean isInputformmethod()
    {
        return inputformmethod;
    }

    /**
     * Is input form method allowed
     *
     * @param inputformmethod
     */
    protected void setInputformmethod(Boolean inputformmethod)
    {
        this.inputformmethod = inputformmethod;
    }

    /**
     * Is input form target allowed
     *
     * @return
     */
    public Boolean isInputformtarget()
    {
        return inputformtarget;
    }

    /**
     * Is input form target allowed
     *
     * @param inputformtarget
     */
    protected void setInputformtarget(Boolean inputformtarget)
    {
        this.inputformtarget = inputformtarget;
    }

    /**
     * Is input form target allowed
     *
     * @return
     */
    public Boolean isInputFormtarget()
    {
        return input_formtarget;
    }

    /**
     * Sets if input form target is allowed
     *
     * @param input_formtarget
     */
    protected void setInputFormtarget(Boolean input_formtarget)
    {
        this.input_formtarget = input_formtarget;
    }

    /**
     * Is beacon allowed
     *
     * @return
     */
    public Boolean isBeacon()
    {
        return beacon;
    }

    /**
     * Is beacon allowed
     *
     * @param beacon
     */
    protected void setBeacon(Boolean beacon)
    {
        this.beacon = beacon;
    }

    /**
     * Is on low bandwidth
     *
     * @return
     */
    public Boolean isLowbandwidth()
    {
        return lowbandwidth;
    }

    /**
     * Is on low bandwidth
     *
     * @param lowbandwidth
     */
    protected void setLowbandwidth(Boolean lowbandwidth)
    {
        this.lowbandwidth = lowbandwidth;
    }

    /**
     * Is event source allowed
     *
     * @return
     */
    public Boolean isEventsource()
    {
        return eventsource;
    }

    /**
     * Is event source allowed
     *
     * @param eventsource
     */
    protected void setEventsource(Boolean eventsource)
    {
        this.eventsource = eventsource;
    }

    /**
     * Is fetch allowed
     *
     * @return
     */
    public Boolean isFetch()
    {
        return fetch;
    }

    /**
     * Is fetch allowed
     *
     * @param fetch
     */
    protected void setFetch(Boolean fetch)
    {
        this.fetch = fetch;
    }

    /**
     * Is XHR allowed
     *
     * @return
     */
    public Boolean isXhrresponsetype()
    {
        return xhrresponsetype;
    }

    /**
     * Is XHR allowed
     *
     * @param xhrresponsetype
     */
    protected void setXhrresponsetype(Boolean xhrresponsetype)
    {
        this.xhrresponsetype = xhrresponsetype;
    }

    /**
     * Is XHR 2 allowed
     *
     * @return
     */
    public Boolean isXhr2()
    {
        return xhr2;
    }

    /**
     * Is XHR 2 allowed
     *
     * @param xhr2
     */
    protected void setXhr2(Boolean xhr2)
    {
        this.xhr2 = xhr2;
    }

    /**
     * Is script async allowed
     *
     * @return
     */
    public Boolean isScriptasync()
    {
        return scriptasync;
    }

    /**
     * Is script async allowed
     *
     * @param scriptasync
     */
    protected void setScriptasync(Boolean scriptasync)
    {
        this.scriptasync = scriptasync;
    }

    /**
     * Is script defer allowed
     *
     * @return
     */
    public Boolean isScriptdefer()
    {
        return scriptdefer;
    }

    /**
     * Is script defer allowed
     *
     * @param scriptdefer
     */
    protected void setScriptdefer(Boolean scriptdefer)
    {
        this.scriptdefer = scriptdefer;
    }

    /**
     * Is speech recognition allowed
     *
     * @return
     */
    public Boolean isSpeechrecognition()
    {
        return speechrecognition;
    }

    /**
     * Is speech recognition allowed
     *
     * @param speechrecognition
     */
    protected void setSpeechrecognition(Boolean speechrecognition)
    {
        this.speechrecognition = speechrecognition;
    }

    /**
     * Is speech synthesis allowed
     *
     * @return
     */
    public Boolean isSpeechsynthesis()
    {
        return speechsynthesis;
    }

    /**
     * Is speech synthesis allowed
     *
     * @param speechsynthesis
     */
    protected void setSpeechsynthesis(Boolean speechsynthesis)
    {
        this.speechsynthesis = speechsynthesis;
    }

    /**
     * Is local storage allowed
     *
     * @return
     */
    public Boolean isLocalstorage()
    {
        return localstorage;
    }

    /**
     * Is local storage allowed
     *
     * @param localstorage
     */
    protected void setLocalstorage(Boolean localstorage)
    {
        this.localstorage = localstorage;
    }

    /**
     * Is session storage allowed
     *
     * @return
     */
    public Boolean isSessionstorage()
    {
        return sessionstorage;
    }

    /**
     * Is session storage allowed
     *
     * @param sessionstorage
     */
    protected void setSessionstorage(Boolean sessionstorage)
    {
        this.sessionstorage = sessionstorage;
    }

    /**
     * Is web sql database allowed
     *
     * @return
     */
    public Boolean isWebsqldatabase()
    {
        return websqldatabase;
    }

    /**
     * Is web sql database allowed
     *
     * @param websqldatabase
     */
    protected void setWebsqldatabase(Boolean websqldatabase)
    {
        this.websqldatabase = websqldatabase;
    }

    /**
     * Is style scoped
     *
     * @return
     */
    public Boolean isStylescoped()
    {
        return stylescoped;
    }

    /**
     * Is style scoped
     *
     * @param stylescoped
     */
    protected void setStylescoped(Boolean stylescoped)
    {
        this.stylescoped = stylescoped;
    }

    /**
     * Is SVG as image allowed
     *
     * @return
     */
    public Boolean isSvgasimg()
    {
        return svgasimg;
    }

    /**
     * Is SVG as image allowed
     *
     * @param svgasimg
     */
    protected void setSvgasimg(Boolean svgasimg)
    {
        this.svgasimg = svgasimg;
    }

    /**
     * are svg filters allowed
     *
     * @return
     */
    public Boolean isSvgfilters()
    {
        return svgfilters;
    }

    /**
     * Are SVG filters allowed
     *
     * @param svgfilters
     */
    protected void setSvgfilters(Boolean svgfilters)
    {
        this.svgfilters = svgfilters;
    }

    /**
     * Is in line SVG allowed
     *
     * @return
     */
    public Boolean isInlinesvg()
    {
        return inlinesvg;
    }

    /**
     * Is inline SVG allowed
     *
     * @param inlinesvg
     */
    protected void setInlinesvg(Boolean inlinesvg)
    {
        this.inlinesvg = inlinesvg;
    }

    /**
     * Is text area max allowed
     *
     * @return
     */
    public Boolean isTextareamaxlength()
    {
        return textareamaxlength;
    }

    /**
     * Is text area max allowed
     *
     * @param textareamaxlength
     */
    protected void setTextareamaxlength(Boolean textareamaxlength)
    {
        this.textareamaxlength = textareamaxlength;
    }

    /**
     * Are blob url's allowed
     *
     * @return
     */
    public Boolean isBloburls()
    {
        return bloburls;
    }

    /**
     * Are blob url's allowed
     *
     * @param bloburls
     */
    protected void setBloburls(Boolean bloburls)
    {
        this.bloburls = bloburls;
    }

    /**
     * Are URL Parsers allowed
     *
     * @return
     */
    public Boolean isUrlparser()
    {
        return urlparser;
    }

    /**
     * Are URL Parsers allowed
     *
     * @param urlparser
     */
    protected void setUrlparser(Boolean urlparser)
    {
        this.urlparser = urlparser;
    }

    /**
     * Are video loops allowed
     *
     * @return
     */
    public Boolean isVideoloop()
    {
        return videoloop;
    }

    /**
     * Are video loops allowed
     *
     * @param videoloop
     */
    protected void setVideoloop(Boolean videoloop)
    {
        this.videoloop = videoloop;
    }

    /**
     * Is Web GL Extentions allowed
     *
     * @return
     */
    public Boolean isWebglextensions()
    {
        return webglextensions;
    }

    /**
     * Is Web GL Extentions allowed
     *
     * @param webglextensions
     */
    protected void setWebglextensions(Boolean webglextensions)
    {
        this.webglextensions = webglextensions;
    }

    /**
     * Is Video preload allowed
     *
     * @return
     */
    public Boolean isVideopreload()
    {
        return videopreload;
    }

    /**
     * Is video preloads allowed
     *
     * @param videopreload
     */
    protected void setVideopreload(Boolean videopreload)
    {
        this.videopreload = videopreload;
    }

    /**
     * Is get user media allowed
     *
     * @return
     */
    public Boolean isGetusermedia()
    {
        return getusermedia;
    }

    /**
     * Is get user media allowed
     *
     * @param getusermedia
     */
    protected void setGetusermedia(Boolean getusermedia)
    {
        this.getusermedia = getusermedia;
    }

    /**
     * Are peer connections allowed
     *
     * @return
     */
    public Boolean isPeerconnection()
    {
        return peerconnection;
    }

    /**
     * Are peer connections allowed
     *
     * @param peerconnection
     */
    protected void setPeerconnection(Boolean peerconnection)
    {
        this.peerconnection = peerconnection;
    }

    /**
     * Are data channels allowed
     *
     * @return
     */
    public Boolean isDatachannel()
    {
        return datachannel;
    }

    /**
     * Are data channels allowed
     *
     * @param datachannel
     */
    protected void setDatachannel(Boolean datachannel)
    {
        this.datachannel = datachannel;
    }

    /**
     * Are binary web sockets allowed
     *
     * @return
     */
    public Boolean isWebsocketsbinary()
    {
        return websocketsbinary;
    }

    /**
     * Are binary web sockets allowed
     *
     * @param websocketsbinary
     */
    protected void setWebsocketsbinary(Boolean websocketsbinary)
    {
        this.websocketsbinary = websocketsbinary;
    }

    /**
     * Is atabbtoa allowed
     *
     * @return
     */
    public Boolean isAtobbtoa()
    {
        return atobbtoa;
    }

    /**
     * Is atobbtoa allowed
     *
     * @param atobbtoa
     */
    protected void setAtobbtoa(Boolean atobbtoa)
    {
        this.atobbtoa = atobbtoa;
    }

    /**
     * Is Atob BTOA allowed
     *
     * @return
     */
    public Boolean isAtobBtoa()
    {
        return atob_btoa;
    }

    /**
     * Is Atob BTOA is allowed
     *
     * @param atob_btoa
     */
    protected void setAtobBtoa(Boolean atob_btoa)
    {
        this.atob_btoa = atob_btoa;
    }

    /**
     * Is frames allowed
     *
     * @return
     */
    public Boolean isFramed()
    {
        return framed;
    }

    /**
     * Is framed allowedc
     *
     * @param framed
     */
    protected void setFramed(Boolean framed)
    {
        this.framed = framed;
    }

    /**
     * Is match media allowed
     *
     * @return
     */
    public Boolean isMatchmedia()
    {
        return matchmedia;
    }

    /**
     * Is match media allowed
     *
     * @param matchmedia
     */
    protected void setMatchmedia(Boolean matchmedia)
    {
        this.matchmedia = matchmedia;
    }

    /**
     * Are shared workers allowed
     *
     * @return
     */
    public Boolean isSharedworkers()
    {
        return sharedworkers;
    }

    /**
     * Are shared workers allowed
     *
     * @param sharedworkers
     */
    protected void setSharedworkers(Boolean sharedworkers)
    {
        this.sharedworkers = sharedworkers;
    }

    /**
     * Is web workers allowed
     *
     * @return
     */
    public Boolean isWebworkers()
    {
        return webworkers;
    }

    /**
     * Are web workers allowed
     *
     * @param webworkers
     */
    protected void setWebworkers(Boolean webworkers)
    {
        this.webworkers = webworkers;
    }

    /**
     * Are transferables allowed
     *
     * @return
     */
    public Boolean isTransferables()
    {
        return transferables;
    }

    /**
     * Are transferables allowed
     *
     * @param transferables
     */
    protected void setTransferables(Boolean transferables)
    {
        this.transferables = transferables;
    }

    /**
     * Is XHR Response type array buffer allowed
     *
     * @return
     */
    public Boolean isXhrresponsetypearraybuffer()
    {
        return xhrresponsetypearraybuffer;
    }

    /**
     * Is XHR Response type array buffer allowed
     *
     * @param xhrresponsetypearraybuffer
     */
    protected void setXhrresponsetypearraybuffer(Boolean xhrresponsetypearraybuffer)
    {
        this.xhrresponsetypearraybuffer = xhrresponsetypearraybuffer;
    }

    /**
     * Is Is XHR Response type array blob allowed
     *
     * @return
     */
    public Boolean isXhrresponsetypeblob()
    {
        return xhrresponsetypeblob;
    }

    /**
     * Is XHR Response type blob allowed
     *
     * @param xhrresponsetypeblob
     */
    protected void setXhrresponsetypeblob(Boolean xhrresponsetypeblob)
    {
        this.xhrresponsetypeblob = xhrresponsetypeblob;
    }

    /**
     * Is XHR Reponse Document sets allowed
     *
     * @return
     */
    public Boolean isXhrresponsetypedocument()
    {
        return xhrresponsetypedocument;
    }

    /**
     * Is XHR Response type documents allowed
     *
     * @param xhrresponsetypedocument
     */
    protected void setXhrresponsetypedocument(Boolean xhrresponsetypedocument)
    {
        this.xhrresponsetypedocument = xhrresponsetypedocument;
    }

    /**
     * Is XHR Json allowed
     *
     * @return
     */
    public Boolean isXhrresponsetypejson()
    {
        return xhrresponsetypejson;
    }

    /**
     * Is XHR Json allowed
     *
     * @param xhrresponsetypejson
     */
    protected void setXhrresponsetypejson(Boolean xhrresponsetypejson)
    {
        this.xhrresponsetypejson = xhrresponsetypejson;
    }

    /**
     * Is XHR Respones Type Text Allowed
     *
     * @return
     */
    public Boolean isXhrresponsetypetext()
    {
        return xhrresponsetypetext;
    }

    /**
     * Is XHR Response type Text Allowed
     *
     * @param xhrresponsetypetext
     */
    protected void setXhrresponsetypetext(Boolean xhrresponsetypetext)
    {
        this.xhrresponsetypetext = xhrresponsetypetext;
    }

    /**
     * Are SVG Clip Paths Allowed
     *
     * @return
     */
    public Boolean isSvgclippaths()
    {
        return svgclippaths;
    }

    /**
     * Are SVG Clip Paths allowed
     *
     * @param svgclippaths
     */
    protected void setSvgclippaths(Boolean svgclippaths)
    {
        this.svgclippaths = svgclippaths;
    }

    /**
     * Is SVG Foreign Objects Allowed
     *
     * @return
     */
    public Boolean isSvgforeignobject()
    {
        return svgforeignobject;
    }

    /**
     * Is SVG Foreign Objects Allowed
     *
     * @param svgforeignobject
     */
    protected void setSvgforeignobject(Boolean svgforeignobject)
    {
        this.svgforeignobject = svgforeignobject;
    }

    /**
     * Is smil allowed
     *
     * @return
     */
    public Boolean isSmil()
    {
        return smil;
    }

    /**
     * Is smil allowed
     *
     * @param smil
     */
    protected void setSmil(Boolean smil)
    {
        this.smil = smil;
    }

    /**
     * Is proximity allowed
     *
     * @return
     */
    public Boolean isProximity()
    {
        return proximity;
    }

    /**
     * Is proximity allowed
     *
     * @param proximity
     */
    protected void setProximity(Boolean proximity)
    {
        this.proximity = proximity;
    }

    /**
     * Are CSS Hyphens allowed
     *
     * @return
     */
    public Boolean isCsshyphens()
    {
        return csshyphens;
    }

    /**
     * Are CSS Hyphens allowed
     *
     * @param csshyphens
     */
    protected void setCsshyphens(Boolean csshyphens)
    {
        this.csshyphens = csshyphens;
    }

    /**
     * Are soft hyphens allowed
     *
     * @return
     */
    public Boolean isSofthyphens()
    {
        return softhyphens;
    }

    /**
     * Are soft hyphens allowed
     *
     * @param softhyphens
     */
    protected void setSofthyphens(Boolean softhyphens)
    {
        this.softhyphens = softhyphens;
    }

    /**
     * Are soft hyphens findable
     *
     * @return
     */
    public Boolean isSofthyphensfind()
    {
        return softhyphensfind;
    }

    /**
     * Are soft hyphens finable
     *
     * @param softhyphensfind
     */
    protected void setSofthyphensfind(Boolean softhyphensfind)
    {
        this.softhyphensfind = softhyphensfind;
    }

    /**
     * Are blob workers enabled
     *
     * @return
     */
    public Boolean isBlobworkers()
    {
        return blobworkers;
    }

    /**
     * Are blob workers enabled
     *
     * @param blobworkers
     */
    protected void setBlobworkers(Boolean blobworkers)
    {
        this.blobworkers = blobworkers;
    }

    /**
     * Are data workers enabled
     *
     * @return
     */
    public Boolean isDataworkers()
    {
        return dataworkers;
    }

    /**
     * Are data workers enabled
     *
     * @param dataworkers
     */
    protected void setDataworkers(Boolean dataworkers)
    {
        this.dataworkers = dataworkers;
    }

    /**
     * Is jpeg 2000 enabled
     *
     * @return
     */
    public Boolean isJpeg2000()
    {
        return jpeg2000;
    }

    /**
     * is jpeg 2000 enabled
     *
     * @param jpeg2000
     */
    protected void setJpeg2000(Boolean jpeg2000)
    {
        this.jpeg2000 = jpeg2000;
    }

    /**
     * Is jpeg xr enabled
     *
     * @return
     */
    public Boolean isJpegxr()
    {
        return jpegxr;
    }

    /**
     * Is jpeg xr enabled
     *
     * @param jpegxr
     */
    protected void setJpegxr(Boolean jpegxr)
    {
        this.jpegxr = jpegxr;
    }

    /**
     * Is web alpha enabled
     *
     * @return
     */
    public Boolean isWebpalpha()
    {
        return webpalpha;
    }

    /**
     * Is web alpha enabled
     *
     * @param webpalpha
     */
    protected void setWebpalpha(Boolean webpalpha)
    {
        this.webpalpha = webpalpha;
    }

    /**
     * Is web animation enabled
     *
     * @return
     */
    public Boolean isWebpanimation()
    {
        return webpanimation;
    }

    /**
     * Is web animation enabled
     *
     * @param webpanimation
     */
    protected void setWebpanimation(Boolean webpanimation)
    {
        this.webpanimation = webpanimation;
    }

    /**
     * Is web p lossless enabled
     *
     * @return
     */
    public Boolean isWebplossless()
    {
        return webplossless;
    }

    /**
     * Is web p lossless enabled
     *
     * @param webplossless
     */
    protected void setWebplossless(Boolean webplossless)
    {
        this.webplossless = webplossless;
    }

    /**
     * Is web p
     *
     * @return
     */
    public Boolean isWebp()
    {
        return webp;
    }

    /**
     * Is web p
     *
     * @param webp
     */
    protected void setWebp(Boolean webp)
    {
        this.webp = webp;
    }

    /**
     * Is exif orientationn enabled
     *
     * @return
     */
    public Boolean isExiforientation()
    {
        return exiforientation;
    }

    /**
     * Is exif orientation enabled
     *
     * @param exiforientation
     */
    protected void setExiforientation(Boolean exiforientation)
    {
        this.exiforientation = exiforientation;
    }

    /**
     * Is a png enabled
     *
     * @return
     */
    public Boolean isApng()
    {
        return apng;
    }

    /**
     * is apng enabled
     *
     * @param apng
     */
    protected void setApng(Boolean apng)
    {
        this.apng = apng;
    }

    /**
     * Is audio preload enabled
     *
     * @return
     */
    public Boolean isAudiopreload()
    {
        return audiopreload;
    }

    /**
     * Is audio preload enabled
     *
     * @param audiopreload
     */
    protected void setAudiopreload(Boolean audiopreload)
    {
        this.audiopreload = audiopreload;
    }

    /**
     * Is video auto play enabled
     *
     * @return
     */
    public Boolean isVideoautoplay()
    {
        return videoautoplay;
    }

    /**
     * Is video autoplay enabled
     *
     * @param videoautoplay
     */
    protected void setVideoautoplay(Boolean videoautoplay)
    {
        this.videoautoplay = videoautoplay;
    }

    /**
     * Is data URI enabled
     *
     * @return
     */
    public Boolean isDatauri()
    {
        return datauri;
    }

    /**
     * Is data uri enabled
     *
     * @param datauri
     */
    protected void setDatauri(Boolean datauri)
    {
        this.datauri = datauri;
    }

    /**
     * Is indexed blob enabled
     *
     * @return
     */
    public Boolean isIndexeddbblob()
    {
        return indexeddbblob;
    }

    /**
     * Is indexed blob enabled
     *
     * @param indexeddbblob
     */
    protected void setIndexeddbblob(Boolean indexeddbblob)
    {
        this.indexeddbblob = indexeddbblob;
    }
}
