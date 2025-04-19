package com.mervesaruhan.invoiceapp.controller;


import com.mervesaruhan.invoiceapp.RestResponse;
import com.mervesaruhan.invoiceapp.dao.InvoiceRepository;
import com.mervesaruhan.invoiceapp.dto.response.InvoiceResponseDTO;
import com.mervesaruhan.invoiceapp.service.InvoiceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Invoice App", description = "Invoice CRUD İşlemleri")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Invoices")
public class InoviceController {
    private final InvoiceService invoiceService;


    @GetMapping
    public ResponseEntity<RestResponse<List<InvoiceResponseDTO>>> getInvoices() {
        return ResponseEntity.ok(RestResponse.of(invoiceService.getAllInvoices()));
    }

    @GetMapping("/{amount}")
    public ResponseEntity<RestResponse<List<InvoiceResponseDTO>>> getInvoicesAbove(@PathVariable Double amount) {
        return ResponseEntity.ok(RestResponse.of(invoiceService.getInvoicesAboveAmount(amount)));
    }

    @GetMapping("/invoices/average")
    public ResponseEntity<RestResponse<Double>> getInvoiceAboveAverage(@RequestParam double avg){
        return ResponseEntity.ok(RestResponse.of(invoiceService.getAverageOfInvoicesAboveAmount(avg)));
    }

    @GetMapping("/filter/below")
    public ResponseEntity<RestResponse<List<String>>> getCustomerNamesWithInvoicesBelowAmount(@RequestParam Double amount) {
        return  ResponseEntity.ok(RestResponse.of(invoiceService.getCustomerNamesWithInvoicesBelowAmount(amount)));
    }





}
