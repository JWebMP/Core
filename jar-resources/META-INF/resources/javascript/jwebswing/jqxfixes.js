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
var divClasses = [];
function jqxWidgetPreCallClassFix(jqxWidgetID)
{
    $('#' + jqxWidgetID + ' > div > div').each(function (i, val) {

        divClasses[i] = $(this).attr('id') + '-' + $(this).attr('class');
        //alert('Index ' + i + '-' + divClasses[i]);
        //divClasses.push($(this).attr('id') + '-' + $(this).attr('class'));
    });
}

function jqxWidgetPostCallClassFix(jqxWidgetID)
{
    for (index = 0; index < divClasses.length; index++)
    {
        var stringArr = divClasses[index].split('-');
        var compID = stringArr[0];
        var oldClasses = stringArr[1];
        //alert('Old Classes ' + index + '-' + divClasses[index]);
        $('#' + compID).attr('class', oldClasses + ' ' + $('#' + compID).attr('class'));
    }
    divClasses = [];//reset
}

function jqxWidgetRibbonWindowResize(jqxWidgetID)
{
    $('#' + jqxWidgetID + '').bind('select', function ()
    {
        $(window).resize();
    })
}

//JQX Events System Implementation
$.fn.jqxSelectItem = function (opts) {
    opts = $.extend({}, $.fn.jw.defaults, opts);
    var event = opts.eventType;
    var tree = $(this);
    tree.off('select.jw');
    tree.on('select.jw', function (event)
    {
        var args = event.args;
        var me = $(this);
        var item = me.jqxTree('getItem', args.element);
        var eventElementBack = new Object();
        eventElementBack.label = item.label;
        eventElementBack.value = item.value;
        eventElementBack.url = item.url;
        eventElementBack.disabled = item.disabled;
        eventElementBack.checked = item.checked;
        eventElementBack.expanded = item.expanded;
        eventElementBack.selected = item.selected;
        eventElementBack.icon = item.icon;
        eventElementBack.iconsize = item.iconsize;
        //var label = item.label;
        //var value = JSON.stringify(JSON.decycle(item));
        //alert(JSON.stringify(JSON.decycle(item)));
        performAjax(me.attr('id'), 'select', 'select', eventElementBack);
    });
    $.fn.jw.defaults = {
        eventType: 'select',
        eventNameSpace: 'jw'
    };
};


