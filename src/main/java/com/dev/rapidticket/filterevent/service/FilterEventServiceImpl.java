package com.dev.rapidticket.filterevent.service;

import com.dev.rapidticket.commons.utilities.Utilities;
import com.dev.rapidticket.filterevent.model.FilterEventRequest;
import com.dev.rapidticket.filterevent.model.FilterEventResponse;
import com.dev.rapidticket.filterevent.repository.FilterEventRepository;
import org.springframework.stereotype.Service;

import java.util.logging.Level;

@Service
public class FilterEventServiceImpl implements FilterEventService {

    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(String.valueOf(FilterEventServiceImpl.class));

    private final FilterEventRepository filterEventRepository;

    private final Utilities utilities;

    public FilterEventServiceImpl(FilterEventRepository filterEventRepository, Utilities utilities) {
        this.filterEventRepository = filterEventRepository;
        this.utilities = utilities;
    }

    @Override
    public FilterEventResponse getFilterEvents(FilterEventRequest filterEventRequest) {
        log.log(Level.INFO, "A new filter events request has been started with the following data: {0}", new Object[]{utilities.convertObjectToString(filterEventRequest)});
        return filterEventRepository.getEvents(filterEventRequest);
    }
}
