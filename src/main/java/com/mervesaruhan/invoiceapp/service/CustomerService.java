package com.mervesaruhan.invoiceapp.service;

import com.mervesaruhan.invoiceapp.dao.CustomerRepository;
import com.mervesaruhan.invoiceapp.dto.request.CustomerCreateDTO;
import com.mervesaruhan.invoiceapp.dto.response.CustomerResponseDTO;
import com.mervesaruhan.invoiceapp.entity.Customer;
import com.mervesaruhan.invoiceapp.entity.Invoice;
import com.mervesaruhan.invoiceapp.mapper.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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


    public Double getTotalInvoiceAmountOfCustomersRegisteredInMonth(int monthValue){
        return customerRepository.findAll().stream()
                .filter(c->c.getCreateDate().getMonthValue()== monthValue)
                .flatMap(c->c.getInvoices().stream()) //Her müşterinin tüm faturasını tek akışta birleştiriyor
                .mapToDouble(Invoice ::getTotalPrice).sum();

        //flatmap:Stream içinde stream varsa, hepsini tek bir düz stream'e indirger
    }


}
