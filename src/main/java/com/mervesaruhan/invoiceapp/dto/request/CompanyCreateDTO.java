package com.mervesaruhan.invoiceapp.dto.request;

import com.mervesaruhan.invoiceapp.enums.EnumSector;

public record CompanyCreateDTO(String name,
                               EnumSector sector) {
}
