# C4 Model — Level 2 (Containers)

```mermaid
C4Container
title JWebMP Core — Container View
Person(dev, "Java Developer")
System_Boundary(host, "Host Application (Maven / JPMS)") {
  Container(core, "JWebMP Core Library", "Java 25, JPMS", "Component model, rendering pipeline, event abstractions")
  Container(guice, "GuicedEE Modules", "Guice extensions", "Lifecycle hooks, module inclusions, service bindings via ServiceLoader")
  Container(vertx, "Vert.x Integration", "Vert.x Web", "Reactive web/events support, Vert.x bridge usage")
}
Container_Ext(client, "Browser/Client", "HTML/CSS/JS consumer")
Container_Ext(repo, "Artifact Repository", "Maven")
Container_Ext(jackson, "Jackson Runtime", "ObjectMapper with `JWebMPJacksonModule`")

Rel(dev, core, "Creates components/pages, configures services")
Rel(core, guice, "Provides/uses `IGuiceModule`, `IGuicePreStartup`, scan inclusions, configurators")
Rel(core, vertx, "Depends on Vert.x Web + `com.guicedee.vertx` bridge")
Rel(core, client, "Outputs rendered markup/scripts")
Rel(core, repo, "Published artifact")
Rel(dev, repo, "Consumes via Maven")
Rel(core, jackson, "Registers custom event deserializers")
```

Evidence
- Dependencies in `pom.xml` (GuicedEE BOMs, Vert.x Web, Jackson, Apache Commons).
- `module-info.java` exports UI/component packages, uses event services, and provides Guice/scan bindings.
- Startup path in `JWebMPPreStartup` registers Jackson module; `JWebMPServicesBindings` wires configurator/service sets.
