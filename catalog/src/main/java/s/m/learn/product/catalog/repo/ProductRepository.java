package s.m.learn.product.catalog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import s.m.learn.product.entity.Product;

import javax.annotation.PostConstruct;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @PostConstruct
    default void logMsg(){
        System.out.println("######## repo loaded");
    }
}
