package s.m.learn.product.catalog.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("s.m.learn.product")
@EnableJpaRepositories("s.m.learn.product.repo")
@EntityScan("s.m.learn.product.entity")
public class ProductCatalogAppConfig { }