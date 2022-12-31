package s.m.learn.product.catalog.service;

import org.springframework.stereotype.Component;
import s.m.learn.product.builders.ProducerBuilder;
import s.m.learn.product.catalog.dto.ProductRequest;
import s.m.learn.product.entity.Product;

@Component
public class ProductHelper {

    public Product prepareProductEntity(final ProductRequest request) {
        return ProducerBuilder.create()
                .setName(request.getName())
                .setMetadata(request.getMetadata())
                .setSku(request.getSku())
                .setCountryOfOrigin(request.getCountryOfOrigin())
                .build();
    }

}
