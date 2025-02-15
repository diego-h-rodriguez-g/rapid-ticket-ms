package com.dev.rapid_ticket_ms.javastack.service;

import com.dev.rapid_ticket_ms.commons.utilities.Utilities;
import com.dev.rapid_ticket_ms.javastack.model.JavaStackResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class JavaStackServiceImplTest {
    @InjectMocks
    private JavaStackServiceImpl javaStackService;

    @Mock
    private Utilities utilities;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void returnGetJavaStackResponseInGetJavaStack() {
        when(utilities.convertObjectToString(Mockito.any(JavaStackResponse.class))).thenReturn("{}");

        JavaStackResponse response = javaStackService.getJavaStack();
        assertEquals(HttpStatus.OK.value(), response.getCode());
        assertEquals("Test service executed successfully", response.getMessage());
        assertEquals(SpringVersion.getVersion(), response.getSpringVersion());
        assertEquals(SpringBootVersion.getVersion(), response.getSpringBootVersion());
        assertEquals(System.getProperty("java.version"), response.getJavaVersion());

    }
}
