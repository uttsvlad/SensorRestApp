package ru.utts.springcourse.SensorRestApp.util.sensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.utts.springcourse.SensorRestApp.models.Sensor;
import ru.utts.springcourse.SensorRestApp.services.SensorService;

/**
 * @author Vlad Utts
 */
@Component
public class SensorValidator implements Validator {
    private final SensorService sensorService;

    @Autowired
    public SensorValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Sensor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sensor sensor = (Sensor) target;

        if (sensorService.findByName(sensor.getName()).isPresent())
            errors.rejectValue("name", "", "This name of sensor is already taken!");
    }
}
