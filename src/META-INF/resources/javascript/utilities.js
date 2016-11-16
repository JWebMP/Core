/* 
 * Copyright (C) 2014 mmagon
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

/**
 * Cleans out HTML into an injectable for JavaScript
 * @param {type} domObjectID DomObjectID to get the HTML Code For
 * @returns String of document
 */
function cleanHtml(domObjectID)
{
    var text = $('#' + domObjectID).html();
    text = text.trim();
    alert('Pre Cleaned HTML : ' + text);
    text = text.replace(/[\n\r]+/g,'');
    text = text.replace(/[\t]/g,'');
    text = text.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
    alert('Cleaned Text [' + text + ']');
    
    return text;
}