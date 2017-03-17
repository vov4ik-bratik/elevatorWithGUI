package model.constant;

/**
 * Created by vs on 08.03.17.
 */
public class Const {

    //biulding properties
    public static final int BUILDING_FIRST_FLOORS = 1;
    public static final int BUILDING_LAST_FLOORS = 10;


    //elevators properties
    public static final int FREIGHT_ELEVATOR_CAPACITY = 1000;
    public static final int FREIGHT_ELEVATOR_ID = 1;

    public static final int PASSENGER_ELEVATOR_CAPACITY = 500;
    public static final int FIRST_PASSENGER_ELEVATOR_ID = 2;
    public static final int SECOND_PASSENGER_ELEVATOR_ID = 3;

    public static final int ELEVATE_TIME_PER_FLOOR_ms = 1000;
    public static final int ELEVATOR_DOORS_OPEN_CLOSE_TIME_ms = 1000;
    public static final int EMPTY_ELEVATOR_WAITING_TIME_ms = 2000;


   //passenger properties
    public static final int PASSENGER_MIN_WEIGHT = 15;
    public static final int PASSENGER_MAX_WEIGHT = 160;

    public static final int PASSENGER_GO_IN_OUT_ELEVATOR_TIME_ms = 1000;
    public static final int NEW_PASSENGER_GENERATE_TIME_ms = 2000;

}
