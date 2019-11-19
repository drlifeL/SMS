package cn.dxxy.service;

import cn.dxxy.dao.ScoreDao;
import cn.dxxy.entity.Course;
import cn.dxxy.entity.Score;
import cn.dxxy.entity.Student;
import cn.dxxy.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ScoreService {
    @Autowired
    ScoreDao scoreDao;

    public List<Map<String, String>> showStuScore() {
        return scoreDao.showStuScore();
    }

    public List<Course> findAllCourse() {
        return scoreDao.findAllCourse();
    }

    public void addScore(Score score) {
        score.setScId(Util.getUUID());
        scoreDao.addScore(score);
    }

    public Map<String, String> findScoreByScId(String scId) {
        return scoreDao.findScoreByScId(scId);
    }

    public void updateScore(String scId, String grade) {
        scoreDao.updateScore(scId, grade);
    }

    public void delScoreById(String scId) {
        scoreDao.delScoreById(scId);
    }

    public List<Map<String, String>> findScoreByClass(String sInfo) {
        return scoreDao.findScoreByClass(sInfo);
    }

    public List<Map<String, String>> findScoreBySid(String sInfo) {
        return scoreDao.findScoreBySid(sInfo);
    }

    public Student findStuById(String sId) {
        return scoreDao.findStuById(sId);
    }

    public List<Course> findCourseBySpId(String spId) {
        return scoreDao.findCourseBySpId(spId);
    }
}
