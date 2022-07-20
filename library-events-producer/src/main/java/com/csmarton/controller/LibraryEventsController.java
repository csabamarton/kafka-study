package com.csmarton.controller;

import com.csmarton.domain.LibraryEvent;
import com.csmarton.domain.LibraryEventType;
import com.csmarton.producer.LibraryEventProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
public class LibraryEventsController {

    public static final String URL_POST_LIBRARY_EVENT = "/v1/libraryevent";
    @Autowired
    LibraryEventProducer libraryEventProducer;

    @PostMapping(URL_POST_LIBRARY_EVENT)
    public ResponseEntity<LibraryEvent> postLibraryEvent(@RequestBody @Valid LibraryEvent libraryEvent) throws JsonProcessingException {

        //invoke kafka producer
        log.info("Before sendLibraryEvent");
        libraryEvent.setLibraryEventType(LibraryEventType.NEW);
        libraryEventProducer.sendLibraryEvent_Approach2(libraryEvent);
        log.info("After sendLibraryEvent");

        return ResponseEntity.status(HttpStatus.CREATED).body(libraryEvent);
    }
}
