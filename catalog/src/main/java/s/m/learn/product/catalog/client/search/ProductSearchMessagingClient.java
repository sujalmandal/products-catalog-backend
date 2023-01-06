package s.m.learn.product.catalog.client.search;

import org.springframework.stereotype.Component;
import s.m.learn.product.catalog.config.CatalogAppProperties;
import s.m.learn.product.lib.model.GenericResponse;
import s.m.learn.product.lib.model.ProductIndexUpdateRequest;

@Component
public class ProductSearchMessagingClient implements ProductSearchClient {

    private final CatalogAppProperties catalogAppProperties;

    public ProductSearchMessagingClient(final CatalogAppProperties catalogAppProperties) {
        this.catalogAppProperties = catalogAppProperties;
    }

    @Override
    public GenericResponse<?> updateSearchIndex(final ProductIndexUpdateRequest request){
        return null;
    }
}
