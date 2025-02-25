package com.dev.rapidticket.filterevent.utilities;

public class Constants {

    public static final String RESPONSE_MESSAGE_FILTER_EVENT = "The query on the events table was successful";
    public static final String INIT_QUERY = "SELECT e.event_id, exp.experience_id, exp.experience_name,  e.event_datetime, p.place_id, " +
            "p.place_name, s.sector_id, s.sector_name, s.sector_price,  COUNT(ss.seat_id) AS available_seats " +
            "FROM rapid_ticket.events e " +
            "JOIN rapid_ticket.experiences exp ON e.experience_id = exp.experience_id " +
            "JOIN rapid_ticket.places p ON e.place_id = p.place_id " +
            "JOIN rapid_ticket.sectors s ON e.event_id = s.event_id " +
            "JOIN rapid_ticket.sectors_seats ss ON s.sector_id = ss.sector_id " +
            "WHERE ss.available_seat = TRUE " +
            "AND e.event_datetime >= NOW() ";
    public static final String GROUP_BY = "GROUP BY e.event_id, exp.experience_id, exp.experience_name, e.event_datetime, p.place_id, p.place_name, s.sector_id, s.sector_name, s.sector_price ";
    public static final String AND_EVENT_ID_EQUALS = "AND e.event_id = :eventId ";
    public static final String AND_EXPERIENCE_ID_EQUALS = "AND exp.experience_id = :experienceId ";
    public static final String AND_PLACE_ID_EQUALS = "AND p.place_id = :placeId ";
    public static final String AND_SECTOR_ID_EQUALS = "AND s.sector_id = :sectorId ";
    public static final String AND_SECTOR_MAX_PRICE_LESS_EQUALS = "AND s.sector_price <= :maxPrice ";
    public static final String AND_SECTOR_MIN_PRICE_GREATER_EQUALS = "AND s.sector_price >= :minPrice ";
    public static final String AND_EVENT_END_DATETIME_LESS_EQUALS = "AND e.event_datetime <= :endEventDate ";
    public static final String AND_EVENT_INIT_DATETIME_GREATER_EQUALS = "AND e.event_datetime >= :initEventDate ";
    public static final String AND_EXPERIENCE_NAME_LIKE = "AND exp.experience_name ILIKE :text ";
    public static final String ORDER_BY_FIELD = " ORDER BY ";

    private Constants() {
        throw new IllegalStateException("Utility class");
    }
}
