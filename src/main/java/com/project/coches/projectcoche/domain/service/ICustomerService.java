package com.project.coches.projectcoche.domain.service;

import com.project.coches.projectcoche.domain.dto.CustomerDto;
import com.project.coches.projectcoche.domain.dto.ResposeCustomerDto;

import java.util.List;
import java.util.Optional;

/**
 * Interface de Servicio Cliente
 */
public interface ICustomerService {

    List<CustomerDto> getAll();

    Optional<CustomerDto> getCustomerById(String cardId);


    Optional<CustomerDto> getCustomerByEmail(String email);


   ResposeCustomerDto save (CustomerDto newCustomer);

Optional<CustomerDto> update(CustomerDto modifyCustomer);


   boolean delete(String cardId);
}
