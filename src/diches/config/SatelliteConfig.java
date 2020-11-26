package diches.config;

import static diches.config.Configuration.*;
public class SatelliteConfig {
    public static String getSatellite(String sat){
        switch (sat){
            case "A":
                return ASTRA;
            case "H":
                return HOTBIRD;
            case "N":
                return NILESAT;
            default:
                return null;
        }
    }
}
