package cn.dxxy.controller;

import cn.dxxy.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

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
    public String toAddScore() {
        return "score/addScore";
    }

}
