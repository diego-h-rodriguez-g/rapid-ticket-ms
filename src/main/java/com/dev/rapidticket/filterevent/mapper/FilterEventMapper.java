package com.dev.rapidticket.filterevent.mapper;


import com.dev.rapidticket.filterevent.dto.FilterEventResponseDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class FilterEventMapper {

    public List<FilterEventResponseDTO> toFilterEventDTOList(List<Object[]> objects) {
        return objects.stream()
                .map(row -> new FilterEventResponseDTO(
                        (Integer) row[0],
                        (Integer) row[1],
                        (String) row[2],
                        row[3].toString(),
                        (Integer) row[4],
                        (String) row[5],
                        (Integer) row[6],
                        (String) row[7],
                        (BigDecimal) row[8],
                        (Long) row[9]
                ))
                .toList();
    }
}
