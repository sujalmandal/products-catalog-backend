package s.m.learn.product.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s.m.learn.product.entity.Product;

import javax.annotation.PostConstruct;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @PostConstruct
    default void logMsg(){
        System.out.println("######## repo loaded");
    }
}
