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
 *
 * @author GedMarc
 * @since Nov 21, 2016
 * @version 1.0
 *
 */
public class ModernizrCapabilitiesDto extends ModernizrBrowserDto
{

    private Boolean fileinput;
    private Boolean ambientlight;
    private Boolean hashchange;
    private Boolean inputsearchevent;
    private Boolean csscalc;
    private Boolean cubicbezierrange;
    private Boolean cssgradients;
    private Boolean opacity;
    private Boolean csspositionsticky;
    private Boolean createelementattrs;
    @JsonProperty(value = "createelement-attrs")
    private Boolean createelement_attrs;
    private Boolean dataset;
    private Boolean csschunit;
    private Boolean cssexunit;
    private Boolean microdata;
    private Boolean bdi;
    private Boolean datalistelem;
    private Boolean hsla;
    private Boolean flash;
    private Boolean hiddenscroll;
    private Boolean mathml;
    private Boolean touchevents;
    private Boolean unicoderange;
    private Boolean unicode;
    private Boolean checked;
    private Boolean displaytable;
    @JsonProperty(value = "display-table")
    private Boolean display_table;
    private Boolean fontface;
    private Boolean generatedcontent;
    private Boolean hairline;
    private Boolean cssinvalid;
    private Boolean lastchild;
    private Boolean nthchild;
    private Boolean cssscrollbar;
    private Boolean siblinggeneral;
    private Boolean subpixelfont;
    private Boolean cssvalid;
    private Boolean cssvhunit;

    public ModernizrCapabilitiesDto()
    {

    }

    /**
     * Is file input allowed
     *
     * @return
     */
    public Boolean isFileinput()
    {
        return fileinput;
    }

    /**
     * Is file input allowed
     *
     * @param fileinput
     */
    protected void setFileinput(Boolean fileinput)
    {
        this.fileinput = fileinput;
    }

    /**
     * Is ambient light allowed
     *
     * @return
     */
    public Boolean isAmbientlight()
    {
        return ambientlight;
    }

    /**
     * Is ambient light allowed
     *
     * @param ambientlight
     */
    protected void setAmbientlight(Boolean ambientlight)
    {
        this.ambientlight = ambientlight;
    }

    /**
     * Is hash changing allowed
     *
     * @return
     */
    public Boolean isHashchange()
    {
        return hashchange;
    }

    /**
     * Is hash changing allowed
     *
     * @param hashchange
     */
    protected void setHashchange(Boolean hashchange)
    {
        this.hashchange = hashchange;
    }

    /**
     * Is input search event allowed
     *
     * @return
     */
    public Boolean isInputsearchevent()
    {
        return inputsearchevent;
    }

    /**
     * Is Input search event allowed
     *
     * @param inputsearchevent
     */
    protected void setInputsearchevent(Boolean inputsearchevent)
    {
        this.inputsearchevent = inputsearchevent;
    }

    /**
     * Is CSS calc enabled
     *
     * @return
     */
    public Boolean isCsscalc()
    {
        return csscalc;
    }

    /**
     * Is CSS Calc enabled
     *
     * @param csscalc
     */
    protected void setCsscalc(Boolean csscalc)
    {
        this.csscalc = csscalc;
    }

    /**
     * Is Cubic Bezier Enabled
     *
     * @return
     */
    public Boolean isCubicbezierrange()
    {
        return cubicbezierrange;
    }

    /**
     * Sets if cubic bezier is enabled
     *
     * @param cubicbezierrange
     */
    protected void setCubicbezierrange(Boolean cubicbezierrange)
    {
        this.cubicbezierrange = cubicbezierrange;
    }

    /**
     * Is CSS Gradients enabled
     *
     * @return
     */
    public Boolean isCssgradients()
    {
        return cssgradients;
    }

    /**
     * Is CSS Gradients enabled
     *
     * @param cssgradients
     */
    protected void setCssgradients(Boolean cssgradients)
    {
        this.cssgradients = cssgradients;
    }

    /**
     * Is opacity enabled
     *
     * @return
     */
    public Boolean isOpacity()
    {
        return opacity;
    }

    /**
     * Is opacity enabled
     *
     * @param opacity
     */
    protected void setOpacity(Boolean opacity)
    {
        this.opacity = opacity;
    }

    /**
     * Is CSS Position Sticky enabled
     *
     * @return
     */
    public Boolean isCsspositionsticky()
    {
        return csspositionsticky;
    }

    /**
     * Sets if CSS Position is sticky
     *
     * @param csspositionsticky
     */
    protected void setCsspositionsticky(Boolean csspositionsticky)
    {
        this.csspositionsticky = csspositionsticky;
    }

    /**
     * Is Create element attributes allowed
     *
     * @return
     */
    public Boolean isCreateelementattrs()
    {
        return createelementattrs;
    }

