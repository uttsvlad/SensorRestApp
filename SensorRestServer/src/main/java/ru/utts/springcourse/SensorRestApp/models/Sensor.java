package ru.utts.springcourse.SensorRestApp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author Vlad Utts
 */
@Entity
@Table(name = "sensor")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Sensor implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Name of sensor should not be empty!")
    @Size(min = 3, max = 30, message = "Name of sensor should be between 3 and 30 characters!")
    private String name;
}