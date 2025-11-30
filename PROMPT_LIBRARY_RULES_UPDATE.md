# 🧰 Starter Prompt — Library Rules Update (Framework/Component Libraries)

Ask your AI tool to copy this template and align with the Rules Repository whenever you maintain a library (e.g., UI Kits, etc) and need to update or (re)create its rules, indexes, and guides. This drives a forward-only, modular documentation model and ensures host projects can navigate component/topic rules easily.

Supported: Junie, AI Assistant, GitHub Copilot Chat, Cursor, ChatGPT, Claude, Roo, Codex.

---

## 0) Provide Inputs
Fill before running.

- Library name: JWebMP Core
- Current/new version: <VERSION>
- Repository URL / path: https://github.com/JWebMP/Core.git
- Rules Repository Location: generative/frontend/jwebmp/core
- Short description: An Object-Orientated HTML Renderer that utilizes pure java to render HTML, CSS and JS
- Type:
  - [ ] UI component library
  - [ ] Data/ORM
  - [X] Service/Framework
  - [ ] Other: <OTHER>

- Stage approvals preference for this run (controls STOP gates)
  - Choose exactly one:
    - [ ] Require explicit approval at each stage (default)
    - [ ] Approvals are optional; proceed with documented defaults if no reply
    - [X] Blanket approval granted for this run (no STOPs)

- AI engine used:
  - [X] Junie
  - [X] GitHub Copilot
  - [ ] Cursor
  - [ ] ChatGPT
  - [ ] Claude
  - [ ] Roo
  - [X] Codex
  - [X] AI Assistant
  - Note: Select every engine participating in the release and ensure rules/templates are configured for each.
    - AI Assistant consumes rules from `.aiassistant/rules/`; replicate enforced policies there.

- Architecture:
  - [x] Specification-Driven Design (SDD) (mandatory)
  - [x] Documentation-as-Code (mandatory)
  - [ ] Monolith
  - [ ] Microservices
  - [ ] Micro Frontends
  - [ ] DDD
  - [ ] TDD (docs-first, test-first)
  - [ ] BDD (docs-first, executable specs)
- Language selection (configure here)
  - Languages
    - Java (choose exactly one LTS)
      - [ ] Java 17 LTS
      - [ ] Java 21 LTS
      - [X] Java 25 LTS
    - Web
      - [ ] TypeScript
        - [ ] Angular (TypeScript)
        - [ ] React (TypeScript)
          - [ ] Next.js (TypeScript)
        - [ ] Vue (TypeScript)
          - [ ] Nuxt (TypeScript)
      - [ ] JavaScript
    - Kotlin
      - [ ] Kotlin
      - [ ] Ktor (requires Kotlin)
    - Other: <OTHER_LANGUAGES>
  - Build engines
    - Java/Kotlin builds
      - [X] Maven
      - [ ] Gradle (Groovy DSL)
      - [ ] Gradle (Kotlin DSL)
      - [ ] Apache Ivy
    - Web builds
      - [ ] npm / package.json scripts
      - [ ] pnpm
      - [ ] yarn
      - [ ] Babel (transpile configuration lives in package.json/babel.config.*)
    - Other build tooling: <OTHER_BUILDS>
  - Dependency declarations
    - JVM: document artifact coordinates only (groupId:artifactId:version); detailed build configuration belongs in build-tooling topics.
    - JavaScript/Web: document package names + versions (npm/pnpm/yarn/Babel) and leave script wiring to language/build guides.

- Component/topic areas (list): JWebMP Client rendering, GuicedEE Core/Client/Web integration, Logging, JSpecify, GitHub Actions CI
- Fluent API Strategy (choose exactly one):
  - [X] CRTP
  - [ ] Builder pattern (Lombok @Builder/manual)
- Backend Reactive:
  - Core stacks:
    - [ ] Vert.x 5 — ./generative/backend/vertx/README.md
    - [ ] Hibernate Reactive 7 — ./generative/backend/hibernate/README.md
  - Quarkus:
    - [ ] Core project setup
    - [ ] RESTEasy Reactive APIs
    - [ ] Persistence (Hibernate/Panache)
    - [ ] Reactive messaging
    - [ ] Security/OIDC
    - [ ] Dev Services & local tooling
    - [ ] Native build & packaging
    - [ ] Testing strategy
    - Note: Quarkus currently embeds Vert.x 4; pick Vert.x 5 only for direct Vert.x API usage.
    - GuicedEE:
      - [X] Core
      - [X] Client
      - [X] Web
      - [ ] WebSocket
      - [ ] Rest
      - [ ] Persistence
      - [ ] RabbitMQ
      - [ ] Cerial
      - [ ] OpenAPI
      - [ ] Sockets
      - Note: If Core is selected, also select Vert.x 5 and include GuicedEE Vert.x Bridge rules (rules/generative/backend/guicedee/vertx/README.md); if Persistence is selected, also select Hibernate Reactive 7 and link rules/generative/backend/guicedee/persistence/README.md.
