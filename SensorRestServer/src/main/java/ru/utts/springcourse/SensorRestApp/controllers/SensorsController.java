package ru.utts.springcourse.SensorRestApp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.utts.springcourse.SensorRestApp.dto.SensorDTO;
import ru.utts.springcourse.SensorRestApp.models.Sensor;
import ru.utts.springcourse.SensorRestApp.services.SensorService;
import ru.utts.springcourse.SensorRestApp.util.sensor.SensorErrorResponse;
import ru.utts.springcourse.SensorRestApp.util.sensor.SensorNotCreatedException;
import ru.utts.springcourse.SensorRestApp.util.sensor.SensorValidator;

import javax.validation.Valid;

import static ru.utts.springcourse.SensorRestApp.util.ErrorsReturner.returnSensorErrorsToClient;

/**
 * @author Vlad Utts
 */
@RestController // @Controller + @ResponseBody над каждым методом
@RequestMapping("/sensors")
public class SensorsController {
    private final SensorService sensorService;
    private final SensorValidator sensorValidator;
    private final ModelMapper modelMapper;

    @Autowired
    public SensorsController(SensorService sensorService, SensorValidator sensorValidator, ModelMapper modelMapper) {
        this.sensorService = sensorService;
        this.sensorValidator = sensorValidator;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registration(@RequestBody @Valid SensorDTO sensorDTO,
                                                   BindingResult bindingResult) {
        Sensor sensor = convertToSensor(sensorDTO);

        sensorValidator.validate(sensor, bindingResult);
        if (bindingResult.hasErrors()) {
             returnSensorErrorsToClient(bindingResult);
        }
        sensorService.register(sensor);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Sensor convertToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);
    }

    @ExceptionHandler
    private ResponseEntity<SensorErrorResponse> handleException(SensorNotCreatedException e) {
        SensorErrorResponse response = new SensorErrorResponse(e.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
