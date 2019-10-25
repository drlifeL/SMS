package cn.dxxy.service;

import cn.dxxy.dao.StudentDao;
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


}
