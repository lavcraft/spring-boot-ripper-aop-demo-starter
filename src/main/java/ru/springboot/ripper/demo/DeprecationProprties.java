package ru.springboot.ripper.demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "demo")
public class DeprecationProprties {

    private String warning;

}
