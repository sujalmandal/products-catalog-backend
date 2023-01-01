package s.m.learn.product.catalog.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOG = LoggerFactory.getLogger(ProductCatalogService.class);

    private final ProductRepository productRepository;
    private final ProductHelper productHelper;

    public ProductCatalogService(
            final ProductRepository productRepository, final ProductHelper productHelper) {
        this.productRepository = productRepository;
        this.productHelper = productHelper;
    }

    @Transactional
    public GenericResponse<Map<String, Long>> addProduct(final ProductRequest request){
        LOG.info("addProduct() triggered : {}", request);

        final Product persistedProduct = productRepository.save(productHelper.prepareProductEntity(request));
        return GenericResponse.create(Map.of(
                PRODUCT_ID, persistedProduct.getId())).setMessage("Product created.").setStatus(SUCCESS);
    }

    public GenericResponse<List<Product>> getProducts(){
        LOG.info("getProducts() triggered");

        return GenericResponse.create(productRepository.findAll())
                .setMessage("Products fetched.").setStatus(SUCCESS);
    }

}
