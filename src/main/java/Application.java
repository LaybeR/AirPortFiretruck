import AirportFireTruck.AirportFireTruck;
import AirportFireTruck.AirportFireTruck.Builder;
import Enums.FrontBackPosition;
import Enums.LeftRightSide;
import Enums.SteeringDirection;
import Enums.SwitchType;
import User.IUser;
import User.Person;

public class Application {

    public static void main(String[] args) {
        System.out.println("Start");
        AirportFireTruck airportFireTruck = new Builder().headlights(6).build();
        IUser user = new Person();
        airportFireTruck.pressDoorButtonLeft(user);
        user = airportFireTruck.sitIn(user, LeftRightSide.LEFT, FrontBackPosition.FRONT);
        System.out.println(user.getClass());
        airportFireTruck.getControlPanel().getSwitch(SwitchType.FIRE_SELF_PROTECTION).press(user);
        airportFireTruck.iterate();
        airportFireTruck.postDisplay();
        System.out.println(airportFireTruck.getCentralUnit().getWaterTank().getFill());
    }
}
