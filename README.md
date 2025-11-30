# JWebMP Core

Open-source core for JWebMP: a strongly-typed, server-rendered HTML/CSS/JS component model for Java. Components are plain Java (CRTP-based) and integrate with GuicedEE/ServiceLoader; Vert.x support is included for reactive endpoints. Licensed under Apache 2.0.

## What you get
- Typed HTML components and CSS builders in Java; render any component (or whole page) with `toString(true)`.
- Server-driven events via adapters (`com.jwebmp.core.events.*`) plus Guice/ServiceLoader extension points.
- Page configurators to inject scripts/styles before render; optional Vert.x bridge for reactive endpoints.
- Apache 2.0 licensed; designed for enterprise servers without coupling to a specific transport.

## Quick start
```java
Page<?> page = new Page<>("Home");
Div<?, ?, ?> container = new Div<>();
container.add(new Paragraph<>().setText("Welcome to JWebMP"));
page.getBody().add(container);
String html = page.toString(true); // HTML + queued JS/CSS requirements
```

## Running pages (GuicedEE + Vert.x)
Pages are discovered by GuicedEE and served over Vert.x Web. Implement `IPage` (typically by subclassing `Page`) and annotate with `@PageConfiguration` to set the URL.
```java
@PageConfiguration(url = "/")
public class HomePage extends Page<HomePage> {
  public HomePage() {
    getBody().add(new Paragraph<>().setText("Hello from JWebMP"));
  }
}
```
- Boot GuicedEE (e.g., `IGuiceContext.instance().inject();` or your host’s bootstrap). The Vert.x HTTP server starts and routes requests to the configured page URLs.
- For a custom path, set `url` in `@PageConfiguration`; the default is `/`.
- Rendered output per request uses the same pipeline as `page.toString(true)`, so server-driven events and configurators are applied automatically.

## Build & test
- Prerequisites: Java 25 LTS, Maven 3.9+
- Build: `mvn -q -DskipTests package`
- Test: `mvn -q test`

## Key docs
- Pact: `PACT.md`
- Rules: `RULES.md`
- Guides: `GUIDES.md`
- Implementation: `IMPLEMENTATION.md`
- Glossary: `GLOSSARY.md`
- Architecture index: `docs/architecture/README.md`
- Rules submodule: `rules/` (update via `git submodule update --init --recursive`)
- Prompt reference: `docs/PROMPT_REFERENCE.md`
- Migration log: `MIGRATION.md`

## CI/CD
- GitHub Actions workflows use `GuicedEE/Workflows/.github/workflows/projects.yml@master`.
- Required secrets: `USERNAME`, `USER_TOKEN`, `SONA_USERNAME`, `SONA_PASSWORD`, `GPG_PASSPHRASE`, `GPG_PRIVATE_KEY` (see workflow files).

## Architecture
- C4 + sequence + ERD diagrams live under `docs/architecture/` and reflect the component model, configurators, and event adapters.

## Support & contributions
- Issues: https://github.com/JWebMP/Core/issues
- License: Apache 2.0 (see `LICENSE`)
