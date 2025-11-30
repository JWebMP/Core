# 🔄 Starter Prompt — Adopt Rules Repository in an Existing Project

Ask your AI tool to copy this template and align with the Rules Repository. The AI will analyze the repo, add the Rules Repository submodule, establish Pact → Rules → Guides → Implementation, and refactor docs to the modular, forward-only model.

Supported: Junie, AI Assistant, GitHub Copilot Chat, Cursor, ChatGPT, Claude, Roo, Codex.

---

## 0) Provide Inputs
Fill before running.

- Repository URL / local path: https://github.com/JWebMP/Core.git
- Org and project name: JWebMP / Core
- Short description: An Object-Orientated HTML Renderer that utilizes pure java to render HTML, CSS and JS
- License (if missing or to change): Apache 2

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
  - Note: Multiple AI engines may be selected; configure each chosen assistant per its workspace requirements.
    - AI Assistant reads rules from `.aiassistant/rules/`; ensure those files stay in sync with this repository’s policies.

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
    - JVM: capture artifact coordinates only (groupId:artifactId:version); rely on build-tooling rules for actual build file changes.
    - JavaScript/Web: capture package names + versions (npm/pnpm/yarn/Babel); do not restate full build scripts here.

- Detected/Chosen tech topics (tick):
  - Fluent API Strategy (choose exactly one):
    - [X] CRTP
    - [ ] Builder pattern (Lombok @Builder/manual)
  - Backend Reactive:
    - Core stacks:
      - [ ] Vert.x 5
      - [ ] Hibernate Reactive 7
    - Quarkus:
      - [ ] Core project setup
      - [ ] RESTEasy Reactive APIs
      - [ ] Persistence (Hibernate/Panache)
      - [ ] Reactive messaging
      - [ ] Security/OIDC
      - [ ] Dev Services & local tooling
      - [ ] Native build & packaging
      - [ ] Testing strategy
      - Note: Quarkus currently embeds Vert.x 4 under the hood; select Vert.x 5 only if directly targeting Vert.x APIs.
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
      - Note: If Core is selected, also select Vert.x 5 and include GuicedEE Vert.x Bridge rules (rules/generative/backend/guicedee/vertx/README.md); if Persistence is selected, also select Hibernate Reactive 7 and link rules/generative/backend/guicedee/persistence/README.md.
    - Databases:
      - [ ] PostgreSQL
      - [ ] MySQL
      - [ ] DB2
      - [ ] Oracle
      - [ ] MSSQL
      - [ ] SQL Client templates
      - [ ] MongoDB
      - [ ] Redis
      - [ ] Cassandra
    - Security (Reactive):
      - [ ] Vert.x Web Auth/JWT/OAuth2
  - Backend:
    - Spring MVC:
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
      - Reference: ./generative/backend/spring/overview-setup.md
    - JDBC Databases:
      - [ ] PostgreSQL
      - [ ] MySQL
      - [ ] Oracle
      - [ ] MSSQL
      - [ ] MariaDB
      - [ ] IBM DB2
      - [ ] SQLite
      - [ ] Other: <DB_OTHER>
  - Security/Auth Providers:
    - [ ] OpenID Connect (generic)
    - [ ] GCP (IAP/OIDC)
    - [ ] Firebase Auth
    - [ ] Microsoft Entra ID (Azure AD)
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
  - Frameworks (JWebMP):
    - [ ] Core
    - [X] Client
    - [ ] WebAwesome
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
  - CI/CD Providers:
    - [X] GitHub Actions
    - [ ] GitLab CI
    - [ ] Jenkins
    - [ ] TeamCity
    - [ ] Google Cloud Build
    - [ ] Azure Pipelines
    - [ ] AWS CodeBuild/CodePipeline
  - Infra/Deploy:
    - [ ] Terraform
    - [ ] GCP Cloud Run
  - Observability/Diagnostics:
    - [ ] Health endpoints
    - [ ] Tracing
    - [ ] OpenAPI
    - [ ] Wireshark
    - OpenAPI Provider (choose one; default = Swagger)
      - [ ] Swagger (default)
      - [ ] MicroProfile OpenAPI
      - [ ] Springdoc OpenAPI (Spring Boot)
    - Health endpoints default to MicroProfile: /health, /health/ready, /health/live (Spring Actuator endpoints supported but not default)
