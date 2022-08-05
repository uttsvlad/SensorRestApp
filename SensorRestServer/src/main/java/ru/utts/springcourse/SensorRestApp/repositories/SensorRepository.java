package ru.utts.springcourse.SensorRestApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.utts.springcourse.SensorRestApp.models.Sensor;

import java.util.Optional;

/**
 * @author Vlad Utts
 */
@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {
    Optional<Sensor> findByName(String name);
}
