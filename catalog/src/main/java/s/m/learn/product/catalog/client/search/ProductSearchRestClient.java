package s.m.learn.product.catalog.client.search;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import s.m.learn.product.catalog.config.CatalogAppProperties;
import s.m.learn.product.lib.model.GenericResponse;
import s.m.learn.product.lib.model.ProductIndexUpdateRequest;

//@Primary
@Component
public class ProductSearchRestClient implements ProductSearchClient {

    private final RestTemplate restTemplate;
    private final CatalogAppProperties catalogAppProperties;

    public ProductSearchRestClient(
            final RestTemplate restTemplate, final CatalogAppProperties catalogAppProperties) {
        this.restTemplate = restTemplate;
        this.catalogAppProperties = catalogAppProperties;
    }

    @Override
    public GenericResponse<?> updateSearchIndex(final ProductIndexUpdateRequest request){
        final String apiURL = this.catalogAppProperties.getSearchBaseUrl() +
                this.catalogAppProperties.getUpdateIndexEndpoint();
        return restTemplate.postForEntity(apiURL, request, GenericResponse.class).getBody();
    }
}
