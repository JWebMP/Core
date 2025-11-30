# GitHub Copilot Instructions — JWebMP Core

- Load project RULES: sections 4/5 of `rules/RULES.md`, Document Modularity Policy, and Forward-Only Change Policy.
- Follow documentation-first stages; Stage 1–3 docs exist (PACT, RULES, GUIDES, GLOSSARY, IMPLEMENTATION, architecture under `docs/architecture/`). Blanket approval is recorded for this run; still respect stage order.
- Do not write project docs inside `rules/` (submodule). Link to submodule topics instead.
- Stack: Java 25 + Maven; CRTP fluent APIs (no builders); Log4j2 logging; JSpecify nullness; GuicedEE + Vert.x + JWebMP Client.
- Use topic-first terminology from `GLOSSARY.md`; if WebAwesome is introduced, use WaButton/WaInput/WaCluster/WaStack naming.
- Prefer Mermaid for diagrams; Mermaid MCP endpoint available: https://mcp.mermaidchart.com/mcp.
