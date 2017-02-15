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
package za.co.mmagon.jwebswing.base.angular;

import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.Body;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * The Angular 2 feature
 *
 * @author GedMarc
 * @since 16 Apr 2016
 */
class Angular2Feature extends Feature<JavaScriptPart, Angular2Feature>
{

    private static final long serialVersionUID = 1L;

    /**
     * Adds on the Angular ComponentFeatureBase to the application to allow full data binding
     *
     * @param b
     */
    public Angular2Feature(Body b)
    {
        super("Angular2Feature");
        //Angular Addition
        getJavascriptReferences().add(AngularReferencePool.Angular2RX.getJavaScriptReference());
        getJavascriptReferences().add(AngularReferencePool.Angular2Polyfills.getJavaScriptReference());
        getJavascriptReferences().add(AngularReferencePool.Angular2AllUMD.getJavaScriptReference());

        /*
         * getJavascriptReferences().add(AngularReferencePool.Angular2Polyfills.getJavaScriptReference()); getJavascriptReferences().add(AngularReferencePool.Angular2RX.getJavaScriptReference());
         * getJavascriptReferences().add(AngularReferencePool.Angular2System.getJavaScriptReference()); getJavascriptReferences().add(AngularReferencePool.Angular2Typescript.getJavaScriptReference());
         * getJavascriptReferences().add(AngularReferencePool.AngularShimsForIE.getJavaScriptReference());
         * getJavascriptReferences().add(AngularReferencePool.AngularSystemPolyfills.getJavaScriptReference()); getJavascriptReferences().add(AngularReferencePool.ES6.getJavaScriptReference());
         * getJavascriptReferences().add(AngularReferencePool.Angular2Router.getJavaScriptReference());
         */
    }

    @Override
    public void assignFunctionsToComponent()
    {
        String jWebApplicationSetup = "(function() {\n"
                + "\n"
                + "  var HelloApp = \n"
                + "    ng.core\n"
                + "    .Component({\n"
                + "      selector: 'hello-app',\n"
                + "      template: '<h1>Hello Angular 2!</h1>'\n"
                + "    })\n"
                + "    .Class({\n"
                + "      constructor: function() {}\n"
                + "    });\n"
                + "    ng.platform.browser.bootstrap(HelloApp);\n"
                + "})();";
        addQuery(jWebApplicationSetup);
    }
}
