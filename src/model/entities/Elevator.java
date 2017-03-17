package model.entities;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import model.constant.Const;

import java.util.ArrayList;
import java.util.List;


public class Elevator extends MovingObjects {

    private final int elevatorId;
    private final int capacity;
    private int currentLoad;
    private List<Passenger> elevatedPassenger;

    public Elevator(int id, int capacity) {

        elevatorId = id;
        this.capacity = capacity;
        currentLoad = 0;
        elevatedPassenger = new ArrayList<>();
    }


    public int getElevatorId() {
        return elevatorId;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentLoad() {
        return currentLoad;
    }

    public List<Passenger> getElevatedPassenger() {
        return elevatedPassenger;
    }


    public void setCurrentLoad(int load) {
        this.currentLoad += load;
    }

    public void moveUp(){

        try {
            Thread.sleep(Const.ELEVATE_TIME_PER_FLOOR_ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

            if(getCurrentPos() >= Const.BUILDING_LAST_FLOORS)
                return;
            else setCurrentPos(getCurrentPos() + 1 );

            for (Passenger p : elevatedPassenger) {
                p.moveUp();
            }

            System.out.println("Elevator " + getElevatorId() + " move up. Current floor - " + getCurrentPos());
    }

    public void moveDown(){

        try {
            Thread.sleep(Const.ELEVATE_TIME_PER_FLOOR_ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

            if(getCurrentPos() <= Const.BUILDING_FIRST_FLOORS)
                return;
            else setCurrentPos(getCurrentPos() - 1 );

            for (Passenger p : elevatedPassenger) {
                p.moveDown();
            }

            System.out.println("Elevator " + getElevatorId() + " move down. Current floor - " + getCurrentPos());
        }


    public void openDoors(){

        try {
                Thread.sleep(Const.ELEVATOR_DOORS_OPEN_CLOSE_TIME_ms);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        System.out.println("dooors opened");

    }

    public void closeDoors(){

        try {
            Thread.sleep(Const.ELEVATOR_DOORS_OPEN_CLOSE_TIME_ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("dooors closed");
    }


    public void passengerIn(Passenger passenger) {
        setCurrentLoad(passenger.getWeight());
        elevatedPassenger.add(passenger);
        System.out.println("passenger in to elevator " + getElevatorId());
    }

    public void passengerOut(Passenger passenger) {
        currentLoad -= passenger.getWeight();
        System.out.println("passenger out from elevator " + getElevatorId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Elevator elevator = (Elevator) o;

        if (elevatorId != elevator.elevatorId) return false;
        if (capacity != elevator.capacity) return false;
        if (currentLoad != elevator.currentLoad) return false;
        return elevatedPassenger != null ? elevatedPassenger.equals(elevator.elevatedPassenger) : elevator.elevatedPassenger == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + elevatorId;
        result = 31 * result + capacity;
        result = 31 * result + currentLoad;
        result = 31 * result + (elevatedPassenger != null ? elevatedPassenger.hashCode() : 0);
        return result;
    }

    public String toString() {
        return "Elevator{" +
                "capacity: " + capacity +
                ", current load: " + currentLoad +
                ", current position: " + getCurrentPos() +
                ", destination position: " + getDestinationPos() +
                '}';
    }

}
