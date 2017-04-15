/* global jw*/

function jwCheckJS() {
    if (angular)
    {
        while (jw.angularLoading)
        {

        }
        jw.afterInit = jw.jwDoJavascript();
    } else
    {
        jw.jwDoJavascript();
    }
}
;

jw.jwDoJavascript = function () {
    //%%JW_JAVASCRIPT%%
};
jwCheckJS();