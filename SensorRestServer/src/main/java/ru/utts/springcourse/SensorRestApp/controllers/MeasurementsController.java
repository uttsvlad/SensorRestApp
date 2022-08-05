package ru.utts.springcourse.SensorRestApp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.utts.springcourse.SensorRestApp.dto.MeasurementDTO;
import ru.utts.springcourse.SensorRestApp.dto.MeasurementsResponse;
import ru.utts.springcourse.SensorRestApp.models.Measurement;
import ru.utts.springcourse.SensorRestApp.services.MeasurementService;
import ru.utts.springcourse.SensorRestApp.util.ErrorsReturner;
import ru.utts.springcourse.SensorRestApp.util.meauserement.MeasurementErrorResponse;
import ru.utts.springcourse.SensorRestApp.util.meauserement.MeasurementNotCreatedException;
import ru.utts.springcourse.SensorRestApp.util.meauserement.MeasurementValidator;

import javax.validation.Valid;
import java.util.stream.Collectors;

import static ru.utts.springcourse.SensorRestApp.util.ErrorsReturner.returnMeasurementErrorsToClient;

/**
 * @author Vlad Utts
 */
@RestController
@RequestMapping("/measurements")
public class MeasurementsController {
    private final MeasurementService measurementService;
    private final MeasurementValidator measurementValidator;
    private final ModelMapper modelMapper;

    @Autowired
    public MeasurementsController(MeasurementService measurementService, MeasurementValidator measurementValidator, ModelMapper modelMapper) {
        this.measurementService = measurementService;
        this.measurementValidator = measurementValidator;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody @Valid MeasurementDTO measurementDTO,
                    BindingResult bindingResult) {
        Measurement measurement = convertToMeasurement(measurementDTO);

        measurementValidator.validate(measurement, bindingResult);
        if (bindingResult.hasErrors()) {
            returnMeasurementErrorsToClient(bindingResult);
        }
        measurementService.add(measurement);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public MeasurementsResponse getMeasurements(){
        return new MeasurementsResponse
                (measurementService.findAll().stream().map(this::convertToMeasurementDto).collect(Collectors.toList()));
    }

    @GetMapping("/rainyDaysCount")
    public Long getRainyDays(){
        return measurementService.countRainyDays();
    }

    private Measurement convertToMeasurement(MeasurementDTO measurementDTO) {
        return modelMapper.map(measurementDTO, Measurement.class);
    }

    private MeasurementDTO convertToMeasurementDto(Measurement measurement) {
        return modelMapper.map(measurement, MeasurementDTO.class);
    }

    @ExceptionHandler
    private ResponseEntity<MeasurementErrorResponse> handleException(MeasurementNotCreatedException e) {
        MeasurementErrorResponse response = new MeasurementErrorResponse(e.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
