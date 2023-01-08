package s.m.learn.product.search.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import s.m.learn.product.lib.model.ProductIndexUpdateRequest;
import s.m.learn.product.search.service.ProductSearchIndexService;

import java.util.function.Consumer;

public class ProductIndexUpdateListener implements Consumer<ProductIndexUpdateRequest> {

    private static final Logger LOG = LoggerFactory.getLogger(ProductIndexUpdateListener.class);

    private final ProductSearchIndexService productSearchIndexService;

    public ProductIndexUpdateListener(final ProductSearchIndexService productSearchIndexService) {
        this.productSearchIndexService = productSearchIndexService;
    }

    @Override
    public void accept(final ProductIndexUpdateRequest updateRequest) {
        LOG.info("received update product message, productId : {}", updateRequest.getProductId());
        productSearchIndexService.updateIndex(updateRequest);
    }
}
