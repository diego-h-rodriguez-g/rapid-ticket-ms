package com.dev.rapidticket.filterevent.repository;

import com.dev.rapidticket.filterevent.dto.FilterEventRequestDTO;

import java.util.List;

public interface FilterEventRepository  {
    List<Object[]> getEvents(FilterEventRequestDTO filterEventRequestDTO);
}
