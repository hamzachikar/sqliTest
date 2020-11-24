package parking;

import org.junit.Before;
import org.junit.Test;
import parking.builder.ParkingBuilder;

import static org.junit.Assert.*;

/**
 * The aim of this exercice is to fill a square shaped park. Here are the representation rules :
 * <ul>
 * <li>'=' is a pedestrian exit
 * <li>'@' is a disabled-only empty bay
 * <li>'U' is a non-disabled empty bay
 * <li>'D' is a disabled-only occupied bay
 * <li>Any other character but the above : the char representation of a parked vehicle for non-empty bays.
 * <li>U, D, @ and = can be considered as reserved chars.
 *</ul>
 * Once an end of lane is reached, then the next lane is reversed (to represent the fact that cars need to turn around)
 */

public class ParkingTest
{
    private static final int FIRSTUPEDESTRIANUEXITUINDEX = 8;
    private Parking parking;

    ///////////////////////////
    // Parking filling tests //
    ///////////////////////////

    /**
     * Setting up the park for the rest of the tests For the remaining of the exercice, this park will called
     * "The Parking" (case sensitive)
     */
    @Before
    public void setUp()
    {
        parking = new ParkingBuilder()
                .withSquareSize(5)
                .withPedestrianExit(FIRSTUPEDESTRIANUEXITUINDEX)
                .withPedestrianExit(12)
                .withDisabledBay(5)
                .withDisabledBay(10)
                .build();
    }

    /**
     * The Parking has to look like this :
     * UUUUU
     * U=UU@
     * @U=UU
     * UUUUU
     * UUUUU
     */
   @Test
    public void testToString()
    {
        assertEquals("UUUUU\nU=UU@\n@U=UU\nUUUUU\nUUUUU", parking.toString());
        assertEquals(23, parking.countAvailableCells());
    }

    /**
     * When you park a car, you want it to be close to a pedestrian exit. So if the car C parks, it will be at the
     * position 7 of The Parking like so :
     * UUUUU
     * U=CU@
     * @U=UU
     * UUUUU
     * UUUUU
     * There will also be 22 and not 23 empty spots after the car C has parked.
     */



}

