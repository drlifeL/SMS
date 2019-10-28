package cn.dxxy.service;

import cn.dxxy.dao.StudentDao;
import cn.dxxy.entity.Faculty;
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
    public List<String> findAllFaculty() {
        return studentDao.findAllFaculty();
    }

    public List<Faculty> getDeptDetail(String deptName) {
        return studentDao.getDeptDetail(deptName);
    }
}
