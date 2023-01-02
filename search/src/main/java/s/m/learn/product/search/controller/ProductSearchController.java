package s.m.learn.product.search.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s.m.learn.product.lib.model.GenericResponse;
import s.m.learn.product.lib.model.ProductIndexUpdateRequest;

import javax.validation.Valid;
import java.util.Collections;

import static s.m.learn.product.lib.model.GenericResponse.Status.SUCCESS;

@RestController
@RequestMapping("search")
public class ProductSearchController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductSearchController.class);

    @PostMapping("/update-index")
    public ResponseEntity<GenericResponse<?>> updateIndex(@RequestBody @Valid final ProductIndexUpdateRequest request){
        LOG.info("updateIndex() called with request : {}", request);
        return ResponseEntity.ok(GenericResponse.create(Collections.singletonMap("productId",request.getProductId()))
                .setStatus(SUCCESS).setMessage(String.format("Product %s updated.", request.getProductId())));
    }

}
