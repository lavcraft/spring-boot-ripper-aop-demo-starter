package ru.springboot.ripper.demo;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
@RequiredArgsConstructor
public class DeprecatedAspect {
    private final DeprecationProprties deprecationProprties;

    @Before("@annotation(Deprecated) && execution(* ru..*.*(..))")
    public void warn(JoinPoint joinPoint) {
        String warning = deprecationProprties.getWarning();
        System.out.println("*** " + warning + " ***");
        System.out.println("*** " + joinPoint.getSignature().getName() + " ***");
    }

}
