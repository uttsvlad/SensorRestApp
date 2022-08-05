package ru.utts.springcourse.SensorRestApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Vlad Utts
 */
@Getter
@Setter
@AllArgsConstructor
public class MeasurementsResponse {
    private List<MeasurementDTO> measurements;
}
