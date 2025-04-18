package com.mervesaruhan.invoiceapp.controller;

import com.mervesaruhan.invoiceapp.RestResponse;
import com.mervesaruhan.invoiceapp.dto.request.CompanyCreateDTO;
import com.mervesaruhan.invoiceapp.dto.response.CompanyResponseDTO;
import com.mervesaruhan.invoiceapp.service.CompanyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
@RequiredArgsConstructor
@Tag(name = "invoice app", description = "Company CRUD işlemleri")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<RestResponse<List<CompanyResponseDTO>>> getAllCompanies() {
        return ResponseEntity.ok(RestResponse.of(companyService.getAllCompany()));
    }

    @PostMapping
    public ResponseEntity<RestResponse<CompanyResponseDTO>> createCompany(@RequestBody CompanyCreateDTO companyCreateDTO) {
       return ResponseEntity.status(HttpStatus.CREATED)
               .body(RestResponse
                       .of(companyService.createCompany(companyCreateDTO)));
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<RestResponse<Void>> deleteCompanyById(@PathVariable Long companyId) {
        companyService.deleteCompanyById(companyId);
        return ResponseEntity.ok(RestResponse.empty());
    }
}
