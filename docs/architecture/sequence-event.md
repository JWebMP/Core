# Sequence — Event Handling (Server-Side Adapter)

```mermaid
sequenceDiagram
  participant Browser as Browser
  participant Vertx as Vert.x Web / HTTP
  participant App as Host App
  participant Jackson as Jackson + JWebMPJacksonModule
  participant EventSvc as Event Adapter (e.g., ClickAdapter)
  participant Component as Component Tree

  Browser->>Vertx: Trigger client event (click/change/etc.)
  Vertx->>App: Route to server endpoint (GuicedEE/Vert.x bridge)
  App->>Jackson: Deserialize payload (IEvent/IEventTypes)
  App->>EventSvc: Resolve matching adapter/service interface (JPMS `uses`)
  EventSvc->>Component: Apply state updates or callbacks
  Component->>Browser: Return updated HTML/JS (delta or full render)
```

Notes
- Event adapters are listed under `com.jwebmp.core.events.*`; service interfaces are consumed via JPMS `uses` entries and ServiceLoader.
- Exact transport (AJAX vs Vert.x websockets) is host-app defined; this diagram reflects the common server-side flow.
