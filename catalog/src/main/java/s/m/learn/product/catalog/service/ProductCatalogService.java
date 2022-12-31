package s.m.learn.product.catalog.service;

import org.springframework.stereotype.Service;
import s.m.learn.product.repo.ProductRepository;

@Service
public class ProductCatalogService {

    private final ProductRepository productRepository;

    public ProductCatalogService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



}
