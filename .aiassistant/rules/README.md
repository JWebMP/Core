# AI Assistant Pinned Rules (JWebMP Core)

- Honor RULES sections 4 (Behavioral) and 5 (Technical) plus Document Modularity and Forward-Only policies from `rules/RULES.md`.
- Documentation-first workflow: complete Stage 1–3 docs (PACT, architecture, RULES/GUIDES/GLOSSARY/IMPLEMENTATION) before code edits; blanket approval recorded for this run.
- Keep host docs outside `rules/` (submodule is read-only for project content).
- Apply CRTP fluent APIs (no builders) and Log4j2 logging defaults; align with Java 25 + Maven toolchain.
- Register Mermaid MCP server when generating diagrams: `https://mcp.mermaidchart.com/mcp`.
- Use topic-first terminology via `GLOSSARY.md`; apply WebAwesome Prompt Language Alignment if that plugin is later selected.
