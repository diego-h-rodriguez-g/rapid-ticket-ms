package com.dev.rapidticket.filterevent.service;

import com.dev.rapidticket.InjectDataTest;
import com.dev.rapidticket.commons.utilities.Utilities;
import com.dev.rapidticket.filterevent.dto.FilterEventRequestDTO;
import com.dev.rapidticket.filterevent.model.FilterEventRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static com.dev.rapidticket.filterevent.utilities.Constants.*;
import static org.mockito.Mockito.when;

public class FilterEventPrepareDataImplTest {

    @InjectMocks
    private FilterEventPrepareDataImpl filterEventPrepareData;

    @Mock
    private Utilities utilities;

    private final InjectDataTest injectDataTest = new InjectDataTest();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should contains all filters in method prepareQueryData")
    public void containsAllFiltersInPrepareQueryData() {
        FilterEventRequest filterEventRequest = injectDataTest.buildFilterEventRequest(200);

        when(utilities.isNullObject(Mockito.any())).thenReturn(false);

        FilterEventRequestDTO expectedResponse = filterEventPrepareData.prepareQueryData(filterEventRequest);
        Assertions.assertTrue(expectedResponse.getQuery().contains(AND_EVENT_ID_EQUALS));
        Assertions.assertTrue(expectedResponse.getQuery().contains(AND_EXPERIENCE_ID_EQUALS));
        Assertions.assertTrue(expectedResponse.getQuery().contains(AND_PLACE_ID_EQUALS));
        Assertions.assertTrue(expectedResponse.getQuery().contains(AND_SECTOR_ID_EQUALS));
        Assertions.assertTrue(expectedResponse.getQuery().contains(AND_SECTOR_MAX_PRICE_LESS_EQUALS));
        Assertions.assertTrue(expectedResponse.getQuery().contains(AND_SECTOR_MIN_PRICE_GREATER_EQUALS));
        Assertions.assertTrue(expectedResponse.getQuery().contains(AND_EVENT_END_DATETIME_LESS_EQUALS));
        Assertions.assertTrue(expectedResponse.getQuery().contains(AND_EVENT_INIT_DATETIME_GREATER_EQUALS));
        Assertions.assertTrue(expectedResponse.getQuery().contains(AND_EXPERIENCE_NAME_LIKE));
        Assertions.assertTrue(expectedResponse.getQuery().contains(ORDER_BY_FIELD));
    }


    @Test
    @DisplayName("Should not contains none filter in method prepareQueryData")
    public void notContainsNoneFilterInPrepareQueryData() {
        FilterEventRequest filterEventRequest = injectDataTest.buildFilterEventRequest(200);

        when(utilities.isNullObject(Mockito.any())).thenReturn(true);

        FilterEventRequestDTO expectedResponse = filterEventPrepareData.prepareQueryData(filterEventRequest);
        Assertions.assertFalse(expectedResponse.getQuery().contains(AND_EVENT_ID_EQUALS));
        Assertions.assertFalse(expectedResponse.getQuery().contains(AND_EXPERIENCE_ID_EQUALS));
        Assertions.assertFalse(expectedResponse.getQuery().contains(AND_PLACE_ID_EQUALS));
        Assertions.assertFalse(expectedResponse.getQuery().contains(AND_SECTOR_ID_EQUALS));
        Assertions.assertFalse(expectedResponse.getQuery().contains(AND_SECTOR_MAX_PRICE_LESS_EQUALS));
        Assertions.assertFalse(expectedResponse.getQuery().contains(AND_SECTOR_MIN_PRICE_GREATER_EQUALS));
        Assertions.assertFalse(expectedResponse.getQuery().contains(AND_EVENT_END_DATETIME_LESS_EQUALS));
        Assertions.assertFalse(expectedResponse.getQuery().contains(AND_EVENT_INIT_DATETIME_GREATER_EQUALS));
        Assertions.assertFalse(expectedResponse.getQuery().contains(AND_EXPERIENCE_NAME_LIKE));
        Assertions.assertFalse(expectedResponse.getQuery().contains(ORDER_BY_FIELD));
    }

    @Test
    @DisplayName("Should contains order by asc or desc in method prepareQueryData")
    public void containsOrderByAscDescInPrepareQueryData() {
        FilterEventRequest filterEventRequest = injectDataTest.buildFilterEventRequest(200);

        when(utilities.isNullObject(Mockito.any())).thenReturn(false);

        FilterEventRequestDTO expectedResponseTrue = filterEventPrepareData.prepareQueryData(filterEventRequest);
        Assertions.assertTrue(expectedResponseTrue.getQuery().contains(ORDER_BY_FIELD));

        filterEventRequest.setIsSortOrderAsc(false);

        FilterEventRequestDTO expectedResponseFalse = filterEventPrepareData.prepareQueryData(filterEventRequest);
        Assertions.assertTrue(expectedResponseFalse.getQuery().contains(ORDER_BY_FIELD));
    }

    @Test
    @DisplayName("Should not contains order by asc or desc in method prepareQueryData")
    public void notContainsOrderByAscDescInPrepareQueryData() {
        FilterEventRequest filterEventRequest = injectDataTest.buildFilterEventRequest(200);

        when(utilities.isNullObject(Mockito.any())).thenReturn(false, false, false, false, false, false, false, false, false, false, true);

        FilterEventRequestDTO expectedResponseTrue = filterEventPrepareData.prepareQueryData(filterEventRequest);
        Assertions.assertFalse(expectedResponseTrue.getQuery().contains(ORDER_BY_FIELD));
    }
}
