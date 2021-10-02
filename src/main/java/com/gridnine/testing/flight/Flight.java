package com.gridnine.testing.flight;

import com.gridnine.testing.filtrs.FilterTheSetOfFlights;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Flight implements FilterTheSetOfFlights {

    private final List<Segment> segments;

    Flight(final List<Segment> segs) {
        segments = segs;
    }

    List<Segment> getSegments() {
        return segments;
    }


    @Override
    public String toString() {
        return segments.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));
    }

    @Override
    public boolean departureUntilTheCurrentTime() {
        return segments.stream()
                .anyMatch(segment -> segment.getDepartureDate()
                        .isAfter(LocalDateTime.now()));
    }

    @Override
    public boolean dateArrivalEarlierThanDepartureDate() {
        return segments.stream()
                .anyMatch(segment -> segment.getDepartureDate()
                        .isBefore(segment.getArrivalDate()));
    }

    @Override
    public boolean timeSpentOnTheGroundExceedsTwoHours() {
        long hoursCount = 0;
        if (segments.size() > 1) {

            for (int i = 0; i < segments.size() - 1; i++) {
                hoursCount += Duration.between(segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate()).toHours();

            }
        }

        return hoursCount < 2;

    }
}
