package cn.dxxy.controller;

import cn.dxxy.entity.Course;
import cn.dxxy.entity.Score;
import cn.dxxy.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 成绩模块
 */
@Controller
public class ScoreController {
    @Autowired
    ScoreService scoreService;

    @RequestMapping("/showStuScore")
    public String showStuScore(Model model) {
        List<Map<String, String>> scores = scoreService.showStuScore();
        model.addAttribute("scores", scores);
        return "score/showScore";
    }

    @RequestMapping("/toAddScore")
    public String toAddScore(Model model) {
        List<Course> courseList = scoreService.findAllCourse();
        model.addAttribute("courseList", courseList);
        return "score/addScore";
    }

    @RequestMapping("/addScore")
    public String addScore(Score score) {
        scoreService.addScore(score);
        return "redirect:showStuScore";
    }

    @RequestMapping("/toEditScore")
    public String toUpdateScorePage(String scId, Model model) {
        Map<String, String> scoreById = scoreService.findScoreByScId(scId);
        model.addAttribute("score", scoreById);
        return "score/editScorePage";
    }

    @RequestMapping("/updateScore")
    public String updateScore(String scId, String grade) {
        scoreService.updateScore(scId, grade);
        return "redirect:showStuScore";
    }

    @RequestMapping("/delScore")
    public String delScoreById(String scId) {
        scoreService.delScoreById(scId);
        return "redirect:showStuScore";
    }

    //根据规则查找
    @RequestMapping("/findScore")
    public String findScore(String sInfo, Model model) {
        //如果是以数字开头的，则认为是学号，其他的就是班级
        String regex = "^\\d+?$";
        List<Map<String, String>> scInfo = null;
        if (sInfo.matches(regex)) {
            //一个学生有多门课程的成绩，所以说不能简单的只查询某一门
            scInfo = scoreService.findScoreBySid(sInfo);
        } else {
            scInfo = scoreService.findScoreByClass(sInfo);
        }
        model.addAttribute("scores", scInfo);
        return "score/showScore";
    }

}
