package s.m.learn.product.catalog.client.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import s.m.learn.product.catalog.config.CatalogAppProperties;

import static s.m.learn.product.catalog.client.search.ProductSearchMessagingClient.PRODUCT_MSG_CLIENT_DESTINATION_NAME;

@Configuration
public class ProductClientConfig {

    private static final Logger LOG = LoggerFactory.getLogger(ProductClientConfig.class);

    @Bean
    @ConditionalOnProperty(name = "products.clients.type", havingValue = "REST")
    public ProductSearchClient productRestClient(final RestTemplate restTemplate, final CatalogAppProperties catalogAppProperties){
        LOG.info("configuring product search rest client..");
        return new ProductSearchRestClient(restTemplate, catalogAppProperties);
    }

    @Bean(PRODUCT_MSG_CLIENT_DESTINATION_NAME)
    @ConditionalOnProperty(name = "products.clients.type", havingValue = "MESSAGING")
    public ProductSearchClient productMessagingClient(final CatalogAppProperties catalogAppProperties){
        LOG.info("configuring product search messaging client..");
        return new ProductSearchMessagingClient(catalogAppProperties);
    }

}
