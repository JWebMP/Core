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

import za.co.mmagon.jwebswing.components.bootstrap.componentoptions.IBSComponentOptions;

/**
 * Modal Modals are streamlined, but flexible dialog prompts powered by JavaScript. They support a number of use cases from user notification to completely custom content and feature a handful of
 * helpful subcomponents, sizes, and more.
 *
 * @author GedMarc
 */
public enum BSComponentModalOptions implements IBSComponentOptions
{
    /**
     * Represents a Modal
     */
    Modal,
    /**
     * The content of the modal
     */
    Modal_Content,
    /**
     * The header of the modal
     */
    Modal_Header,
    /**
     * The body of the modal
     */
    Modal_Body,
    /**
     * The footer of the modal
     */
    Modal_Footer,
    /**
     * The modal title
     */
    Modal_Title,
    /**
     * The modal dialog
     */
    Modal_Dialog,;

    private BSComponentModalOptions()
    {

    }

    @Override
    public String toString()
    {
        return name().toLowerCase().replace('_', '-');
    }

}
