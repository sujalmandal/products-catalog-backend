package s.m.learn.product.catalog.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@EnableAsync
@Configuration
public class AsyncConfig {


    @Bean(name = "asyncTask")
    public ExecutorService executorService(){
        return Executors.newSingleThreadExecutor();
    }
}
