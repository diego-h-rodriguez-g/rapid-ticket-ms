package com.dev.rapidticket.createreservation.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.util.List;

import static com.dev.rapidticket.commons.utilities.Constants.*;

@Builder
@Data
public class CreateReservationRequest {

    @NotBlank (message = ERROR_MESSAGE_NOT_BLANK)
    private String customerName;

    @NotNull(message = ERROR_MESSAGE_NOT_NULL)
    @Positive(message = ERROR_MESSAGE_POSITIVE)
    private Long customerDocumentNumber;

    @NotEmpty(message = ERROR_MESSAGE_NOT_EMPTY)
    private List<Integer> sectorSeatIds;
}
