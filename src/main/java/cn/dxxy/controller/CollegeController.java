package cn.dxxy.controller;

import cn.dxxy.entity.College;
import cn.dxxy.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CollegeController {
    @Autowired
    CollegeService collegeService;

    //显示所有学院
    @RequestMapping("/showAllCollege")
    public String showAllFaculty(Model model) {
        List<College> colleges = collegeService.findAllCollege();
        model.addAttribute("colleges", colleges);
        return "college/showCollege";
    }
}
