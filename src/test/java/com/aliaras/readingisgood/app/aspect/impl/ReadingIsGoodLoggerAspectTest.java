package com.aliaras.readingisgood.app.aspect.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ReadingIsGoodLoggerAspectTest {

    @Mock
    ObjectMapper om;

    @Mock
    ProceedingJoinPoint proceedingJoinPoint;

    @InjectMocks
    ReadingIsGoodLoggerAspect readingIsGoodLoggerAspect;

    @Test
    void logger() {
        Assertions.assertDoesNotThrow(() -> readingIsGoodLoggerAspect.Logger(proceedingJoinPoint));
    }
}