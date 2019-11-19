package cn.dxxy.dao;

import cn.dxxy.entity.Course;
import cn.dxxy.entity.Score;
import cn.dxxy.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ScoreDao {
    //显示所有的学生成绩
    List<Map<String, String>> showStuScore();

    //查询所有的课程
    List<Course> findAllCourse();

    void addScore(Score score);

   Map<String,String> findScoreByScId(String scId);

    void updateScore(@Param("scId") String scId, @Param("grade") String grade);

    void delScoreById(String scId);

    List<Map<String, String>> findScoreByClass(String sInfo);

    List<Map<String, String>> findScoreBySid(String sInfo);

    Student findStuById(String sId);

    List<Course> findCourseBySpId(String spId);
}
