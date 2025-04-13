package com.mervesaruhan.invoiceapp.dto.response;

public record ProductResponseDTO(Long id,
                                 String name,
                                 String description,
                                 Double price,
                                 Integer quantity) {
}