- Level of change:
  - [x] Forward-only (default)
  - [ ] Conservative (only if explicitly required)

Policies (must honor):
- Reset the AI context before running this template—act as if this is the first prompt for the project and do not reuse prior session memory.
- Treat all existing repository documentation as out-of-date; never rely on it as a source of truth. When executing this template, reference only the current checked-in code/config you observe.
- Honor the selected Java LTS exactly; do not substitute another version. If Java 25 is selected, plan and generate for Java 25 everywhere.
- Use Markdown for docs. Follow RULES.md sections: 4 (Behavioral), 5 (Technical), Document Modularity Policy, 6 (Forward-Only Change Policy).
- Do NOT place project-specific docs inside the submodule directory.
- Logging policy: Default to Log4j2; wire logging/config/examples against Log4j2. If Lombok is selected, use Lombok's `@Log4j2` annotation (avoid other Lombok logging annotations).
- Fluent API Strategy: Choose either CRTP or Builder. CRTP is enforced if GuicedEE or JWebMP is selected. Align Lombok usage accordingly:
  - If CRTP: do not use @Builder; implement manual CRTP fluent setters returning (J)this with @SuppressWarnings("unchecked") as needed.
  - If Builder: prefer Lombok @Builder or manual builders; do not apply CRTP chaining rules.
- Angular version policy: Select exactly one Angular version (17/19/20). Migrate docs to base + override model:
  - Base rules — ./generative/language/angular/angular.md
  - Version overrides — ./generative/language/angular/angular-17.rules.md | ./angular-19.rules.md | ./angular-20.rules.md
  - Remove monolithic Angular docs; link to base + selected override; do not mix version APIs in a single project.
- Angular Plugins policy: Select Angular plugins (e.g., Angular Awesome) from the “Frontend (Angular Plugins)” list. Treat plugins as additive to the chosen Angular version; link to the plugin’s topic index and glossary.
- Glossary policy (topic-first): Compose the host GLOSSARY.md from topic-scoped glossaries for all selected topics. Topic glossaries take precedence over the root glossary. Minimize duplication by linking to each topic’s GLOSSARY.md and rules; copy only enforced Prompt Language Alignment mappings (e.g., WebAwesome: WaButton/WaInput).
---

## Documentation-First, Stage-Gated Workflow (Mandatory)

- This repository enforces a documentation-first, stage-gated process for all AI systems (Junie, Copilot, Cursor, ChatGPT, Claude, Roo, Codex).
- The AI MUST NOT write or modify source code until documentation phases are completed and explicitly approved by the user.
- Stage approvals default to user review checkpoints; the user may explicitly waive these STOP gates or grant blanket approval, in which case continue after documenting the opt-out.
- Junie exception: If Junie is the active AI engine, bypass all stage approval pauses and document that Junie auto-approves each stage.
- Documentation fidelity for existing projects: Always describe the actual host repository observed on disk. Do not invent new systems, rename components without evidence, or introduce imagined architecture beyond what the project already contains; align every artifact to discovered facts and note any unknowns explicitly.

Stage 1 — Architecture & Foundations (Docs only)
- Deliver:
  - PACT draft/updates; architecture overview; C4 or ADRs where appropriate
  - Sequence diagrams for key flows; async/system flow diagrams
  - Data flow diagrams; threat model summary and trust boundaries
  - Dependency/integration map (internal/external services)
  - Glossary composition plan (topic-first, precedence and anchors)
  - Evidence capture: base every description on repository discovery (source tree, existing docs, config). Where details are missing, highlight questions instead of fabricating architecture.
- Output format: Markdown docs placed in host docs (outside rules/), with links to enterprise rules indexes.
- STOP (user review optional): Offer a review/approval checkpoint before Stage 2. If the user has opted out or granted blanket approval, note it and continue without waiting.

