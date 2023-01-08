package s.m.learn.product.catalog.client.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import s.m.learn.product.catalog.config.CatalogAppProperties;
import s.m.learn.product.lib.error.code.ErrorCode;
import s.m.learn.product.lib.error.handler.ApplicationException;
import s.m.learn.product.lib.model.GenericResponse;
import s.m.learn.product.lib.model.ProductIndexUpdateRequest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;

public class ProductSearchMessagingClient implements ProductSearchClient, Supplier<ProductIndexUpdateRequest> {

    private static final Logger LOG = LoggerFactory.getLogger(ProductSearchMessagingClient.class);

    private final CatalogAppProperties catalogAppProperties;
    private BlockingQueue<ProductIndexUpdateRequest> queue = new LinkedBlockingQueue<>();
    

    public ProductSearchMessagingClient(final CatalogAppProperties catalogAppProperties) {
        this.catalogAppProperties = catalogAppProperties;
    }

    @Override
    public GenericResponse<?> updateSearchIndex(final ProductIndexUpdateRequest request){
        try{
            queue.put(request);
        } catch (Exception e){
            throw ApplicationException.create(e).setErrorCode(ErrorCode.MESSAGE_PUBLISH_FAILED);
        }
        return GenericResponse.create(request)
                .setStatus(GenericResponse.Status.SUCCESS).setMessage("Published in queue.");
    }

    @Override
    public ProductSearchClient.ClientType getType() {
        return ClientType.MESSAGING;
    }

    @Override
    public ProductIndexUpdateRequest get() {
        LOG.info("pushing to message broker..");
        try {
            return queue.take();
        } catch (InterruptedException e) {
            throw ApplicationException.create(e)
                    .setErrorCode(ErrorCode.MESSAGE_PUBLISH_FAILED);
        }
    }
}
