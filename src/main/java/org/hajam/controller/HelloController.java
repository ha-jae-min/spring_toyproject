package org.hajam.controller;

import org.hajam.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    private final HelloService helloService;
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public void hello(Model model) {
        log.info("hello...." + helloService);
        
        String timeStr = helloService.getTime();
        
        model.addAttribute("timeStr", timeStr);
    }
}