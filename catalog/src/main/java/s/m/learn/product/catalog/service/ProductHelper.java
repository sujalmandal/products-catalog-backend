package s.m.learn.product.catalog.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import s.m.learn.product.builders.ProducerBuilder;
import s.m.learn.product.catalog.client.ProductSearchClient;
import s.m.learn.product.catalog.dto.ProductRequest;
import s.m.learn.product.entity.Product;
import s.m.learn.product.lib.error.handler.ApplicationException;
import s.m.learn.product.lib.model.ProductIndexUpdateRequest;

@Component
public class ProductHelper {

    private final ProductSearchClient productSearchClient;

    public ProductHelper(final ProductSearchClient productSearchClient) {
        this.productSearchClient = productSearchClient;
    }

    @Async("asyncTask")
    public void updateIndex(final Product product){
        this.productSearchClient.updateSearchIndex(prepareProductSearchIndexRequest(product));
        if(true) throw ApplicationException.create();
    }

    public ProductIndexUpdateRequest prepareProductSearchIndexRequest(final Product product) {
        return ProductIndexUpdateRequest.create().setProductId(product.getId())
                .setSku(product.getSku()).setName(product.getName()).setCountryOfOrigin(product.getCountryOfOrigin());
    }

    public Product prepareProductEntity(final ProductRequest request) {
        return ProducerBuilder.create()
                .setName(request.getName())
                .setMetadata(request.getMetadata())
                .setSku(request.getSku())
                .setCountryOfOrigin(request.getCountryOfOrigin())
                .build();
    }

}
