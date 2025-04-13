package com.mervesaruhan.invoiceapp.dto.request;

public record CustomerCreateDTO(String name,
                                String surname,
                                String email,
                                String phone,
                                String city) {
}
