package com.mervesaruhan.invoiceapp.service;

import com.mervesaruhan.invoiceapp.dao.InvoiceRepository;
import com.mervesaruhan.invoiceapp.dto.response.InvoiceResponseDTO;
import com.mervesaruhan.invoiceapp.entity.Invoice;
import com.mervesaruhan.invoiceapp.mapper.InvoiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;


    public List<InvoiceResponseDTO> getAllInvoices() {
        return invoiceMapper.toDtoList(invoiceRepository.findAll());
    }

    public List<InvoiceResponseDTO> getInvoicesAboveAmount(double amount) {
        List<Invoice> aboveAmountInvoices = invoiceRepository.findByTotalPriceGreaterThan(amount);
        return invoiceMapper.toDtoList(aboveAmountInvoices);
    }

    public Double getAverageOfInvoicesAboveAmount(double amount) {
        List<Invoice> aboveAmountInvoices = invoiceRepository.findByTotalPriceGreaterThan(amount);
        double avg = aboveAmountInvoices.stream()
                .mapToDouble(invoice -> invoice.getTotalPrice())
                .average().orElse(0.00);
        return avg;
    }

    public List<String> getCustomerNamesWithInvoicesBelowAmount(double amount) {
        List<Invoice> lessThanInvoices = invoiceRepository.findByTotalPriceLessThan(amount);
        return lessThanInvoices.stream()
                .map(invoice -> invoice.getCustomer().getName())
                .distinct()
                .collect(Collectors.toList());
    }


}
