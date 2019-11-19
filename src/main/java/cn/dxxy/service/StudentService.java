package cn.dxxy.service;

import cn.dxxy.dao.StudentDao;
import cn.dxxy.entity.College;
import cn.dxxy.entity.StuClass;
import cn.dxxy.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    /**
     * 查询所有学生
     *
     * @return
     */
    public List<Student> findAllStu() {
        return studentDao.findAllStu();
    }


    /**
     * 返回所有的学院
     */
    public List<College> findAllCollege() {
        return studentDao.findAllCollege();
    }

    public List<StuClass> getClassDetail(String deptId) {
        return studentDao.getClassDetail(deptId);
    }

    /**
     * <p>
     * 注意：此处应该有事务功能
     *
     * @param student
     */
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    /**
     * 根据学生的id查询学生
     *
     * @param sId
     * @return
     */
    public Student findStudentById(String sId) {
        return studentDao.findStudentById(sId);
    }

    /**
     * 删除学生
     *
     * @param sId
     */
    public void delStudent(String sId) {
        studentDao.delStudent(sId);
    }

    public void updateStu(Student student) {
        studentDao.updateStu(student);
    }

}
