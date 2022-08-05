package ru.utts.springcourse.SensorRestApp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author Vlad Utts
 */
@Getter
@Setter
public class SensorDTO {

    @NotEmpty(message = "Name of sensor should not be empty!")
    @Size(min = 3, max = 30, message = "Name of sensor should be between 3 and 30 characters!")
    private String name;
}
