# GUIDES — How to Apply the Rules

Load RULES.md and topic docs before implementation. Key guides for this stack:

Language & Build
- Java 25 patterns: `rules/generative/language/java/README.md`, `rules/generative/language/java/java-25.rules.md`
- Maven integration: `rules/generative/language/java/build-tooling.md`

Frontend (JWebMP)
- Component/rendering guide: `rules/generative/frontend/jwebmp/README.md`
- Client runtime specifics (AJAX, Vert.x bridges, logging, nullness): `rules/generative/frontend/jwebmp/client/README.md`

Backend (GuicedEE + Vert.x)
- Core setup and DI patterns: `rules/generative/backend/guicedee/README.md`
- Client-side services: `rules/generative/backend/guicedee/client/README.md`
- Web layer guidance: `rules/generative/backend/guicedee/web/README.md`
- Vert.x bridge rules (required with Core): `rules/generative/backend/guicedee/vertx/README.md`, `rules/generative/backend/vertx/README.md`
- Nullness and type safety: `rules/generative/backend/jspecify/README.md`
- Logging policy: `rules/generative/backend/logging/README.md`

Platform & Delivery
- CI/CD provider: `rules/generative/platform/ci-cd/providers/github-actions.md`
- Secrets/env: `rules/generative/platform/secrets-config/README.md` and `env-variables.md`
- Observability baseline: `rules/generative/platform/observability/README.md`

Architecture & Quality
- Architecture practices: `rules/generative/architecture/README.md`
- Testing approaches: `rules/generative/architecture/tdd/README.md`, `rules/generative/architecture/bdd/README.md`

API Surface Sketch (current code evidence)
- Component tree built from `com.jwebmp.core.Component` and HTML element subclasses; CRTP setters return `(J)this`.
- Services exposed via `IPageConfigurator`, `IGuiceModule`, `IGuicePreStartup`, and event service interfaces listed in `module-info.java`.
- Service providers registered under `src/main/resources/META-INF/services`.

Test Strategy Outline
- Favor TDD/BDD from the linked guides; reuse existing JUnit suites under `src/test/java` for regression.
- Validate JPMS exports/uses/provides align with GuicedEE modules; add nullness checks per JSpecify rules.
- For Vert.x integration, include lightweight handler tests (unit) and optional integration smoke tests (disabled by default) using env toggles from `.env.example`.

Acceptance Criteria (Docs Phase)
- RULES/GUIDES/IMPLEMENTATION reference selected stacks and architecture diagrams.
- Glossary precedence documented; Prompt Language Alignment honored when applicable.
- CI plan aligned to GitHub Actions shared workflow; env keys enumerated.

Migration Notes (Doc Model)
- Treat legacy READMEs as superseded; new modular docs live at the root and under `docs/architecture/`.
- No project-specific docs reside in `rules/`; all links target the submodule for rules content.

Tracing & Diagrams
- Architecture index: `docs/architecture/README.md` (C4, sequences, ERD).
- Ensure GUIDE usage links back to `IMPLEMENTATION.md` once updated.
