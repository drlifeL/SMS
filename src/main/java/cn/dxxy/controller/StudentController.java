package cn.dxxy.controller;

import cn.dxxy.entity.Faculty;
import cn.dxxy.entity.Student;
import cn.dxxy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    /**
     * 来到学生列表
     *
     * @param model
     * @return
     */
    @RequestMapping("/showStuInfo")
    public String showStuInfo(Model model) {
        List<Student> allStu = studentService.findAllStu();
        model.addAttribute("allStu", allStu);
        return "showStudent";
    }

    /**
     * 去学生添加页面
     * 这里要将所有的学院信息查询出来，带给页面
     *
     * @return
     */
    @RequestMapping("/toAddStuPage")
    public String toAddStu(Model model) {
        List<String> listFacultyName = studentService.findAllFaculty();
        model.addAttribute("facultys", listFacultyName);
        return "addStudent";
    }

    /**
     * 添加学生
     * 1.校验数据
     * 2.添加入库
     * 3.跳转到学生列表界面
     *
     * @param student
     * @return
     */
    @RequestMapping("/addStudent")
    public String addStudent(Student student) {
        return "forward:showStuInfo";
    }

    /**
     * 获取所属学院下的班级
     * 并返回json数据给页面
     *
     * @param deptName 部门信息
     * @return 部门信息+cid
     */
    @ResponseBody
    @RequestMapping("/getClassDetail")
    public List<Faculty> getDeptDetail(String deptName) {
        return studentService.getDeptDetail(deptName);
    }


}
