package electricTrip;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * An electric car's endurance is given by the amount of energy it can store in its battery (KWh)
 * and its efficiency (how many Km you can drive with one KWh of energy). Since electric
 * chargers are not yet so frequent on the road it is important to plan a trip according to where
 * the you can charge.
 * The very first charging stations are found today on highways near cities.
 * A trip is defined by a set of cities separated by the number of Km between two cities.
 * It is useful to have system that tells you to stop when you are passing by a charger if there's
 * no further charging infrastructure within the given range. This test suite will bring you to
 * build such a system.
 */
public class ElectricTripTest {
   /* @Test
    public void shouldGetAtDestinationWithLowerCharge() {
        ElectricTrip trip = new ElectricTrip("PARIS-200-BOURGES");
        int batterySize = 85; //KWh
        int lowSpeedPerformance = 5; //Km per KWh
        int highSpeedPerformance = 5; //Km per KWh
        int participantId = trip.startTripIn("PARIS", batterySize, lowSpeedPerformance, highSpeedPerformance);
        trip.go(participantId);
        assertThat(trip.locationOf(participantId), is("BOURGES"));
        assertThat(trip.chargeOf(participantId), is("53%")); //% is rounded to closest integer
    }*/

}
