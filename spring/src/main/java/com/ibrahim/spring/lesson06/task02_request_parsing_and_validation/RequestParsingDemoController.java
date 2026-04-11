package com.ibrahim.spring.lesson06.task02_request_parsing_and_validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/v1/api")
public class RequestParsingDemoController {
    @GetMapping("/demo/headers")
    public Map<String, String> readHeaders(
            @RequestHeader("X-Request-ID") String requestId,
            @RequestHeader("Authorization") String auth,
            @RequestHeader(value = "X-Client_Version", required = false,
                    defaultValue = "unknown") String clientVersion) {

        log.info("=== POINT 1: Custom Headers ===");
        log.info("  X-Request-ID    : {}", requestId);
        log.info("  Authorization   : {}", maskToken(auth));
        log.info("  X-Client-Version: {}", clientVersion);
        return Map.of(
                "requestId", requestId,
                "clientVersion", clientVersion,
                "authPresent", String.valueOf(auth != null && !auth.isBlank())
        );
    }

    @GetMapping("/orders/{orderId}/items/{itemId}")
    public Map<String, Long> getOrderItem(
            @PathVariable Long orderId,
            @PathVariable Long itemId) {

        log.info("=== POINT 2: Path Variables ===");
        log.info("  orderId: {}", orderId);
        log.info("  itemId : {}", itemId);

        return Map.of("orderId", orderId, "itemId", itemId);
    }

    private String maskToken(String auth) {
        if (auth == null || auth.length() < 10) return "***";
        return auth.substring(0, 10) + "...[masked]";
    }
}
