package s.m.learn.product.search.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import s.m.learn.product.lib.model.ProductIndexUpdateRequest;

@Service
public class ProductSearchIndexService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductSearchIndexService.class);

    public void updateIndex(final ProductIndexUpdateRequest request) {
        LOG.info("Updating product information in search index.. : {}", request);
    }
}
