package com.traceforge.event;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/events")
public class TraceEventController {

    @PostMapping
    public TraceEventRequest receiveEvent(
        @Valid @RequestBody TraceEventRequest request
    ) {
        return request;
    }

    @GetMapping("/{id}")
    public String getEventById(@PathVariable  Long id) {
        return "Event ID" + id;
    }

    @GetMapping
    public String getAllEvents() {
        return "All events";
    }
}