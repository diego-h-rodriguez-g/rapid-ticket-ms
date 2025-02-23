package com.dev.rapidticket.filterevent.service;

import com.dev.rapidticket.commons.utilities.Utilities;
import com.dev.rapidticket.filterevent.dto.FilterEventRequestDTO;
import com.dev.rapidticket.filterevent.mapper.FilterEventMapper;
import com.dev.rapidticket.filterevent.model.FilterEventRequest;
import com.dev.rapidticket.filterevent.model.FilterEventResponse;
import com.dev.rapidticket.filterevent.repository.FilterEventRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Level;

import static com.dev.rapidticket.filterevent.utilities.Constants.RESPONSE_MESSAGE_FILTER_EVENT;

@Service
public class FilterEventServiceImpl implements FilterEventService {

    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(String.valueOf(FilterEventServiceImpl.class));

    private final FilterEventPrepareData filterEventPrepareData;

    private final FilterEventRepository filterEventRepository;

    private final FilterEventMapper filterEventMapper;

    private final Utilities utilities;

    public FilterEventServiceImpl(FilterEventPrepareData filterEventPrepareData, FilterEventRepository filterEventRepository, FilterEventMapper filterEventMapper, Utilities utilities) {
        this.filterEventPrepareData = filterEventPrepareData;
        this.filterEventRepository = filterEventRepository;
        this.filterEventMapper = filterEventMapper;
        this.utilities = utilities;
    }

    @Override
    public FilterEventResponse getFilterEvents(FilterEventRequest filterEventRequest) {
        log.log(Level.INFO, "A new filter events request has been started with the following data: {0}", new Object[]{utilities.convertObjectToString(filterEventRequest)});
        FilterEventRequestDTO filterEventRequestDTO = filterEventPrepareData.prepareQueryData(filterEventRequest);
        List<Object[]> listObjectsResponse = filterEventRepository.getEvents(filterEventRequestDTO);
        return FilterEventResponse.builder()
                .rowCount(listObjectsResponse.size())
                .message(RESPONSE_MESSAGE_FILTER_EVENT)
                .eventList(filterEventMapper.toFilterEventDTOList(listObjectsResponse))
                .build();
    }
}