    /**
     * Is create element attributes allowed
     *
     * @param createelementattrs
     */
    protected void setCreateelementattrs(Boolean createelementattrs)
    {
        this.createelementattrs = createelementattrs;
    }

    /**
     * Sets if create elements attr's are allowed
     *
     * @return
     */
    public Boolean isCreateelementAttrs()
    {
        return createelement_attrs;
    }

    /**
     * Sets if create element attrs are allowed
     *
     * @param createelement_attrs
     */
    protected void setCreateelementAttrs(Boolean createelement_attrs)
    {
        this.createelement_attrs = createelement_attrs;
    }

    /**
     * If datasets are allowed
     *
     * @return
     */
    public Boolean isDataset()
    {
        return dataset;
    }

    /**
     * If datasets are allowed
     *
     * @param dataset
     */
    protected void setDataset(Boolean dataset)
    {
        this.dataset = dataset;
    }

    /**
     * If CSS CH Units are allowed
     *
     * @return
     */
    public Boolean isCsschunit()
    {
        return csschunit;
    }

    /**
     * If CSS CH Units are allowed
     *
     * @param csschunit
     */
    protected void setCsschunit(Boolean csschunit)
    {
        this.csschunit = csschunit;
    }

    /**
     * If CSS EX Units are allowed
     *
     * @return
     */
    public Boolean isCssexunit()
    {
        return cssexunit;
    }

    /**
     * If CSS Ex Units are allowed
     *
     * @param cssexunit
     */
    protected void setCssexunit(Boolean cssexunit)
    {
        this.cssexunit = cssexunit;
    }

    /**
     * Is micro data allowed
     *
     * @return
     */
    public Boolean isMicrodata()
    {
        return microdata;
    }

    /**
     * Sets if micro data is allowed
     *
     * @param microdata
     */
    protected void setMicrodata(Boolean microdata)
    {
        this.microdata = microdata;
    }

    /**
     * Is BDI Allowed
     *
     * @return
     */
    public Boolean isBdi()
    {
        return bdi;
    }

    /**
     * Sets if BDI Is allowed
     *
     * @param bdi
     */
    protected void setBdi(Boolean bdi)
    {
        this.bdi = bdi;
    }

    /**
     * If Data List Elem is allowed
     *
     * @return
     */
    public Boolean isDatalistelem()
    {
        return datalistelem;
    }

    /**
     * If data list elem is allowed
     *
     * @param datalistelem
     */
    protected void setDatalistelem(Boolean datalistelem)
    {
        this.datalistelem = datalistelem;
    }

    /**
     * Is HSLA Allowed
     *
     * @return
     */
    public Boolean isHsla()
    {
        return hsla;
    }

    /**
     * Is HSLA Allowed
     *
     * @param hsla
     */
    protected void setHsla(Boolean hsla)
    {
        this.hsla = hsla;
    }

    /**
     * Is Flash Allowed
     *
     * @return
     */
    public Boolean isFlash()
    {
        return flash;
    }

    /**
     * Is flash allowed
     *
     * @param flash
     */
    protected void setFlash(Boolean flash)
    {
        this.flash = flash;
    }

    /**
     * Is hidden scroll allowed
     *
     * @return
     */
    public Boolean isHiddenscroll()
    {
        return hiddenscroll;
    }

    /**
     * If hidden scroll is allowed
     *
     * @param hiddenscroll
     */
    protected void setHiddenscroll(Boolean hiddenscroll)
    {
        this.hiddenscroll = hiddenscroll;
    }

    /**
     * Is Math allowed
     *
     * @return
     */
    public Boolean isMathml()
    {
        return mathml;
    }

    /**
     * Is math allowed
     *
     * @param mathml
     */
    protected void setMathml(Boolean mathml)
    {
        this.mathml = mathml;
    }

    /**
     * Are touch events allowed
     *
     * @return
     */
    public Boolean isTouchevents()
    {
        return touchevents;
    }

    /**
     * are touch events allowed
     *
     * @param touchevents
     */
    protected void setTouchevents(Boolean touchevents)
    {
        this.touchevents = touchevents;
    }

    /**
     * Is Unicode Range allowed
     *
     * @return
     */
    public Boolean isUnicoderange()
    {
        return unicoderange;
    }

    /**
     * Is uni-code range allowed
     *
     * @param unicoderange
     */
    protected void setUnicoderange(Boolean unicoderange)
    {
        this.unicoderange = unicoderange;
    }

    /**
     * Is Unicode allowed
     *
     * @return
     */
    public Boolean isUnicode()
    {
        return unicode;
    }

