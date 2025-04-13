package com.mervesaruhan.invoiceapp.mapper;

import com.mervesaruhan.invoiceapp.dto.request.ProductCreateDTO;
import com.mervesaruhan.invoiceapp.dto.response.ProductResponseDTO;
import com.mervesaruhan.invoiceapp.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    ProductResponseDTO toDto (Product entity);
    Product toEntity (ProductCreateDTO dto);
    List<ProductResponseDTO> toDtoList (List<Product> entities);

}
