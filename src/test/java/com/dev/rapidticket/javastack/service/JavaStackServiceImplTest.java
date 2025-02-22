package com.dev.rapidticket.javastack.service;

import com.dev.rapidticket.InjectDataTest;
import com.dev.rapidticket.commons.utilities.Utilities;
import com.dev.rapidticket.javastack.model.JavaStackResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class JavaStackServiceImplTest {
    @InjectMocks
    private JavaStackServiceImpl javaStackService;

    @Mock
    private Utilities utilities;

    private final InjectDataTest injectDataTest = new InjectDataTest();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void returnGetJavaStackResponseInGetJavaStack() {
        JavaStackResponse expectedResponse = injectDataTest.buildJavaStackResponse(200);

        when(utilities.convertObjectToString(Mockito.any(JavaStackResponse.class))).thenReturn("{}");

        assertEquals(expectedResponse,javaStackService.getJavaStack());
    }
}
