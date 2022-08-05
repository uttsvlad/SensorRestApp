package ru.utts.springcourse.SensorRestApp.util.meauserement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.utts.springcourse.SensorRestApp.models.Measurement;
import ru.utts.springcourse.SensorRestApp.services.SensorService;

/**
 * @author Vlad Utts
 */
@Component
public class MeasurementValidator implements Validator {
    private final SensorService sensorService;

    @Autowired
    public MeasurementValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return MeasurementValidator.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Measurement measurement = (Measurement) target;

        if (measurement.getSensor() == null) {
            return;
        }
        if (sensorService.findByName(measurement.getSensor().getName()).isEmpty())
            errors.rejectValue("sensor", "", "Sensor with this name doesn't exist!");
    }
}
