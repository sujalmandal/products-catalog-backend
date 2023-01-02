package s.m.learn.product.lib.common;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Class defining some common beans that are to be autowired in
 * any project that includes common-libs as dependencies.
 *
 */
@Configuration
public class CommonConfiguration {

    /**
     * Inject instance of restTemplate using restTemplateBuilder so that Spring Slueth can properly
     * add traceId and spanId to out going requests made using this particular restTemplate.
     *
     * @param restTemplateBuilder
     *
     * @return RestTemplate
     */
    @Bean
    public RestTemplate restTemplate(final RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.build();
    }
}
