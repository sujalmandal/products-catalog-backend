package s.m.learn.product.catalog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s.m.learn.product.catalog.dto.ProductRequest;
import s.m.learn.product.lib.model.GenericResponse;
import s.m.learn.product.catalog.service.ProductCatalogService;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductCatalogController {

    private final ProductCatalogService productCatalogService;

    public ProductCatalogController(final ProductCatalogService productCatalogService) {
        this.productCatalogService = productCatalogService;
    }

    @PostMapping("/add")
    public ResponseEntity<GenericResponse<?>> addProduct(
            @Valid @RequestBody final ProductRequest productRequest){
        return ResponseEntity.ok(productCatalogService.addProduct(productRequest));
    }

    @GetMapping
    public ResponseEntity<GenericResponse<?>> getProducts(){
        return ResponseEntity.ok(productCatalogService.getProducts());
    }
}
