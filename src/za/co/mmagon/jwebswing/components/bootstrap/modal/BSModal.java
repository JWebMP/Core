/*
 * Copyright (C) 2015 Marc Magon
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
package za.co.mmagon.jwebswing.components.bootstrap.modal;

import za.co.mmagon.jwebswing.base.html.Button;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.attributes.ButtonAttributes;
import za.co.mmagon.jwebswing.components.bootstrap.BootstrapClasses;

/**
 * An implementation of the bootstrap modal
 * <p>
 * @author Marc Magon
 * @since 9 Nov 2016
 * @version 1.0
 */
public class BSModal extends Div<BSModalChildren, BSModalAttributes, BSModalFeatures, BSModalEvents, BSModal> implements IBSModal
{

    private static final long serialVersionUID = 1L;
    private BSModalFeature feature;
    
    private Div modalDialog;
    private Div modalContent;
    private Div modalHeader;
    private Div modalBody;
    private Div modalFooter;

    public BSModal()
    {
        addFeature(getFeature());
        addClass(BootstrapClasses.Modal);
        addClass(BootstrapClasses.Fade);
        addAttribute(BSModalAttributes.Role, "dialog");
    }
    
    /**
     * Returns this modal with only its methods
     * @return 
     */
    public IBSModal asMe()
    {
        return this;
    }

    public final BSModalFeature getFeature()
    {
        if (feature == null)
        {
            feature = new BSModalFeature(this);
        }
        return feature;
    }

    @Override
    public BSModalOptions getOptions()
    {
        return getFeature().getOptions();
    }

    @Override
    public Div getModalDialog()
    {
        if(modalDialog == null)
        {
            setModalDialog(new Div());
        }
        return modalDialog;
    }

    /**
     * Sets the overall dialog of the modal
     * @param modalDialog 
     */
    @Override
    public void setModalDialog(Div modalDialog)
    {
        getChildren().remove(this.modalDialog);
        this.modalDialog = modalDialog;
        if(this.modalDialog != null)
        {
            add(modalDialog);
        }
    }

    /**
     * Gets the modal content pane
     * @return 
     */
    @Override
    public Div getModalContent()
    {
        if(modalContent == null)
        {
            setModalContent(new Div());
        }
        return modalContent;
    }

    /**
     * Sets the modal content pane
     * @param modalContent 
     */
    @Override
    public void setModalContent(Div modalContent)
    {
        getModalDialog().remove(this.modalContent);
        this.modalContent = modalContent;
        if(this.modalContent != null)
        {
            this.modalContent.addClass(BootstrapClasses.Modal_Content);
            getModalDialog().add(this.modalContent);
        }
    }

    /**
     * Sets the modal header pane
     * @return 
     */
    @Override
    public Div getModalHeader()
    {
        if(modalHeader == null)
        {
            setModalHeader(new Div());
        }
        return modalHeader;
    }

    /**
     * Sets the modal header pane
     * @param modalHeader 
     */
    @Override
    public void setModalHeader(Div modalHeader)
    {
        getModalContent().remove(modalHeader);
        this.modalHeader = modalHeader;
        if(this.modalHeader != null)
        {
            getModalContent().add(0,this.modalHeader);
            this.modalHeader.addClass(BootstrapClasses.Modal_Header);
        }
    }

    /**
     * Gets the modal body
     * @return 
     */
    @Override
    public Div getModalBody()
    {
        if(this.modalBody == null)
        {
            setModalBody(new Div());
        }
        return modalBody;
    }

    /**
     * Sets the modal body
     * @param modalBody 
     */
    @Override
    public void setModalBody(Div modalBody)
    {
        getModalContent().remove(this.modalBody);
        this.modalBody = modalBody;
        if(this.modalBody != null)
        {
            this.modalBody.addClass(BootstrapClasses.Modal_Body);
            getModalContent().add(this.modalBody);
        }
    }

    /**
     * Gets the modal footer
     * @return 
     */
    @Override
    public Div getModalFooter()
    {
        if(modalFooter == null)
        {
            setModalFooter(new Div());
        }
        return modalFooter;
    }

    /**
     * Sets the modal footer
     * @param modalFooter 
     */
    @Override
    public void setModalFooter(Div modalFooter)
    {
        getModalContent().remove(this.modalFooter);
        this.modalFooter = modalFooter;
        if(this.modalFooter != null)
        {
            getModalContent().add(this.modalFooter);
            this.modalFooter.addClass(BootstrapClasses.Modal_Footer);
        }
    }

    /**
     * Adds a button that will open up the modal
     * @param button 
     */
    @Override
    public void addOpenButton(Button button)
    {
        button.addAttribute(ButtonAttributes.Data_Toggle, "modal");
        button.addAttribute(ButtonAttributes.Data_Target, getID(true));
    }
    
    /**
     * Adds the dismiss button to the modal
     * @param button 
     */
    @Override
    public void addDismissButton(Button button)
    {
        button.addClass(BootstrapClasses.Close);
        button.addAttribute(ButtonAttributes.Data_Dismiss, "modal");
    }
    
    /**
     * Sets the size to render for the modal.
     * By default medium. false sets small
     * @param large 
     */
    @Override
    public void setModalDialogSize(boolean large)
    {
        if(large)
        {
            getModalDialog().removeClass("modal-sm");
            getModalDialog().addClass("modal-lg");
        }
        else
        {
            getModalDialog().addClass("modal-sm");
            getModalDialog().removeClass("modal-lg");
        }
    }
}
