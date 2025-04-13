package com.mervesaruhan.invoiceapp.dto.response;

import com.mervesaruhan.invoiceapp.enums.EnumSector;

import java.util.List;

public record CompanyResponseDTO(String name,
                                 EnumSector sector,
                                 List<InvoiceResponseDTO> invoices) {
}
