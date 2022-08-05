package dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Vlad Utts
 */
@Getter
@Setter
public class MeasurementsResponse {
    List<MeasurementDTO> measurements;
}
