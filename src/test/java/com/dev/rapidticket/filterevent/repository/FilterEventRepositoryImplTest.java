package com.dev.rapidticket.filterevent.repository;

import com.dev.rapidticket.InjectDataTest;
import com.dev.rapidticket.filterevent.dto.FilterEventRequestDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FilterEventRepositoryImplTest {

    @InjectMocks
    private FilterEventRepositoryImpl filterEventRepository;

    @Mock
    private EntityManager entityManager;

    @Mock
    private Query query;

    private final InjectDataTest injectDataTest = new InjectDataTest();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should return a List of Object[] in method getEvents")
    void returnListOfObjectsInGetEvents() {
        FilterEventRequestDTO filterEventRequestDTO = injectDataTest.buildFilterEventRequestDTO(200);
        List<Object[]> expectedResponse = new ArrayList<>();

        when(entityManager.createNativeQuery(filterEventRequestDTO.getQuery())).thenReturn(query);
        filterEventRequestDTO.getParameters().forEach((key, value) -> doAnswer(invocation -> null).when(query).setParameter(key, value));
        when(query.getResultList()).thenReturn(expectedResponse);

        assertEquals(expectedResponse, filterEventRepository.getEvents(filterEventRequestDTO));
    }
}