    /**
     * Is Unicode allowed
     *
     * @param unicode
     */
    protected void setUnicode(Boolean unicode)
    {
        this.unicode = unicode;
    }

    /**
     * Is checked allowed
     *
     * @return
     */
    public Boolean isChecked()
    {
        return checked;
    }

    /**
     * if checked allowed
     *
     * @param checked
     */
    protected void setChecked(Boolean checked)
    {
        this.checked = checked;
    }

    /**
     * Is display tables allowed
     *
     * @return
     */
    public Boolean isDisplaytable()
    {
        return displaytable;
    }

    /**
     * Sets if display tables are allowed
     *
     * @param displaytable
     */
    protected void setDisplaytable(Boolean displaytable)
    {
        this.displaytable = displaytable;
    }

    /**
     * If display table is allowed
     *
     * @return
     */
    public Boolean isDisplayTable()
    {
        return display_table;
    }

    /**
     * If display table is allowed
     *
     * @param display_table
     */
    protected void setDisplayTable(Boolean display_table)
    {
        this.display_table = display_table;
    }

    /**
     * If font faces are allowed
     *
     * @return
     */
    public Boolean isFontface()
    {
        return fontface;
    }

    /**
     * If font faces are allowed
     *
     * @param fontface
     */
    protected void setFontface(Boolean fontface)
    {
        this.fontface = fontface;
    }

    /**
     * Is generated content allowed
     *
     * @return
     */
    public Boolean isGeneratedcontent()
    {
        return generatedcontent;
    }

    /**
     * Is generated content allowed
     *
     * @param generatedcontent
     */
    protected void setGeneratedcontent(Boolean generatedcontent)
    {
        this.generatedcontent = generatedcontent;
    }

    /*
     * Is hair line allowed
     */
    public Boolean isHairline()
    {
        return hairline;
    }

    /**
     * Is hair line allowed
     *
     * @param hairline
     */
    protected void setHairline(Boolean hairline)
    {
        this.hairline = hairline;
    }

    /**
     * Is CSS Invalid
     *
     * @return
     */
    public Boolean isCssinvalid()
    {
        return cssinvalid;
    }

    /**
     * Is CSS Invalid
     *
     * @param cssinvalid
     */
    protected void setCssinvalid(Boolean cssinvalid)
    {
        this.cssinvalid = cssinvalid;
    }

    /**
     * Is last child elements allowed
     *
     * @return
     */
    public Boolean isLastchild()
    {
        return lastchild;
    }

    /**
     * Sets if last child elements are allowed
     *
     * @param lastchild
     */
    protected void setLastchild(Boolean lastchild)
    {
        this.lastchild = lastchild;
    }

    /**
     * Is number child allocations allowed
     *
     * @return
     */
    public Boolean isNthchild()
    {
        return nthchild;
    }

    /**
     * Is number child allocations allowed
     *
     * @param nthchild
     */
    protected void setNthchild(Boolean nthchild)
    {
        this.nthchild = nthchild;
    }

    /**
     * Is a CSS scroll bar allowed
     *
     * @return
     */
    public Boolean isCssscrollbar()
    {
        return cssscrollbar;
    }

    /**
     * Is the CSS Scroll bar allowed
     *
     * @param cssscrollbar
     */
    protected void setCssscrollbar(Boolean cssscrollbar)
    {
        this.cssscrollbar = cssscrollbar;
    }

    /**
     * Is sibling general CSS allowed
     *
     * @return
     */
    public Boolean isSiblinggeneral()
    {
        return siblinggeneral;
    }

    /**
     * Is sibling general allowed
     *
     * @param siblinggeneral
     */
    protected void setSiblinggeneral(Boolean siblinggeneral)
    {
        this.siblinggeneral = siblinggeneral;
    }

    /**
     * Is Sub Pixel Font allowed
     *
     * @return
     */
    public Boolean isSubpixelfont()
    {
        return subpixelfont;
    }

    /**
     * Is Subpixel font allowed
     *
     * @param subpixelfont
     */
    protected void setSubpixelfont(Boolean subpixelfont)
    {
        this.subpixelfont = subpixelfont;
    }

    /**
     * Is CSS Valid allowed
     *
     * @return
     */
    public Boolean isCssvalid()
    {
        return cssvalid;
    }

    /**
     * Is CSS Valid allowed
     *
     * @param cssvalid
     */
    protected void setCssvalid(Boolean cssvalid)
    {
        this.cssvalid = cssvalid;
    }

    /**
     * Is vh units allowed
     *
     * @return
     */
    public Boolean isCssvhunit()
    {
        return cssvhunit;
    }

    /**
     * Is vh units allowed
     *
     * @param cssvhunit
     */
    protected void setCssvhunit(Boolean cssvhunit)
    {
        this.cssvhunit = cssvhunit;
    }

}
