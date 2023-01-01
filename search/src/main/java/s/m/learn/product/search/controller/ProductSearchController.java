package s.m.learn.product.search.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("search")
public class ProductSearchController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductSearchController.class);

    @PutMapping("/update-index")
    public void updateIndex(@RequestBody final Object obj){
        
    }

}
