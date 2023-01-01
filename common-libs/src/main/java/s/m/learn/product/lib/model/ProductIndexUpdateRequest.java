package s.m.learn.product.lib.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductIndexUpdateRequest {

    @NotNull(message = "Cannot be null!")
    private Integer productId;

    @NotEmpty(message = "Cannot be empty!")
    private String name;

    @NotEmpty(message = "Cannot be empty!")
    private String sku;

    @NotEmpty(message = "Cannot be empty!")
    private String countryOfOrigin;

    public static ProductIndexUpdateRequest create(){
        return new ProductIndexUpdateRequest();
    }

    public Integer getProductId() {
        return productId;
    }

    public ProductIndexUpdateRequest setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductIndexUpdateRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getSku() {
        return sku;
    }

    public ProductIndexUpdateRequest setSku(String sku) {
        this.sku = sku;
        return this;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public ProductIndexUpdateRequest setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
        return this;
    }

    public enum Operation{

        REPLACE("REPLACE"), ADD("ADD"), DELETE("DELETE");
        public String operation;

        Operation(String op){
            this.operation = op;
        }
    }
}
