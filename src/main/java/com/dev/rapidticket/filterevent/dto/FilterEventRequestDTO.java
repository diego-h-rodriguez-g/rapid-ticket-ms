package com.dev.rapidticket.filterevent.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.Map;

@Builder
@Data
@AllArgsConstructor
public class FilterEventRequestDTO {
    private String query;
    private Map<String, Object> parameters;
}