Stage 2 — Guides & Design Validation (Docs only)
- Deliver:
  - RULES mapping to selected stacks; GUIDES with “how to apply”
  - API surface sketches and contracts (OpenAPI, types) where applicable
  - UI flows/wireframes (if applicable) and component mapping
  - Migration notes, test strategy outline, acceptance criteria
  - Alignment rule: mirror actual modules/components in the host repo; do not introduce hypothetical stacks or flows unless clearly marked as proposals derived from repo evidence.
- STOP (user review optional): Offer a review/approval checkpoint before Stage 3. Proceed immediately only if the user has opted out or granted blanket approval.

Stage 3 — Implementation Plan (No code yet)
- Deliver:
  - Scaffolding plan and module/file tree
  - Build/annotation-processor wiring, CI workflow plan, env/config plan
  - Rollout plan (phased), risk items, validation approach
  - Validation rule: plans must map to existing directories/services; flag delta work explicitly rather than redefining the system.
- STOP (user review optional): Offer a review/approval checkpoint before Stage 4. Continue without delay only if the user has opted out or granted blanket approval.

Stage 4 — Implementation & Scaffolding (Code allowed)
- Scope: Only after explicit approval unless the user has already waived stage approvals or granted blanket approval for the run.
- Approach: Generate minimal scaffolding first, then iterate in small, reviewable steps tied to actual repository artifacts. After each step, present diffs and validation, then ask to continue; do not author fictional modules or rename components without host repo evidence.

Universal STOP rule
- If the user requires staged approvals and approval is not granted, revise docs; if the user waived staged approvals, continue but be ready to revise when feedback arrives.
- Each stage must close loops via links: PACT ↔ GLOSSARY ↔ RULES ↔ GUIDES ↔ IMPLEMENTATION.

### Stage Gate Interaction Protocol (Non-blocking, with defaults)
- Purpose: Fix cases where no user options are shown and the assistant times out after repeated prompts. This protocol standardizes the UI options and fallback behavior.
- At every STOP gate, the assistant MUST present the following options block verbatim (adapting only the stage number):

  Options:
  - 1) Approve Stage N → proceed to Stage N+1
  - 2) Request changes to Stage N (specify what to adjust)
  - 3) Skip approval for this stage and proceed (recorded as optional approval)
  - 4) Pause here (do not proceed)

- Retry and fallback rules:
  - If “Blanket approval” is selected in inputs: proceed automatically without asking; still log that gates were skipped by policy.
  - If “Approvals optional” is selected: present the options once, send one reminder if no reply within a reasonable time, then proceed with option 3 and record the default decision. Do NOT loop more than 2 attempts.
  - If “Require explicit approval” is selected: present the options and send one reminder if no reply; if still no response, stop at the gate with a concise summary and instructions to resume. Do NOT loop more than 2 attempts.
  - Under no circumstance should the assistant perform more than two consecutive “await user input” attempts at a single gate.

- Rendering requirement:
  - The options block MUST be included under a clearly labeled STOP section so that UIs can render actionable choices. Avoid free-form phrasing that hides the options.
  - Always echo the current stage and the next stage name in the options block.

## 1) Self‑Configure the AI Engine
- Pin ./RULES.md anchors (sections above). Operate in forward-only mode: remove/replace legacy docs as needed; update all references.
- AI workspace files (selected engines):
  - AI Assistant: ensure `.aiassistant/rules/` exists with a pinned summary of RULES.md sections 4/5, Document Modularity, and Forward-Only; keep it synchronized with the host RULES.md.
  - GitHub Copilot: add `.github/copilot-instructions.md` (or workspace note) with the same constraints and STOP-gate policy.
  - Cursor: add `.cursor/rules.md` with the same constraints (may share content with Copilot if both are selected).
- MCP servers (per selected AI engine):
  - If the chosen assistant supports MCP (e.g., Cursor, Claude Desktop, MCP-capable IDEs), register the servers before running the prompt.
  - Always register the Mermaid MCP server for docs/diagrams: HTTP `https://mcp.mermaidchart.com/mcp` (`"type": "http"`) or SSE `https://mcp.mermaidchart.com/sse` (`"type": "sse"`).
  - Confirm in responses which MCP servers are active so registration aligns with the AI engine selections.
