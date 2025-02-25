package com.dev.rapidticket.createreservation.utilities;

public class Constants {
    public static final String INSERT_VALUES_RESERVATION = "INSERT INTO rapid_ticket.reservations (customer_document_number, customer_name, event_id, experience_id, experience_name, " +
            "place_id, place_name, sector_id, sector_name, sector_price, sectors_seats_id, seat_id, seat_row, seat_column, seat_number) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String RESPONSE_MESSAGE_RESERVATION= "Reservation completed successfully";

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

}
