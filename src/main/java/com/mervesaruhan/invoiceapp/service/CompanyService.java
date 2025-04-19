package com.mervesaruhan.invoiceapp.service;

import com.mervesaruhan.invoiceapp.dao.CompanyRepository;
import com.mervesaruhan.invoiceapp.dao.InvoiceRepository;
import com.mervesaruhan.invoiceapp.dto.request.CompanyCreateDTO;
import com.mervesaruhan.invoiceapp.dto.response.CompanyResponseDTO;
import com.mervesaruhan.invoiceapp.entity.Company;
import com.mervesaruhan.invoiceapp.entity.Invoice;
import com.mervesaruhan.invoiceapp.enums.EnumSector;
import com.mervesaruhan.invoiceapp.mapper.CompanyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Locale.filter;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final InvoiceRepository invoiceRepository;


public List<CompanyResponseDTO> getAllCompany(){
    return companyRepository.findAll()
            .stream()
            .map(companyMapper::toDto)
            .collect(Collectors.toList());
    //return companyMapper.toDtoList(companyRepository.findAll());
}


public CompanyResponseDTO createCompany(CompanyCreateDTO request){
    return companyMapper
            .toDto(companyRepository
                    .save(companyMapper
                            .toEntity(request)));
}


public void deleteCompanyById(Long companyId){
    Company company = companyRepository.findById(companyId)
            .orElseThrow(() -> new IllegalArgumentException("Company not found"));
    companyRepository.deleteById(companyId);
}

public List<EnumSector> getCompanyByDateAndAveragePrice(Month month, double avg){
    LocalDateTime start = LocalDate.of(LocalDate.now().getYear(), month, 1).atStartOfDay();
    LocalDateTime end = start.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX);

    List<Invoice> invoices = invoiceRepository.findCreateDateBetween(start,end);
    Map<Company, List<Invoice>> grouped = invoices.stream()
            .collect(Collectors.groupingBy(Invoice::getCompany));
    return grouped.entrySet().stream()
            .filter(entry -> entry.getValue()
                    .stream()
                    .mapToDouble(Invoice::getTotalPrice)
                    .average().orElse(0.0) < avg)
            .map(entry -> entry.getKey().getSector())
            .distinct()
            .collect(Collectors.toList());

    }

}

