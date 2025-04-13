package com.mervesaruhan.invoiceapp.service;

import com.mervesaruhan.invoiceapp.dao.CustomerRepository;
import com.mervesaruhan.invoiceapp.dto.request.CustomerCreateDTO;
import com.mervesaruhan.invoiceapp.dto.response.CustomerResponseDTO;
import com.mervesaruhan.invoiceapp.entity.Customer;
import com.mervesaruhan.invoiceapp.mapper.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    public CustomerResponseDTO save(CustomerCreateDTO createDTO) {
        var customer = customerMapper.toEntity(createDTO);
        return customerMapper.toDto(customerRepository.save(customer));
    }



    public List<CustomerResponseDTO> getAllCustomers() {
        return customerMapper.toDtoList(customerRepository.findAll());
    }

    public List<CustomerResponseDTO> getCustomerByNameContainLetter(String targetWord){
        return customerMapper.toDtoList(customerRepository.findByNameContainingIgnoreCase(targetWord));
    }

    public void delete(Long id){
        if(!customerRepository.existsById(id)){
            throw new IllegalArgumentException("Customer not found");
        }
        customerRepository.deleteById(id);
    }
}
