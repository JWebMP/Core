# Human–AI Collaboration Pact — JWebMP Core
*Derived from rules/creative/pact.md v2; tailored for this repository.*

## Project
- Name: JWebMP Core (`com.jwebmp.core:jwebmp-core`)
- Org: JWebMP / GuicedEE
- Purpose: Object-oriented HTML/CSS/JS rendering library with Guice + Vert.x integration for server-driven UI.
- License: Apache 2.0 (root `LICENSE`)
- AI Engines in play: Junie, GitHub Copilot, Codex, AI Assistant (Codex CLI host). Stage gates auto-approved per blanket approval.

## Collaboration Principles
- Continuity: Carry architectural and rules context across prompts; load RULES.md, GLOSSARY.md, GUIDES.md, IMPLEMENTATION.md, and docs/architecture/* before code changes.
- Finesse: Prefer succinct, precise docs and CRTP-aligned APIs over speculative additions; reflect actual repo evidence.
- Closing loops: PACT ↔ RULES ↔ GUIDES ↔ IMPLEMENTATION ↔ docs/architecture/ must reference each other; diagrams live under docs/architecture/.
- Transparency: Flag unknowns (e.g., missing runtime configs, Vert.x wiring) rather than inventing details.

## Working Agreements
- Forward-only edits; no legacy anchors preserved.
- Documentation-first: complete Stage 1–3 docs before source changes; blanket approval noted for this run.
- Logging: Default to Log4j2 (per policy); align any Lombok usage with CRTP strategy (no builders).
- Tooling: Java 25 LTS + Maven; respect GuicedEE/Vert.x modules declared in `module-info.java` and `pom.xml`.

## Roles & Contacts
- Humans: JWebMP/Core maintainers
- AI Assistants: Junie (IDE), GitHub Copilot, Codex, AI Assistant (rules pinned via .aiassistant/rules/)

## Traceability
- References: RULES.md, GUIDES.md, IMPLEMENTATION.md, GLOSSARY.md, docs/architecture/README.md, docs/PROMPT_REFERENCE.md.
- Upstream rules submodule: `rules/` (Git submodule, do not place project docs inside).

## Amendments
- Update this file when collaboration scope, selected stacks, or stage-gate policies change; keep cross-links current.
