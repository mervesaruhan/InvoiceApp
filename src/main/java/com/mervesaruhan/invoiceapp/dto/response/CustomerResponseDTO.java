package com.mervesaruhan.invoiceapp.dto.response;

import com.mervesaruhan.invoiceapp.entity.Invoice;

import java.util.List;

public record CustomerResponseDTO(String name,
                                  String surname,
                                  String email,
                                  String phone,
                                  String city,
                                  List<InvoiceResponseDTO> invoiceList) {

}
