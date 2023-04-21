package com.project.coches.projectcoche.domain.service;

import com.project.coches.projectcoche.domain.dto.CustomerDto;
import com.project.coches.projectcoche.domain.dto.ResposeCustomerDto;
import com.project.coches.projectcoche.domain.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

/**
 *
 * Sevico de clientesd
 */
@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {
    private final ICustomerRepository iCustomerRepository;

    @Override
    public Optional<CustomerDto> update(CustomerDto modifyCustomer) {
        if (iCustomerRepository.getCustomerById(modifyCustomer.getCardId()).isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(iCustomerRepository.save(modifyCustomer));
    }

    @Override
    public List<CustomerDto> getAll() {

        return iCustomerRepository.getAll();
    }

    @Override
    public Optional<CustomerDto> getCustomerById(String cardId) {
        return iCustomerRepository.getCustomerById(cardId);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerRepository.getCustomerByEmail(email);
    }

    @Override
    public ResposeCustomerDto save(CustomerDto newCustomer) {
        String passwordGenerate = generarRadomPassword(8);
        newCustomer.setPassword(passwordGenerate);
        newCustomer.setActive(1);
        iCustomerRepository.save(newCustomer);
        return  new ResposeCustomerDto(passwordGenerate);
    }

    @Override
    public boolean delete(String cardId) {
        if (iCustomerRepository.getCustomerById(cardId).isEmpty()) {
            return false;
        }
        iCustomerRepository.delete(cardId);
        return true;

    }

    //metodo genera una Conraseña aleatoria
    private String generarRadomPassword(int len) {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<=len;i++){
            int radomindex = random.nextInt(chars.length());
            sb.append(chars.charAt(radomindex));
        }
    return  sb.toString();
    }
}