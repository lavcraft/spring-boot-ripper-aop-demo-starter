package ru.springboot.ripper.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DeprecationProprties.class)
public class AopConfiguration {

    @Bean
    @ConditionalOnProperty("demo.warning")
    public DeprecatedAspect deprecatedAspect(DeprecationProprties prop) {
        return new DeprecatedAspect(prop);
    }

    @Bean
    public BenchmarkAspect benchmarkAspect() {
        return new BenchmarkAspect();
    }
}