- Backend:
  - Spring MVC
    - [ ] Core MVC/Web
    - [ ] Validation (Bean Validation)
    - [ ] Data JPA (Hibernate ORM)
    - [ ] Security (non-reactive)
    - [ ] Actuator (ops endpoints)
    - [ ] OpenAPI (springdoc)
    - [ ] Micrometer/Tracing (OTel exporters optional)
    - [ ] Caching
    - [ ] Scheduling & Async
    - [ ] Batch
    - [ ] Mail
    - [ ] Messaging
    - Database migrations:
      - [ ] Flyway
      - [ ] Liquibase
    - [ ] Testing
    - [ ] Packaging & Deployment
  - JDBC Databases:
    - [ ] PostgreSQL
    - [ ] MySQL
    - [ ] Oracle
    - [ ] MSSQL
    - [ ] MariaDB
    - [ ] IBM DB2
    - [ ] SQLite
    - [ ] Other: <DB_OTHER>
- Structural:
  - [ ] MapStruct
  - [ ] Lombok
  - [X] Logging
  - [X] JSpecify
- Testing & Coverage:
  - [ ] Jacoco
  - [ ] SonarQube
  - [ ] Java Micro Harness
  - [ ] Cypress
  - [ ] BrowserStack
- Frontend (Standard):
  - [ ] Web Components
- Frontend (Reactive):
  - Angular (choose exactly one)
    - [ ] Angular 17
    - [ ] Angular 19
    - [ ] Angular 20
  - Other frameworks
    - [ ] React
      - [ ] Next.js
    - [ ] Vue
      - [ ] Nuxt
- Frontend (Angular Plugins):
  - [ ] Angular Awesome
- Frameworks (JWebMP):
  - [ ] Core
  - [X] Client
  - [ ] WebAwesome
- Security/Auth Providers:
  - [ ] OpenID Connect (generic)
  - [ ] GCP (IAP/OIDC)
  - [ ] Firebase Auth
  - [ ] Microsoft Entra ID (Azure AD)
- CI/CD Providers:
  - [X] GitHub Actions
  - [ ] GitLab CI
  - [ ] Jenkins
  - [ ] TeamCity
  - [ ] Google Cloud Build
  - [ ] Azure Pipelines
  - [ ] AWS CodeBuild/CodePipeline
- Observability/Diagnostics:
  - [ ] Wireshark
- Release impact:
  - [x] Forward-only (breaking changes allowed)
  - [ ] Backcompat required (only if explicitly demanded)

Policies (must honor):
- Reset the AI context before running this template—act as if this is the first prompt for the project and do not reuse prior session memory.
- Treat all existing repository documentation as out-of-date; never rely on it as a source of truth. When executing this template, reference only the current checked-in code/config you observe.
- Honor the selected Java LTS (Java 25) everywhere—examples, diagrams, and coordinates must target Java 25; do not substitute another version.
- Follow RULES.md sections: 4 (Behavioral), 5 (Technical), Document Modularity Policy, 6 (Forward-Only Change Policy).
- Use Markdown for docs. Keep library docs in this repository (outside any Rules Repository submodule).
- Documentation fidelity: describe the actual library code/config you observe; do not invent architecture or rename components without evidence—surface unknowns explicitly.
- Logging policy: Default to Log4j2; wire logging/config/examples against Log4j2. If Lombok is selected, use Lombok's `@Log4j2` annotation (avoid other Lombok logging annotations).
- Generated artifacts are read-only; do not propose edits to compiled outputs (e.g., TS/HTML/site bundles). For JWebMP specifically, do not generate or reference separate TS/HTML components for missing views—render dialogs/tables directly from Java components/cell renderers.
- In JWebMP, avoid inline string HTML; express markup using JWebMP components (Div, Paragraph, Span, Table, H1–H6, etc.).
- PostgreSQL (JPMS): Do not shade the driver. Use GuicedEE Services artifacts (com.guicedee.services:postgresql) and require org.postgresql in module-info.java.
- For component-driven topics, provide a parent README index that links to each component .rules.md or subsection anchors.
- Fluent API Strategy: Choose either CRTP or Builder. CRTP is enforced if GuicedEE or JWebMP is selected. Align Lombok usage accordingly:
  - If CRTP: do not use @Builder; implement manual CRTP fluent setters returning (J)this with @SuppressWarnings("unchecked") as needed.
  - If Builder: prefer Lombok @Builder or manual builders; do not apply CRTP chaining rules.
