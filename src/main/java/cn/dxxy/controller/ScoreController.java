package cn.dxxy.controller;

import cn.dxxy.entity.Course;
import cn.dxxy.entity.Score;
import cn.dxxy.entity.Student;
import cn.dxxy.service.ScoreService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * 成绩模块
 */
@Controller
public class ScoreController {
    @Autowired
    ScoreService scoreService;

    //显示所有学生分数
    @RequestMapping("/showStuScore")
    public String showStuScore(Model model, @RequestParam(defaultValue = "1") Integer start) {
        PageHelper.startPage(start, 5);
        List<Map<String, String>> scores = scoreService.showStuScore();
        PageInfo<Map<String, String>> pageInfo = new PageInfo<>(scores);
        model.addAttribute("pageInfo", pageInfo);
        return "score/showScore";
    }

    //去到添加页面
    @RequestMapping("/toAddScore")
    public String toAddScore() {
        return "score/addScore";
    }

    //添加分数
    @RequestMapping("/addScore")
    public String addScore(Score score) {
        scoreService.addScore(score);
        return "redirect:showStuScore";
    }

    //去到修改分数页面
    @RequestMapping("/toEditScore")
    public String toUpdateScorePage(String scId, Model model) {
        Map<String, String> scoreById = scoreService.findScoreByScId(scId);
        model.addAttribute("score", scoreById);
        return "score/editScorePage";
    }

    //执行修改分数
    @RequestMapping("/updateScore")
    public String updateScore(String scId, String grade) {
        scoreService.updateScore(scId, grade);
        return "redirect:showStuScore";
    }

    //删除分数
    @RequestMapping("/delScore")
    public String delScoreById(String scId) {
        scoreService.delScoreById(scId);
        return "redirect:showStuScore";
    }

    //查找分数   根据规则查找
    @RequestMapping("/findScore")
    public String findScore(String sInfo, Model model) {
        //如果是以数字开头的，则认为是学号，其他的就是班级
        String regex = "^\\d+?$";
        List<Map<String, String>> scInfo = null;
        PageHelper.startPage(1, 5);
        if (sInfo.matches(regex)) {
            //一个学生有多门课程的成绩，所以说不能简单的只查询某一门
            scInfo = scoreService.findScoreBySid(sInfo);
        } else {
            scInfo = scoreService.findScoreByClass(sInfo);
        }

        PageInfo<Map<String, String>> pageInfo = new PageInfo<>(scInfo,5);
        model.addAttribute("pageInfo", pageInfo);
        return "score/showScore";
    }

    // 返回当前学生是否存在，以及当前学生对应专业下的课程
    @ResponseBody
    @RequestMapping("/findStuAndCourseDetailById")
    public Map<String, Object> findStuAndCourseDetailById(String sId) {
        Map<String, Object> res = new HashMap<>();
        Student stu = scoreService.findStuById(sId);
        //如果当前查询出来的学生存在Cid .专业属性
        if (stu == null || stu.getcId().equals("")) {
            //100失败 200成功
            res.put("code", 100);
        } else {
            List<Course> lists = scoreService.findCourseBySpId(stu.getcId());
            res.put("code", 200);
            res.put("lists", lists);
        }
        return res;
    }

}
