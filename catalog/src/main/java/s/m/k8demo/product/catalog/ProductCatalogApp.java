package s.m.k8demo.product.catalog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductCatalogApp implements ApplicationRunner {

    private Logger LOG = LoggerFactory.getLogger(ProductCatalogApp.class);

    public static void main(String[] args) {
        SpringApplication.run(ProductCatalogApp.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        LOG.info("Started s.m.k8demo.product.catalog.ProductCatalogApp with : {}",args.getOptionNames());
    }
}
