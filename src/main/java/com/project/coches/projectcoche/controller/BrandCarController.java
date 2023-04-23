package com.project.coches.projectcoche.controller;

import com.project.coches.projectcoche.domain.dto.BrandCarDto;
import com.project.coches.projectcoche.domain.useCase.IBrandCarServiceUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/marcas-coches")
public class BrandCarController {

    /**
     * Servico de marca coche
     */
    private final IBrandCarServiceUseCase iBrandCarServiceUseCase;

    @GetMapping
    public ResponseEntity<List<BrandCarDto>> getAll() {
        return ResponseEntity.ok(iBrandCarServiceUseCase.getAll());
        //  alternativa return  ResponseEntity.status(HttpStatus.OK)
        //        .body(iBrandCarService.getAll());
        // otra alternativa return new ResponseEntity<>(iBrandCardService.getAll(), httpStatus.ok);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BrandCarDto> getBrandCar(@PathVariable Integer id) {
        return ResponseEntity.of(iBrandCarServiceUseCase.getBrandCar(id));
    }
    @PostMapping
    public ResponseEntity<BrandCarDto>  save(@RequestBody BrandCarDto brandCarPojonew){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iBrandCarServiceUseCase.save(brandCarPojonew));
        }
        catch(Exception e){
        //otra manera    return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    @PatchMapping
    public ResponseEntity<BrandCarDto>  update(@RequestBody BrandCarDto brandCarDtoUpdate){

            return ResponseEntity.status(HttpStatus.OK)
                    .body(iBrandCarServiceUseCase.save(brandCarDtoUpdate));



    }
    @DeleteMapping(path="/{id}")
    public ResponseEntity<Boolean>  delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iBrandCarServiceUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
