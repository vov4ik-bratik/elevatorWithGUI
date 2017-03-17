package interfaces;

import model.entities.Elevator;

/**
 * Created by vs on 16.03.2017.
 */
public interface Elevators {

    int showCurrentPosition (int elevatorId);

    void showStatus (Elevator elevator);

    void callElevator (Elevator elevator);

    void setDestination(Elevator elevator);
}
