package com.zhonghuasheng.seckill.controller;

import com.zhonghuasheng.seckill.common.CodeMsg;
import com.zhonghuasheng.seckill.common.Result;
import com.zhonghuasheng.seckill.domain.Student;
import com.zhonghuasheng.seckill.rabbitmq.MQSender;
import com.zhonghuasheng.seckill.rabbitmq.SeckillMessage;
import com.zhonghuasheng.seckill.redis.RedisService;
import com.zhonghuasheng.seckill.redis.UserKey;
import com.zhonghuasheng.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private MQSender mqSender;

    @GetMapping("/hello")
    @ResponseBody
    public Result<String> hello() {
        return Result.success("Hello World");
    }

    @GetMapping("/helloError")
    @ResponseBody
    public Result<String> helloError() {
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @GetMapping("/thymeleaf")
    public String hi(Model model) {
        model.addAttribute("name", "Luke");
        return "demo";
    }

    @GetMapping("/db/get")
    @ResponseBody
    public Result<Student> dbGet() {
        Student student = userService.getById(10000);
        return Result.success(student);
    }

    @GetMapping("/db/tx")
    @ResponseBody
    public Result<Boolean> dbTx() {
        userService.tx();
        return Result.success(true);
    }


    @GetMapping("/redis/get")
    @ResponseBody
    public Result<Student> redisGet() {
        Student value = redisService.get(UserKey.getById,"10000", Student.class);
        return Result.success(value);
    }

    @GetMapping("/redis/set")
    @ResponseBody
    public Result<Boolean> redisSet() {
        Student student = new Student(10000, "Luke", 18); // UserKey:id10000
        boolean result = redisService.set(UserKey.getById, String.valueOf(student.getId()), student);

        return Result.success(result);
    }

    @RequestMapping("/mq")
    @ResponseBody
    public Result<String> mq() {
        // mqSender.send("Hello, RabbitMQ!!!");
        return Result.success("SUCCESS");
    }
}
