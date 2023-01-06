package s.m.learn.product.catalog.client.search;

import s.m.learn.product.lib.model.GenericResponse;
import s.m.learn.product.lib.model.ProductIndexUpdateRequest;

public interface ProductSearchClient {
    GenericResponse<?> updateSearchIndex(final ProductIndexUpdateRequest request);
}
