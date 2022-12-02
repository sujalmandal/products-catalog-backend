package s.m.learn.product.lib.entity;

import s.m.learn.product.lib.entity.common.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Product extends AbstractEntity {

    @Column(name="name")
    private String name;

    @Column(name="sku")
    private String sku;

    @Column(name="country_of_origin")
    private String countryOfOrigin;

    @Column(name="metadata")
    private String metadata;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }
}
