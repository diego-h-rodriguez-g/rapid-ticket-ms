package com.dev.rapidticket.filterevent.service;

import com.dev.rapidticket.InjectDataTest;
import com.dev.rapidticket.commons.utilities.Utilities;
import com.dev.rapidticket.filterevent.dto.FilterEventRequestDTO;
import com.dev.rapidticket.filterevent.dto.FilterEventResponseDTO;
import com.dev.rapidticket.filterevent.mapper.FilterEventMapper;
import com.dev.rapidticket.filterevent.model.FilterEventRequest;
import com.dev.rapidticket.filterevent.model.FilterEventResponse;
import com.dev.rapidticket.filterevent.repository.FilterEventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.Mockito.when;

public class FilterEventServiceImplTest {
    @InjectMocks
    private FilterEventServiceImpl filterEventService;

    @Mock
    private FilterEventPrepareData filterEventPrepareData;

    @Mock
    private FilterEventRepository filterEventRepository;

    @Mock
    private FilterEventMapper filterEventMapper;

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
        FilterEventRequestDTO filterEventRequestDTO = injectDataTest.buildFilterEventRequestDTO(200);
        Object[] objects= anyCollection().toArray(new Object[0]);
        List<Object[]> listObjectsResponse = new ArrayList<>();
        listObjectsResponse.add(objects);
        List<FilterEventResponseDTO> filterEventResponseDTO = Collections.singletonList(injectDataTest.buildFilterEventResponseDTO(200));
        FilterEventResponse expectedResponse = injectDataTest.buildFilterEventResponse(200);
        expectedResponse.setRowCount(listObjectsResponse.size());
        expectedResponse.setEventList(filterEventResponseDTO);

        when(utilities.convertObjectToString(filterEventRequest)).thenReturn("{}");
        when(filterEventPrepareData.prepareQueryData(filterEventRequest)).thenReturn(filterEventRequestDTO);
        when(filterEventRepository.getEvents(filterEventRequestDTO)).thenReturn(listObjectsResponse);
        when(filterEventMapper.toFilterEventDTOList(listObjectsResponse)).thenReturn(filterEventResponseDTO);

        assertEquals(expectedResponse, filterEventService.getFilterEvents(filterEventRequest));
    }
}
