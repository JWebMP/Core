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
 * 
 * Just a jquery variation of the below code
 * 
 */

(function ($) {
    $.fn.radialTree = function (opts)
    {
        opts = $.extend({}, $.fn.radialTree.defaults, opts);
        var datasets = opts.data;
        var diam = opts.diameter;
        var ids1 = '#' + $(this).prop('id');
        //alert('here - ' + id);
        var margin = {top: opts.marginTop, right: opts.marginRight, bottom: opts.marginBottom, left: opts.marginLeft},
        width = diam,
                height = diam;

        var i = 0,
                duration = opts.animationSpeed,
                root;

        var tree = d3.layout.tree()
                .size([opts.maximumDegrees, diam / 2 - 80])
                .separation(function (a, b) {
                    return (a.parent === b.parent ? 1 : 10) / a.depth;
                });

        var diagonal = d3.svg.diagonal.radial()
                .projection(function (d) {
                    return [d.y, d.x / 180 * Math.PI];
                });

        var svg = d3.select(ids1).append("svg")
                .attr("width", width)
                .attr("height", height)
                .append("g")
                .attr("transform", "translate(" + diam / 2 + "," + diam / 2 + ")");

        root = datasets;
        root.x0 = height / 2;
        root.y0 = 0;

        root.children.forEach(collapse); // start with all children collapsed
        update(root);

        d3.select(self.frameElement).style("height", diam + "px");

        function update(source) {

            // Compute the new tree layout.
            var nodes = tree.nodes(root),
                    links = tree.links(nodes);

            // Normalize for fixed-depth.
            nodes.forEach(function (d) {
                d.y = d.depth * opts.nodeDistance;
            });

            var NodeMarkerOptions = opts.nodeMarker;
            var NodeMarkerWithChildrenOptions = opts.nodeWithChildrenMarker;
            var NodeMarkerEnterOptions = opts.nodeEnterMarker;
            var NodeMarkerExitOptions = opts.nodeExitMarker;
            var NodeTextOptions = opts.nodeText;
            var NodeTextEnterOptions = opts.nodeEnterText;
            var NodeTextExitOptions = opts.nodeExitText;
            var NodeLinkOptions = opts.nodeLink;
            var NodeLinkEnterOptions = opts.nodeEnterLink;
            var NodeLinkExitOptions = opts.nodeEnterLink;


            // Update the nodes…
            var node = svg.selectAll("g.node")
                    .data(nodes, function (d) {
                        return d.id || (d.id = ++i);
                    });

            // Enter any new nodes at the parent's previous position.
            var nodeEnter = node.enter().append("g")
                    .attr("class", "node")
                    //.attr("transform", function(d) { return "rotate(" + (d.x - 90) + ")translate(" + d.y + ")"; })
                    .on("click", click);

            nodeEnter.append(NodeMarkerEnterOptions.markerType)
                    .attr("r", NodeMarkerEnterOptions.markerSize)
                    .style({"fill": NodeMarkerEnterOptions.fill,
                        "stroke": NodeMarkerEnterOptions.stroke,
                        "stroke-width": NodeMarkerEnterOptions.strokeWidth,
                        "fill-opacity": NodeMarkerEnterOptions.fillOpacity,
                        "margin-left": NodeMarkerEnterOptions.marginLeft,
                        "margin-right": NodeMarkerEnterOptions.marginRight,
                        "margin-top": NodeMarkerEnterOptions.marginTop,
                        "margin-bottom": NodeMarkerEnterOptions.marginBottom});

            nodeEnter.append("text")
                    .attr("x", 10)
                    .attr("dy", ".35em")
                    .attr("text-anchor", "start")
                    .attr("transform", function(d) { return d.x < 180 ? "translate(0)" : "rotate(180)translate(-" + (d.name.length * 8.5)  + ")"; })
                    .text(function (d) {
                        return d.name;
                    })
                    .style({"font-size": NodeTextEnterOptions.fontSize,
                        "font-name": NodeTextEnterOptions.fontName,
                        "font-weight": NodeTextEnterOptions.fontWeight,
                        "font-color": NodeTextEnterOptions.fontColour,
                        "fill-opacity": NodeTextEnterOptions.fillOpacity,
                        "background-color": NodeTextEnterOptions.backgroundColour,
                        "margin-left": NodeMarkerEnterOptions.marginLeft,
                        "margin-right": NodeMarkerEnterOptions.marginRight,
                        "margin-top": NodeMarkerEnterOptions.marginTop,
                        "margin-bottom": NodeMarkerEnterOptions.marginBottom});

            // Transition nodes to their new position.
            var nodeUpdate = node.transition()
                    .duration(duration)
                    .attr("transform", function (d) {
                        return "rotate(" + (d.x - 90) + ")translate(" + d.y + ")";
                    });

            nodeUpdate.select(NodeMarkerOptions.markerType)
                    .attr("r", NodeMarkerOptions.markerSize)
                    .style({"fill": function (d) {
                            return d._children ? NodeMarkerWithChildrenOptions.fill : NodeMarkerOptions.fill;
                        },
                        "stroke": NodeMarkerOptions.stroke,
                        "stroke-width": NodeMarkerOptions.strokeWidth,
                        "fill-opacity": NodeMarkerOptions.fillOpacity,
                        "margin-left": NodeMarkerEnterOptions.marginLeft,
                        "margin-right": NodeMarkerEnterOptions.marginRight,
                        "margin-top": NodeMarkerEnterOptions.marginTop,
                        "margin-bottom": NodeMarkerEnterOptions.marginBottom});


            nodeUpdate.select("text")
                    .style({"font-size": NodeTextOptions.fontSize,
                        "font-name": NodeTextOptions.fontName,
                        "font-weight": NodeTextOptions.fontWeight,
                        "color": NodeTextOptions.fontColour,
                        "fill-opacity": NodeTextOptions.fillOpacity,
                        "background-color": NodeTextOptions.backgroundColour,
                        "margin-left": NodeMarkerEnterOptions.marginLeft,
                        "margin-right": NodeMarkerEnterOptions.marginRight,
                        "margin-top": NodeMarkerEnterOptions.marginTop,
                        "margin-bottom": NodeMarkerEnterOptions.marginBottom})
                    .attr("transform", function (d) {
                        return d.x < 180 ? "translate(0)" : "rotate(180)translate(-" + (d.name.length + 50) + ")";
                    });

            // TODO: appropriate transform
            var nodeExit = node.exit().transition() 
                    .duration(duration)
                    //.attr("transform", function(d) { return "diagonal(" + source.y + "," + source.x + ")"; })
                    .remove();

            nodeExit.select(NodeMarkerExitOptions.markerType)
                    .attr("r", NodeMarkerExitOptions.markerSize)
                    .style({"fill": NodeMarkerExitOptions.fill,
                        "stroke": NodeMarkerExitOptions.stroke,
                        "stroke-width": NodeMarkerExitOptions.strokeWidth,
                        "fill-opacity": NodeMarkerExitOptions.fillOpacity,
                        "margin-left": NodeMarkerEnterOptions.marginLeft,
                        "margin-right": NodeMarkerEnterOptions.marginRight,
                        "margin-top": NodeMarkerEnterOptions.marginTop,
                        "margin-bottom": NodeMarkerEnterOptions.marginBottom});

            nodeExit.select("text")
                    .style({"font-size": NodeTextExitOptions.fontSize,
                        "font-name": NodeTextExitOptions.fontName,
                        "font-weight": NodeTextExitOptions.fontWeight,
                        "font-color": NodeTextExitOptions.fontColour,
                        "fill-opacity": NodeTextExitOptions.fillOpacity,
                        "background-color": NodeTextExitOptions.backgroundColour,
                        "margin-left": NodeMarkerEnterOptions.marginLeft,
                        "margin-right": NodeMarkerEnterOptions.marginRight,
                        "margin-top": NodeMarkerEnterOptions.marginTop,
                        "margin-bottom": NodeMarkerEnterOptions.marginBottom});

            // Update the links…
            var link = svg.selectAll("path.link")
                    .data(links, function (d) {
                        return d.target.id;
                    })
                    .style({"fill": NodeLinkOptions.fill,
                        "fill-opacity": NodeLinkOptions.fillOpacity,
                        "stroke-opacity": NodeLinkOptions.strokeOpacity,
                        "stroke": NodeLinkOptions.stroke,
                        "stroke-width": NodeLinkOptions.strokeWidth,
                        "margin-left": NodeLinkOptions.marginLeft,
                        "margin-right": NodeLinkOptions.marginRight,
                        "margin-top": NodeLinkOptions.marginTop,
                        "margin-bottom": NodeLinkOptions.marginBottom})
                    ;

            // Enter any new links at the parent's previous position.
            link.enter().insert("path", "g")
                    .attr("class", "link")
                    .attr("d", function (d) {
                        var o = {x: source.x0, y: source.y0};
                        return diagonal({source: o, target: o});
                    })
                    .style({"fill": NodeLinkEnterOptions.fill,
                        "fill-opacity": NodeLinkEnterOptions.fillOpacity,
                        "stroke": NodeLinkEnterOptions.stroke,
                        "stroke-width": NodeLinkEnterOptions.strokeWidth,
                        "margin-left": NodeLinkEnterOptions.marginLeft,
                        "margin-right": NodeLinkEnterOptions.marginRight,
                        "margin-top": NodeLinkEnterOptions.marginTop,
                        "margin-bottom": NodeLinkEnterOptions.marginBottom,
                        "stroke-opacity": NodeLinkEnterOptions.strokeOpacity});

            // Transition links to their new position.
            link.transition()
                    .duration(duration)
                    .attr("d", diagonal);

            // Transition exiting nodes to the parent's new position.
            link.exit().transition()
                    .duration(duration)
                    .attr("d", function (d) {
                        var o = {x: source.x, y: source.y};
                        return diagonal({source: o, target: o});
                    })
                    .style({"fill": NodeLinkExitOptions.fill,
                        "fill-opacity": NodeLinkExitOptions.fillOpacity,
                        "stroke-opacity": NodeLinkExitOptions.strokeOpacity,
                        "stroke": NodeLinkExitOptions.stroke,
                        "stroke-width": NodeLinkExitOptions.strokeWidth,
                        "margin-left": NodeLinkExitOptions.marginLeft,
                        "margin-right": NodeLinkExitOptions.marginRight,
                        "margin-top": NodeLinkExitOptions.marginTop,
                        "margin-bottom": NodeLinkExitOptions.marginBottom})
                    .remove();

            // Stash the old positions for transition.
            nodes.forEach(function (d) {
                d.x0 = d.x;
                d.y0 = d.y;
            });
        }

// Toggle children on click.
        function click(d) {
            if (d.children) {
                d._children = d.children;
                d.children = null;
            } else {
                d.children = d._children;
                d._children = null;
            }

            update(d);
        }

// Collapse nodes
        function collapse(d) {
            if (d.children) {
                d._children = d.children;
                d._children.forEach(collapse);
                d.children = null;
            }
        }

    };

    $.fn.radialTree.defaults =
            {
                diameter: 960,
                data: null,
                nodeDistance: 100,
                marginLeft: 120,
                marginRight: 120,
                marginTop: 20,
                marginBottom: 20,
                animationSpeed: 600,
                maximumDegrees: 360,
                nodeMarker: {
                    markerType: "circle",
                    markerSize: 4.5,
                    fill: "white",
                    stroke: "steelblue",
                    strokeWidth: "1.5px",
                    marginLeft: 0,
                    marginRight: 0,
                    marginTop: 0,
                    marginBottom: 0,
                    fillOpacity: 1
                },
                nodeWithChildrenMarker: {
                    markerType: "circle",
                    markerSize: 4.5,
                    fill: "steelblue",
                    stroke: "steelblue",
                    strokeWidth: "1.5px",
                    marginLeft: 0,
                    marginRight: 0,
                    marginTop: 0,
                    marginBottom: 0,
                    fillOpacity: 1
                },
                nodeEnterMarker: {
                    markerType: "circle",
                    markerSize: 18,
                    fill: "purple",
                    stroke: "steelblue",
                    strokeWidth: "1.5px",
                    marginLeft: 0,
                    marginRight: 0,
                    marginTop: 0,
                    marginBottom: 0,
                    fillOpacity: 1
                },
                nodeExitMarker: {
                    markerType: "circle",
                    markerSize: 28,
                    fill: "steelblue",
                    stroke: "steelblue",
                    strokeWidth: "1.5px",
                    marginLeft: 0,
                    marginRight: 0,
                    marginTop: 0,
                    marginBottom: 0,
                    fillOpacity: 1
                },
                nodeText: {
                    fontSize: "14px",
                    fontName: "sans-serif",
                    fontWeight: 1.0,
                    fontColour: "black",
                    fillOpacity: 1,
                    marginLeft: 0,
                    marginRight: 0,
                    marginTop: 0,
                    marginBottom: 0,
                    backgroundColour: "white"
                },
                nodeEnterText: {
                    fontSize: "14px",
                    fontName: "sans-serif",
                    fontWeight: 1.0,
                    fontColour: "black",
                    fillOpacity: 1,
                    marginLeft: 0,
                    marginRight: 0,
                    marginTop: 0,
                    marginBottom: 0,
                    backgroundColour: "white"
                },
                nodeExitText: {
                    fontSize: "14px",
                    fontName: "sans-serif",
                    fontWeight: 1.0,
                    fontColour: "black",
                    fillOpacity: 1,
                    backgroundColour: "white"
                },
                nodeLink: {
                    fill: "none",
                    fillOpacity: 0.6,
                    stroke: "ccc",
                    strokeWidth: "1.5px",
                    strokeOpacity: 1,
                    marginLeft: 0,
                    marginRight: 0,
                    marginTop: 0,
                    marginBottom: 0
                },
                nodeEnterLink: {
                    fill: "royalBlue",
                    fillOpacity: 0.6,
                    stroke: "ccc",
                    strokeWidth: "1.5px",
                    marginLeft: 0,
                    marginRight: 0,
                    marginTop: 0,
                    marginBottom: 0,
                    strokeOpacity: 1
                },
                nodeExitLink: {
                    fill: "royalBlue",
                    fillOpacity: 0.6,
                    stroke: "ccc",
                    strokeWidth: "1.5px",
                    marginLeft: 0,
                    marginRight: 0,
                    marginTop: 0,
                    marginBottom: 0,
                    strokeOpacity: 1
                }
            };
})(jQuery);