package cn.dxxy.controller;

import cn.dxxy.entity.College;
import cn.dxxy.entity.Course;
import cn.dxxy.entity.StuClass;
import cn.dxxy.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    //添加学院
    @RequestMapping("/addCollege")
    public String addCollege(College college) {
        collegeService.addCollege(college);
        return "redirect:showAllCollege";
    }

    //根据学院Id拿到学院
    @ResponseBody
    @RequestMapping("/getCollegeDetailById")
    public College getCollegeDetailById(String collegeNum) {
        College collegeDetailById = collegeService.getCollegeDetailById(collegeNum);
        return collegeDetailById;
    }

    //更新学院
    @RequestMapping("/updateCollege")
    public String updateCollege(College college) {
        collegeService.updateCollege(college);
        return "redirect:showAllCollege";
    }

    //删除学院
    @RequestMapping("/delCollege")
    public String delCollege(String collegeNum) {
        collegeService.delCollege(collegeNum);
        return "redirect:showAllCollege";
    }


    //专业 Discipline  展示所有的专业
    @RequestMapping("/showDiscipline")
    public String showDiscipline(Model model) {
        List<College> colleges = collegeService.findAllCollege();
        model.addAttribute("colleges", colleges);
        return "college/showDiscipline";
    }

    //添加专业到学院下
    @RequestMapping("/addClassByCollege")
    public String addClassByCollege(StuClass stuClass) {
        collegeService.addClassByCollege(stuClass);
        return "redirect:showDiscipline";
    }

    //根据专业Id拿到所有该专业下的所以课程，
    @RequestMapping("/getCourseBySpId")
    public String getCourseBySpId(String spId, Model model) {
        List<Course> courses = collegeService.getCourseBySpId(spId);
        //拿到专业
        StuClass sp = collegeService.getSpById(spId);
        model.addAttribute("courses", courses);
        model.addAttribute("sp", sp);
        return "college/addCourse";
    }

    //课程列表
    @RequestMapping("/showCourses")
    public String showCourses(Model model) {
        List<Course> courses = collegeService.findAllCourse();
        model.addAttribute("courses", courses);
        return "college/showCourse";
    }

    //添加课程
    @RequestMapping("/addCourse")
    public String addCourse(Course course) {
        collegeService.addCourse(course);
        return "redirect:showCourses";
    }

    //所有的课程信息。打包成JSON数据
    @ResponseBody
    @RequestMapping("/findAllCourseDetail")
    public List<Course> findAllCourseDetail() {
        return collegeService.findAllCourse();
    }

    /**
     *  将专业和课程关联起来
     * @param cId  专业id
     * @param couId 课程id
     * @return
     */
    @RequestMapping("/addCourseBySp")
    public String addCourseBySp(String cId, String couId) {
        collegeService.addCourseBySp(cId, couId);
        return "redirect:showDiscipline";
    }


}
