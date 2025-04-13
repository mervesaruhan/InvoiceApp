package com.mervesaruhan.invoiceapp.controller;


import com.mervesaruhan.invoiceapp.RestResponse;
import com.mervesaruhan.invoiceapp.dto.request.CustomerCreateDTO;
import com.mervesaruhan.invoiceapp.dto.response.CustomerResponseDTO;
import com.mervesaruhan.invoiceapp.entity.Customer;
import com.mervesaruhan.invoiceapp.service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "invoice app", description = "Customer CRUD işlemleri")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<RestResponse<List<CustomerResponseDTO>>> getAllCustomers() {
        return ResponseEntity.ok(RestResponse.of(customerService.getAllCustomers()));
    }

    @GetMapping("/filter/{targetWord}")
    public ResponseEntity<RestResponse<List<CustomerResponseDTO>>> getAllCustomersWithTargetWord(@PathVariable String targetWord) {
        return ResponseEntity.ok(RestResponse.of(customerService.getCustomerByNameContainLetter(targetWord)));
    }

    @PostMapping
    public ResponseEntity<RestResponse<CustomerResponseDTO>> save(@RequestBody CustomerCreateDTO customerCreateDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(RestResponse.of(customerService.save(customerCreateDTO)));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<RestResponse<Void>> delete(@PathVariable Long customerId) {
        customerService.delete(customerId);
        return ResponseEntity.ok(RestResponse.empty());
    }

}
