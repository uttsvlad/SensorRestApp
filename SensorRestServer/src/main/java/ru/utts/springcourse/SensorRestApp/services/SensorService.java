package ru.utts.springcourse.SensorRestApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.utts.springcourse.SensorRestApp.models.Sensor;
import ru.utts.springcourse.SensorRestApp.repositories.SensorRepository;

import java.util.Optional;

/**
 * @author Vlad Utts
 */
@Service
@Transactional(readOnly = true)
public class SensorService {

    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public Optional<Sensor> findByName(String name) {
        return sensorRepository.findByName(name);
    }

    @Transactional
    public void register(Sensor sensor) {
        sensorRepository.save(sensor);
    }
}
