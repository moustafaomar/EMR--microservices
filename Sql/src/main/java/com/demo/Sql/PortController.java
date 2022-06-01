package com.demo.Sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortController {

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    Environment environment;

    public String checkStatus()
    {
        return "Checking status ...... " + " " + appName + " running on port " +
                environment.getProperty("local.server.port")  ;
    }

    @GetMapping(value = "/check-status")
    public String checkStatusRequest()
    {
        return checkStatus();
    }

}
