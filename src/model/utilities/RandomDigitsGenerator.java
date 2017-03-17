package model.utilities;


public final class RandomDigitsGenerator {


    public static int generator (int min, int max){

        return (int)(Math.random()*(max - min + 1)) + min;

    }

}
