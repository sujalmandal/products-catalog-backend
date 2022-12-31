package s.m.learn.product.catalog.dto;

import s.m.learn.product.catalog.dto.common.BaseRequest;

public class ProductRequest extends BaseRequest {

    private String name;
    private String sku;
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
}