- Glossary policy (topic-first): Provide and maintain a topic-scoped GLOSSARY.md for your library with minimal canonical terms and “LLM interpretation guidance”. Avoid duplicating definitions in host projects. Host projects compose their root GLOSSARY.md by linking to your topic GLOSSARY.md and copying only enforced Prompt Language Alignment mappings (e.g., WebAwesome names); all other terms should be linked to your topic files/anchors.
- **Sandbox awareness / Pact note** — Record in PACT that host artifacts stay at the repo root or `docs/`. When a release is finalized, update the canonical rules under `rules/frontend/angular-awesome` (the ruleset this library maintains) and limit writes inside the Rules Repository to `repository/frontend/angular-awesome`; never modify other directories in the rules repo.

---

## Documentation-First, Stage-Gated Workflow (Mandatory)

- This repository enforces a documentation-first, stage-gated process for all AI systems (Junie, Copilot, Cursor, ChatGPT, Claude, Roo, Codex).
- The AI MUST NOT write or modify source code until documentation phases are completed and explicitly approved by the user.
- Stage approvals default to user review checkpoints; the user may explicitly waive these STOP gates or grant blanket approval, after which you may proceed while documenting the opt-out.
- Junie exception: If Junie is the active AI engine, never pause for stage approvals; treat each stage as auto-approved while noting Junie’s no-review policy.

Stage 1 — Architecture & Foundations (Docs only)
- Deliver:
  - Library scope statement and architecture overview; ADRs/C4 where appropriate
  - Sequence diagrams for core component lifecycles and integration flows
  - Data/interaction flow diagrams; threat model summary and trust boundaries
  - Dependency/integration map (internal/external, peer libs, generators)
  - Glossary composition plan (topic-first, precedence and anchors)
- Output format: Markdown docs placed in the library repo’s docs (outside rules/), with links to enterprise rules indexes.
- STOP (user review optional): Offer a review/approval checkpoint before Stage 2. Continue without waiting only if the user has opted out or granted blanket approval.

Stage 2 — Rules/Guides Design (Docs only)
- Deliver:
  - Parent topic README index and modular rules skeletons (docs only)
  - RULES mapping to selected stacks; GUIDES with “how to apply” steps
  - API surface sketches/contracts (where relevant), examples plan, testing strategy
  - Migration/Release notes outline and breaking change summary (if forward-only)
- STOP (user review optional): Offer a review/approval checkpoint before Stage 3. Continue without waiting only if the user has opted out or granted blanket approval.

Stage 3 — Implementation Plan (No code yet)
- Deliver:
  - File and module tree plan for rules/docs; lint/link-check plan
  - CI/docs publishing plan (if applicable); versioning/release steps
  - Rollout plan (phased), risk items, validation approach
- STOP (user review optional): Offer a review/approval checkpoint before Stage 4. Continue without waiting only if the user has opted out or granted blanket approval.

Stage 4 — Implementation (Docs and/or Code allowed)
- Scope: Only after explicit approval unless the user has already waived stage approvals or granted blanket approval for the run.
- Approach: Generate minimal, reviewable changes per module. After each step, present diffs and validation, then ask to continue.

Universal STOP rule
- If the user requires staged approvals and approval is not granted, revise docs; if the user waived staged approvals, continue but be ready to revise when feedback arrives.
- Each stage must close loops via links: PACT ↔ GLOSSARY ↔ RULES ↔ GUIDES ↔ IMPLEMENTATION.

### Stage Gate Interaction Protocol (Non-blocking, with defaults)
- At every STOP gate, present the following options block verbatim (replace N with the current stage):

  Options:
  - 1) Approve Stage N → proceed to Stage N+1
  - 2) Request changes to Stage N (specify what to adjust)
  - 3) Skip approval for this stage and proceed (recorded as optional approval)
  - 4) Pause here (do not proceed)

