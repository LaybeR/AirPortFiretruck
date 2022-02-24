import AirportFireTruck.AirportFireTruck;
import AirportFireTruck.AirportFireTruck.Builder;

public class Application {

    public static void main(String[] args) {
        System.out.println("Start");
        AirportFireTruck airportFireTruck = new Builder().headlights(6).build();
    }
}
