(function($) {
	var has_VML, has_canvas, create_canvas_for, add_shape_to, clear_canvas, shape_from_area,
		canvas_style, hex_to_decimal, css3color, is_image_loaded, options_from_area;

	has_VML = document.namespaces;
	has_canvas = !!document.createElement('canvas').getContext;

	if(!(has_canvas || has_VML)) {
		$.fn.maphilight = function() { return this; };
		return;
	}
	
	if(has_canvas) {
		hex_to_decimal = function(hex) {
			return Math.max(0, Math.min(parseInt(hex, 16), 255));
		};
		css3color = function(color, opacity) {
			return 'rgba('+hex_to_decimal(color.substr(0,2))+','+hex_to_decimal(color.substr(2,2))+','+hex_to_decimal(color.substr(4,2))+','+opacity+')';
		};
		create_canvas_for = function(img) {
			var c = $('<canvas style="width:'+img.width+'px;height:'+img.height+'px;"></canvas>').get(0);
			c.getContext("2d").clearRect(0, 0, c.width, c.height);
			return c;
		};
		var draw_shape = function(context, shape, coords, x_shift, y_shift) {
			x_shift = x_shift || 0;
			y_shift = y_shift || 0;
			
			context.beginPath();
			if(shape == 'rect') {
				// x, y, width, height
				context.rect(coords[0] + x_shift, coords[1] + y_shift, coords[2] - coords[0], coords[3] - coords[1]);
			} else if(shape == 'poly') {
				context.moveTo(coords[0] + x_shift, coords[1] + y_shift);
				for(i=2; i < coords.length; i+=2) {
					context.lineTo(coords[i] + x_shift, coords[i+1] + y_shift);
				}
			} else if(shape == 'circ') {
				// x, y, radius, startAngle, endAngle, anticlockwise
				context.arc(coords[0] + x_shift, coords[1] + y_shift, coords[2], 0, Math.PI * 2, false);
			}
			context.closePath();
		}
		add_shape_to = function(canvas, shape, coords, options, name) {
			var i, context = canvas.getContext('2d');
			
			// Because I don't want to worry about setting things back to a base state
			
			// Shadow has to happen first, since it's on the bottom, and it does some clip /
			// fill operations which would interfere with what comes next.
			if(options.shadow) {
				context.save();
				if(options.shadowPosition == "inside") {
					// Cause the following stroke to only apply to the inside of the path
					draw_shape(context, shape, coords);
					context.clip();
				}
				
				// Redraw the shape shifted off the canvas massively so we can cast a shadow
				// onto the canvas without having to worry about the stroke or fill (which
				// cannot have 0 opacity or width, since they're what cast the shadow).
				var x_shift = canvas.width * 100;
				var y_shift = canvas.height * 100;
				draw_shape(context, shape, coords, x_shift, y_shift);
				
				context.shadowOffsetX = options.shadowX - x_shift;
				context.shadowOffsetY = options.shadowY - y_shift;
				context.shadowBlur = options.shadowRadius;
				context.shadowColor = css3color(options.shadowColor, options.shadowOpacity);
				
				// Now, work out where to cast the shadow from! It looks better if it's cast
				// from a fill when it's an outside shadow or a stroke when it's an interior
				// shadow. Allow the user to override this if they need to.
				var shadowFrom = options.shadowFrom;
				if (!shadowFrom) {
					if (options.shadowPosition == 'outside') {
						shadowFrom = 'fill';
					} else {
						shadowFrom = 'stroke';
					}
				}
				if (shadowFrom == 'stroke') {
					context.strokeStyle = "rgba(0,0,0,1)";
					context.stroke();
				} else if (shadowFrom == 'fill') {
					context.fillStyle = "rgba(0,0,0,1)";
					context.fill();
				}
				context.restore();
				
				// and now we clean up
				if(options.shadowPosition == "outside") {
					context.save();
					// Clear out the center
					draw_shape(context, shape, coords);
					context.globalCompositeOperation = "destination-out";
					context.fillStyle = "rgba(0,0,0,1);";
					context.fill();
					context.restore();
				}
			}
			
			context.save();
			
			draw_shape(context, shape, coords);
			
			// fill has to come after shadow, otherwise the shadow will be drawn over the fill,
			// which mostly looks weird when the shadow has a high opacity
			if(options.fill) {
				context.fillStyle = css3color(options.fillColor, options.fillOpacity);
				context.fill();
			}
			// Likewise, stroke has to come at the very end, or it'll wind up under bits of the
			// shadow or the shadow-background if it's present.
			if(options.stroke) {
				context.strokeStyle = css3color(options.strokeColor, options.strokeOpacity);
				context.lineWidth = options.strokeWidth;
				context.stroke();
			}
			
			context.restore();
			
			if(options.fade) {
				$(canvas).css('opacity', 0).animate({opacity: 1}, 100);
			}
		};
		clear_canvas = function(canvas) 
		{
			canvas.getContext('2d').clearRect(0, 0, canvas.width,canvas.height);
		};
	} else {   // ie executes this code
		create_canvas_for = function(img) {
			return $('<var style="zoom:1;overflow:hidden;display:block;width:'+img.width+'px;height:'+img.height+'px;"></var>').get(0);
		};
		add_shape_to = function(canvas, shape, coords, options, name) {
			var fill, stroke, opacity, e;
			fill = '<v:fill color="#'+options.fillColor+'" opacity="'+(options.fill ? options.fillOpacity : 0)+'" />';
			stroke = (options.stroke ? 'strokeweight="'+options.strokeWidth+'" stroked="t" strokecolor="#'+options.strokeColor+'"' : 'stroked="f"');
			opacity = '<v:stroke opacity="'+options.strokeOpacity+'"/>';
			if(shape == 'rect') {
				e = $('<v:rect name="'+name+'" filled="t" '+stroke+' style="zoom:1;margin:0;padding:0;display:block;position:absolute;left:'+coords[0]+'px;top:'+coords[1]+'px;width:'+(coords[2] - coords[0])+'px;height:'+(coords[3] - coords[1])+'px;"></v:rect>');
			} else if(shape == 'poly') {
				e = $('<v:shape name="'+name+'" filled="t" '+stroke+' coordorigin="0,0" coordsize="'+canvas.width+','+canvas.height+'" path="m '+coords[0]+','+coords[1]+' l '+coords.join(',')+' x e" style="zoom:1;margin:0;padding:0;display:block;position:absolute;top:0px;left:0px;width:'+canvas.width+'px;height:'+canvas.height+'px;"></v:shape>');
			} else if(shape == 'circ') {
				e = $('<v:oval name="'+name+'" filled="t" '+stroke+' style="zoom:1;margin:0;padding:0;display:block;position:absolute;left:'+(coords[0] - coords[2])+'px;top:'+(coords[1] - coords[2])+'px;width:'+(coords[2]*2)+'px;height:'+(coords[2]*2)+'px;"></v:oval>');
			}
			e.get(0).innerHTML = fill+opacity;
			$(canvas).append(e);
		};
		clear_canvas = function(canvas) 
		{
			$(canvas).find('[name=highlighted]').remove();
		};
	}
	
	shape_from_area = function(area) {
		var i, coords = area.getAttribute('coords').split(',');
		for (i=0; i < coords.length; i++) { coords[i] = parseFloat(coords[i]); }
		return [area.getAttribute('shape').toLowerCase().substr(0,4), coords];
	};

	options_from_area = function(area, options) {
		var $area = $(area);
		return $.extend({}, options, $.metadata ? $area.metadata() : false, $area.data('maphilight'));
	};
	
	is_image_loaded = function(img) {
		if(!img.complete) { return false; } // IE
		if(typeof img.naturalWidth != "undefined" && img.naturalWidth == 0) { return false; } // Others
		return true;
	};

	canvas_style = {
		position: 'absolute',
		left: 0,
		top: 0,
		padding: 0,
		border: 0
	};
	
	var ie_hax_done = false;
	
	
        
        
        
        
	/********************************************
	This is the custom img tag sizer
	ie 8/7/6 sillyness thing with dialogs or div's that are not visible....
	*********************************************/
	$.fn.mapPrep = function(opts)
	{
			var img;
			img = $(this);
			//alert('width [' + img.width + '] - height [' + img.height + ']');
			var wantedWidth,wantedHeight;
			if(img.attr('width'))
				wantedWidth = img.attr('width')
			else 
				wantedWidth = img.width;	
			if(img.attr('height'))
				wantedHeight = img.attr('height')
			else 
				wantedHeight = img.height;
			img.height(wantedHeight);
			img.width(wantedWidth);
	};
	
        
        
        
        
        
        
        
        
	
	$.fn.maphilight = function(opts) 
	{
		//Pull through the bone id
		var aps = Array.prototype.slice;
		var args = aps.call( arguments );
	
		opts = $.extend({}, $.fn.maphilight.defaults, opts);
		
		if(!has_canvas && $.browser.msie && !ie_hax_done) {
			document.namespaces.add("v", "urn:schemas-microsoft-com:vml");
			var style = document.createStyleSheet();
			var shapes = ['shape','rect', 'oval', 'circ', 'fill', 'stroke', 'imagedata', 'group','textbox'];
			$.each(shapes,
				function() {
					style.addRule('v\\:' + this, "behavior: url(#default#VML); antialias:true");
				}
			);
			ie_hax_done = true;
		}
		
		
		
		return this.each(function() 
		{
			var img, wrap, options, map, canvas, canvas_always, mouseover, highlighted_shape, usemap;
			var canvas_display; //the canvas to always display regardless of alwaysOn or not -- heat map
			var canvas_sticky; // the canvas that holds clicks
			
			
			
			img = $(this);

			if(!is_image_loaded(this)) {
				// If the image isn't fully loaded, this won't work right.  Try again later.
				return window.setTimeout(function() {
					img.maphilight(opts);
				}, 200);
			}

			options = $.extend({}, opts, $.metadata ? img.metadata() : false, img.data('maphilight'));

			// jQuery bug with Opera, results in full-url#usemap being returned from jQuery's attr.
			// So use raw getAttribute instead.
			usemap = img.get(0).getAttribute('usemap');

			map = $('map[name="'+usemap.substr(1)+'"]');

			var wantedWidth,wantedHeight;
			if(img.attr('width'))
				wantedWidth = img.attr('width')
			else 
				wantedWidth = img.width;
				
			if(img.attr('height'))
				wantedHeight = img.attr('height')
			else 
				wantedHeight = img.height;
			
			img.height(wantedHeight);
			img.width(wantedWidth);
			
//			alert('usemap [' + usemap.substr(1) + '] - width [' + wantedWidth + '] - height [' + wantedHeight + ']');
			
			if(!(img.is('img') && usemap && map.size() > 0)) {
				return;
			}

			if(img.hasClass('maphilighted')) 
			{
				// We're redrawing an old map, probably to pick up changes to the options.
				// Just clear out all the old stuff.
				var wrapper = img.parent();
				img.insertBefore(wrapper);
				wrapper.remove();
				$(map).unbind('.maphilight').find('area[coords]').unbind('.maphilight');
			}

			wrap = $('<div></div>').css({
				display:'block',
				background:'url("'+this.src+'")',
				position:'relative',
				padding:0,
				width:wantedWidth, //img.width,
				height:wantedHeight //img.height
				});
				
			if(options.wrapClass) {
				if(options.wrapClass === true) {
					wrap.addClass($(this).attr('class'));
				} else {
					wrap.addClass(options.wrapClass);
				}
			}
			img.before(wrap).css('opacity', 0).css(canvas_style).remove();
			if($.browser.msie) { img.css('filter', 'Alpha(opacity=0)'); }
			wrap.append(img);
			
			canvas = create_canvas_for(this);
			$(canvas).css(canvas_style);
			canvas.height = this.height;
			canvas.width = this.width;
			
			/*
				The change : create a canvas that is always displayed 
				below the normal canvas and the always on canvas (to avoid conflift with canvas_always)
			*/
			canvas_display = create_canvas_for(this);
			$(canvas_display).css(canvas_style);
			canvas_display.height = this.height;
			canvas_display.width = this.width;
			
			canvas_sticky = create_canvas_for(this);
			$(canvas_sticky).css(canvas_style);
			canvas_sticky.height = this.height;
			canvas_sticky.width = this.width;
			
			mouseover = function(e) {
				var shape, area_options;
				area_options = options_from_area(this, options);
				if
				(
					!area_options.neverOn
					&&
					!area_options.alwaysOn
				) {
					shape = shape_from_area(this);
					add_shape_to(canvas, shape[0], shape[1], area_options, "highlighted");
					if(area_options.groupBy) 
					{
						var areas;
						var checkGroupBy = area_options.groupBy;
						// two ways groupBy might work; attribute and selector
						if(/^[a-zA-Z][-a-zA-Z]+$/.test(area_options.groupBy)) {
							areas = map.find('area');
						} else {
						//areas = map.find('area');
							//areas = map.find(area_options.groupBy);
						}
						
						var first = this;
						areas.each(function() {
						var subarea_options = options_from_area(this, options);
						//alert(subarea_options.groupBy + ' = ' + checkGroupBy);
						if(subarea_options.groupBy)
						{
							if(this != first)
							{
							//alert('Sub Area Group By Specified');
							var shape = shape_from_area(this);
							add_shape_to(canvas, shape[0], shape[1], subarea_options, "highlighted");
							}		
							
						}
							//if(this != first) {
								
								//alert(areas);
								
								//if(subarea_option.groupBy == checkGroupBy)
								//{
									//alert(areas);
								//if(!subarea_options.neverOn && !subarea_options.alwaysOn) {
									
									
								//}
							////}
						});
					}
					// workaround for IE7, IE8 not rendering the final rectangle in a group
					if(!has_canvas) {
						$(canvas).append('<v:rect></v:rect>');
					}
				}
			}
			
			click = function(e){
				clear_canvas(canvas_sticky);
				var shape, area_options;
				area_options = options_from_area(this, options);
				//area_options.strokeColor = '004d36';
				//area_options.strokeWidth = 3;
				//area_options.stroke=true;
				//alert(this.getAttribute('ALT')+ "clicked");
				shape = shape_from_area(this);
				add_shape_to(canvas_sticky, shape[0], shape[1], area_options, "highlighted");
				
				if(area_options.groupBy) 
					{
						var areas;
						var checkGroupBy = area_options.groupBy;
						// two ways groupBy might work; attribute and selector
						if(/^[a-zA-Z][-a-zA-Z]+$/.test(area_options.groupBy)) {
							areas = map.find('area');
						} else {
						//areas = map.find('area');
							//areas = map.find(area_options.groupBy);
						}
						
						var first = this;
						areas.each(function() {
						var subarea_options = options_from_area(this, options);
						//alert(subarea_options.groupBy + ' = ' + checkGroupBy);
						if(subarea_options.groupBy)
						{
							if(this != first)
							{
							//alert('Sub Area Group By Specified');
							var shape = shape_from_area(this);
							add_shape_to(canvas_sticky, shape[0], shape[1], subarea_options, "highlighted");
							//$(this).trigger("click");
							}		
							
						}
							//if(this != first) {
								
								//alert(areas);
								
								//if(subarea_option.groupBy == checkGroupBy)
								//{
									//alert(areas);
								//if(!subarea_options.neverOn && !subarea_options.alwaysOn) {
									
									
								//}
							////}
						});
					}
				//customMakeSelection(this.getAttribute('name'), area_options.boneId, area_options.attName);
				//alert('att name = ' + area_options.attName);
				// workaround for IE7, IE8 not rendering the final rectangle in a group
				if(!has_canvas) 
				{
					$(canvas).append('<v:rect></v:rect>');
				}
			}
			
			/*
				creates the heatmap canvas layer and displays it using the new permanent option
			*/
			$(map).bind('alwaysHaveOn', function()
			{
				$(map).find('area[coords]').each(function() 
				{
					//alert('creating new shape on area');
					var shape, area_options;
					area_options = options_from_area(this, options);

					area_options.fillColor = area_options.overlayColorPermanent;
					area_options.strokeWidth = 0;
					area_options.strokeColor = '000000';
					//alert(area_options.overlayColorPermanent);
					area_options.fillOpacity = area_options.overlayColorOpacity;
					//alert('colour :' + area_options.fillColor);
					//alert('permanent :' + area_options.overlayColorPermanent);
					//area_options.fade = area_options.alwaysOnFade;
					shape = shape_from_area(this);
					
					if(!(area_options.fillColor === "transparent"))
					{
					add_shape_to(canvas_display, shape[0], shape[1], area_options, "");
					add_shape_to(canvas_display, shape[0], shape[1], area_options, "");
					}
					
				});
				img.before(canvas_display);
			});

			$(map).bind('alwaysOn.maphilight', function() 
			{
				// Check for areas with alwaysOn set. These are added to a *second* canvas,
				// which will get around flickering during fading.
				if(canvas_always) 
				{
					clear_canvas(canvas_always)
				}
				if(!has_canvas) 
				{
					$(canvas).empty();
				}
				$(map).find('area[coords]').each(function() 
				{
					var shape, area_options;
					area_options = options_from_area(this, options);
					if(area_options.alwaysOn) 
					{
						if(!canvas_always && has_canvas) 
						{
							canvas_always = create_canvas_for(img.get());
							$(canvas_always).css(canvas_style);
							canvas_always.width = img.width();
							canvas_always.height = img.height();
							img.before(canvas_always);
						}
						area_options.fade = area_options.alwaysOnFade; // alwaysOn shouldn't fade in initially
						shape = shape_from_area(this);
						//if (canvas_always) 
						//{
							add_shape_to(canvas_always, shape[0], shape[1], area_options, "");
						//} else 
						//{
							add_shape_to(canvas, shape[0], shape[1], area_options, "");
						//}
					}
				});
			});
			
			
			$(map).trigger('alwaysHaveOn').find('area[coords]'); //call that colours the canvas_display
			$(map).trigger('alwaysOn.maphilight').find('area[coords]') //call that colours the highlighting
			.bind('mouseover.maphilight', mouseover) //call that manages the highlighting
			.bind('click.maphilight', click) //call that manages the click
			.bind('mouseout.maphilight', function(e) { clear_canvas(canvas);});; //mouse out clear of highlight
			
			img.before(canvas); // if we put this after, the mouseover events wouldn't fire.
			img.before(canvas_sticky); // if we put this after, the mouseover events wouldn't fire.
			
			img.addClass('maphilighted');
		});
	};
	$.fn.maphilight.defaults = 
	{
		fill: true,
		fillColor: '000000',
		fillOpacity: 0.4,
		stroke: true,
		strokeColor: '000000',
		strokeOpacity: 1,
		strokeWidth: 1,
		fade: true,
		alwaysOn: false,
		neverOn: false,
		groupBy: false,
		wrapClass: true,
		// plenty of shadow:
		shadow: false,
		shadowX: 0,
		shadowY: 0,
		shadowRadius: 6,
		shadowColor: '000000',
		shadowOpacity: 0.8,
		shadowPosition: 'outside',
		shadowFrom: false,
		overlayColorPermanent:'transparent',
        overlayColorOpacity:1,
		attName: '8D679D4B11D3E4981000E787EC6DE8A4',
		attName2: 'attribute2',
		boneId : 'no bone'
	};
})(jQuery);
