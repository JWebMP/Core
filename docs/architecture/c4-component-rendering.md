# C4 Model — Level 3 (Component: Rendering & Events)

```mermaid
C4Component
title JWebMP Core — Component View (Rendering & Events)
Container_Boundary(core, "JWebMP Core Library") {
  Component(componentModel, "Component Model", "com.jwebmp.core.*", "CRTP-based HTML component hierarchy (Component, Page, HTML element subclasses)")
  Component(cssModel, "CSS/Style Model", "com.jwebmp.core.htmlbuilder.css.*", "Typed CSS builders (colors, measurements, backgrounds, fonts, layout)")
  Component(pageConfig, "Page Configurators", "com.jwebmp.core.base.page.*", "Service providers for script/style injection (`IPageConfigurator`)")
  Component(eventAdapters, "Event Adapters & Services", "com.jwebmp.core.events.*", "Adapter classes and service interfaces (`IOn*`, `IEventConfigurator`)")
  Component(serviceRegistry, "Service Registry Integration", "com.jwebmp.core.implementations.*", "Guice modules (`JWebMPServicesBindings`), scan inclusions, pre-startup Jackson registration")
}
Component_Ext(guice, "GuicedEE Modules", "", "Provides lifecycle + scanning hooks")
Component_Ext(vertx, "Vert.x Web", "", "Reactive web/event APIs")
Component_Ext(appCode, "Host Application Code", "", "Builds pages/components using the model")
Component_Ext(jackson, "Jackson Runtime", "", "Uses `JWebMPJacksonModule` for event deserialization")

Rel(appCode, componentModel, "Extends/assembles components")
Rel(componentModel, cssModel, "Applies typed CSS builders to components")
Rel(componentModel, pageConfig, "Delegates page-level script/style injection")
Rel(componentModel, eventAdapters, "Attaches event adapters/features; uses `IEventConfigurator`")
Rel(serviceRegistry, guice, "Provides modules/pre-startup & scan inclusions to Guice context")
Rel(eventAdapters, vertx, "Uses Vert.x types when host enables reactive endpoints")
Rel(appCode, serviceRegistry, "Consumes auto-registered services via Guice")
Rel(serviceRegistry, jackson, "Adds event deserializers during startup")
```

Evidence
- Exports/uses/provides in `module-info.java` (component packages, event `uses` clauses, Guice bindings).
- Service provider declarations in `src/main/resources/META-INF/services`.
- Guice bindings + Jackson module under `com.jwebmp.core.implementations`.
- Event adapter classes under `src/main/java/com/jwebmp/core/events/*`.
