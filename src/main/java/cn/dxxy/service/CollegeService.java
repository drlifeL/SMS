package cn.dxxy.service;

import cn.dxxy.dao.CollegeDao;
import cn.dxxy.entity.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {

    @Autowired
    CollegeDao collegeDao;

    public List<College> findAllCollege() {
        return collegeDao.findAllCollege();
    }

//    public List<Faculty> findAllFaculty() {
//        return facultyDao.findAllFaculty();
//    }
}
