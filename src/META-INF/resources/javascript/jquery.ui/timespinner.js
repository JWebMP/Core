/* global Globalize */

/**
 * http://jqueryui.com/spinner/#time
 * @param {type} param1
 * @param {type} param2
 * @param {type} param3
 */
  $.widget( "ui.timespinner", $.ui.spinner, {
    options: {
      // seconds
      step: 60 * 1000,
      // hours
      page: 60
    },
 
    _parse: function( value ) {
      if ( typeof value === "string" ) {
        // already a timestamp
        if ( Number( value ) === value ) {
          return Number( value );
        }
        return + Globalize.parseDate( value );
      }
      return value;
    },
 
    _format: function( value ) {
      return Globalize.format( new Date(value), "t" );
    }
  });