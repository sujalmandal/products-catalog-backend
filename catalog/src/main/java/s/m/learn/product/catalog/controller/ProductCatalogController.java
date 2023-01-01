package s.m.learn.product.catalog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s.m.learn.product.catalog.dto.ProductRequest;
import s.m.learn.product.lib.model.GenericResponse;
import s.m.learn.product.catalog.service.ProductCatalogService;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductCatalogController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductCatalogController.class);

    private final ProductCatalogService productCatalogService;

    public ProductCatalogController(final ProductCatalogService productCatalogService) {
        this.productCatalogService = productCatalogService;
    }

    @PostMapping("/add")
    public ResponseEntity<GenericResponse<?>> addProduct(
            @Valid @RequestBody final ProductRequest productRequest){
        LOG.info("addProduct() triggered : {}", productRequest);
        return ResponseEntity.ok(productCatalogService.addProduct(productRequest));
    }

    @GetMapping
    public ResponseEntity<GenericResponse<?>> getProducts(){
        LOG.info("getProducts() triggered");
        return ResponseEntity.ok(productCatalogService.getProducts());
    }
}
