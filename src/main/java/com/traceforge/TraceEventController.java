package com.traceforge;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController // сообщает Spring, что это HTTP-контроллер, возвращающий данные в ответе.
@RequestMapping("/api/events")
public class TraceEventController {

    @PostMapping // обрабатывает HTTP POST-запросы.
    public TraceEventRequest receiveEvent(
        @Valid @RequestBody TraceEventRequest request // указывает Spring преобразовать JSON из тела запроса в Java-объект.
    ) {
        return request;
    }
}