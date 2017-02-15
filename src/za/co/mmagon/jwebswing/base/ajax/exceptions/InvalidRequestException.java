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
package za.co.mmagon.jwebswing.base.ajax.exceptions;

/**
 * Occurs when no Servlet was found in an event situation
 *
 * @author GedMarc
 * @since 09 May 2016
 */
public class InvalidRequestException extends Exception
{

    public InvalidRequestException()
    {
    }

    public InvalidRequestException(String message)
    {
        super(message);
    }

    public InvalidRequestException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public InvalidRequestException(Throwable cause)
    {
        super(cause);
    }

    public InvalidRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
