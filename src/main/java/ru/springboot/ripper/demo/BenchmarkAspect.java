package ru.springboot.ripper.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class BenchmarkAspect {

    @Around("@annotation(Benchmark) && execution(* ru..*.*(..))")
    public Object benchmark(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object retval;

        long start = System.nanoTime();
        retval = proceedingJoinPoint.proceed();
        long stop = System.nanoTime();

        String name = proceedingJoinPoint.getSignature().getName();
        System.out.println(name + " execution time — " + (stop - start));
        System.out.println("*** " + name + " ***");
        return retval;
    }
}
