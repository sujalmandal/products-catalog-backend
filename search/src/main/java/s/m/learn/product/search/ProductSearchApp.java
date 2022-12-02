package s.m.learn.product.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductSearchApp implements ApplicationRunner {

    private final Logger LOG = LoggerFactory.getLogger(ProductSearchApp.class);

    public static void main(String[] args) {
        SpringApplication.run(ProductSearchApp.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        LOG.info("Started s.m.k8demo.product.catalog.ProductSearchApp with : {}",args.getOptionNames());

    }
}
