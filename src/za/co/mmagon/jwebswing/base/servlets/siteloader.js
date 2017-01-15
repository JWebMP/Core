/* global BootstrapDialog, eval */

var jw = {};
jw.siteAddress = "%SITEADDRESS%";

/**
 * Load scripts in parallel keeping execution order.
 * @param scripts {array} An array of script urls. They will parsed in the order of the array.
 * @returns {$.Deferred}
 */
function getScripts(scripts) {
    var xhrs = scripts.map(function (url) {
        return $.ajax({
            url: url,
            dataType: 'text',
            cache: true
        });
    });

    return $.when.apply($, xhrs).done(function () {
        Array.prototype.forEach.call(arguments, function (res) {
            eval.call(this, res[0]);
        });
    });
}

function nodeScriptReplace(nodeRoot) {

    var children = nodeRoot.childNodes;
    var scripts = [];
    children.forEach(function (node) {

        if (node !== 'undefined')
            if (nodeScriptIs(node) === true) {
                if (node.attributes && node.attributes.src)
                    var location = node.attributes.src.value;
                scripts.push(location);
            }
    });

    getScripts(scripts);
    return nodeRoot;
}

function nodeScriptIs(node) {
    try
    {
        return node.tagName === 'SCRIPT';
    } catch (e)
    {
        return false;
    }
}


function getLocalStorage() {
    var localStorage = {};

    //test for firefox 3.6 see if it works
//with this way of iterating it
    for (var i = 0, len = localStorage.length; i < len; i++) {
        var key = localStorage.key(i);
        var value = localStorage[key];
        console.log(key + " => " + value);
    }




};



$.ajax({
    type: "POST",
    url: jw.siteAddress + 'jwcordova',
    data: null,
    success: function (e) {
        var result = e;
        var header = result.components[0].html;
        var body = result.components[1].html;

        document.getElementsByTagName('head')[0].innerHTML = header;
        document.getElementsByTagName('body')[0].innerHTML = body;

        nodeScriptReplace(document.getElementsByTagName("head")[0]);

        $(window).resize();
    }
});


