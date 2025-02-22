package com.dev.rapidticket.filterevent.repository;

import com.dev.rapidticket.commons.utilities.Utilities;
import com.dev.rapidticket.filterevent.dto.FilterEventResponseDTO;
import com.dev.rapidticket.filterevent.model.FilterEventRequest;
import com.dev.rapidticket.filterevent.model.FilterEventResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.dev.rapidticket.commons.utilities.Constants.RESPONSE_MESSAGE_FILTER_EVENT;

@Repository
public class FilterEventRepositoryImpl implements FilterEventRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    private final Utilities utilities;

    String filterEventQuery = "SELECT e.event_id, exp.experience_id, exp.experience_name,  e.event_datetime, p.place_id, " +
            "    p.place_name, s.sector_id, s.sector_name, s.sector_price,  COUNT(ss.seat_id) AS available_seats " +
            "FROM rapid_ticket.events e " +
            "JOIN rapid_ticket.experiences exp ON e.experience_id = exp.experience_id " +
            "JOIN rapid_ticket.places p ON e.place_id = p.place_id " +
            "JOIN rapid_ticket.sectors s ON e.event_id = s.event_id " +
            "JOIN rapid_ticket.sectors_seats ss ON s.sector_id = ss.sector_id " +
            "WHERE ss.available_seat = TRUE";

    String groupEventQuery = " GROUP BY e.event_id, exp.experience_id, exp.experience_name, e.event_datetime, p.place_id, p.place_name, s.sector_id, s.sector_name, s.sector_price ";

    public FilterEventRepositoryImpl(EntityManager entityManager, Utilities utilities) {
        this.entityManager = entityManager;
        this.utilities = utilities;
    }

    @Override
    public FilterEventResponse getEvents(FilterEventRequest filterEventRequest) {
        Map<String, Object> parameters = new HashMap<>();
        StringBuilder stringQuery = new StringBuilder(filterEventQuery);

        if (Boolean.FALSE.equals(utilities.isNullObject(filterEventRequest.getEventId()))) {
            stringQuery.append(" AND e.event_id = :eventId ");
            parameters.put("eventId", filterEventRequest.getEventId());
        }
        if (Boolean.FALSE.equals(utilities.isNullObject(filterEventRequest.getExperienceId()))) {
            stringQuery.append(" AND exp.experience_id = :experienceId ");
            parameters.put("experienceId", filterEventRequest.getExperienceId());
        }
        if (Boolean.FALSE.equals(utilities.isNullObject(filterEventRequest.getPlaceId()))) {
            stringQuery.append(" AND p.place_id = :placeId ");
            parameters.put("placeId", filterEventRequest.getPlaceId());
        }
        if (Boolean.FALSE.equals(utilities.isNullObject(filterEventRequest.getSectorId()))) {
            stringQuery.append(" AND s.sector_id = :sectorId ");
            parameters.put("sectorId", filterEventRequest.getSectorId());
        }
        if (Boolean.FALSE.equals(utilities.isNullObject(filterEventRequest.getMaxPrice()))) {
            stringQuery.append(" AND s.sector_price <= :maxPrice ");
            parameters.put("maxPrice", filterEventRequest.getMaxPrice());
        }
        if (Boolean.FALSE.equals(utilities.isNullObject(filterEventRequest.getMinPrice()))) {
            stringQuery.append(" AND s.sector_price >= :minPrice ");
            parameters.put("minPrice", filterEventRequest.getMinPrice());
        }
        if (Boolean.FALSE.equals(utilities.isNullObject(filterEventRequest.getEndEventDate()))) {
            stringQuery.append(" AND e.event_datetime <= :endEventDate ");
            parameters.put("endEventDate", filterEventRequest.getEndEventDate());
        }
        if (Boolean.FALSE.equals(utilities.isNullObject(filterEventRequest.getInitEventDate()))) {
            stringQuery.append(" AND e.event_datetime >= :initEventDate ");
            parameters.put("initEventDate", filterEventRequest.getInitEventDate());
        }
        if (Boolean.FALSE.equals(utilities.isNullObject(filterEventRequest.getText()))) {
            stringQuery.append(" AND exp.experience_name ILIKE :text ");
            parameters.put("text", "%" + filterEventRequest.getText() + "%");
        }
        stringQuery.append(groupEventQuery);

        if (Boolean.FALSE.equals(utilities.isNullObject(filterEventRequest.getSortFieldTypeEnum())) && Boolean.FALSE.equals(utilities.isNullObject(filterEventRequest.getIsSortOrderAsc()))) {
            String order = Boolean.TRUE.equals(filterEventRequest.getIsSortOrderAsc()) ? " ASC" : " DESC";
            stringQuery.append(" ORDER BY ").append(filterEventRequest.getSortFieldTypeEnum().getValue()).append(order);
        }

        Query query = entityManager.createNativeQuery(stringQuery.toString());
        parameters.forEach(query::setParameter);
        List<Object[]> queryResponse = query.getResultList();
        System.out.println("queryResponse" + queryResponse);
        List<FilterEventResponseDTO> filterEventResponseDTOList = queryResponse.stream()
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


        return FilterEventResponse.builder()
                .rowCount(queryResponse.size())
                .message(RESPONSE_MESSAGE_FILTER_EVENT)
                .filterEventResponseDTOList(filterEventResponseDTOList)
                .build();
    }
}
