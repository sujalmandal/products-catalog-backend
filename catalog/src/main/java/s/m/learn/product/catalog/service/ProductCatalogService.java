package s.m.learn.product.catalog.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import s.m.learn.product.catalog.dto.ProductRequest;
import s.m.learn.product.lib.model.GenericResponse;
import s.m.learn.product.entity.Product;
import s.m.learn.product.repo.ProductRepository;

import java.util.List;
import java.util.Map;

import static s.m.learn.product.catalog.constant.CommonConstant.PRODUCT_ID;
import static s.m.learn.product.lib.model.GenericResponse.Status.SUCCESS;

@Service
public class ProductCatalogService {

    private final ProductRepository productRepository;
    private final ProductHelper productHelper;

    public ProductCatalogService(
            final ProductRepository productRepository, final ProductHelper productHelper) {
        this.productRepository = productRepository;
        this.productHelper = productHelper;
    }

    @Transactional
    public GenericResponse<Map<String, Long>> addProduct(final ProductRequest request){
        final Product persistedProduct = productRepository.save(productHelper.prepareProductEntity(request));
        return GenericResponse.create(Map.of(
                PRODUCT_ID, persistedProduct.getId())).setMessage("Product created.").setStatus(SUCCESS);
    }

    public GenericResponse<List<Product>> getProducts(){
        return GenericResponse.create(productRepository.findAll())
                .setMessage("Products fetched.").setStatus(SUCCESS);
    }

}
