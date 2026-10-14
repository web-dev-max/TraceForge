package com.traceforge.trace;

import jakarta.validation.constraints.NotBlank;

public record TraceRequest(
    @NotBlank String traceId
) {
    
}