- For ChatGPT/Claude:
  - Start with system note: "Follow Rules Repository RULES.md sections 4,5, Document Modularity, and 6 (forward-only). Close loops across artifacts."
  - Owner mode (this Rules Repository repository is the active workspace; not used as a submodule):
    - Do not refer to this repository as a submodule.
    - Load and pin ./skills.md; use project-scoped Skills under .claude/skills/.
  - Host project mode (a downstream project adopting these rules):
    - Use this repository as a Git submodule and link to it from host artifacts.
  - For Claude specifically: load and pin ./skills.md; discover project Agent Skills under .claude/skills/ (auto-discovered by Claude Code); acknowledge which Skills are active and apply them throughout generation.
- For Codex CLI (Codex agent):
  - Load ./RULES.md anchors plus README context; confirm forward-only and Document Modularity constraints are pinned in the Codex CLI workspace.
  - Follow Codex CLI harness instructions: run shell commands with `bash -lc` and explicit `workdir`, prefer `rg` for scans, honor sandbox/approval settings, and use the plan tool for multi-step work.
- For Roo: load and pin ROO_WORKSPACE_POLICY.md at the repository root. If it does not exist, create it with a summary of RULES.md sections 4,5, Document Modularity Policy, and 6 (Forward-Only). Ensure repo-scoped conversations, include file paths in responses, and confirm forward-only mode is enabled. Update all references affected by a change in the same forward-only change set.

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
  - When Maven, Gradle (Groovy/Kotlin DSL), or Apache Ivy is selected, document artifact coordinates only (groupId:artifactId:version); rely on build-tooling.md for plugin/configuration wiring.
- If Web → TypeScript is selected:
  - Include language rules link: rules/generative/language/typescript/README.md.
  - If Angular is also selected: include rules/generative/language/angular/README.md and scaffold Angular app structure when requested.
  - If React is also selected: include rules/generative/language/react/README.md and scaffold React app structure when requested.
  - If React → Next.js is selected: include rules/generative/frontend/nextjs/README.md and align routing/data fetching to that guide.
  - If Vue is also selected: include rules/generative/language/vue/README.md and scaffold Vue structure when requested.
  - If Vue → Nuxt is selected: include rules/generative/frontend/nuxt/README.md and follow SSR/SSG routing guidance.
  - When npm, pnpm, yarn, or Babel is selected, list package@version dependencies only; defer bundler/transpiler setup to the TypeScript/JS build guides.
- If Kotlin is selected:
  - Include language rules link: rules/generative/language/kotlin/README.md.
  - If Ktor is also selected, scaffold a minimal Ktor service module and wire guides accordingly.

---

## 2) Migration Plan (AI must draft first)
The AI should begin by producing a short plan with:
- Inventory: existing docs (README, RULES, GUIDES, architecture docs), CI, env files, components.
- Gaps: missing Pact/Rules/Guides/Implementation, outdated monolithic docs, absent indexes.
- Actions: submodule add; create/relocate docs; refactor to modular; update links; CI/env alignment.
- Risk notes: any breaking removals per forward-only policy.

When approved, execute the plan as one change set.

---

## 3) Required Changes
1. Add Rules Repository submodule (rules/ or docs/rules-repository) and document usage in README.
2. Create PACT.md (root or docs/) based on rules/creative/pact.md. Fill project details and cross-links.
3. Create GLOSSARY.md (root or docs/):
   - Compose from topic glossaries (topic-first). For each selected topic, link to its topic GLOSSARY.md and adopt its canonical terms; these take precedence over root terms for that scope.
   - Copy only enforced Prompt Language Alignment mappings into the host glossary (e.g., WebAwesome: WaButton, WaInput, WaCluster, WaStack). For all other terms, link to the topic file/anchor instead of duplicating definitions.
   - Document a “Glossary Precedence Policy”: topic glossaries override root for their scope; the host GLOSSARY.md acts as an index and aggregator with minimal duplication and LLM interpretation guidance (e.g., CRTP vs Builder routing, JSpecify defaults).
