# Migration Notes — Forward-Only Updates

- Replaced legacy `README.md` with a concise, rules-aligned overview linking PACT/RULES/GUIDES/IMPLEMENTATION/GLOSSARY and architecture docs.
- Added docs/architecture/* (C4, sequences, ERD, data flow) and `docs/PROMPT_REFERENCE.md` to seed future prompts.
- Introduced `.env.example` for local configuration; secrets remain external.
- Added GitHub Actions workflow `./.github/workflows/maven-package.yml` referencing the shared GuicedEE workflow (kept existing `maven-publish.yml`).
- Added AI workspace guardrails (`.aiassistant/rules/`, `.github/copilot-instructions.md`) to enforce RULES sections 4/5, Document Modularity, and Forward-Only policy.
