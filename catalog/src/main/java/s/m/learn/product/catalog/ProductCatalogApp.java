package s.m.learn.product.catalog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import s.m.learn.product.catalog.config.ProductCatalogAppConfig;

@SpringBootApplication
@Import(ProductCatalogAppConfig.class)
public class ProductCatalogApp implements ApplicationRunner {

    private final Logger LOG = LoggerFactory.getLogger(ProductCatalogApp.class);

    public static void main(String[] args) {
        SpringApplication.run(ProductCatalogApp.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        LOG.debug("### Started {} with : {}", this.getClass().getSimpleName(), args.getOptionNames());
    }
}