- Retry/fallback:
  - If blanket approval is selected: proceed automatically and note that gates were skipped by policy.
  - If approvals are optional: show options once, send one reminder if no reply, then proceed with option 3 and record the default. Do not attempt more than twice.
  - If explicit approval is required: show options, send one reminder if no reply, then stop at the gate with a concise summary. Do not attempt more than twice.

## 1) Self‑Configure the AI Engine
- Pin ./RULES.md anchors (sections above). Operate in forward-only mode.
- AI workspace files (selected engines):
  - AI Assistant: ensure `.aiassistant/rules/` exists with a pinned summary of RULES.md sections 4/5, Document Modularity, and Forward-Only; keep it synchronized with the host RULES.md.
  - GitHub Copilot: add `.github/copilot-instructions.md` (or workspace note) with the same constraints and STOP-gate policy.
  - Cursor: add `.cursor/rules.md` with the same constraints (may share content with Copilot if both are selected).
- MCP servers (per selected AI engine):
  - If the chosen assistant supports MCP (e.g., Cursor, Claude Desktop, MCP-capable IDEs), register the servers before running the prompt.
  - Always register the Mermaid MCP server for docs/diagrams: HTTP `https://mcp.mermaidchart.com/mcp` (`"type": "http"`) or SSE `https://mcp.mermaidchart.com/sse` (`"type": "sse"`).
  - Confirm in responses which MCP servers are active so registration aligns with the AI engine selections.
- If ChatGPT/Claude:
  - Start with system note: "Follow Rules Repository RULES.md sections 4,5, Document Modularity, and 6 (forward-only). Close loops across artifacts."
  - Owner mode (this Rules Repository repository is the active workspace; not used as a submodule):
    - Do not refer to this repository as a submodule.
    - Load and pin ./skills.md; use project-scoped Skills under .claude/skills/.
  - Host project mode (a downstream project consuming these rules):
    - Use this repository as a Git submodule and link to it from host artifacts.
  - For Claude specifically: load and pin ./skills.md; discover project Agent Skills under .claude/skills/ (auto-discovered by Claude Code); acknowledge which Skills are active and apply them throughout generation.
- For Codex CLI (Codex agent):
  - Load ./RULES.md anchors plus README context; confirm forward-only and Document Modularity constraints are pinned in the Codex CLI workspace.
  - Follow Codex CLI harness instructions: run shell commands with `bash -lc` and explicit `workdir`, prefer `rg` for scans, honor sandbox/approval settings, and use the plan tool for multi-step work.
- If Roo, load and pin ROO_WORKSPACE_POLICY.md at the repository root. If it does not exist, create it with a summary of RULES.md sections 4,5, Document Modularity Policy, and 6 (Forward-Only). Ensure repo-scoped conversations, include file paths in responses, and confirm forward-only mode is enabled. Update all references affected by a change in the same forward-only change set.

Language Selection (configure here)
- Languages
  - Java (choose exactly one LTS)
    - [ ] Java 17 LTS
    - [ ] Java 21 LTS
    - [ ] Java 25 LTS
  - Web
    - [ ] TypeScript
      - [ ] Angular (TypeScript)
      - [ ] React (TypeScript)
        - [ ] Next.js (TypeScript)
      - [ ] Vue (TypeScript)
        - [ ] Nuxt (TypeScript)
    - [ ] JavaScript
  - Kotlin
    - [ ] Kotlin
    - [ ] Ktor (requires Kotlin)
  - Other: <OTHER_LANGUAGES>

Language selection → generation rules
- If Java 17/21/25 is selected:
  - Apply the corresponding LTS rules and toolchains (link to the selected: rules/generative/language/java/java-17.rules.md, rules/generative/language/java/java-21.rules.md, or rules/generative/language/java/java-25.rules.md).
  - Include build integration via rules/generative/language/java/build-tooling.md.
  - When Maven, Gradle (Groovy/Kotlin DSL), or Apache Ivy is selected, document artifact coordinates only (groupId:artifactId:version) and rely on build-tooling.md for plugin/configuration wiring.
