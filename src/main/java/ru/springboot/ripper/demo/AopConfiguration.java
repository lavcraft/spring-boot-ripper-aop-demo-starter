package ru.springboot.ripper.demo;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Configuration
public class AopConfiguration {

    @ControllerAdvice(annotations = {FrontendController.class})
    public static class FrontendControllerResponseWrapperAdvice implements ResponseBodyAdvice {
        @Override
        public boolean supports(MethodParameter returnType, Class converterType) {
            return true;
        }

        @Override
        public Object beforeBodyWrite(Object body,
                                      MethodParameter returnType,
                                      MediaType selectedContentType,
                                      Class selectedConverterType,
                                      ServerHttpRequest request,
                                      ServerHttpResponse response) {
            return new HeroResponseWrapper().setResult(body);
        }
    }

}
