package s.m.learn.product.builders;

import s.m.learn.product.entity.Product;

public class ProducerBuilder {

    private String name;
    private String sku;
    private String countryOfOrigin;
    private String metadata;

    public static ProducerBuilder create(){
        return new ProducerBuilder();
    }

    public String getName() {
        return name;
    }

    public ProducerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getSku() {
        return sku;
    }

    public ProducerBuilder setSku(String sku) {
        this.sku = sku;
        return this;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public ProducerBuilder setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
        return this;
    }

    public String getMetadata() {
        return metadata;
    }

    public ProducerBuilder setMetadata(String metadata) {
        this.metadata = metadata;
        return this;
    }

    public Product build(){
        Product product = new Product();

        product.setName(this.name);
        product.setSku(this.sku);
        product.setMetadata(this.metadata);
        product.setCountryOfOrigin(this.countryOfOrigin);

        return product;
    }
}
