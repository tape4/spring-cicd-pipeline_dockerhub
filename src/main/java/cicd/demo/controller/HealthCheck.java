package cicd.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
public class HealthCheck {

    public static String uuid = UUID.randomUUID().toString();
    @ResponseBody
    @GetMapping("/health-check")
    public String health_check() {
        return uuid;
    }
}
