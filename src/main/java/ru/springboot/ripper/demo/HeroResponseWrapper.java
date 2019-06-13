package ru.springboot.ripper.demo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class HeroResponseWrapper {
    private Object result;
}
