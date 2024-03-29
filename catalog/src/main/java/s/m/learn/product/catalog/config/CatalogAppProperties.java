package s.m.learn.product.catalog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import s.m.learn.product.lib.util.JsonUtil;

//TODO : use @ConfigurationProperties("prefix") & remove @Value
@Component
@PropertySource("classpath:application.yml")
public class CatalogAppProperties {

    @Value( "${product.search.base-url}" )
    private String searchBaseUrl;

    @Value("${product.search.api.update-index}")
    private String updateIndexEndpoint;

    public String getSearchBaseUrl() {
        return searchBaseUrl;
    }

    public String getUpdateIndexEndpoint() {
        return updateIndexEndpoint;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this);
    }
}
