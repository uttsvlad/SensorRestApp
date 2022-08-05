package ru.utts.springcourse.SensorRestApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.utts.springcourse.SensorRestApp.models.Measurement;
import ru.utts.springcourse.SensorRestApp.repositories.MeasurementRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author Vlad Utts
 */
@Service
@Transactional(readOnly = true)
public class MeasurementService {
    private final MeasurementRepository measurementRepository;
    private final SensorService sensorService;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository, SensorService sensorService) {
        this.measurementRepository = measurementRepository;
        this.sensorService = sensorService;
    }

    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }

    @Transactional
    public void add(Measurement measurement) {
        enrichMeasurement(measurement);

        measurementRepository.save(measurement);
    }

    private void enrichMeasurement(Measurement measurement){
        measurement.setSensor(sensorService.findByName(measurement.getSensor().getName()).get());

        measurement.setMeasurementDateTime(LocalDateTime.now());
    }

    public Long countRainyDays() {
        return (long) measurementRepository.findAllByRainingIsTrue().size();
    }
}
