function jwCheckJS() {
    try {
        if (angular !== undefined && angular) {
            while (jw.angularLoading) {

            }
            jw.afterInit = jw.jwDoJavascript();
        } else {
            jw.jwDoJavascript();
        }
    }catch(e)
    {
        console.log('no angular found');
        jw.jwDoJavascript();
    }
}

jw.jwDoJavascript = function () {
    JW_JAVASCRIPT
};
jwCheckJS();
