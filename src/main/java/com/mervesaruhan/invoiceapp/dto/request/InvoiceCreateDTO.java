package com.mervesaruhan.invoiceapp.dto.request;

import com.mervesaruhan.invoiceapp.enums.EnumSector;

import java.util.HashMap;
import java.util.List;

public record InvoiceCreateDTO(Long companyId,
                               Long customerId,
                               List<ProductCreateDTO> productList) {
}
