package s.m.learn.product.lib.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.io.Resource;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class YamlFileApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    private final Logger LOG = LoggerFactory.getLogger(YamlFileApplicationContextInitializer.class);

    private final Map<String, String> namePathMap;

    private YamlFileApplicationContextInitializer(final Map<String, String> namePathMap){
        this.namePathMap = namePathMap;
    }

    public static YamlFileApplicationContextInitializer create(final Map<String, String> namePathMap){
        return new YamlFileApplicationContextInitializer(namePathMap);
    }

    @Override
  public void initialize(final ConfigurableApplicationContext applicationContext) {
        LOG.info("attempting to customize applicationContext...");
    try {
        final List<Map.Entry<String, String>> entries = new ArrayList<>(namePathMap.entrySet());
        for(int i = 0 ; i< entries.size() ; i++){
            String sourceName = entries.get(i).getKey();
            String source = entries.get(i).getValue();
            final Resource resource = applicationContext.getResource(String.format("classpath:%s", source));
            final YamlPropertySourceLoader sourceLoader = new YamlPropertySourceLoader();
            sourceLoader.load(sourceName, resource).forEach(propertySource ->
                    applicationContext.getEnvironment().getPropertySources().addFirst(propertySource));
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
  }
}