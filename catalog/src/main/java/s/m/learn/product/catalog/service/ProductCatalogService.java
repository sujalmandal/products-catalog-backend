package s.m.learn.product.catalog.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import s.m.learn.product.catalog.dto.ProductRequest;
import s.m.learn.product.catalog.dto.common.GenericResponse;
import s.m.learn.product.entity.Product;
import s.m.learn.product.repo.ProductRepository;

import java.util.Map;

import static s.m.learn.product.catalog.dto.common.GenericResponse.Status.SUCCESS;

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
    public GenericResponse<Map<String, Long>> addProductResponse(final ProductRequest request){
        final Product persistedProduct = productRepository.save(productHelper.prepareProductEntity(request));
        final Map<String, Long> data = Map.of("ProductId", persistedProduct.getId());
        GenericResponse.create().setMessage("Product created.").setStatus(SUCCESS).setData(data);
        return null;
    }

}
