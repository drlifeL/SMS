package cn.dxxy.dao;

import cn.dxxy.entity.College;
import cn.dxxy.entity.StuClass;
import cn.dxxy.entity.Student;
import javafx.beans.DefaultProperty;

import java.util.List;

public interface StudentDao {

    //查询所有学生
    List<Student> findAllStu();
    //查询所有二级学院
    List<College> findAllCollege();
    //根绝学院名称，拿到学院下的班级和cid
    List<StuClass> getClassDetail(String deptId);
    //添加学生
    void addStudent(Student student);
    //根据sId查找学生
    Student findStudentById(String sId);
    //根据id删除学生
    void delStudent(String sId);
    //修改学生
    void updateStu(Student student);
}


