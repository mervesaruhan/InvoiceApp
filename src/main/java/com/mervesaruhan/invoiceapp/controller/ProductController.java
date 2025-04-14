package com.mervesaruhan.invoiceapp.controller;

import com.mervesaruhan.invoiceapp.RestResponse;
import com.mervesaruhan.invoiceapp.dto.request.ProductCreateDTO;
import com.mervesaruhan.invoiceapp.dto.response.ProductResponseDTO;
import com.mervesaruhan.invoiceapp.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "invoice app", description = "Product CRUD işlemleri")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<RestResponse<List<ProductResponseDTO>>> getAllProducts() {
        return ResponseEntity.ok(RestResponse.of(productService.getAllProducts()));
    }


    @PostMapping
    public ResponseEntity<RestResponse<ProductResponseDTO>> saveProduct(@RequestBody ProductCreateDTO productCreateDTO) {
        return ResponseEntity.ok(RestResponse.of(productService.saveProduct(productCreateDTO)));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<RestResponse<Void>> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok(RestResponse.empty());
    }

}
