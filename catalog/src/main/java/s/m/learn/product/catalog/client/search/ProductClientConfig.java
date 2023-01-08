package s.m.learn.product.catalog.client.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import s.m.learn.product.catalog.config.CatalogAppProperties;
import s.m.learn.product.lib.common.CommonConstant;

@Configuration
public class ProductClientConfig {

    private static final Logger LOG = LoggerFactory.getLogger(ProductClientConfig.class);

    @Bean
    @ConditionalOnProperty(name = "products.clients.type", havingValue = "REST")
    public ProductSearchClient productRestClient(final RestTemplate restTemplate, final CatalogAppProperties catalogAppProperties){
        LOG.info("configuring product search rest client..");
        return new ProductSearchRestClient(restTemplate, catalogAppProperties);
    }

    @Bean
    @ConditionalOnProperty(name = "products.clients.type", havingValue = "MESSAGING")
    public ProductSearchClient productProducer(final CatalogAppProperties catalogAppProperties){
        LOG.info("configuring product search messaging client..");
        return new ProductSearchMessagingClient(catalogAppProperties);
    }

}
