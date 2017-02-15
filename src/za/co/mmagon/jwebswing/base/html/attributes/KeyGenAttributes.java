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
package za.co.mmagon.jwebswing.base.html.attributes;

import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;

/**
 * Definition and Usage
 * <p>
 * The &gt;keygen&lt; tag specifies a key-pair generator field used for forms.
 * <p>
 * When the form is submitted, the private key is stored locally, and the public key is sent to the server. Browser Support
 * <p>
 * The numbers in the table specify the first browser version that fully supports the element. Element &gt;keygen&lt; 1.0 Not supported 1.0 1.2 3.0
 *
 * @author GedMarc
 * @since Feb 9, 2015
 * @version 1.0
 * <p>
 *
 */
public enum KeyGenAttributes implements AttributeDefinitions
{

    /**
     * Sets or returns whether a keygen field automatically gets focus when the page loads, or not
     */
    AutoFocus,
    /**
     * Sets or returns the value of the challenge attribute of a keygen field
     */
    Challenge,
    /**
     * Sets or returns whether a keygen field is disabled, or not
     */
    Disabled,
    /**
     * Returns a reference to the form that contains the keygen field
     * <p>
     */
    Form,
    /**
     * Sets or returns the value of the keytype attribute of a keygen field
     */
    KeyType,
    /**
     * Sets or returns the value of the name attribute of a keygen field
     */
    Name,
    /**
     * Returns which type of form element the keygen field is
     */
    Type;

    @Override
    public boolean isKeyword()
    {
        return false;
    }
}
