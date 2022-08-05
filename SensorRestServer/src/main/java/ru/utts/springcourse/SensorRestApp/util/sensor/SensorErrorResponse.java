package ru.utts.springcourse.SensorRestApp.util.sensor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Vlad Utts
 */
@Getter
@Setter
@AllArgsConstructor
public class SensorErrorResponse {
    private String message;
    private long timestamp;
}
