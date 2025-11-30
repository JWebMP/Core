# GLOSSARY — JWebMP Core (Topic-First)

Glossary Precedence Policy
- Topic glossaries override root definitions within their scope; this file indexes topics and records Prompt Language Alignment mappings.
- Copy only enforced mappings locally; defer to topic files for detailed terminology.

Selected Topics
- Java 25: `rules/generative/language/java/GLOSSARY.md` — language/JVM/JPMS terms.
- JWebMP Client/Core: `rules/generative/frontend/jwebmp/client/GLOSSARY.md` — component model, rendering, client runtime terms.
- GuicedEE Core/Client/Web: `rules/generative/backend/guicedee/GLOSSARY.md`, `rules/generative/backend/guicedee/client/GLOSSARY.md`, `rules/generative/backend/guicedee/web/GLOSSARY.md`, `rules/generative/backend/guicedee/vertx/GLOSSARY.md`
- JSpecify: `rules/generative/backend/jspecify/GLOSSARY.md`
- Logging: use rule definitions in `rules/generative/backend/logging/README.md` (no dedicated glossary).
- Vert.x: follow terminology in `rules/generative/backend/vertx/README.md` (no dedicated glossary file).

Prompt Language Alignment (enforced)
- WebAwesome terms (if adopted later): WaButton, WaInput, WaCluster, WaStack — see `rules/generative/frontend/webawesome/README.md` for anchors; use these names instead of generic “button/input/row/column”.

Local Terms
- Component Tree: CRTP-based hierarchy rooted at `com.jwebmp.core.Component`, rendered to HTML/JS/CSS.
- Page Configurator: Service provider implementing `IPageConfigurator` that injects scripts/styles before render.
- Event Adapter: Classes under `com.jwebmp.core.events.*` that handle DOM-like events and integrate with host transport (AJAX/Vert.x).

Usage
- When unsure, open the topic glossary first; update this index only when new topics are selected.
- All docs (RULES/GUIDES/IMPLEMENTATION) should reference topics instead of redefining terms.
