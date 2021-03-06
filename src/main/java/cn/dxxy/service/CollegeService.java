package cn.dxxy.service;

import cn.dxxy.dao.CollegeDao;
import cn.dxxy.entity.College;
import cn.dxxy.entity.Course;
import cn.dxxy.entity.StuClass;
import cn.dxxy.utils.Util;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {
//    public static final Logger logger = LoggerFactory.getLogger(CollegeService.class);
//
//    public CollegeService() {
//        logger.info("开始进行初始化！");
//        logger.info(logger.getClass().getName());
//    }

    @Autowired
    CollegeDao collegeDao;

    public List<College> findAllCollege() {
        return collegeDao.findAllCollege();
    }

    public void addCollege(College college) {
        collegeDao.addCollege(college);
    }

    public College getCollegeDetailById(String collegeNum) {
        return collegeDao.getCollegeDetailById(collegeNum);
    }

    public void updateCollege(College college) {
        collegeDao.updateCollege(college);
    }

    public void delCollege(String collegeNum) {
        collegeDao.delCollege(collegeNum);
    }

    public void addClassByCollege(StuClass stuClass) {
        collegeDao.addClassByCollege(stuClass);
    }

    public List<Course> getCourseBySpId(String spId) {
        return collegeDao.getCourseBySpId(spId);
    }

    public StuClass getSpById(String spId) {
        return collegeDao.getSpById(spId);
    }

    public List<Course> findAllCourse() {
        return collegeDao.findAllCourse();
    }

    public void addCourse(Course course) {
        collegeDao.addCourse(course);
    }

    public void addCourseBySp(String cId, String couId) {
        collegeDao.addCourseBySp(Util.getUUID(), cId, couId);
    }

    public List<Course> findAllCourseDetailById(String spId) {
        return collegeDao.findAllCourseDetailById(spId);
    }
}
