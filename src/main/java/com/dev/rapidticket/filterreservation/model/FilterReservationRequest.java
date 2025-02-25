package com.dev.rapidticket.filterreservation.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import static com.dev.rapidticket.commons.utilities.Constants.ERROR_MESSAGE_NOT_NULL;
import static com.dev.rapidticket.commons.utilities.Constants.ERROR_MESSAGE_POSITIVE;

@Builder
@Data
public class FilterReservationRequest {
    @NotNull(message = ERROR_MESSAGE_NOT_NULL)
    @Positive(message = ERROR_MESSAGE_POSITIVE)
    private Long customerDocumentNumber;
}
