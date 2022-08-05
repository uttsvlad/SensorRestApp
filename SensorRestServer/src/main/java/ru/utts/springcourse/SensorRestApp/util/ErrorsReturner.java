package ru.utts.springcourse.SensorRestApp.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import ru.utts.springcourse.SensorRestApp.util.meauserement.MeasurementNotCreatedException;
import ru.utts.springcourse.SensorRestApp.util.sensor.SensorNotCreatedException;

import java.util.List;

/**
 * @author Vlad Utts
 */
public class ErrorsReturner {
    public static void returnSensorErrorsToClient(BindingResult bindingResult) {
        StringBuilder stringBuilder = new StringBuilder();
        List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError error : errors) {
            stringBuilder.append(error.getField())
                    .append(" - ")
                    .append(error.getDefaultMessage())
                    .append("; ");
        }
        throw new SensorNotCreatedException(stringBuilder.toString());
    }

    public static void returnMeasurementErrorsToClient(BindingResult bindingResult) {
        StringBuilder stringBuilder = new StringBuilder();
        List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError error : errors) {
            stringBuilder.append(error.getField())
                    .append(" - ")
                    .append(error.getDefaultMessage())
                    .append("; ");
        }
        throw new MeasurementNotCreatedException(stringBuilder.toString());
    }
}
