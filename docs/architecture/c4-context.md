# C4 Model — Level 1 (Context)

```mermaid
C4Context
title JWebMP Core — Context
Person(dev, "Java Developer", "Builds server-side UI using JWebMP Core with GuicedEE/Vert.x")
System_Boundary(app, "Host Application") {
  System_Core(core, "JWebMP Core Library", "Object-oriented HTML/CSS/JS rendering; Guice-integrated; Vert.x-aware")
}
System_Ext(browser, "Browser / Client", "Receives rendered HTML/JS/CSS")
System_Ext(guicedee, "GuicedEE Platform", "Dependency injection + service registry")
System_Ext(vertx, "Vert.x Web", "Evented runtime used for reactive endpoints/bridges (via GuicedEE Vert.x)")
System_Ext(mvn, "Maven Central / Internal Repos", "Artifact distribution")
System_Ext(jackson, "Jackson Runtime", "JSON serialization/deserialization for events/options")

Rel(dev, core, "Implements pages/components, wires services")
Rel(core, guicedee, "Provides/uses service bindings (modules, configurators, startup)")
Rel(core, vertx, "Uses reactive web/event abstractions (Vert.x bridge)")
Rel(core, browser, "Renders HTML/CSS/JS to clients")
Rel(core, jackson, "Registers custom event modules on startup")
Rel(dev, mvn, "Fetches artifacts")
Rel(core, mvn, "Published artifacts")
```

Notes
- Based on `pom.xml` dependencies, `module-info.java` uses/provides entries, Guice bindings, and service provider files.
- Host apps embed the library; transport/auth decisions remain in the host.
