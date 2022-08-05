package ru.utts.springcourse.SensorRestApp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Vlad Utts
 */
@Entity
@Table(name = "measurement")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Measurement {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "value")
    @Min(value = -100, message = "Value should be greater than -100!")
    @Max(value = 100, message = "Value should be less than 100!")
    @NotNull
    private Double value;

    @Column(name = "raining")
    @NotNull
    private Boolean raining;

    @Column(name = "measurement_date_time")
    @NotNull
    private LocalDateTime measurementDateTime;

    @ManyToOne
    @JoinColumn(name = "sensor", referencedColumnName = "name")
    @NotNull
    private Sensor sensor;
}
