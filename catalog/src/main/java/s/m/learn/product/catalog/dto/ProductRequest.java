package s.m.learn.product.catalog.dto;

import s.m.learn.product.lib.model.BaseRequest;
import s.m.learn.product.lib.util.JsonUtil;

import javax.validation.constraints.NotEmpty;

public class ProductRequest extends BaseRequest {

    @NotEmpty(message = "Cannot be empty!")
    private String name;

    @NotEmpty(message = "Cannot be empty!")
    private String sku;

    @NotEmpty(message = "Cannot be empty!")
    private String countryOfOrigin;

    private String metadata;

    public String getName() {
        return name;
    }

    public String getSku() {
        return sku;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public String getMetadata() {
        return metadata;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this);
    }
}
