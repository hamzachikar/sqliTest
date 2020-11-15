package electricTrip;

public class ElectricTrip {
    Trip trip;
    public ElectricTrip(){}
    class Trip{
        String start;
        String end;
        int distance;
        public Trip(String tripDetail){
            String[] split=tripDetail.split("-");
            this.start=split[0];
            this.end=split[2];
            this.distance=Integer.valueOf(split[1]);
        }
    }
    public ElectricTrip(String tripDetail){
        this.trip=new Trip(tripDetail);
    }
    public int startTripIn(String start,int batterySize,int lowSpeedPerformance,int highSpeedPerformance){
    return 0;
    }
}
