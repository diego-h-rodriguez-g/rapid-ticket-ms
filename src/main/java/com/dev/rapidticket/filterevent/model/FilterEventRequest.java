package com.dev.rapidticket.filterevent.model;

import com.dev.rapidticket.filterevent.dto.SortFieldTypeEnum;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.dev.rapidticket.commons.utilities.Constants.ERROR_MESSAGE_FUTURE;
import static com.dev.rapidticket.commons.utilities.Constants.ERROR_MESSAGE_POSITIVE;

@Builder
@Data
public class FilterEventRequest {

    @Positive(message = ERROR_MESSAGE_POSITIVE)
    private Integer eventId;

    @Positive(message = ERROR_MESSAGE_POSITIVE)
    private Integer experienceId;

    @Positive(message = ERROR_MESSAGE_POSITIVE)
    private Integer sectorId;

    @Positive(message = ERROR_MESSAGE_POSITIVE)
    private Integer placeId;

    @Positive(message = ERROR_MESSAGE_POSITIVE)
    private BigDecimal maxPrice;

    @Positive(message = ERROR_MESSAGE_POSITIVE)
    private BigDecimal minPrice;

    @Future(message = ERROR_MESSAGE_FUTURE)
    private LocalDateTime initEventDate;

    private LocalDateTime endEventDate;

    private String text;

    @JsonAlias("sortField")
    private SortFieldTypeEnum sortFieldTypeEnum;

    private Boolean isSortOrderAsc;
}
