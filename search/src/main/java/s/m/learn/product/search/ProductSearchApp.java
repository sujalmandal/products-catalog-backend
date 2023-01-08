package s.m.learn.product.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import s.m.learn.product.lib.common.YamlFileApplicationContextInitializer;

import java.util.Map;

@SpringBootApplication
public class ProductSearchApp implements ApplicationRunner {

    private final Logger LOG = LoggerFactory.getLogger(ProductSearchApp.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder(ProductSearchApp.class)
                .initializers(YamlFileApplicationContextInitializer.create(
                        Map.of("messaging-config", "messaging.yml"))).run(args);
    }

    @Override
    public void run(ApplicationArguments args) {
        LOG.info("{} with : {}",this.getClass().getSimpleName(), args.getOptionNames());
    }
}