- If Web → TypeScript is selected:
  - Include language rules link: rules/generative/language/typescript/README.md.
  - If Angular is also selected: include rules/generative/language/angular/README.md and scaffold Angular app structure when requested.
  - If React is also selected: include rules/generative/language/react/README.md and scaffold React app structure when requested.
  - If React → Next.js is selected: include rules/generative/frontend/nextjs/README.md and apply App Router guidance.
  - If Vue is also selected: include rules/generative/language/vue/README.md and scaffold Vue app structure when requested.
  - If Vue → Nuxt is selected: include rules/generative/frontend/nuxt/README.md and follow Nuxt SSR/SSG rules.
  - When npm, pnpm, yarn, or Babel is selected, list package@version dependencies only; defer bundler/transpiler configuration to the TypeScript/JS build guides.
- If Kotlin is selected:
  - Include language rules link: rules/generative/language/kotlin/README.md.
  - If Ktor is also selected, scaffold a minimal Ktor service module and wire guides accordingly.

---

## 2) Library Documentation Tasks
Perform as a single, forward-only change set. The exact target paths depend on your library repo structure (e.g., docs/, guides/, or packages/<lib>/docs/). Do NOT put library-specific docs inside the Rules Repository submodule directory.

1. Topic index (parent README)
   - Create or update a topic index README for this library’s rules directory.
   - For UI libraries (e.g., WebAwesome):
     - Index each component with links to ./<component>.rules.md
     - If a component is documented as a subsection, add direct anchors (e.g., input.rules.md#number-input)
   - For non-UI libraries (e.g., EntityAssist):
     - Index modular topics (e.g., Entities, Repositories, Transactions, Testing, Anti-patterns)

2. Modularize content
   - Split monolithic docs into smaller modular files focused on a single topic/area.
   - Use kebab-case filenames; for components, use <component>.rules.md; for guides, prefer concise overviews.
   - Remove obsolete monoliths (no legacy anchors) and update all references per Forward-Only policy.

3. Rules templates (components)
   - For each component/topic, create a .rules.md with:
     - Overview and purpose
     - Usage patterns and minimal examples
     - Inputs/outputs/events (for UI)
     - Styling/theming (for UI) or configuration (for non-UI)
     - Accessibility (UI) or performance/constraints (non-UI)
     - See-also links (index, related rules)

4. Cross-links to enterprise topics
- Link to relevant Rules Repository indexes in your README to aid host projects:
- Frontend (Standard):
  - Web Components: rules/generative/frontend/webcomponents/README.md
  - WebAwesome: rules/generative/frontend/webawesome/README.md
  - JWebMP: rules/generative/frontend/jwebmp/README.md
  - JWebMP Client library: rules/generative/frontend/jwebmp/client/README.md
  - Frontend (Reactive):
    - Angular: rules/generative/language/angular/README.md
    - Angular Awesome (Angular 19+ plugin): rules/generative/frontend/angular-awesome/README.md
    - React: rules/generative/language/react/README.md
    - Next.js (App Router): rules/generative/frontend/nextjs/README.md
    - Vue: rules/generative/language/vue/README.md
    - Nuxt: rules/generative/frontend/nuxt/README.md
  - Backend:
    - Hibernate (ORM/Reactive): rules/generative/backend/hibernate/README.md
    - Quarkus: rules/generative/backend/quarkus/README.md
    - GuicedEE Websockets: rules/generative/backend/guicedee/websockets/README.md
    - GuicedEE Persistence: rules/generative/backend/guicedee/persistence/README.md
  - Platform:
    - CI/CD: rules/generative/platform/ci-cd/README.md
      - If CI/CD Providers are selected, also link provider docs:
        - GitHub Actions — rules/generative/platform/ci-cd/providers/github-actions.md
        - GitLab CI — rules/generative/platform/ci-cd/providers/gitlab-ci.md
        - Jenkins — rules/generative/platform/ci-cd/providers/jenkins.md
        - TeamCity — rules/generative/platform/ci-cd/providers/teamcity.md
        - Google Cloud Build — rules/generative/platform/ci-cd/providers/google-cloud-build.md
        - Azure Pipelines — rules/generative/platform/ci-cd/providers/azure-pipelines.md
        - AWS CodeBuild/CodePipeline — rules/generative/platform/ci-cd/providers/aws-codebuild-codepipeline.md
    - Platform Observability: rules/generative/platform/observability/README.md
    - Platform Security & Auth: rules/generative/platform/security-auth/README.md
    - Env variables: rules/generative/platform/secrets-config/env-variables.md
  - Architecture: rules/generative/architecture/README.md (e.g., ddd/README.md, microfronts/README.md, tdd/README.md, bdd/README.md)
  - Data:
    - rules/generative/data/README.md
    - rules/generative/data/activity-master/README.md

5. Versioning and release notes
   - If rules reorganization is breaking (likely under forward-only), prepare RELEASE_NOTES.md summarizing changes.
   - Update CHANGELOG.md and bump version appropriately.

6. README (library root) updates
- Add “How to use these rules” section pointing to your topic index and to the Rules Repository submodule usage.
- Add “Prompt Language Alignment & Glossary” note:
  - Link to your library’s topic GLOSSARY.md and state that it is the authoritative, minimal glossary for this topic with LLM interpretation guidance (topic-first).
  - List any enforced aligned names (if applicable) and instruct host projects to copy only those into their root GLOSSARY.md; for all other terms, host projects should link back to your topic GLOSSARY.md/rules instead of duplicating definitions.

7. AI workspace alignment (selected engines)
   - AI Assistant — `.aiassistant/rules/` with RULES.md sections 4/5, Document Modularity, and Forward-Only.
   - GitHub Copilot — `.github/copilot-instructions.md` (or workspace note) covering the same constraints and STOP-gate policy.
   - Cursor — `.cursor/rules.md` mirroring the same constraints.
   - Roo — ROO_WORKSPACE_POLICY.md present/pinned if Roo is selected.
---

## 3) Special Guidance by Library Type
- WebAwesome (UI components)
  - Ensure parent README index exists and includes components such as button.rules.md, input.rules.md (with #number-input anchor), etc.
  - Enforce prompt language alignment in docs and examples: use WebAwesome component names when prompting and naming (e.g., WaButton, WaIconButton, WaInput, WaCluster for rows, WaStack for columns/stacks). Link to generative/frontend/webawesome/README.md → “Prompt Language Alignment”.
  - For new components, add <name>.rules.md and update the index.
- JWebMP wrappers
  - Provide wrapper-specific rules where needed; link to underlying WebAwesome or Web Component contracts.
  - If the JWebMP Client library is selected, include the JWebMP Client topic index (rules/generative/frontend/jwebmp/client/README.md) and its subtopics (configuration/JPMS, interception, rendering, reactive, logging, nullness, examples).
- EntityAssist / ORM-like libraries
  - Provide modular rules for entities, repositories, transactions, testing, threading, and anti-patterns.
- Service/Framework libraries
  - Provide modular rules for lifecycle, configuration, extension points, and integration examples.

---

## 4) Output Checklist
- [ ] Stage 1 (Architecture & Foundations) docs produced; capture user approval if they require the STOP gate
- [ ] Stage 2 (Rules/Guides Design) docs produced; capture user approval if they require the STOP gate
- [ ] Stage 3 (Implementation Plan) produced; capture user approval if they require the STOP gate
- [ ] Stage 4 (Implementation) executed only after explicit approval unless the user granted blanket approval; diffs presented with validation and links
- [ ] Parent topic README index created/updated with full component/topic coverage
- [ ] Modular .md files created and linked; monoliths removed per Forward-Only policy
- [ ] Component .rules.md files created/updated with usage, patterns, and see-also links
- [ ] Cross-links to Rules Repository topic indexes included
- [ ] Fluent API Strategy declared (CRTP vs Builder) and reflected in library rules/examples; Lombok usage aligned to selection
- [ ] Topic GLOSSARY.md created/updated (topic-first, minimal duplication) with LLM interpretation guidance; README includes “Prompt Language Alignment & Glossary” note linking to it
- [ ] Release notes and version bump prepared (if applicable)
- [ ] Root README updated with navigation and usage instructions
- [ ] MCP servers registered for selected assistants (Mermaid MCP for docs/diagrams) and acknowledged in outputs
- [ ] AI workspace files committed for selected engines (.aiassistant/rules/, .github/copilot-instructions.md, .cursor/rules.md, ROO_WORKSPACE_POLICY.md if Roo)
- [ ] All links resolve

---

## 5) Guardrails
- No backwards compatibility stubs unless explicitly required; apply Forward-Only Change Policy fully.
- Keep library docs in the library repo (outside any Rules Repository submodule).
- Close loops: indexes ↔ rules files ↔ examples/implementations.

---

## 6) AI Response Format (Stage-Gated)
1) Stage N deliverables (docs or plans only until Stage 4), with file paths and working links
2) Open questions, decisions required, risks
3) STOP — Render the standardized options block (see Stage Gate Interaction Protocol). Respect the Stage approvals preference from Inputs.
   - If approvals are optional and no reply is received after one reminder, proceed with option 3 and record the default.
   - If explicit approval is required and still no reply after one reminder, stop and summarize how to resume; do not retry more than twice.
   - If blanket approval is set, skip STOP sections but record that the gate was auto-approved by policy.
