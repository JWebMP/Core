function jwCheckJS() {
    try {
        if (jw.angularExists) {
            while (jw.angularLoading) {

            }
            jw.afterInit = jw.jwDoJavascript();
        } else {
            jw.jwDoJavascript();
        }
    }catch(e)
    {
        console.log('no angular found - exception ' + e);
        jw.jwDoJavascript();
    }
}

jw.jwDoJavascript = function () {
    JW_JAVASCRIPT
};
jwCheckJS();