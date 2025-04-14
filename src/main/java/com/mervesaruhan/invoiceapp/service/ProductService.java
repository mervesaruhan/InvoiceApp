package com.mervesaruhan.invoiceapp.service;

import com.mervesaruhan.invoiceapp.dao.ProductRepository;
import com.mervesaruhan.invoiceapp.dto.request.ProductCreateDTO;
import com.mervesaruhan.invoiceapp.dto.response.ProductResponseDTO;
import com.mervesaruhan.invoiceapp.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    public List<ProductResponseDTO> getAllProducts(){
        return productMapper.toDtoList(productRepository.findAll());
    }


    public ProductResponseDTO saveProduct(ProductCreateDTO dto){
        var product = productMapper.toEntity(dto);
        return productMapper.toDto(productRepository.save(product));
    }

    public void deleteProduct(Long id){
        if(!productRepository.existsById(id)){
            throw new IllegalArgumentException("Product not found");
        }
        productRepository.deleteById(id);
    }


}
