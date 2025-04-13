package com.mervesaruhan.invoiceapp.mapper;

import com.mervesaruhan.invoiceapp.dto.request.CustomerCreateDTO;
import com.mervesaruhan.invoiceapp.dto.response.CustomerResponseDTO;
import com.mervesaruhan.invoiceapp.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
uses = InvoiceMapper.class)
public interface CustomerMapper {
    //CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    //Bu tanım componentModel = "spring" kullandığında gerekli değildir.
    Customer toEntity(CustomerCreateDTO request);
    CustomerResponseDTO toDto(Customer entity);
    List<CustomerResponseDTO> toDtoList(List<Customer> customers);

}
