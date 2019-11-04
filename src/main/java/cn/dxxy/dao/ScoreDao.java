package cn.dxxy.dao;

import java.util.List;
import java.util.Map;

public interface ScoreDao {
    //显示所有的学生成绩
    List<Map<String, String>> showStuScore();
}
