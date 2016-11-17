/*
 * Copyright (C) 2015 GedMarc
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
package za.co.mmagon.jwebswing.components.jqxwidgets.fileupload;

import za.co.mmagon.jwebswing.components.jqxwidgets.JQXDefaultJavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptFunction;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXFileUploadOptions extends JQXDefaultJavaScriptPart
{

    private Boolean autoUpload;// 	Boolean 	false
    private String accept;// 	String 	null
    private String browseTemplate;// 	String 	''
    private String cancelTemplate;// 	String 	''
    private Boolean disabled;// 	Boolean 	false
    private String fileInputName;// 	String 	''
    private JQXFileUploadLocalization localization;// 	Object 	null
    private Boolean multipleFilesUpload;// 	Boolean 	true
    private JavascriptFunction renderFiles;// 	function 	null
    private Boolean rtl;// 	Boolean 	false
    private String uploadUrl;// 	String 	''
    private String uploadTemplate;// 	String 	''

    public JQXFileUploadOptions()
    {

    }

    public Boolean getAutoUpload()
    {
        return autoUpload;
    }

    public void setAutoUpload(Boolean autoUpload)
    {
        this.autoUpload = autoUpload;
    }

    public String getAccept()
    {
        return accept;
    }

    public void setAccept(String accept)
    {
        this.accept = accept;
    }

    public String getBrowseTemplate()
    {
        return browseTemplate;
    }

    public void setBrowseTemplate(String browseTemplate)
    {
        this.browseTemplate = browseTemplate;
    }

    public String getCancelTemplate()
    {
        return cancelTemplate;
    }

    public void setCancelTemplate(String cancelTemplate)
    {
        this.cancelTemplate = cancelTemplate;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public String getFileInputName()
    {
        return fileInputName;
    }

    public void setFileInputName(String fileInputName)
    {
        this.fileInputName = fileInputName;
    }

    public JQXFileUploadLocalization getLocalization()
    {
        return localization;
    }

    public void setLocalization(JQXFileUploadLocalization localization)
    {
        this.localization = localization;
    }

    public Boolean getMultipleFilesUpload()
    {
        return multipleFilesUpload;
    }

    public void setMultipleFilesUpload(Boolean multipleFilesUpload)
    {
        this.multipleFilesUpload = multipleFilesUpload;
    }

    public JavascriptFunction getRenderFiles()
    {
        return renderFiles;
    }

    public void setRenderFiles(JavascriptFunction renderFiles)
    {
        this.renderFiles = renderFiles;
    }

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    public String getUploadUrl()
    {
        return uploadUrl;
    }

    public void setUploadUrl(String uploadUrl)
    {
        this.uploadUrl = uploadUrl;
    }

    public String getUploadTemplate()
    {
        return uploadTemplate;
    }

    public void setUploadTemplate(String uploadTemplate)
    {
        this.uploadTemplate = uploadTemplate;
    }

}
