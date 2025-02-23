package com.dev.rapidticket.filterevent.service;

import com.dev.rapidticket.commons.utilities.Utilities;
import com.dev.rapidticket.filterevent.dto.FilterEventRequestDTO;
import com.dev.rapidticket.filterevent.model.FilterEventRequest;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

import static com.dev.rapidticket.filterevent.utilities.Constants.*;

@Service
public class FilterEventPrepareDataImpl implements FilterEventPrepareData {

    private final Utilities utilities;

    public FilterEventPrepareDataImpl(Utilities utilities) {
        this.utilities = utilities;
    }

    @Override
    public FilterEventRequestDTO prepareQueryData(FilterEventRequest filterEventRequest) {
        Map<String, Object> parameters = new HashMap<>();
        StringBuilder stringQuery = new StringBuilder(INIT_QUERY);

        if (Boolean.FALSE.equals(utilities.isNullObject(filterEventRequest.getEventId()))) {
            stringQuery.append(AND_EVENT_ID_EQUALS);
            parameters.put("eventId", filterEventRequest.getEventId());
        }
        if (Boolean.FALSE.equals(utilities.isNullObject(filterEventRequest.getExperienceId()))) {
            stringQuery.append(AND_EXPERIENCE_ID_EQUALS);
            parameters.put("experienceId", filterEventRequest.getExperienceId());
        }
        if (Boolean.FALSE.equals(utilities.isNullObject(filterEventRequest.getPlaceId()))) {
            stringQuery.append(AND_PLACE_ID_EQUALS);
            parameters.put("placeId", filterEventRequest.getPlaceId());
        }
        if (Boolean.FALSE.equals(utilities.isNullObject(filterEventRequest.getSectorId()))) {
            stringQuery.append(AND_SECTOR_ID_EQUALS);
            parameters.put("sectorId", filterEventRequest.getSectorId());
        }
        if (Boolean.FALSE.equals(utilities.isNullObject(filterEventRequest.getMaxPrice()))) {
            stringQuery.append(AND_SECTOR_MAX_PRICE_LESS_EQUALS);
            parameters.put("maxPrice", filterEventRequest.getMaxPrice());
        }
        if (Boolean.FALSE.equals(utilities.isNullObject(filterEventRequest.getMinPrice()))) {
            stringQuery.append(AND_SECTOR_MIN_PRICE_GREATER_EQUALS);
            parameters.put("minPrice", filterEventRequest.getMinPrice());
        }
        if (Boolean.FALSE.equals(utilities.isNullObject(filterEventRequest.getEndEventDate()))) {
            stringQuery.append(AND_EVENT_END_DATETIME_LESS_EQUALS);
            parameters.put("endEventDate", filterEventRequest.getEndEventDate());
        }
        if (Boolean.FALSE.equals(utilities.isNullObject(filterEventRequest.getInitEventDate()))) {
            stringQuery.append(AND_EVENT_INIT_DATETIME_GREATER_EQUALS);
            parameters.put("initEventDate", filterEventRequest.getInitEventDate());
        }
        if (Boolean.FALSE.equals(utilities.isNullObject(filterEventRequest.getText()))) {
            stringQuery.append(AND_EXPERIENCE_NAME_LIKE);
            parameters.put("text", "%" + filterEventRequest.getText() + "%");
        }
        stringQuery.append(GROUP_BY);

        if (Boolean.FALSE.equals(utilities.isNullObject(filterEventRequest.getSortFieldTypeEnum())) && Boolean.FALSE.equals(utilities.isNullObject(filterEventRequest.getIsSortOrderAsc()))) {
            String order = Boolean.TRUE.equals(filterEventRequest.getIsSortOrderAsc()) ? " ASC" : " DESC";
            stringQuery.append(ORDER_BY_FIELD).append(filterEventRequest.getSortFieldTypeEnum().getValue()).append(order);
        }
        return FilterEventRequestDTO.builder()
                .query(stringQuery.toString())
                .parameters(parameters)
                .build();
    }
}
