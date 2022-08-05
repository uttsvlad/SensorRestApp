package ru.utts.springcourse.SensorRestApp.util.meauserement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Vlad Utts
 */
@Getter
@Setter
@AllArgsConstructor
public class MeasurementErrorResponse {
    private String message;
    private long timestamp;
}
