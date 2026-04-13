# JWebMP Core

[![Build](https://github.com/JWebMP/Core/actions/workflows/maven-publish.yml/badge.svg)](https://github.com/JWebMP/Core/actions/workflows/maven-publish.yml)
[![Maven Central](https://img.shields.io/maven-central/v/com.jwebmp.core/jwebmp-core)](https://central.sonatype.com/artifact/com.jwebmp.core/jwebmp-core)
[![Maven Snapshot](https://img.shields.io/nexus/s/com.jwebmp.core/jwebmp-core?server=https%3A%2F%2Foss.sonatype.org&label=Maven%20Snapshot)](https://oss.sonatype.org/content/repositories/snapshots/com/jwebmp/core/jwebmp-core/)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue)](https://www.apache.org/licenses/LICENSE-2.0)

![Java 25+](https://img.shields.io/badge/Java-25%2B-green)
![Guice 7](https://img.shields.io/badge/Guice-7%2B-green)
![Vert.X 5](https://img.shields.io/badge/Vert.x-5%2B-green)
![Maven 4](https://img.shields.io/badge/Maven-4%2B-green)

**Strongly-typed HTML/CSS/JS component model** for Java — the heart of [JWebMP](https://jwebmp.com).

The core defines the **HTML language in Java** — every HTML element, CSS property, event, and feature is a first-class Java object using CRTP generics. It generates the HTML, JavaScript, and CSS required for any page, and provides the SPI contracts that allow a mass ecosystem of plugins to be created that adhere to the component model.

Every component serves **dual purposes**:
- **`toString(true)`** renders the component as **HTML** (with all queued CSS/JS) — use this for server-side rendering, template generation, or serving pages on the Vert.x router
- **`toString()`** renders the component as **JSON** — use this for AJAX responses, API payloads, or any scenario where the component tree needs to be serialized

Pages can optionally be annotated with `@PageConfiguration` and served directly via the Vert.x HTTP server, or components can be used standalone to generate HTML/JSON without a server at all.

Provides `Page`, the full HTML element library (`Div`, `Span`, `Table`, `Form`, …), a typed CSS builder, 50+ server-driven event adapters, page configurators that inject scripts/styles before render, and a Jackson-serialized AJAX pipeline for live DOM updates. Extension is SPI-driven via `ServiceLoader`.

Built on [JWebMP Client](../client) · [GuicedEE](https://github.com/GuicedEE) · [Vert.x 5](https://vertx.io/) · JPMS module `com.jwebmp.core` · Java 25+

## 📦 Installation

```xml
<dependency>
  <groupId>com.jwebmp.core</groupId>
  <artifactId>core</artifactId>
</dependency>
```

<details>
<summary>Gradle (Kotlin DSL)</summary>

```kotlin
implementation("com.jwebmp.core:jwebmp-core:2.0.0-RC5")
```
</details>

> Version is managed by the [JWebMP BOM](../bom/README.MD).

## ✨ Features

- **HTML language in Java** — the core defines the entire HTML5 element set as typed Java classes, along with CSS and JavaScript rendering rules, forming the foundation that all JWebMP plugins build on top of
- **Dual rendering modes** — `toString(true)` produces full HTML with all CSS/JS assets; `toString()` produces JSON for AJAX/API consumption — same component tree, two output formats
- **Complete HTML element library** — every HTML5 element (`Div`, `Span`, `Table`, `Form`, `Input`, `Select`, `Canvas`, `Video`, `Article`, `Section`, …) is a typed Java class with CRTP fluent API; child constraints are enforced at compile time
- **Typed input elements** — `InputTextType`, `InputEmailType`, `InputNumberType`, `InputDateType`, `InputFileType`, `InputCheckBoxType`, `InputRadioType`, and 15 more — each with the correct HTML attributes
- **Typed CSS builder** — annotation-driven CSS properties (`@CSS`) across 14 sub-packages: backgrounds, borders, colours, fonts, margins, padding, displays, lists, tables, text, outline, measurement, height/width, image — rendered inline or composed via `CSSPropertiesFactory`
- **50+ server-driven event adapters** — `OnClickAdapter`, `OnChangeAdapter`, `OnSubmitAdapter`, `OnDragAdapter`, `OnKeyDownAdapter`, `OnMouseEnterAdapter`, and many more — each backed by a `ServiceLoader` SPI (`IOnClickService`, `IOnChangeService`, etc.). **Events must be their own named classes** — anonymous inner classes and lambdas are not supported because the framework relies on class identity for serialization and `ServiceLoader` discovery
- **Page configurators (optional)** — `IPageConfigurator` SPI is an optional hook that modifies pages before rendering — use it to inject CSS links, JavaScript references, dynamic scripts, or top-shelf scripts in priority order; pages work perfectly fine without any configurators
- **Render-ordering hooks** — `RenderBeforeLinks`, `RenderAfterLinks`, `RenderBeforeScripts`, `RenderAfterScripts`, `RenderBeforeDynamicScripts`, `RenderAfterDynamicScripts` — fine-grained control over asset insertion
- **AJAX pipeline** — `AjaxCall`/`AjaxResponse` (from [jwebmp-client](../client)) carry event payloads and DOM update instructions; `Event` base class wires server handlers to browser events
- **Feature system** — `Feature<O, J>` wraps a JavaScript library with typed options (`JavaScriptPart`), CSS/JS references, and automatic dependency ordering. **Features must be their own named classes** — the framework uses class identity for deduplication, dependency ordering, and Jackson serialization
- **CSSComponent** — render-only CSS classes (no HTML tag) for reusable style-only components
- **DataAdapter** — bridges server-side data into raw JSON for component consumption
- **Content Security Policy** — `ContentSecurityPolicy` builder for CSP headers
- **Jackson module** — `JWebMPJacksonModule` registers custom event deserializers at pre-startup
- **Component hierarchy** — 11-layer deep CRTP chain: `ComponentBase` → `ComponentHierarchyBase` → `ComponentHTMLBase` → `ComponentHTMLAttributeBase` → `ComponentHTMLOptionsBase` → `ComponentStyleBase` → `ComponentThemeBase` → `ComponentDataBindingBase` → `ComponentDependencyBase` → `ComponentFeatureBase` → `ComponentEventBase` → `Component` → your subclass
- **Utility belt** — `GUIDGenerator`, `ColourUtils`, `TextUtilities`, `EscapeChars`, `DateUtils`, regex patterns (email, date, text)

## 🚀 Quick Start

### Build a page in pure Java

No server needed — just create components and render:

```java
Page<?> page = new Page<>();
Div<?, ?, ?> container = new Div<>();
container.add(new Paragraph<>().setText("Welcome to JWebMP"));
page.getBody().add(container);

String html = page.toString(true);  // full HTML + queued CSS/JS
String json = page.toString();      // JSON representation of the component tree
```

### Optionally serve it with GuicedEE + Vert.x

Annotate with `@PageConfiguration` to host the page on the Vert.x HTTP server — this is **optional** and only needed when you want server-side rendering via Vert.x:

```java
@PageConfiguration(url = "/")
public class HomePage extends Page<HomePage> {

    public HomePage() {
        getBody().add(new H1<>().setText("Hello from JWebMP"));
        getBody().add(new Paragraph<>().setText("Server-rendered, type-safe HTML."));
    }
}
```

```java
module my.app {
    requires com.jwebmp.core;

    provides com.jwebmp.core.services.IPage
        with my.app.HomePage;
}
```

Boot GuicedEE — the page is now live:

```java
IGuiceContext.instance().inject();
// Vert.x HTTP server starts, HomePage served at "/"
```

### Handle a click event

Events **must be their own named classes** — define a top-level or static inner class:

```java
public class ButtonClickEvent extends OnClickAdapter {

    public ButtonClickEvent(Component component) {
        super(component);
    }

    @Override
    public void onClick(AjaxCall<?> call, AjaxResponse<?> response) {
        response.addComponent(new Paragraph<>().setText("Clicked!"));
    }
}
```

Then attach it to any component:

```java
Div<?, ?, ?> button = new Div<>();
button.setText("Click me");
button.addEvent(new ButtonClickEvent(button));
page.getBody().add(button);
```

> ⚠️ **Anonymous inner classes and lambdas are not supported for events or features.** The framework relies on class identity for serialization, `ServiceLoader` discovery, and deduplication. Always create a named class.

### Add a Feature with typed options

```java
public class TooltipFeature extends Feature<TooltipOptions, TooltipFeature> {

    public TooltipFeature(IComponentHierarchyBase<?, ?> component) {
        super("tooltip", component);
        getOptions().setPlacement("top");
    }

    @Override
    protected void assignFunctionalityToComponent() {
        addQuery(getComponent().asBase().getJQueryID() + "tooltip(" + getOptions() + ");");
    }
}
```

### Use the CSS builder

```java
Div<?, ?, ?> styled = new Div<>();
styled.getCss()
      .getBackground().setBackgroundColor$(ColourNames.AliceBlue);
styled.getCss()
      .getBorder().setBorderWidth(new MeasurementCSSImpl(1, MeasurementTypes.Pixels));
styled.getCss()
      .getFont().setFontSize(new MeasurementCSSImpl(14, MeasurementTypes.Pixels));
```

## 📐 Page Render Flow

```
IGuiceContext.instance().inject()
 └─ JWebMPPreStartup (IGuicePreStartup, sortOrder=15)
     └─ Register JWebMPJacksonModule with ObjectMapper

 HTTP request arrives at @PageConfiguration URL
 └─ IPage instance created (via Guice binding → Page.class)
     └─ IPageConfigurator chain (sorted by sortOrder)
         ├─ CSSLinksInsertPageConfigurator
         │    ├─ RenderBeforeLinks SPIs
         │    ├─ CSS <link> tags inserted into <head>
         │    └─ RenderAfterLinks SPIs
         ├─ ScriptsInsertPageConfigurator
         │    ├─ RenderBeforeScripts SPIs
         │    ├─ <script> tags inserted (by RequirementsPriority)
         │    └─ RenderAfterScripts SPIs
         ├─ TopShelfScriptsInsertPageConfigurator
         │    └─ High-priority scripts in <head>
         └─ ScriptsDynamicPageConfigurator
              ├─ RenderBeforeDynamicScripts SPIs
              ├─ Inline/dynamic <script> blocks
              └─ RenderAfterDynamicScripts SPIs
     └─ page.toString(true) → full HTML response
```

## 🔌 SPI Extension Points

All SPIs are discovered via `ServiceLoader`. Register implementations with JPMS `provides...with` or `META-INF/services`.

### `IPage`

Provide a page implementation — typically by subclassing `Page`:

```java
@PageConfiguration(url = "/dashboard")
public class Dashboard extends Page<Dashboard> {

    public Dashboard() {
        getBody().add(new H1<>().setText("Dashboard"));
    }

    @Override
    public AjaxResponse<?> onConnect(AjaxCall<?> call, AjaxResponse<?> response) {
        // handle initial connection
        return response;
    }
}
```

### `IPageConfigurator`

Configure pages before rendering — inject CSS, JS, meta tags, or transform the component tree:

```java
public class AnalyticsConfigurator
        implements IPageConfigurator<AnalyticsConfigurator> {

    @Override
    public IPage<?> configure(IPage<?> page) {
        page.addJavaScriptReference(new JavascriptReference("analytics", 1.0, "analytics.js"));
        return page;
    }

    @Override
    public Integer sortOrder() {
        return 500;  // after core configurators
    }
}
```

### `IEventConfigurator`

Transform any `Event` after creation — add global behaviour to all events:

```java
public class EventLogger implements IEventConfigurator<EventLogger> {

    @Override
    public Event<?, ?> configureEvent(Event<?, ?> event) {
        // add logging, metrics, or security checks
        return event;
    }
}
```

### Render-ordering SPIs

| SPI | Purpose |
|---|---|
| `RenderBeforeLinks` | Insert content before CSS `<link>` tags |
| `RenderAfterLinks` | Insert content after CSS `<link>` tags |
| `RenderBeforeScripts` | Insert content before `<script>` tags |
| `RenderAfterScripts` | Insert content after `<script>` tags |
| `RenderBeforeDynamicScripts` | Insert content before dynamic/inline scripts |
| `RenderAfterDynamicScripts` | Insert content after dynamic/inline scripts |

### Event SPIs

Each of the 50+ event types has a corresponding service interface discovered via `ServiceLoader`:

| SPI | Event |
|---|---|
| `IOnClickService` | Click |
| `IOnChangeService` | Change |
| `IOnSubmitService` | Submit |
| `IOnKeyDownService` | Key down |
| `IOnMouseEnterService` | Mouse enter |
| `IOnDragService` / `IOnDropService` | Drag & drop |
| `IOnFocusService` / `IOnBlurService` | Focus / blur |
| … and 40+ more | See `com.jwebmp.core.events.services` |

## 🧱 Component Hierarchy

The CRTP component chain provides progressive enhancement — each layer adds a capability:

```
ComponentBase            → ID, name, properties, JSON serialization
 └─ ComponentHierarchyBase  → parent/child tree, add(), CSS/JS references
     └─ ComponentHTMLBase      → tag rendering, text, raw HTML, newlines
         └─ ComponentHTMLAttributeBase → HTML attributes (typed enums)
             └─ ComponentHTMLOptionsBase  → JavaScript options (JavaScriptPart)
                 └─ ComponentStyleBase       → inline CSS via the CSS builder
                     └─ ComponentThemeBase       → theme support
                         └─ ComponentDataBindingBase → data-bind hooks
                             └─ ComponentDependencyBase  → CSS/JS dependency refs
                                 └─ ComponentFeatureBase    → Feature attachment
                                     └─ ComponentEventBase     → Event attachment
                                         └─ Component              → final user-facing base
```

Concrete HTML elements (`Div`, `Table`, `Form`, etc.) extend `Component` and lock down child/attribute/event types via generics.

> **Note:** The hierarchy depth is a design-time concern only. Modern JDK versions flatten class hierarchies at runtime, so the 11-layer chain has zero performance overhead — you get full type safety with no cost.

## 🎨 CSS Builder Packages

| Package | Properties |
|---|---|
| `css.backgrounds` | `background-color`, `background-image`, `background-repeat`, … |
| `css.borders` | `border-width`, `border-style`, `border-color`, `border-radius`, … |
| `css.colours` | Named colours, colour enumeration |
| `css.fonts` | `font-family`, `font-size`, `font-weight`, `font-style`, … |
| `css.margins` | `margin-top`, `margin-right`, `margin-bottom`, `margin-left` |
| `css.padding` | `padding-top`, `padding-right`, `padding-bottom`, `padding-left` |
| `css.displays` | `display`, `visibility`, `overflow`, `position`, `float`, … |
| `css.text` | `text-align`, `text-decoration`, `text-transform`, `line-height`, … |
| `css.tables` | `border-collapse`, `border-spacing`, `table-layout`, … |
| `css.lists` | `list-style-type`, `list-style-position`, … |
| `css.outline` | `outline-width`, `outline-style`, `outline-color` |
| `css.heightwidth` | `height`, `width`, `min-height`, `max-width`, … |
| `css.measurement` | `MeasurementCSSImpl` — px, em, rem, %, vw, vh, … |
| `css.animatable` | Animatable property markers |

## ⚙️ Configuration

| Variable / Property | Default | Purpose |
|---|---|---|
| `@PageConfiguration(url=)` | `"/"` | URL path for page discovery |
| Environment-driven ports | via [jwebmp-vertx](../vertx) | HTTP/HTTPS listen ports |

## 🗺️ Module Graph

```
com.jwebmp.core
 ├── com.jwebmp.client               (SPI contracts, AjaxCall/Response, interceptors)
 ├── com.guicedee.client              (DI, lifecycle, CallScope)
 ├── com.guicedee.vertx               (Vert.x lifecycle, event bus)
 ├── com.guicedee.jsonrepresentation  (Jackson ObjectMapper, IJsonRepresentation)
 ├── io.vertx.core                    (Vert.x core)
 ├── io.vertx.web                     (Vert.x Web — Router)
 ├── com.google.guice                 (Dependency injection)
 ├── com.fasterxml.jackson.databind   (JSON serialization)
 ├── jakarta.validation               (Bean Validation)
 ├── org.apache.commons.lang3         (String utilities)
 ├── org.apache.commons.text          (Text utilities)
 ├── org.apache.commons.io            (IO utilities)
 ├── net.sf.uadetector.core           (User-agent parsing)
 └── net.sf.uadetector.resources
```

## 🧩 JPMS

Module name: **`com.jwebmp.core`**

The module:
- **exports** `com.jwebmp.core`, `com.jwebmp.core.base`, `com.jwebmp.core.base.html`, `com.jwebmp.core.base.html.inputs`, `com.jwebmp.core.base.page`, `com.jwebmp.core.components`, `com.jwebmp.core.events.*` (50+ packages), `com.jwebmp.core.htmlbuilder.css.*` (14 packages), `com.jwebmp.core.utilities`, `com.jwebmp.core.enumerations`, `com.jwebmp.core.implementations`
- **provides** `IGuiceModule` with `JWebMPServicesBindings`, `IGuicePreStartup` with `JWebMPPreStartup`, `IGuiceScanModuleInclusions` with `JWebMPModuleInclusions`, `IPageConfigurator` with `CSSLinksInsertPageConfigurator`, `ScriptsInsertPageConfigurator`, `ScriptsDynamicPageConfigurator`, `TopShelfScriptsInsertPageConfigurator`, `IRegularExpressions` with regex pattern providers
- **uses** `IPage`, `IPageConfigurator`, `IErrorPage`, `IEventConfigurator`, `IDynamicRenderingServlet`, `IOnComponentConfigured`, `IOnDataBind`, `IOnDataBindCloak`, `IOnComponentHtmlRender`, `IOnComponentAdded`, `IAfterRenderComplete`, all `RenderBefore*/RenderAfter*` SPIs, all 50+ event service SPIs

## 🏗️ Key Classes

| Class | Role |
|---|---|
| `Page` | Top-level HTML page — subclass and annotate with `@PageConfiguration` |
| `Component` | Base class for all HTML elements — CRTP with typed children, attributes, features, events |
| `CSSComponent` | CSS-only component (renders as class, no HTML tag) |
| `Feature` | Wraps a JS library — typed options, CSS/JS references, jQuery integration |
| `Event` | Server-driven event handler — wires browser events to `AjaxCall`/`AjaxResponse` |
| `DataAdapter` | Bridges server data into raw JSON for component consumption |
| `ContentSecurityPolicy` | Builder for CSP headers |
| `PageOptions` | Page-level options (title, author, favicon, keywords, etc.) |
| `CSSPropertiesFactory` | Renders `@CSS`-annotated objects into inline CSS strings |
| `JWebMPServicesBindings` | `IGuiceModule` — binds `IPage`, page configurators, render-ordering SPIs |
| `JWebMPPreStartup` | `IGuicePreStartup` — registers `JWebMPJacksonModule` at startup |
| `JWebMPJacksonModule` | Jackson module — custom `Event` and `IEventTypes` deserializers |
| `IEventConfigurator` | SPI — transform any `Event` after creation |
| `GUIDGenerator` | Unique ID generation for components |

### HTML Elements (partial list)

| Element | Class | Children type |
|---|---|---|
| `<div>` | `Div` | `GlobalChildren` |
| `<span>` | `Span` | `GlobalChildren` |
| `<p>` | `Paragraph` | `GlobalChildren` |
| `<h1>`–`<h6>` | `H1`–`H6` | `GlobalChildren` |
| `<table>` | `Table` | `TableHeaderGroup`, `TableBodyGroup`, `TableFooterGroup` |
| `<form>` | `Form` | `FormChildren` |
| `<input>` | `Input` + 22 typed variants | inline |
| `<select>` | `Select` | `Option`, `OptionGroup` |
| `<ul>` / `<ol>` | `List` | `ListItem` |
| `<a>` | `Link` | `GlobalChildren` |
| `<img>` | `Image` | inline |
| `<button>` | `Button` | `GlobalChildren` |
| `<header>` / `<footer>` / `<nav>` / `<section>` / `<article>` / `<aside>` | Semantic elements | `GlobalChildren` |
| `<canvas>` / `<video>` / `<audio>` | Media elements | `Source`, `Track` |
| `<script>` / `<style>` / `<link>` | Asset elements | — |

## 🧪 Build & Test

```bash
# Build
mvn -B -ntp -DskipTests package

# Test
mvn -B -ntp verify
```

Prerequisites: Java 25+, Maven 3.9+

## 🤝 Contributing

Issues and pull requests are welcome at [github.com/JWebMP/Core/issues](https://github.com/JWebMP/Core/issues).

## 📄 License

[Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0)
