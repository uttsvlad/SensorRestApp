package dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Vlad Utts
 */
@Getter
@Setter
public class MeasurementDTO {
    private Double value;
    private Boolean isRaining;
    private SensorDTO sensor;
}
