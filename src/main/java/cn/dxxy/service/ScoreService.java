package cn.dxxy.service;

import cn.dxxy.dao.ScoreDao;
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
}