4) If approval is required and granted, provide the next-stage plan; if not granted, revise and re-submit Stage N; if the user opted out or blanket approval applies, continue with the next-stage plan

End of prompt.
## Diagrams and Docs-as-Code Policy (Mandatory)

Purpose
- Libraries using the Rules Repository must be documented with architecture diagrams and technical flows that are reviewable by humans and consumable by AI.
- These documents are first-class, version-controlled artifacts and are referenced by this and all future prompts/actions on the library.

Required artifacts (Docs-as-Code)
- C4 Architecture (text-based)
  - Level 1 (Context): ecosystem position of the library, upstream/downstream integrations
  - Level 2 (Container): major modules/packages, processors/generators, entrypoints
  - Level 3 (Component): key components (e.g., annotation processors, renderers, adapters)
  - Optional Level 4 (Code): only for deep internals that benefit consumers
- Sequence Diagrams
  - Core flows (e.g., build-time processing, runtime lifecycle, integration hooks)
  - Include async boundaries (gradle/maven tasks, processors order, event buses)
- ERDs or Schemas
  - If the library persists or generates schema: core entities/DTOs and relationships
  - Ownership/bounded contexts and supported compatibility ranges
- Deployment/Distribution
  - Publishing flow, artifacts, JPMS modules, supported runtimes

