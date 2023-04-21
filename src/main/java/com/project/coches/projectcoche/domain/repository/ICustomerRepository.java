package com.project.coches.projectcoche.domain.repository;

import com.project.coches.projectcoche.domain.dto.BrandCarDto;
import com.project.coches.projectcoche.domain.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

/**
 * Interface de repostorio de cliente
 */
public interface ICustomerRepository {

    List<CustomerDto> getAll();

    Optional<CustomerDto> getCustomerById(String cardId);


    Optional<CustomerDto> getCustomerByEmail(String email);


   CustomerDto save (CustomerDto newCustomer);


    void delete(String cardId);
}
