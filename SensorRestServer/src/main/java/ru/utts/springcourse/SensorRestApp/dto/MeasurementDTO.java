package ru.utts.springcourse.SensorRestApp.dto;

import lombok.Getter;
import lombok.Setter;
import ru.utts.springcourse.SensorRestApp.models.Sensor;

import javax.validation.constraints.*;

/**
 * @author Vlad Utts
 */
@Getter
@Setter
public class MeasurementDTO {
    @Min(value = -100, message = "Value should be greater than -100!")
    @Max(value = 100, message = "Value should be less than 100!")
    @NotNull
    private Double value;

    @NotNull
    private Boolean raining;

    @NotNull
    private Sensor sensor;
}
