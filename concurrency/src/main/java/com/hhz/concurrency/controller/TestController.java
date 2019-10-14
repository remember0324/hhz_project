package com.hhz.concurrency.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Rem
 * @Date 2019-09-06
 * @Version 1.0
 */

@RestController
@Slf4j
public class TestController {


    @GetMapping("/tt")
    public String test() {
        return "hello";
    }
}
