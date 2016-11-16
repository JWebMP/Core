/*
 * Copyright (C) 2016 GedMarc
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

/**
 * The Bootstrap Modal Interface 
 * @author GedMarc
 * @since Nov 11, 2016
 * 
 */
public interface IBSModal 
{

    /**
     * Adds the dismiss button to the modal
     * @param button
     */
    void addDismissButton(Button button);

    /**
     * Adds a button that will open up the modal
     * @param button
     */
    void addOpenButton(Button button);

    /**
     * Gets the modal body
     * @return
     */
    Div getModalBody();

    /**
     * Gets the modal content pane
     * @return
     */
    Div getModalContent();
    /**
     * Returns the modal dialog part
     * @return 
     */
    Div getModalDialog();

    /**
     * Gets the modal footer
     * @return
     */
    Div getModalFooter();

    /**
     * Sets the modal header pane
     * @return
     */
    Div getModalHeader();

    /**
     * Sets the modal body
     * @param modalBody
     */
    void setModalBody(Div modalBody);

    /**
     * Sets the modal content pane
     * @param modalContent
     */
    void setModalContent(Div modalContent);

    /**
     * Sets the overall dialog of the modal
     * @param modalDialog
     */
    void setModalDialog(Div modalDialog);

    /**
     * Sets the size to render for the modal.
     * By default medium. false sets small
     * @param large
     */
    void setModalDialogSize(boolean large);

    /**
     * Sets the modal footer
     * @param modalFooter
     */
    void setModalFooter(Div modalFooter);

    /**
     * Sets the modal header pane
     * @param modalHeader
     */
    void setModalHeader(Div modalHeader);

}
