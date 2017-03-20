package model.entities;

import model.constant.Const;

import java.util.*;


public class Building {

    private static final Building BUILDING = new Building();

    private Map <Elevator, List<Passenger>>elevatorsWithPassengers;

    public static Building getInstance (){
        return BUILDING;
    }

    private Building() {

        elevatorsWithPassengers = new HashMap<>();

        elevatorsWithPassengers.put(new Elevator(Const.FREIGHT_ELEVATOR_ID, Const.FREIGHT_ELEVATOR_CAPACITY), new ArrayList<>());
        elevatorsWithPassengers.put(new Elevator(Const.FIRST_PASSENGER_ELEVATOR_ID, Const.PASSENGER_ELEVATOR_CAPACITY), new ArrayList<>());
        elevatorsWithPassengers.put(new Elevator(Const.SECOND_PASSENGER_ELEVATOR_ID, Const.PASSENGER_ELEVATOR_CAPACITY), new ArrayList<>());
    }


    public Map<Elevator, List<Passenger>> getElevatorsWithPassengers() {
        return elevatorsWithPassengers;
    }

    public void createPassenger(int elevatorId, int destination){

        Passenger passenger = new Passenger(elevatorId, destination);
        System.out.println(passenger + "\n");

        getPassengerList(passenger.getElevatorId()).add(passenger);
    }


    public List<Passenger> getPassengerList(int elevatorId){

        for (Map.Entry<Elevator, List<Passenger>> entry : elevatorsWithPassengers.entrySet()){
            if(entry.getKey().getElevatorId() == elevatorId){
                return entry.getValue();
            }
        }
        return null;
    }

    public void setPassengerList(int elevatorId, List<Passenger> passengers){

        for (Map.Entry<Elevator, List<Passenger>> entry : elevatorsWithPassengers.entrySet()){
            if(entry.getKey().getElevatorId() == elevatorId) {
                entry.setValue(passengers);
            }
        }
    }

    public Elevator getElevatorById(int id){

        for (Map.Entry<Elevator, List<Passenger>> entry : elevatorsWithPassengers.entrySet()){
            if(entry.getKey().getElevatorId() == id)
                return entry.getKey();
        }

        return null;
    }

    public void loadUnloadPassenger (Elevator elevator){
        
        elevator.openDoors();

        Iterator<Passenger>iterator = elevator.getElevatedPassenger().iterator();

        while (iterator.hasNext()){
            Passenger p = iterator.next();
            if (p.getDestinationPos() == elevator.getCurrentPos()){
                elevator.passengerOut(p);
                iterator.remove();
            }
        }

        iterator =  getPassengerList(elevator.getElevatorId()).iterator();

        while (iterator.hasNext()){
            Passenger p = iterator.next();
            if(p.getCurrentPos() == elevator.getCurrentPos() &&
                    (elevator.getCurrentLoad() + p.getWeight()) < elevator.getCapacity()){
                elevator.passengerIn(p);
                iterator.remove();
            }
        }

        elevator.closeDoors();
    }

    public void deliverPassenger(Elevator elevator) {

        if(elevator.getDestinationPos() > elevator.getCurrentPos()){
            do{
                elevator.moveUp();

                if(isPassengerOnTheFloor(elevator.getElevatorId(), elevator.getCurrentPos()) ||
                        isArrivedPassengerInElevator(elevator.getElevatorId(), elevator.getCurrentPos())) {
                    loadUnloadPassenger(elevator);
                }

            }while (elevator.getDestinationPos() != elevator.getCurrentPos());
        }
        else {
            do{
                elevator.moveDown();

                if(isPassengerOnTheFloor(elevator.getElevatorId(), elevator.getCurrentPos()) ||
                        isArrivedPassengerInElevator(elevator.getElevatorId(), elevator.getCurrentPos())) {
                    loadUnloadPassenger(elevator);
                }

            }while (elevator.getDestinationPos() != elevator.getCurrentPos());
        }

        elevatorDestiantionChange(elevator);

    }

    public boolean isPassengerOnTheFloor (int elevatorId, int floor){

        for (Passenger p : getPassengerList(elevatorId)) {
            if(p.getCurrentPos() == floor){
                return true;
            }
        }
        return false;
    }

    public boolean isArrivedPassengerInElevator (int elevatorId, int floor){

        for (Passenger p : getElevatorById(elevatorId).getElevatedPassenger()) {
            if(p.getDestinationPos() == floor){
                return true;
            }
        }
        return false;
    }

    public void elevatorDestiantionChange(Elevator elevator){
        if(elevator.getElevatedPassenger().size() > 0 &&
                elevator.getCurrentPos() == elevator.getDestinationPos()){
            elevator.setDestinationPos(elevator.getElevatedPassenger().get(0).getDestinationPos());
        }
        else
        if (elevator.getElevatedPassenger().isEmpty()) {
            elevator.setDestinationPos(elevator.getCurrentPos());
        }
    }

    public void elevatorInitialStart(Elevator elevator){

        elevator.setDestinationPos(getPassengerList(elevator.getElevatorId()).get(0).getCurrentPos());

        if(elevator.getDestinationPos() > elevator.getCurrentPos()){
            do{
                elevator.moveUp();
            }while (elevator.getDestinationPos() != elevator.getCurrentPos());
        }
        else if (elevator.getDestinationPos() < elevator.getCurrentPos()){
            do{
                elevator.moveDown();
            }while (elevator.getDestinationPos() != elevator.getCurrentPos());
        }

        loadUnloadPassenger(elevator);

        elevatorDestiantionChange(elevator);

    }


    public void elevatorStart(Elevator elevator){

        while(true) {

            if (getPassengerList(elevator.getElevatorId()).size() > 0 && elevator.getElevatedPassenger().isEmpty()) {
                elevatorInitialStart(elevator);
            }

            if (!elevator.getElevatedPassenger().isEmpty()) {
                deliverPassenger(elevator);
            }

            try {
                Thread.sleep(Const.EMPTY_ELEVATOR_WAITING_TIME_ms);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