Format and storage (Docs as Code)
- Use text formats that diff well:
  - Mermaid (preferred) fenced blocks (```mermaid)
  - PlantUML (.puml) or fenced blocks (```plantuml)
  - Mermaid MCP server is available to assist with architecture and diagrams: HTTP endpoint `https://mcp.mermaidchart.com/mcp` with `"type": "http"`; SSE endpoint `https://mcp.mermaidchart.com/sse` with `"type": "sse"`.
- Storage conventions (in the library repository, outside rules/):
  - docs/architecture/README.md — index of all diagrams
  - docs/architecture/c4-context.md — C4 L1
  - docs/architecture/c4-container.md — C4 L2
  - docs/architecture/c4-component-<area>.md — C4 L3 files
  - docs/architecture/sequence-<flow>.md — sequences
  - docs/architecture/erd-<domain>.md — ERDs/schemas
  - Optional rendered images under docs/architecture/img/ derived from sources; do not commit images without their sources
- Version control mandate
  - Commit diagram sources (Mermaid/PlantUML). Images never replace sources.

Prompt seeding and traceability
- Create docs/PROMPT_REFERENCE.md that:
  - Records selected stacks, supported versions, and glossary composition (topic-first precedence)
  - Links to all diagrams under docs/architecture/
  - Is referenced by future prompts for this library; AI must load and honor it
- Close the documentation loop: PACT ↔ GLOSSARY ↔ RULES ↔ GUIDES ↔ IMPLEMENTATION must reference and reuse these diagrams.

Stage-gates alignment (reinforced)
- Stage 1 (Architecture & Foundations) must produce:
  - C4 L1/L2 and initial L3 for critical areas
  - Sequence diagrams for at least two core flows
  - ERD or equivalent (if applicable)
  - docs/architecture/README.md and docs/PROMPT_REFERENCE.md
- Stage 2 may refine/extend diagrams; Stage 3/4 must not proceed without Stage 1/2 approval when the user requests staged reviews.

Checklist addendum (Docs & Diagrams)
- [ ] docs/architecture/README.md exists and links to all diagrams
- [ ] docs/architecture/c4-context.md committed (Mermaid/PlantUML source)
- [ ] docs/architecture/c4-container.md committed (Mermaid/PlantUML source)
- [ ] docs/architecture/c4-component-*.md committed for critical areas
- [ ] docs/architecture/sequence-*.md committed for core flows
- [ ] docs/architecture/erd-*.md committed when applicable
- [ ] docs/PROMPT_REFERENCE.md created with links to the above and selected stacks
- [ ] PACT/RULES/GUIDES/IMPLEMENTATION link to these diagrams (closing the loop)

Note
- These documents form part of all present and future prompts for this library and must always exist under version control. Any AI system acting on this repository must load and respect them before proposing or generating code.
