package com.gridnine.testing.filtrs;

public interface FilterTheSetOfFlights {
    //Departure until the current time
    boolean departureUntilTheCurrentTime();

    //There are segments with arrival date earlier than departure date
    boolean dateArrivalEarlierThanDepartureDate();

    //The total time spent on the ground exceeds two hours
    boolean timeSpentOnTheGroundExceedsTwoHours();
}
