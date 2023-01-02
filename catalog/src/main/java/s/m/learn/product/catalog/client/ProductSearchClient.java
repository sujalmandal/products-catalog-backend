package s.m.learn.product.catalog.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import s.m.learn.product.catalog.config.CatalogAppProperties;
import s.m.learn.product.lib.model.GenericResponse;
import s.m.learn.product.lib.model.ProductIndexUpdateRequest;

@Component
public class ProductSearchClient {

    private final RestTemplate restTemplate;
    private final CatalogAppProperties catalogAppProperties;

    public ProductSearchClient(
            final RestTemplate restTemplate, final CatalogAppProperties catalogAppProperties) {
        this.restTemplate = restTemplate;
        this.catalogAppProperties = catalogAppProperties;
    }

    public GenericResponse<?> updateSearchIndex(final ProductIndexUpdateRequest request){
        final String apiURL = this.catalogAppProperties.getSearchBaseUrl() +
                this.catalogAppProperties.getUpdateIndexEndpoint();
        return restTemplate.postForEntity(apiURL, request, GenericResponse.class).getBody();
    }
}
