package s.m.learn.product.search.listener;

import com.solace.spring.cloud.stream.binder.messaging.SolaceBinderHeaders;
import kotlin.Suppress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import s.m.learn.product.lib.model.ProductIndexUpdateRequest;
import s.m.learn.product.search.service.ProductSearchIndexService;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ProductIndexUpdateListener implements Consumer<Message<List<Payload>>> {

    private static final Logger LOG = LoggerFactory.getLogger(ProductIndexUpdateListener.class);

    private final ProductSearchIndexService productSearchIndexService;

    public ProductIndexUpdateListener(final ProductSearchIndexService productSearchIndexService) {
        this.productSearchIndexService = productSearchIndexService;
    }

    /*
    @Override
    public void accept(final Collection<Message<ProductIndexUpdateRequest>> updateRequest) {
        LOG.info("received update product message, productId : {}", updateRequest);
        //updateRequest.forEach(productSearchIndexService::updateIndex);
    }
    */
    @Override
    public void accept(final Message<List<Payload>> listMessage) {
        LOG.info("received update product message, productId : {}", listMessage.getPayload().size());
        List<Map<String, Object>> batchedHeaders = (List<Map<String, Object>>)listMessage.getHeaders()
                .get(SolaceBinderHeaders.BATCHED_HEADERS);
        List<Payload> batchedPayloads = listMessage.getPayload();
        batchedPayloads.forEach(msg-> LOG.info("msg : {}", msg));
    }
}
