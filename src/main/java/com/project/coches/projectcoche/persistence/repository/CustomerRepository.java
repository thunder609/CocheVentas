package com.project.coches.projectcoche.persistence.repository;

import com.project.coches.projectcoche.domain.dto.CustomerDto;
import com.project.coches.projectcoche.domain.repository.ICustomerRepository;
import com.project.coches.projectcoche.persistence.entity.CustomerEntity;
import com.project.coches.projectcoche.persistence.mapper.ICustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Repository
public class CustomerRepository implements ICustomerRepository {
     private final ICustomerMapper iCustomerMapper;
     private final ICustomerCrudRepository iCustomerCrudRepository;

    @Override
    public List<CustomerDto> getAll() {
        return  iCustomerMapper.toCustomersDto(iCustomerCrudRepository.findAll());
    }

    @Override
    public Optional<CustomerDto> getCustomerById(String cardId) {
        return iCustomerCrudRepository.findById(cardId)
                .map(iCustomerMapper::toCustomerDto);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerCrudRepository.findByEmail(email)
                .map(iCustomerMapper::toCustomerDto);
    }

    @Override
    public CustomerDto save(CustomerDto Customernew) {
        return iCustomerMapper
                .toCustomerDto(iCustomerCrudRepository.save(iCustomerMapper.toCustomerEntity(Customernew)));
    }

    @Override
    public void delete(String cardId) {
               iCustomerCrudRepository.deleteById(cardId);
    }
}
