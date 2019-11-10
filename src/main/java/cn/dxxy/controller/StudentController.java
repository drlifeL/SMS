package cn.dxxy.controller;

import cn.dxxy.entity.Faculty;
import cn.dxxy.entity.Student;
import cn.dxxy.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Arrays;
import java.util.Enumeration;
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
    public String showStuInfo(Model model, Integer start) {
        PageHelper.startPage(1, 5);
        List<Student> allStu = studentService.findAllStu();
        PageInfo<Student> pageInfo = new PageInfo<>(allStu, 5);
        System.out.println(pageInfo);
        model.addAttribute("allStu", allStu);
        return "student/showStudent";
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
        return "student/addStudent";
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
        studentService.addStudent(student);
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

    /**
     * 去更改页面
     *
     * @return
     */
    @RequestMapping("/toEditPage")
    public String toEditPage(String sId, Model model) {
        //拿到当前学生的所有信息
        Student student = studentService.findStudentById(sId);
        //拿到所有的学院信息
        List<String> departs = studentService.findAllFaculty();
        //拿到当前学生所属学院的班级信息
        List<Faculty> fDetail = studentService.getDeptDetail(student.getFaculty().getcDepartments());
        model.addAttribute("stuInfo", student);
        model.addAttribute("departs", departs);
        model.addAttribute("fDetail", fDetail);
        return "student/editStuPage";
    }

    /**
     * 删除学生功能
     *
     * @param delId
     * @return
     */
    @RequestMapping("/delStu")
    public String delStu(@RequestParam("sId") String delId) {
        Student student = studentService.findStudentById(delId);
        if (student != null)
            studentService.delStudent(student.getsId());
        return "forward:showStuInfo";
    }

    /**
     * 修改学生信息
     *
     * @param student
     * @return
     */
    @RequestMapping("/updateStu")
    public String updateStu(Student student) {
        studentService.updateStu(student);
        return "forward:showStuInfo";
    }


}
