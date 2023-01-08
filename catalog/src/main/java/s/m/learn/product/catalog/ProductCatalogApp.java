package s.m.learn.product.catalog;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;
import s.m.learn.product.catalog.config.CatalogAppProperties;
import s.m.learn.product.catalog.config.ProductCatalogAppConfig;
import s.m.learn.product.lib.common.YamlFileApplicationContextInitializer;
import s.m.learn.product.lib.util.TimeZoneUtil;

import java.util.Map;


@SpringBootApplication
@Import(ProductCatalogAppConfig.class)
public class ProductCatalogApp implements ApplicationRunner {

    private final Logger LOG = LoggerFactory.getLogger(ProductCatalogApp.class);

    @Autowired
    private final CatalogAppProperties catalogAppProperties;

    @Autowired
    private final ObjectMapper objectMapper;

    public ProductCatalogApp(CatalogAppProperties catalogAppProperties, ObjectMapper objectMapper) {
        this.catalogAppProperties = catalogAppProperties;
        this.objectMapper = objectMapper;
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ProductCatalogApp.class)
                .initializers(YamlFileApplicationContextInitializer.create(
                        Map.of("messaging-config", "messaging.yml"))).run(args);
    }

    @Override
    public void run(final ApplicationArguments args) {
        LOG.info("{} with : {}",this.getClass().getSimpleName(), args.getOptionNames());
        TimeZoneUtil.setDefaultTimeZone();
    }
}
