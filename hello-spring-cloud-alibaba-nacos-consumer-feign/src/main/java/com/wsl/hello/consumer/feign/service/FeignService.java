package com.wsl.hello.consumer.feign.service;

import com.wsl.hello.consumer.feign.service.fallback.FallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-provider",fallback = FallbackServiceImpl.class)
public interface FeignService {
    @GetMapping(value = "/test/{message}")
    String test(@PathVariable("message") String message);
}