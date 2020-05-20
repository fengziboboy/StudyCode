package com.fengziboboy.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: FirstDemo
 * @description:
 * @author: ZhaoJinbo
 * @create: 2020-05-20 16:17
 **/
@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