4. Create/Update project RULES.md (outside submodule):
  - Declare scope, chosen stacks, and any project-specific conventions.
  - Link to relevant topic indexes:
    - Frontend:
      - rules/generative/frontend/webcomponents/README.md
      - rules/generative/frontend/webawesome/README.md
      - rules/generative/frontend/jwebmp/README.md
      - If JWebMP Client is selected: rules/generative/frontend/jwebmp/client/README.md
      - If JWebMP with WebAwesome plugin is selected: rules/generative/frontend/jwebmp/jwebmp-webawesome/README.md
      - rules/generative/frontend/angular-awesome/README.md
    - React/Vue/Next/Nuxt:
      - rules/generative/language/react/README.md
      - rules/generative/frontend/nextjs/README.md
      - rules/generative/language/vue/README.md
      - rules/generative/frontend/nuxt/README.md
    - Backend:
      - rules/generative/backend/guicedee/README.md
      - rules/generative/backend/guicedee/client/README.md
      - rules/generative/backend/guicedee/persistence/README.md
      - rules/generative/backend/hibernate/README.md
      - rules/generative/backend/security-reactive/README.md
      - If GuicedEE Core is selected: include rules/generative/backend/vertx/README.md and rules/generative/backend/guicedee/vertx/README.md.
      - If Backend Reactive → GuicedEE options are selected: link chosen function/rules under rules/generative/backend/guicedee/ (functions/..., persistence/README.md, websockets/README.md).
      - If GuicedEE Persistence is selected: ensure Hibernate Reactive 7 is selected/linked (rules/generative/backend/hibernate/README.md) and include rules/generative/backend/guicedee/persistence/README.md.
    - Platform/Architecture:
      - rules/generative/platform/ci-cd/README.md
        - If CI/CD Providers are selected, also link provider docs:
          - GitHub Actions — rules/generative/platform/ci-cd/providers/github-actions.md
          - GitLab CI — rules/generative/platform/ci-cd/providers/gitlab-ci.md
          - Jenkins — rules/generative/platform/ci-cd/providers/jenkins.md
          - TeamCity — rules/generative/platform/ci-cd/providers/teamcity.md
          - Google Cloud Build — rules/generative/platform/ci-cd/providers/google-cloud-build.md
          - Azure Pipelines — rules/generative/platform/ci-cd/providers/azure-pipelines.md
          - AWS CodeBuild/CodePipeline — rules/generative/platform/ci-cd/providers/aws-codebuild-codepipeline.md
      - rules/generative/platform/observability/README.md
      - rules/generative/architecture/README.md
      - rules/generative/architecture/tdd/README.md
      - rules/generative/architecture/bdd/README.md
      - rules/generative/platform/security-auth/README.md
   - Reference GLOSSARY.md for naming/terminology alignment.
5. Create/Update GUIDES.md with links to chosen modular entries (e.g., Hibernate transactions, CRUD; Web Components custom-elements/shadow-dom; Angular producing/consuming; WebAwesome Button/Input rules). Use glossary-aligned terms consistently.
6. Create/Update IMPLEMENTATION.md explaining current modules, code layout, and back-links to guides. Ensure implementation names and labels adhere to GLOSSARY.md.
7. Refactor legacy docs to modular model where feasible:
   - Split overly large monoliths into focused docs or replace with links to the submodule’s modular entries (preferred).
   - Remove deprecated/duplicate documents per Forward-Only policy; update all inbound links.
8. Environment alignment
   - Create or update .env.example using rules/generative/platform/secrets-config/env-variables.md as the source of truth.
9. CI alignments
   - Add/update minimal GitHub Actions workflows for build/test and document required secrets.
   - If the project is a GuicedEE library and GitHub Actions is selected, add `.github/workflows/maven-package.yml` pointing at the shared workflow:
      ```yaml
      name: Maven Package
      on:
        workflow_dispatch:
        push:
      jobs:
        GuicedInjection:
          uses: GuicedEE/Workflows/.github/workflows/projects.yml@master
          with:
            baseDir: ''
            name: 'Guiced Injection'
          secrets:
            USERNAME: ${{secrets.USERNAME}}
            USER_TOKEN: ${{secrets.USER_TOKEN}}
            SONA_USERNAME: ${{secrets.SONA_USERNAME}}
            SONA_PASSWORD: ${{secrets.SONA_PASSWORD}}
      ```
