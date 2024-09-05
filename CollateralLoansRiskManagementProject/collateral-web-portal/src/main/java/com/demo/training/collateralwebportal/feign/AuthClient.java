package com.demo.training.collateralwebportal.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.training.collateralwebportal.model.LoginModel;

@FeignClient(name = "auth-client", url = "http://localhost:8081/auth")
public interface AuthClient {
    
    @GetMapping("/validate")
    public boolean validate(String token);

    @PostMapping("/login")
    public String login(LoginModel model);
}
