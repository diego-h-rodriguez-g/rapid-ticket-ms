package com.dev.rapid_ticket_ms.javastack.controller;

import com.dev.rapid_ticket_ms.javastack.model.JavaStackResponse;
import com.dev.rapid_ticket_ms.javastack.service.JavaStackService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

public class JavaStackControllerTest {
    @InjectMocks
    private JavaStackController javaStackController;
    @Mock
    private JavaStackService javaStackService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void returnGetJavaStackResponseInGetJavaStack() {
        JavaStackResponse javaStackResponse = JavaStackResponse.builder().build();
        ResponseEntity<JavaStackResponse> expectedResponse = ResponseEntity.ok(javaStackResponse);

        when(javaStackService.getJavaStack()).thenReturn(javaStackResponse);

        ResponseEntity<JavaStackResponse> receivedResponse = javaStackController.getJavaStack();
        Assertions.assertEquals(expectedResponse.getStatusCodeValue(), receivedResponse.getStatusCodeValue());
    }
}
