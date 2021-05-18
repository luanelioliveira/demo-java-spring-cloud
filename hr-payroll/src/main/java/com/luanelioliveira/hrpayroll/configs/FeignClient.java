package com.luanelioliveira.hrpayroll.configs;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.luanelioliveira.hrpayroll.clients")
public class FeignClient {}
