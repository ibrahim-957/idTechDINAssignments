package com.ibrahim.spring.lesson02.task02_idempotency_and_safety;

public class HttpMethodProperties {
    public static void main(String[] args) {
        IdempotencyTest.testAnnotations();
        IdempotencyTest.testPutIdempotency();
        IdempotencyTest.testPostNonIdempotency();
        IdempotencyTest.testDeleteIdempotency();
        IdempotencyTest.testIdempotencyKeyMiddleware();
    }

    /*
     * ╔══════════════════════════════════════════════════════════════════════════╗
     * ║  WHY IS POST NOT IDEMPOTENT — AND WHY DOES IT MATTER IN MICROSERVICES?  ║
     * ╠══════════════════════════════════════════════════════════════════════════╣
     * ║                                                                          ║
     * ║  POST means "append a new subordinate resource."  The server assigns     ║
     * ║  the identity (auto-increment id, UUID …).  Therefore:                  ║
     * ║                                                                          ║
     * ║    POST /orders  ──▶  order #101 created                                ║
     * ║    POST /orders  ──▶  order #102 created   ← DIFFERENT OUTCOME          ║
     * ║    POST /orders  ──▶  order #103 created                                ║
     * ║                                                                          ║
     * ║  The same request body produces a different server state each time.      ║
     * ║  That is the definition of non-idempotent.                               ║
     * ║                                                                          ║
     * ║  WHY IT MATTERS FOR MICROSERVICE RETRY LOGIC:                            ║
     * ║                                                                          ║
     * ║  In a distributed system a request can fail at three points:             ║
     * ║    A) Before the server received it    → safe to retry                   ║
     * ║    B) While the server was processing  → unknown state                   ║
     * ║    C) After the server committed it,   → response lost in transit        ║
     * ║       before the response arrived                                         ║
     * ║                                                                          ║
     * ║  For idempotent methods (GET, PUT, DELETE) a retry in scenario B/C       ║
     * ║  is always safe — the repeated call produces the same outcome.           ║
     * ║                                                                          ║
     * ║  For POST, a retry in scenario B/C creates a DUPLICATE:                  ║
     * ║    • Duplicate order charged to a customer's credit card                 ║
     * ║    • Duplicate email sent                                                 ║
     * ║    • Duplicate row in the database                                        ║
     * ║                                                                          ║
     * ║  SOLUTION — Idempotency Keys:                                            ║
     * ║    The CLIENT generates a unique key (UUID) per logical operation and    ║
     * ║    sends it as a header:  Idempotency-Key: <uuid>                        ║
     * ║    The SERVER caches responses keyed by that value.  If the same key     ║
     * ║    arrives again within the TTL window the server returns the cached      ║
     * ║    response WITHOUT re-executing the operation.                           ║
     * ║                                                                          ║
     * ║  Real-world usage: Stripe, PayPal, and most payment APIs require an      ║
     * ║  Idempotency-Key header on every POST to enable safe client retries.     ║
     * ╚══════════════════════════════════════════════════════════════════════════╝
     */
}
