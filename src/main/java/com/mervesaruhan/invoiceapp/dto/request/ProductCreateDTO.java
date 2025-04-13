package com.mervesaruhan.invoiceapp.dto.request;

public record ProductCreateDTO(String name,
                               String description,
                               Double price,
                               Integer quantity) {
}
