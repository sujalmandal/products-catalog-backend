package s.m.learn.product.catalog.client.search;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import s.m.learn.product.catalog.config.CatalogAppProperties;
import s.m.learn.product.lib.model.GenericResponse;
import s.m.learn.product.lib.model.ProductIndexUpdateRequest;

@Primary
@Component
public class ProductSearchMessagingClient implements ProductSearchClient {

    private final CatalogAppProperties catalogAppProperties;
    private final StreamBridge streamBridge;

    public ProductSearchMessagingClient(final CatalogAppProperties catalogAppProperties, StreamBridge streamBridge) {
        this.catalogAppProperties = catalogAppProperties;
        this.streamBridge = streamBridge;
    }

    @Override
    public GenericResponse<?> updateSearchIndex(final ProductIndexUpdateRequest request){
        streamBridge.send("product-index", request);
        return GenericResponse.create(request)
                .setStatus(GenericResponse.Status.SUCCESS).setMessage("Published in queue.");
    }

}
