package com.gridnine.testing.flight;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class FlightTest {


    @Test
    void departureUntilTheCurrentTime() {
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(LocalDateTime.of(2021, 11, 11, 1, 0), LocalDateTime.of(2021, 11, 15, 1, 0)));
        Flight flight = new Flight(segments);
        assertTrue(flight.departureUntilTheCurrentTime());
    }


    @Test
    void dateArrivalEarlierThanDepartureDate() {
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(LocalDateTime.of(2021, 11, 11, 9, 0), LocalDateTime.of(2021, 11, 11, 7, 0)));
        Flight flight = new Flight(segments);
        assertFalse(flight.dateArrivalEarlierThanDepartureDate());
    }

    @Test
    void timeSpentOnTheGroundExceedsTwoHours() {
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(LocalDateTime.of(2021, 11, 11, 9, 0), LocalDateTime.of(2021, 11, 11, 11, 0)));
        segments.add(new Segment(LocalDateTime.of(2021, 11, 11, 16, 0), LocalDateTime.of(2021, 11, 11, 20, 0)));
        Flight flight = new Flight(segments);
        assertFalse(flight.timeSpentOnTheGroundExceedsTwoHours());
    }
}