10. README updates
   - State adoption of Rules Repository, link submodule path, and link PACT/RULES/GUIDES/IMPLEMENTATION/GLOSSARY.
11. AI workspace alignment (selected engines)
    - AI Assistant — `.aiassistant/rules/` with RULES.md sections 4/5, Document Modularity, and Forward-Only.
    - GitHub Copilot — `.github/copilot-instructions.md` (or workspace note) covering the same constraints and STOP-gate policy.
    - Cursor — `.cursor/rules.md` mirroring the same constraints.
    - Roo — ROO_WORKSPACE_POLICY.md present/pinned if Roo is selected.

- WebAwesome prompt language alignment (if selected)
  - When prompting, use WebAwesome component names to enforce alignment:
    - “button” → say “WaButton” (see rules/generative/frontend/webawesome/button.rules.md)
    - “icon button” → say “WaIconButton” (see rules/generative/frontend/webawesome/icon-button.rules.md)
    - “input” → say “WaInput” (see rules/generative/frontend/webawesome/input.rules.md)
    - “row” (layout) → say “WaCluster”
    - “column/stack” (layout) → say “WaStack”
  - If a variant has no dedicated file, link to the subsection under the broader rule (e.g., WaInput → #number-input).

---

## 4) Output Checklist
- [ ] Stage 1 (Architecture & Foundations) docs produced; record user approval if they require the STOP gate
- [ ] Stage 2 (Guides & Design Validation) docs produced; record user approval if they require the STOP gate
- [ ] Stage 3 (Implementation Plan) produced; record user approval if they require the STOP gate
- [ ] Stage 4 (Code/Scaffolding) executed only after explicit approval, unless the user granted blanket approval; diffs presented with validation and links
- [ ] Submodule added and referenced in README
- [ ] PACT.md present and linked
- [ ] Project RULES.md present, linking to enterprise RULES and topic indexes
- [ ] Fluent API Strategy declared (CRTP vs Builder) and reflected in RULES.md and GLOSSARY.md; Lombok usage aligned to selection
- [ ] GLOSSARY.md composed topic-first: links to selected topic glossaries; Glossary Precedence Policy documented; minimal duplication; Prompt Language Alignment mappings copied where enforced
- [ ] GUIDES.md and IMPLEMENTATION.md present with back/forward links
- [ ] Monolithic/legacy docs removed or replaced; all references updated
- [ ] .env.example aligned to env-variables.md
- [ ] CI updated/added
- [ ] MCP servers registered for selected assistants (Mermaid MCP for docs/diagrams) and acknowledged in outputs
- [ ] AI workspace files committed for selected engines (.aiassistant/rules/, .github/copilot-instructions.md, .cursor/rules.md, ROO_WORKSPACE_POLICY.md if Roo)
- [ ] All links resolve; no project files placed inside the submodule
---

## 5) Guardrails
- Apply Forward-Only Change Policy fully; do not keep legacy stubs/anchors for compatibility.
- Document any risky removals briefly in MIGRATION.md (create if necessary).
- Close loops between artifacts (traceability in both directions).

---

## 6) AI Response Format (Stage-Gated)
1) Stage N deliverables (docs or plans only until Stage 4), with file paths and working links
2) Open questions, decisions required, risks
3) STOP — Render the standardized options block (see Stage Gate Interaction Protocol). Respect the Stage approvals preference from Inputs.
   - If approvals are optional and no reply is received after one reminder, proceed with option 3 and record the default.
   - If explicit approval is required and still no reply after one reminder, stop and summarize how to resume; do not retry more than twice.
   - If blanket approval is set, skip STOP sections but record that the gate was auto-approved by policy.
4) If approval is required and granted, provide the next-stage plan; if not granted, revise and re-submit Stage N; if the user opted out or blanket approval applies, continue with the next stage plan

End of prompt.
## Diagrams and Docs-as-Code Policy (Mandatory)

