package com.dev.rapid_ticket_ms.commons.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.Mockito.when;

public class UtilitiesImplTest {
    @InjectMocks
    private UtilitiesImpl utilities;

    @Mock
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should return a String in method convertObjectToString")
    public void returnStringInConvertObjectToString() throws JsonProcessingException {
        Object object = new Object();
        when(objectMapper.writeValueAsString(object)).thenReturn("{}");
        assertThat(utilities.convertObjectToString(object), instanceOf(String.class));
    }
}
