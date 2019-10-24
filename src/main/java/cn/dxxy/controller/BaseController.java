package cn.dxxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {

    @RequestMapping("/hh")
    public String haha() {
        return "hah";
    }
}
