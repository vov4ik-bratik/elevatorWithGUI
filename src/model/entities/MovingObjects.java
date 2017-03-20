package model.entities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableIntegerValue;
import model.constant.Const;
import model.utilities.RandomDigitsGenerator;


abstract class MovingObjects {

    private IntegerProperty currentPos = new SimpleIntegerProperty(0);

    private int destinationPos;

    abstract public void moveUp();

    abstract public void moveDown();

    public MovingObjects() {

        currentPos.set(RandomDigitsGenerator.generator(Const.BUILDING_FIRST_FLOORS, Const.BUILDING_LAST_FLOORS));;
        destinationPos = currentPos.get();
    }


    public int getCurrentPos() {return currentPos.get(); }

    public IntegerProperty getObservatedCurrentPos() {return currentPos; }

    public int getDestinationPos() {
        return destinationPos;
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos.set(currentPos);
    }

    public void setDestinationPos(int destinationPos) {
        this.destinationPos = destinationPos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovingObjects)) return false;

        MovingObjects that = (MovingObjects) o;

        if (currentPos != that.currentPos) return false;
        return destinationPos == that.destinationPos;
    }

    @Override
    public int hashCode() {
        int result = currentPos.get();
        result = 31 * result + destinationPos;
        return result;
    }



}
