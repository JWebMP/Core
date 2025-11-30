# IMPLEMENTATION — Plan and Traceability (Pre-Code)

Current Layout (evidence)
- Module: `com.jwebmp.core` (JPMS). Exports component, CSS, event, utilities, implementations packages; uses/provides GuicedEE and event services (`module-info.java`).
- Dependencies: GuicedEE BOMs, Vert.x Web, Guice, Jackson, Apache Commons (from `pom.xml`).
- Service providers: `src/main/resources/META-INF/services/*` for regex patterns, page configurators, lifecycle hooks.
- Tests: Extensive JUnit suites under `src/test/java/com/jwebmp/test/...`.
- CI: `.github/workflows/maven-publish.yml` uses GuicedEE shared workflow; `.github/workflows/maven-package.yml` added for baseline builds.
- Env scaffolding: `.env.example` added for local/dev defaults.

Planned Changes (Stage 4)
- Docs: Keep PACT/RULES/GUIDES/GLOSSARY/IMPLEMENTATION aligned; back-link to `docs/architecture/README.md` and `docs/PROMPT_REFERENCE.md`.
- README: Replace legacy content with adoption notes, links to rules submodule, docs, and CI/env expectations.
- Env: Add `.env.example` using keys from `rules/generative/platform/secrets-config/env-variables.md` with local defaults.
- CI: Add `.github/workflows/maven-package.yml` referencing GuicedEE shared workflow (per required snippet); retain existing workflow unless deprecated.
- AI workspace: Add `.aiassistant/rules/`, `.github/copilot-instructions.md` (Codex/Copilot); register Mermaid MCP.
- Migration tracking: Document removals/forward-only changes in `MIGRATION.md` if needed.

Build/Annotation/CI Plan
- Maven build remains authoritative; no plugin changes planned in this iteration.
- Ensure JPMS exports match GuicedEE/Vert.x rules; avoid Lombok builders (CRTP).
- GitHub Actions workflow uses `GuicedEE/Workflows/.github/workflows/projects.yml@master` with required secrets.

Rollout & Risks
- Risk: Legacy README content may conflict with new forward-only docs—replace and note in migration log.
- Risk: Missing environment values for Vert.x/GuicedEE runtime; `.env.example` provides placeholders but host apps must supply secrets.
- Risk: Submodule drift—document `git submodule update --init --recursive` in README.

Validation Approach
- Documentation completeness check: links resolve to submodule topics and architecture diagrams.
- Build sanity (optional post-doc): `mvn -q -DskipTests package` once code changes resume.
- Review JPMS/service loader wiring against `module-info.java` and `META-INF/services`.

Cross-Links
- Rules: `RULES.md`
- Guides: `GUIDES.md`
- Glossary: `GLOSSARY.md`
- Architecture: `docs/architecture/README.md`
- Prompt reference: `docs/PROMPT_REFERENCE.md`
