package com.zhonghuasheng.ms.test;

import com.zhonghuasheng.springboot.starter.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class DemoController {

    @Resource(name = "demo")
    private DemoService demoService;

    @GetMapping("/demo")
    public String demo() {
        return demoService.say();
    }
}
