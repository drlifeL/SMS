package cn.dxxy.dao;


import cn.dxxy.entity.College;
import cn.dxxy.entity.Course;
import cn.dxxy.entity.StuClass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollegeDao {

    List<College> findAllCollege();

    void addCollege(College college);

    College getCollegeDetailById(String collegeNum);

    void updateCollege(College college);

    void delCollege(String collegeNum);

    void addClassByCollege(StuClass stuClass);

    List<Course> getCourseBySpId(String spId);

    StuClass getSpById(String spId);

    List<Course> findAllCourse();

    void addCourse(Course course);

    void addCourseBySp(@Param("id") String uuid, @Param("cId") String cId, @Param("couId") String couId);

    List<Course> findAllCourseDetailById(String spId);
}
