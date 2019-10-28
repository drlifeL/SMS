package cn.dxxy.dao;

import cn.dxxy.entity.Faculty;
import cn.dxxy.entity.Student;

import java.util.List;

public interface StudentDao {

    List<Student> findAllStu();


    List<String> findAllFaculty();

    List<Faculty> getDeptDetail(String deptName);
}


