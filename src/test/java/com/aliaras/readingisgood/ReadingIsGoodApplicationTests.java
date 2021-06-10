package com.aliaras.readingisgood;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = AppStarter.class)
class ReadingIsGoodApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> AppStarter.main(new String[]{"just testing"}));
    }

}
