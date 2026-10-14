package com.traceforge.trace;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/api/traces")
public class TraceController {
    
    @GetMapping("/{traceId}")
    public String getTraceById(@PathVariable("traceId") Long traceId) {
        return "Trace ID: " + traceId;
    }
}
