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
package za.co.mmagon.jwebswing.base.exceptions;

/**
 * Exception thrown when a component cannot be null
 *
 * @author GedMarc
 * @since 29 Jul 2016
 */
public class NullComponentException extends RuntimeException
{

    /**
     * Exception thrown when a component cannot be null
     */
    public NullComponentException()
    {
    }

    /**
     * Exception thrown when a component cannot be null
     *
     * @param message a message for the exception
     */
    public NullComponentException(String message)
    {
        super(message);
    }

    /**
     * Exception thrown when a component cannot be null
     *
     * @param message A message for the exception
     * @param cause   the exception
     */
    public NullComponentException(String message, Throwable cause)
    {
        super(message, cause);
    }

    /**
     * Exception thrown when a component cannot be null
     *
     * @param cause the exception that caused this
     */

    public NullComponentException(Throwable cause)
    {
        super(cause);
    }

    /**
     * Exception thrown when a component cannot be null
     *
     * @param message            The message for the exception
     * @param cause              the exception that caused it
     * @param enableSuppression  enable suppression
     * @param writableStackTrace make the stack trace writable
     */
    public NullComponentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
