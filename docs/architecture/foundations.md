# Architecture Foundations — Stage 1 (refreshed)

## Data & Control Flow (Render + Event Round-Trip)

```mermaid
flowchart TD
  Dev[Host App Code] -->|Builds component tree (CRTP)| Components
  Components -->|Inject scripts/styles| PageCfg[IPageConfigurator providers<br/>(ServiceLoader via Guice)]
  Components --> Renderer[Renderer/HTML Builder + CSS Builders]
  Renderer -->|HTML/CSS/JS| Browser
  Browser -->|AJAX/Vert.x call| Endpoint[Host Endpoint (GuicedEE/Vert.x bridge)]
  Endpoint --> EventSvc[Event Adapter Service<br/>(IOn* service interfaces)]
  EventSvc --> Components
  Components -->|Updated markup (full/delta)| Browser
```

## Dependency & Integration Map (evidence-driven)
- Internal modules: Component hierarchy rooted at `com.jwebmp.core.Component`, page roots (`Page`), CSS builders (`com.jwebmp.core.htmlbuilder.css.*`), event adapters (`com.jwebmp.core.events.*`), configurators (`com.jwebmp.core.base.page.*`), Guice bindings (`com.jwebmp.core.implementations.*`).
- External dependencies (pom.xml + `module-info.java`):
  - GuicedEE client/core lifecycle + context (`com.guicedee.client`, `IGuiceModule`, `IGuicePreStartup`, `IGuiceScanModuleInclusions`).
  - Vert.x Web + GuicedEE Vert.x bridge (`io.vertx.web`, `com.guicedee.vertx`) for reactive endpoints.
  - Jackson (`com.fasterxml.jackson.*`) with `JWebMPJacksonModule` (custom event deserializers).
  - Apache Commons (`lang3`, `text`, `io`) utilities.
- Service wiring:
  - Service providers under `src/main/resources/META-INF/services/*` supply configurators, regex sets, page binding, and lifecycle hooks.
  - `JWebMPServicesBindings` uses `IGuiceContext.getLoader(...)` to expose provider sets; `JWebMPPreStartup` registers Jackson module on startup.
  - JPMS `provides/uses` entries define extension points for event services (`IOn*` interfaces), pages, configurators, and rendering hooks.

## Trust Boundaries & Threat Notes
- Browser ↔ Host endpoint (AJAX/Vert.x): XSS risk if component rendering leaks unsanitized strings; host must enforce auth/CSRF as transport is host-defined.
- Service loader / Guice bindings: untrusted provider jars could alter render pipeline; restrict classpath and validate service implementations.
- JSON deserialization (events/options): `JacksonEventDeserializer` and `JacksonEventTypeDeserializer` rely on incoming payloads; host should validate payload sources.
- Logging: Default to Log4j2; avoid logging user input verbatim, especially around event payloads and regex patterns.

## Glossary Composition Plan
- Topic-first: pull definitions from rules submodule glossaries for Java 25, JWebMP Client/Core, GuicedEE Core/Client/Web, Vert.x, JSpecify, and logging.
- Root `GLOSSARY.md` only indexes topics and Prompt Language Alignment mappings (e.g., WebAwesome names if ever adopted); defer detail to topic glossaries.

## Evidence References
- `module-info.java` exports/uses/provides for component/event/configurator services.
- `pom.xml` dependency set and BOM imports (Java 25 LTS, Maven).
- `src/main/resources/META-INF/services/*` provider declarations.
- `com.jwebmp.core.implementations.*` Guice bindings and Jackson wiring.
