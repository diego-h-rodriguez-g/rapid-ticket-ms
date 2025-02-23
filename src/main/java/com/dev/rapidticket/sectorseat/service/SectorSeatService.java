package com.dev.rapidticket.sectorseat.service;

import com.dev.rapidticket.sectorseat.model.SectorSeatResponse;

public interface SectorSeatService {

    SectorSeatResponse getAvailableSeats(Integer eventId);
}
