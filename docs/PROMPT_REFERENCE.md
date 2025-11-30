# Prompt Reference — JWebMP Core

Use this file to seed future prompts. Load alongside `PACT.md`, `RULES.md`, `GUIDES.md`, `IMPLEMENTATION.md`, and `docs/architecture/README.md` before generating changes.

## Selected Stacks & Policies
- Language: Java 25 LTS, Maven build (per `pom.xml`)
- Patterns: CRTP fluent API (no @Builder), Log4j2 logging policy, JSpecify nullness, Forward-Only change policy
- Frameworks: JWebMP Core + Client; GuicedEE Core/Client/Web; Vert.x Web; Logging
- CI/CD: GitHub Actions (shared workflow via GuicedEE/Workflows)
- AI Engines: Junie, GitHub Copilot, Codex, AI Assistant (Mermaid MCP available at https://mcp.mermaidchart.com/mcp)
- Stage Gates: Blanket approval for this run; still document stage transitions.

## Key Artifacts
- PACT: `PACT.md`
- Rules: `RULES.md` (links to `rules/` submodule)
- Guides: `GUIDES.md`
- Implementation: `IMPLEMENTATION.md`
- Glossary: `GLOSSARY.md` (topic-first)
- Architecture Index: `docs/architecture/README.md`
  - C4 Context: `docs/architecture/c4-context.md`
  - C4 Container: `docs/architecture/c4-container.md`
  - C4 Component: `docs/architecture/c4-component-rendering.md`
  - Sequences: `docs/architecture/sequence-render.md`, `docs/architecture/sequence-event.md`
  - ERD: `docs/architecture/erd-core.md`

## Glossary Composition Policy
- Topic-first: prefer topic glossaries from the rules submodule (e.g., Java, JWebMP client, GuicedEE, Vert.x, Logging, JSpecify).
- Precedence: topic glossary definitions override root for their scope; root GLOSSARY.md indexes and notes Prompt Language Alignment (e.g., WebAwesome naming if used).

## Traces
- Ensure PACT ↔ RULES ↔ GUIDES ↔ IMPLEMENTATION cross-link to architecture diagrams above.
- Keep project docs outside `rules/` (submodule is read-only for host docs).
