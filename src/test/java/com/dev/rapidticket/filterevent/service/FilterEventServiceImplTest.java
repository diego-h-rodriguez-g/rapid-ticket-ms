package com.dev.rapidticket.filterevent.service;

import com.dev.rapidticket.InjectDataTest;
import com.dev.rapidticket.commons.utilities.Utilities;
import com.dev.rapidticket.filterevent.model.FilterEventRequest;
import com.dev.rapidticket.filterevent.model.FilterEventResponse;
import com.dev.rapidticket.filterevent.repository.FilterEventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FilterEventServiceImplTest {
    @InjectMocks
    private FilterEventServiceImpl filterEventService;

    @Mock
    private FilterEventRepository filterEventRepository;

    @Mock
    private Utilities utilities;

    private final InjectDataTest injectDataTest = new InjectDataTest();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should return a FilterEventResponse in method getFilterEvents")
    void returnFilterEventResponseInGetFilterEvents() {
        FilterEventRequest filterEventRequest = injectDataTest.buildFilterEventRequest(0);
        FilterEventResponse expectedResponse = injectDataTest.buildFilterEventResponse(200);

        when(utilities.convertObjectToString(filterEventRequest)).thenReturn("{}");
        when(filterEventRepository.getEvents(filterEventRequest)).thenReturn(expectedResponse);

        assertEquals(expectedResponse, filterEventService.getFilterEvents(filterEventRequest));
    }
}
