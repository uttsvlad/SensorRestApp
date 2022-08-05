package ru.utts.springcourse.SensorRestApp.util.sensor;

/**
 * @author Vlad Utts
 */
public class SensorNotCreatedException extends RuntimeException {
    public SensorNotCreatedException(String message) {
        super(message);
    }
}
