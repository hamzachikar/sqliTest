package parking.service;

import parking.builder.bay.Bay;

public interface ParkingService {
    public int park(Bay bay, Bay[][] parking);
}
