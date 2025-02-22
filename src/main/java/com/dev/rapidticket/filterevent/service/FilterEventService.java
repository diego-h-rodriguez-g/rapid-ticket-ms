package com.dev.rapidticket.filterevent.service;

import com.dev.rapidticket.filterevent.model.FilterEventRequest;
import com.dev.rapidticket.filterevent.model.FilterEventResponse;

public interface FilterEventService {

    FilterEventResponse getFilterEvents(FilterEventRequest filterEventRequest);
}
