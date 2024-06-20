package cicd.demo.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealthCheckTest {

//    @Test
//    void FailTest() {
//        Assertions.assertThat(true).isEqualTo(false);
//    }

    @Test
    void SuccessTest() {
        Assertions.assertThat(true).isEqualTo(true);
    }
}