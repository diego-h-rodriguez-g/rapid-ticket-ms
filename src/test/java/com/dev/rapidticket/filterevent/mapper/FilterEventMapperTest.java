package com.dev.rapidticket.filterevent.mapper;

import com.dev.rapidticket.InjectDataTest;
import com.dev.rapidticket.filterevent.dto.FilterEventResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterEventMapperTest {

    @InjectMocks
    private FilterEventMapper filterEventMapper;

    private final InjectDataTest injectDataTest = new InjectDataTest();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should return a List of FilterEventResponseDTO in method toFilterEventDTOList")
    public void returnListOfFilterEventResponseDTOInToFilterEventDTOList() {
        List<Object[]> objects = new ArrayList<>();
        objects.add(new Object[]{6, 2, "experience name", "2025-02-23 20:34:19.313994", 3, "stadium", 9, "VIP", BigDecimal.valueOf(50000.00), 30L});
        List<FilterEventResponseDTO> expectedResponse = Collections.singletonList(injectDataTest.buildFilterEventResponseDTO(200));

        assertEquals(expectedResponse, filterEventMapper.toFilterEventDTOList(objects));
    }

}
