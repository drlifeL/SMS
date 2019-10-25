package cn.dxxy.controller;

import cn.dxxy.entity.Student;
import cn.dxxy.service.StudentService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    /**
     * 来到学生列表
     * @param model
     * @return
     */
    @RequestMapping("/showStuInfo")
    public String showStuInfo(Model model) {
        List<Student> allStu = studentService.findAllStu();
        model.addAttribute("allStu", allStu);
        return "showStudent";
    }


}
