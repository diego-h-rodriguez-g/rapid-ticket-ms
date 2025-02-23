package com.dev.rapidticket;

import com.dev.rapidticket.filterevent.dto.FilterEventRequestDTO;
import com.dev.rapidticket.filterevent.dto.FilterEventResponseDTO;
import com.dev.rapidticket.filterevent.dto.SortFieldTypeEnum;
import com.dev.rapidticket.filterevent.model.FilterEventRequest;
import com.dev.rapidticket.filterevent.model.FilterEventResponse;
import com.dev.rapidticket.javastack.model.JavaStackResponse;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static com.dev.rapidticket.commons.utilities.Constants.RESPONSE_MESSAGE_JAVA_STACK;
import static com.dev.rapidticket.filterevent.utilities.Constants.INIT_QUERY;
import static com.dev.rapidticket.filterevent.utilities.Constants.RESPONSE_MESSAGE_FILTER_EVENT;

public class InjectDataTest {

    public JavaStackResponse buildJavaStackResponse(int index) {
        if (index == 200) {
            return JavaStackResponse.builder()
                    .code(HttpStatus.OK.value())
                    .message(RESPONSE_MESSAGE_JAVA_STACK)
                    .springVersion(SpringVersion.getVersion())
                    .springBootVersion(SpringBootVersion.getVersion())
                    .javaVersion(System.getProperty("java.version"))
                    .build();
        }
        return JavaStackResponse.builder().build();
    }

    public FilterEventRequest buildFilterEventRequest(int index) {
        if (index == 200) {
            return FilterEventRequest.builder().eventId(6)
                    .eventId(6)
                    .experienceId(2)
                    .sectorId(9)
                    .placeId(3)
                    .maxPrice(BigDecimal.valueOf(50000.00))
                    .minPrice(BigDecimal.valueOf(50000.00))
                    .initEventDate(LocalDateTime.now())
                    .endEventDate(LocalDateTime.now())
                    .text("VIP")
                    .sortFieldTypeEnum(SortFieldTypeEnum.eventId)
                    .isSortOrderAsc(true)
                    .build();
        }
        return FilterEventRequest.builder().build();
    }

    public FilterEventResponse buildFilterEventResponse(int index) {
        if (index == 200) {
            return FilterEventResponse.builder().rowCount(index).message(RESPONSE_MESSAGE_FILTER_EVENT).build();
        }
        return FilterEventResponse.builder().build();
    }

    public FilterEventRequestDTO buildFilterEventRequestDTO(int index) {
        Map<String, Object> parameters = new HashMap<>();
        if (index == 200) {
            parameters.put("param", 1);
            return FilterEventRequestDTO.builder().query(INIT_QUERY).parameters(parameters).build();
        }
        return FilterEventRequestDTO.builder().query(INIT_QUERY).parameters(parameters).build();
    }

    public FilterEventResponseDTO buildFilterEventResponseDTO(int index) {
        if (index == 200) {
            return FilterEventResponseDTO.builder()
                    .eventId(6)
                    .experienceId(2)
                    .experienceName("experience name")
                    .eventDateTime("2025-02-23 20:34:19.313994")
                    .placeId(3)
                    .placeName("stadium")
                    .sectorId(9)
                    .sectorName("VIP")
                    .sectorPrice(BigDecimal.valueOf(50000.00))
                    .availableSeats(30L).build();
        }
        return FilterEventResponseDTO.builder().build();
    }
}
