package com.dev.rapidticket.filterevent.repository;

import com.dev.rapidticket.filterevent.model.FilterEventRequest;
import com.dev.rapidticket.filterevent.model.FilterEventResponse;

public interface FilterEventRepository  {
    FilterEventResponse getEvents(FilterEventRequest filterEventRequest);
}
