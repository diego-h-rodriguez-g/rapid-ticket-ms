package com.dev.rapidticket.javastack.controller;

import com.dev.rapidticket.InjectDataTest;
import com.dev.rapidticket.javastack.model.JavaStackResponse;
import com.dev.rapidticket.javastack.service.JavaStackService;
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

    private final InjectDataTest injectDataTest = new InjectDataTest();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void returnGetJavaStackResponseInGetJavaStack() {
        JavaStackResponse javaStackResponse = injectDataTest.buildJavaStackResponse(0);
        ResponseEntity<JavaStackResponse> expectedResponse = ResponseEntity.ok(javaStackResponse);

        when(javaStackService.getJavaStack()).thenReturn(javaStackResponse);

        ResponseEntity<JavaStackResponse> receivedResponse = javaStackController.getJavaStack();
        Assertions.assertEquals(expectedResponse.getStatusCode(), receivedResponse.getStatusCode());
    }
}
