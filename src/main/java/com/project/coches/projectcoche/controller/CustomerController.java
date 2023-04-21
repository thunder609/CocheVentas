package com.project.coches.projectcoche.controller;

import com.project.coches.projectcoche.domain.dto.CustomerDto;
import com.project.coches.projectcoche.domain.dto.ResposeCustomerDto;
import com.project.coches.projectcoche.domain.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/customers")

public class CustomerController {
   private final ICustomerService iCustomerService;
    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAll() {
        return ResponseEntity.ok(iCustomerService.getAll());
        //  alternativa return  ResponseEntity.status(HttpStatus.OK)
        //        .body(iBrandCarService.getAll());
        // otra alternativa return new ResponseEntity<>(iBrandCardService.getAll(), httpStatus.ok);
    }
    @GetMapping(path = "/{cardId}")
    public ResponseEntity<CustomerDto> getCustonerBId(@PathVariable String cardId) {
        return ResponseEntity.of(iCustomerService.getCustomerById(cardId));
    }
    @GetMapping(path = "/email/{email}")
    public ResponseEntity<CustomerDto> getCustonerByEmail(@PathVariable String email) {
        return ResponseEntity.of(iCustomerService.getCustomerByEmail(email));
    }
    @PostMapping
    public ResponseEntity<ResposeCustomerDto>  save(@RequestBody CustomerDto customerDtonew){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iCustomerService.save(customerDtonew));
        }
        catch(Exception e){
            //otra manera    return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    @PatchMapping
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customerDtoUpdate){
        return ResponseEntity.of(iCustomerService.update(customerDtoUpdate));
    }
    @DeleteMapping(path = "/{cardId}")
  public ResponseEntity<Boolean> delete(@PathVariable String cardId){
        return new ResponseEntity<>(this.iCustomerService.delete(cardId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
