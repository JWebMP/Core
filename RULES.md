# Project RULES — JWebMP Core

Scope & Selection
- Language/Build: Java 25 LTS, Maven (`pom.xml`)
- Patterns: CRTP fluent APIs (no builders), JSpecify nullness, Log4j2 logging policy
- Frameworks: JWebMP Core + Client; GuicedEE Core/Client/Web with Vert.x bridge; Vert.x Web reactive runtime
- CI/CD: GitHub Actions (shared workflow), forward-only changes

Submodule Reference
- Rules repository is mounted at `rules/` (Git submodule). Project-specific docs live outside the submodule.
- Load enterprise anchors: `rules/RULES.md`, Document Modularity Policy, Forward-Only Change Policy.

Topic Index (follow links before implementing)
- Language/Build: `rules/generative/language/java/README.md`, `rules/generative/language/java/java-25.rules.md`, `rules/generative/language/java/build-tooling.md`
- Backend (GuicedEE): `rules/generative/backend/guicedee/README.md`, `rules/generative/backend/guicedee/client/README.md`, `rules/generative/backend/guicedee/web/README.md`, `rules/generative/backend/guicedee/vertx/README.md`, `rules/generative/backend/vertx/README.md`
- Backend (Logging/JSpecify): `rules/generative/backend/logging/README.md`, `rules/generative/backend/jspecify/README.md`
- Frontend (JWebMP): `rules/generative/frontend/jwebmp/README.md`, `rules/generative/frontend/jwebmp/client/README.md`
- Platform: `rules/generative/platform/ci-cd/README.md` (provider: `rules/generative/platform/ci-cd/providers/github-actions.md`), `rules/generative/platform/secrets-config/README.md`, `rules/generative/platform/observability/README.md`
- Architecture practices: `rules/generative/architecture/README.md`, `rules/generative/architecture/tdd/README.md`, `rules/generative/architecture/bdd/README.md`

Conventions
- Fluent API strategy: CRTP; return `(J) this` in setters and avoid Lombok builders.
- Logging: default Log4j2 (apply to examples/config); avoid other logging annotations unless specified.
- Docs-first: Stage 1–3 must be completed before code edits; blanket approval for this run noted in `PACT.md`.
- Terminology: Align with `GLOSSARY.md` (topic-first). Apply Prompt Language Alignment when using WebAwesome naming (WaButton/WaInput/WaCluster/WaStack) if that plugin is introduced later.
- Environment/config: Mirror keys in `.env.example` with `rules/generative/platform/secrets-config/env-variables.md`.

Traceability
- Cross-link PACT ↔ RULES ↔ GUIDES ↔ IMPLEMENTATION ↔ docs/architecture/.
- Host docs must not be stored in `rules/`.
