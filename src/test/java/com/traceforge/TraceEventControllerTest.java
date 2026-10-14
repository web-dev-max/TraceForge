
package com.traceforge;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TraceEventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldAcceptValidEvent() throws Exception {
        mockMvc.perform(post("/api/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "traceId": "trace-001",
                                  "serviceName": "payment-service",
                                  "eventType": "ERROR",
                                  "message": "Payment processing failed"
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.traceId").value("trace-001"))
                .andExpect(jsonPath("$.serviceName").value("payment-service"))
                .andExpect(jsonPath("$.eventType").value("ERROR"))
                .andExpect(jsonPath("$.message")
                        .value("Payment processing failed"));
    }

    @Test
    void shouldRejectEventWithBlankTraceId() throws Exception {
        mockMvc.perform(post("/api/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "traceId": " ",
                                  "serviceName": "payment-service",
                                  "eventType": "ERROR",
                                  "message": "Payment processing failed"
                                }
                                """))
                .andExpect(status().isBadRequest());
    }
}
