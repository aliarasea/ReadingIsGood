package com.aliaras.readingisgood.app.aspect.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ReadingIsGoodLoggerAspect {
    private static final Logger log = LogManager.getLogger(ReadingIsGoodLoggerAspect.class);
    private final ObjectMapper om;

    ReadingIsGoodLoggerAspect(ObjectMapper om) {
        this.om = om;
    }

    @Around("@annotation(com.aliaras.readingisgood.app.aspect.ReadingIsGoodLogger)")
    public Object Logger(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            log.info(joinPoint.getSignature() + ":\n" + om.writeValueAsString(joinPoint.getArgs()));
            Object proceed = joinPoint.proceed();
            log.info(joinPoint.getSignature() + ":\n" + om.writeValueAsString(proceed));
            return proceed;
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new Exception("Something went wrong!", ex);
        }
    }
}
