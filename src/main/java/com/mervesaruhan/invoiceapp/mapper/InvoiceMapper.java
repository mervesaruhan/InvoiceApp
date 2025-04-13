package com.mervesaruhan.invoiceapp.mapper;

import com.mervesaruhan.invoiceapp.dto.request.InvoiceCreateDTO;
import com.mervesaruhan.invoiceapp.dto.response.InvoiceResponseDTO;
import com.mervesaruhan.invoiceapp.entity.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = ProductMapper.class)//reponseta productresponsedto list var buraya mapplemem lazım, nested dönüşüm
public interface InvoiceMapper {

    Invoice toEntity (InvoiceCreateDTO request);

    @Mapping(source ="company.companyName", target ="companyName")
    InvoiceResponseDTO toDto (Invoice entity);

    List<InvoiceResponseDTO> toDtoList (List<Invoice> invoices);

}
