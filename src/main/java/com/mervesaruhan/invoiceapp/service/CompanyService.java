package com.mervesaruhan.invoiceapp.service;

import com.mervesaruhan.invoiceapp.dao.CompanyRepository;
import com.mervesaruhan.invoiceapp.dto.request.CompanyCreateDTO;
import com.mervesaruhan.invoiceapp.dto.response.CompanyResponseDTO;
import com.mervesaruhan.invoiceapp.entity.Company;
import com.mervesaruhan.invoiceapp.mapper.CompanyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;


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



}
