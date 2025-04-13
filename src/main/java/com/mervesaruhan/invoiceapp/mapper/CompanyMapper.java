package com.mervesaruhan.invoiceapp.mapper;

import ch.qos.logback.core.model.ComponentModel;
import com.mervesaruhan.invoiceapp.dto.request.CompanyCreateDTO;
import com.mervesaruhan.invoiceapp.dto.response.CompanyResponseDTO;
import com.mervesaruhan.invoiceapp.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel ="spring",uses = InvoiceMapper.class,
unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyMapper {
    CompanyResponseDTO toDto(Company entity);
    Company toEntity(CompanyCreateDTO request);
    List<CompanyResponseDTO> toDtoList(List<Company> entities);
}
