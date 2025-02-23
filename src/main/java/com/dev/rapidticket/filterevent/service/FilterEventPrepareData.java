package com.dev.rapidticket.filterevent.service;

import com.dev.rapidticket.filterevent.dto.FilterEventRequestDTO;
import com.dev.rapidticket.filterevent.model.FilterEventRequest;

public interface FilterEventPrepareData {

    FilterEventRequestDTO prepareQueryData(FilterEventRequest filterEventRequest);
}
