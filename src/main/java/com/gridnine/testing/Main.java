package com.gridnine.testing;

import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.FlightBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        //get a list of flights
        List<Flight> flightList = FlightBuilder.createFlights();

        //display information on request
        //If the volume of data with flights is very large, here you can create a new thread for each filtering
        System.out.println("WITHOUT DEPARTURE UNTIL THE CURRENT TIME \n");
        flightList.stream()
                .filter(Flight::departureUntilTheCurrentTime)
                .forEach(System.out::println);

        System.out.println("\n WITHOUT THERE ARE SEGMENTS WITH ARRIVAL DATE EARLIER THAN DEPARTURE DATE\n");
        flightList.stream()
                .filter(Flight::dateArrivalEarlierThanDepartureDate)
                .forEach(System.out::println);

        System.out.println("\n WITHOUT THE TOTAL TIME SPENT ON THE GROUND EXCEEDS TWO HOURS \n");
        flightList.stream()
                .filter(Flight::timeSpentOnTheGroundExceedsTwoHours)
                .forEach(System.out::println);


    }
}
