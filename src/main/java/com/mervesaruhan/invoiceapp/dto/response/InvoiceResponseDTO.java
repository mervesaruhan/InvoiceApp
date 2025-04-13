package com.mervesaruhan.invoiceapp.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public record InvoiceResponseDTO(Double totalPrice,
                                 LocalDateTime createDate,
                                 String companyName,
                                 List<ProductResponseDTO> productList) {
}
