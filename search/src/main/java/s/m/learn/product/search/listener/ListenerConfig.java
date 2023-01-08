package s.m.learn.product.search.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import s.m.learn.product.lib.common.CommonConstant;
import s.m.learn.product.search.service.ProductSearchIndexService;

@Configuration
public class ListenerConfig {

    private static final Logger LOG = LoggerFactory.getLogger(ListenerConfig.class);

    @Bean
    public ProductIndexUpdateListener productConsumer(final ProductSearchIndexService productSearchIndexService){
        return new ProductIndexUpdateListener(productSearchIndexService);
    }
}
