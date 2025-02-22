package com.dev.rapidticket.filterevent.model;

import com.dev.rapidticket.filterevent.dto.FilterEventResponseDTO;
import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterEventResponse {
    private Integer rowCount;
    private String message;
    private List<FilterEventResponseDTO> filterEventResponseDTOList;
}
