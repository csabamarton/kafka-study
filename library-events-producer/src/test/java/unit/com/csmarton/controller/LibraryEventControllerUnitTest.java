package com.csmarton.controller;

import com.csmarton.domain.Book;
import com.csmarton.domain.LibraryEvent;
import com.csmarton.domain.LibraryEventType;
import com.csmarton.producer.LibraryEventProducer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static com.csmarton.controller.LibraryEventsController.URL_POST_LIBRARY_EVENT;
import static org.mockito.ArgumentMatchers.isA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LibraryEventsController.class)
@AutoConfigureMockMvc
public class LibraryEventControllerUnitTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @MockBean
    LibraryEventProducer libraryEventProducer;

    @Test
    void postLibraryEvent() throws Exception {
        //given
        Book book = Book.builder()
                .bookId(123)
                .bookAuthor("Hanga")
                .bookName("Little Princess")
                .build();
        LibraryEvent libraryEvent = LibraryEvent.builder()
                .libraryEventId(null)
                .libraryEventType(LibraryEventType.NEW)
                .book(book)
                .build();

        String string = objectMapper.writeValueAsString(libraryEvent);

        when(libraryEventProducer.sendLibraryEvent_Approach2(isA(LibraryEvent.class))).thenReturn(null);

        //when
        mockMvc.perform(post(URL_POST_LIBRARY_EVENT)
                .content(string)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void postLibraryEvent_4xx() throws Exception {
        //given
        Book book = Book.builder()
                .bookId(123)
                .bookAuthor(null)
                .bookName("Little Princess")
                .build();
        LibraryEvent libraryEvent = LibraryEvent.builder()
                .libraryEventId(null)
                .libraryEventType(LibraryEventType.NEW)
                .book(book)
                .build();

        String string = objectMapper.writeValueAsString(libraryEvent);

        when(libraryEventProducer.sendLibraryEvent_Approach2(isA(LibraryEvent.class))).thenReturn(null);


        //when
        mockMvc.perform(post(URL_POST_LIBRARY_EVENT)
                        .content(string)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(content().string("book.bookAuthor - must not be blank"));
    }


}
