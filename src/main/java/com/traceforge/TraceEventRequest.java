package com.traceforge;

import jakarta.validation.constraints.NotBlank;

public record TraceEventRequest (
    @NotBlank String traceId,
    @NotBlank String serviceName,
    @NotBlank String eventType,
    @NotBlank String message
) {

}