Purpose
- When adopting the Rules Repository, the existing system must be documented with architecture diagrams and technical flows that are reviewable by humans and consumable by AI.
- These documents are version-controlled first-class artifacts, referenced by this and future prompts for the project.

Required artifacts (Docs-as-Code)
- C4 Architecture Diagrams (text-based)
  - Level 1 (Context): system context and external dependencies
  - Level 2 (Container): major containers/services and responsibilities
  - Level 3 (Component): key components within each container (per bounded context)
  - Optional Level 4 (Code): for deep drill-down where necessary
- Sequence Diagrams
  - Critical flows (auth, business transactions, error paths, background jobs)
  - Include async steps and boundaries (bus, schedulers)
- ERDs (Entity-Relationship Diagrams)
  - Core domain model and relationships
  - Ownership/bounded contexts and data lifecycles
- Deployment/Runtime
  - Topology (edge, API, workers), environments, regions, significant infra

Format and storage (Docs as Code)
- Use text formats that diff well:
  - Mermaid (preferred) in Markdown fenced blocks (```mermaid)
  - PlantUML (.puml) or fenced blocks (```plantuml)
  - Mermaid MCP server is available to assist with architecture and diagrams: HTTP endpoint `https://mcp.mermaidchart.com/mcp` with `"type": "http"`; SSE endpoint `https://mcp.mermaidchart.com/sse` with `"type": "sse"`.
- Storage conventions in host repo (outside rules/):
  - docs/architecture/README.md — architecture index linking all diagrams
  - docs/architecture/c4-context.md — C4 L1
  - docs/architecture/c4-container.md — C4 L2
  - docs/architecture/c4-component-<bounded-context>.md — C4 L3 files
  - docs/architecture/sequence-<flow>.md — sequence diagrams
  - docs/architecture/erd-<domain>.md — ERD diagrams
  - Optional rendered images under docs/architecture/img/ derived from sources; do not commit images without sources
- Version control mandate
  - Commit all diagram sources (Mermaid/PlantUML). Images never replace sources.

Adoption specifics (reverse-engineering)
- Inventory the current system, produce C4 L1/L2 from code/services/deploy manifests.
- Establish at least one L3 for a critical bounded context and two key sequence diagrams.
- Draft initial ERD for the core domain from schema/migrations.
- Link all artifacts from docs/architecture/README.md for discoverability.

Prompt seeding and traceability
- Create docs/PROMPT_REFERENCE.md that:
  - Records selected stacks (languages/frameworks/plugins) and glossary composition (topic-first precedence)
  - Links to all diagrams under docs/architecture/
  - Is referenced by future prompts for this project; AI must load and honor it
- Close the documentation loop: PACT ↔ GLOSSARY ↔ RULES ↔ GUIDES ↔ IMPLEMENTATION must reference and reuse these diagrams.

Stage-gates alignment (reinforced)
- Stage 1 (Architecture & Foundations) must produce:
  - C4 L1/L2 and initial L3 for critical bounded contexts
  - Sequence diagrams for at least two key flows
  - Initial ERD for the core domain
  - docs/architecture/README.md and docs/PROMPT_REFERENCE.md
- Stage 2 may refine/extend diagrams; Stage 3/4 must not proceed without Stage 1/2 approval when the user requests staged reviews.

Checklist addendum (Docs & Diagrams)
- [ ] docs/architecture/README.md exists and links all diagrams
- [ ] docs/architecture/c4-context.md committed (Mermaid/PlantUML source)
- [ ] docs/architecture/c4-container.md committed (Mermaid/PlantUML source)
- [ ] docs/architecture/c4-component-*.md committed for critical bounded contexts
- [ ] docs/architecture/sequence-*.md committed for critical flows
- [ ] docs/architecture/erd-*.md committed for core domain(s)
- [ ] docs/PROMPT_REFERENCE.md created with links to the above and selected stacks
- [ ] PACT/RULES/GUIDES/IMPLEMENTATION link to these diagrams (closing the loop)

Note
- These documents are part of all present and future prompts for this project and must remain under version control. Any AI system acting on this repository must load and respect them before proposing or generating code.
