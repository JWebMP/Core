# ERD — Core UI Model (Component Hierarchy → HTML)

```mermaid
erDiagram
  COMPONENT_BASE ||--|| COMPONENT_THEME : extends
  COMPONENT_THEME ||--|| COMPONENT_HIERARCHY : extends
  COMPONENT_HIERARCHY ||--|| COMPONENT_STYLE : extends
  COMPONENT_STYLE ||--|| COMPONENT_EVENT : extends
  COMPONENT_EVENT ||--|| COMPONENT_HTML_OPTIONS : extends
  COMPONENT_HTML_OPTIONS ||--|| COMPONENT_HTML_ATTR : extends
  COMPONENT_HTML_ATTR ||--|| COMPONENT_HTML : extends
  COMPONENT_HTML ||--|| COMPONENT : extends

  COMPONENT_HIERARCHY ||--|{ COMPONENT : "children"
  COMPONENT ||--|{ FEATURE : "has JS features"
  COMPONENT ||--|{ EVENT_ADAPTER : "binds DOM-like events"
  COMPONENT_STYLE ||--|| CSS_BLOCK : "styled by"
  COMPONENT_HTML ||--|| HTML_TAG : "renders"
  PAGE ||--|{ COMPONENT : "root contains"
  PAGE ||--|{ PAGE_CONFIGURATOR : "applies scripts/styles"

  COMPONENT_BASE {
    string id
    ComponentTypes componentType
    string text
    bool tiny
    bool configured
    bool initialized
    bool touched
  }
  COMPONENT_THEME {
    Theme theme
  }
  COMPONENT_HIERARCHY {
    list children
    COMPONENT parent
    bool renderChildren
  }
  COMPONENT_STYLE {
    string cssName
    map cssTypeHashMap "CSSTypes -> ICSSImpl"
    CSSImpl css
  }
  COMPONENT_EVENT {
    list events
    list variables
  }
  COMPONENT_HTML_OPTIONS {
    bool renderTag "suppress tag when needed"
    bool renderChildren "toggle child render"
    bool renderTextBeforeChildren "order of text vs children"
    bool renderTagManually "manual render override"
  }
  COMPONENT_HTML_ATTR {
    map attributes "global + local attributes"
    map styles "style attribute key/values"
    map overrideAttributes "manual overrides"
    bool renderIDAttribute
    bool invertColonRender
  }
  COMPONENT_HTML {
    string tag
    bool closingTag
    bool inlineClosingTag
    bool newLineForRawText "NoNewLineForRawText marker"
    bool newLineForClosingTag "NoNewLineBeforeClosingTag marker"
    int currentTabIndents "indentation control"
  }
  COMPONENT {
    string tagName "alias for HTML tag"
    bool noClosingTagAllowed "supports NoClosingTag marker"
  }
  HTML_TAG {
    string tagName
    json attributes
  }
  PAGE {
    string title
    list meta
    list headers
  }
  FEATURE {
    string name
    json options
  }
  EVENT_ADAPTER {
    string eventType
    string handlerRef
  }
  CSS_BLOCK {
    json declarations
  }
  PAGE_CONFIGURATOR {
    string name
  }
```

How this maps to HTML generation
- The CRTP chain starts at `ComponentBase` (IDs, component type, raw text), then adds themes, children, CSS, events, and finally HTML tag controls (`ComponentHTMLBase`, `ComponentStyleBase`, `ComponentEventBase`, `ComponentHierarchyBase`, `Component`).
- `ComponentHierarchyBase` manages parent/child relationships and render ordering, producing nested HTML nodes.
- `ComponentHTMLOptionsBase` toggles rendering of tag/children/text; `ComponentHTMLAttributeBase` composes global/local attributes, inline styles, and ID handling; `ComponentHTMLBase` controls tag name, closing behavior, inline rendering, and new-line preferences.
- `ComponentStyleBase` composes CSS via `CSSImpl` and `ICSSImpl` per `CSSTypes`; output becomes class attributes or inline styles.
- `ComponentEventBase` and event adapters (e.g., `ClickAdapter`) bind DOM-like events to server-side handlers; features emit supporting scripts.
- Pages (`Page`) are roots that aggregate components, headers, and configurators. Configurators (`IPageConfigurator`) are loaded via ServiceLoader (`JWebMPServicesBindings`) to inject scripts/styles before render.

Evidence
- Class chain observed in `ComponentBase`, `ComponentThemeBase`, `ComponentHierarchyBase`, `ComponentStyleBase`, `ComponentEventBase`, `ComponentHTMLBase`, `Component`.
- Service providers for configurators and events in `src/main/resources/META-INF/services`; Guice bindings in `com.jwebmp.core.implementations`.
- CSS builders under `com.jwebmp.core.htmlbuilder.css.*`; event adapters under `com.jwebmp.core.events.*`.
