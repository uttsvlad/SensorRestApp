package ru.utts.springcourse.SensorRestApp.util.meauserement;

/**
 * @author Vlad Utts
 */
public class MeasurementNotCreatedException extends RuntimeException{
    public MeasurementNotCreatedException(String message) {
        super(message);
    }
}
