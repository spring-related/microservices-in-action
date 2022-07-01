package com.optimagrowth.license;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
        properties = {"spring.cloud.config.enabled=false"}
)
@Disabled
class LicenseServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
