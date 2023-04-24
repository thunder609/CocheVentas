package com.project.coches.projectcoche.controller;

import com.project.coches.projectcoche.domain.dto.BrandCarDto;
import com.project.coches.projectcoche.domain.dto.CarDto;
import com.project.coches.projectcoche.domain.useCase.ICarServiceUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping(path="/carros")
public class CarController {
    private final ICarServiceUseCase iCarServiceUseCase;

    @GetMapping()
    public ResponseEntity<List<CarDto>> getAll(){

        return  ResponseEntity.ok(iCarServiceUseCase.getAll());
    }

    @PostMapping
    public ResponseEntity<CarDto>  save(@RequestBody CarDto carPojonew){

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iCarServiceUseCase.save(carPojonew));



    }
    @GetMapping(path = "/brand-car/{idBrandCar}")
    public ResponseEntity<List<CarDto>> getByIdBrandCar(@PathVariable Integer idBrandCar) {
        return ResponseEntity.ok(iCarServiceUseCase.getByIdBrandCar(idBrandCar));
    }

    @GetMapping(path = "/{idCar}")
    public ResponseEntity<CarDto> getCar(@PathVariable Integer idCar) {
        return ResponseEntity.of(iCarServiceUseCase.getCar(idCar));
    }
    @GetMapping(path="/price{priceCar}")
    public ResponseEntity<List<CarDto>> getCarsByPriceLessThan(@PathVariable  Double priceCar){
        return  ResponseEntity.ok(iCarServiceUseCase.getCarsByPriceLessThan(priceCar));
    }
    @DeleteMapping(path = "/{idCar}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer idCar) {
        return new ResponseEntity<>(this.iCarServiceUseCase.delete(idCar) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }


}
