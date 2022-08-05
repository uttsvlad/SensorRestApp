package ru.utts.springcourse.SensorRestApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.utts.springcourse.SensorRestApp.models.Measurement;

import java.util.List;

/**
 * @author Vlad Utts
 */
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
    List<Measurement> findAllByRainingIsTrue();
}
