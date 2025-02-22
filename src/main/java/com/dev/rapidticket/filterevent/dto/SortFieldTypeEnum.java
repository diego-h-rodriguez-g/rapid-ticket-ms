package com.dev.rapidticket.filterevent.dto;

import lombok.Getter;

@Getter
public enum SortFieldTypeEnum {
    eventId("e.event_id"),
    experienceId("exp.experience_id"),
    experienceName("exp.experience_name"),
    placeId("p.place_id"),
    placeName("p.place_name"),
    sectorId("s.sector_id"),
    sectorName("s.sector_name"),
    maxPrice("s.price_amount"),
    minPrice("s.price_amount"),
    initEventDate("e.event_datetime"),
    endEventDate("e.event_datetime"),
    availableSeats("available_seats");

    private final String value;

    SortFieldTypeEnum(String value) {
        this.value = value;
    }

    public static SortFieldTypeEnum fromValue(String value) {
        for (SortFieldTypeEnum sortFieldTypeEnum : values()) {
            if (sortFieldTypeEnum.value.equals(value)) {
                return sortFieldTypeEnum;
            }
        }
        throw new IllegalArgumentException("Valor no válido para SortField: " + value);
    }
}