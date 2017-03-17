package interfaces.impls;
import model.entities.Building;
import model.entities.Elevator;

/**
 * Created by vs on 16.03.2017.
 */
public class ElevatorsImpl implements interfaces.Elevators {

    Building building = Building.getInstance();

    public Building getBuilding() {
        return building;
    }

    @Override
    public int showCurrentPosition(int elevatorId) {
        return Building.getInstance().getElevatorById(elevatorId).getCurrentPos();
    }

    @Override
    public void showStatus(Elevator elevator) {
    }

    @Override
    public void callElevator(Elevator elevator) {

    }

    @Override
    public void setDestination(Elevator elevator) {
    }
}
