package top.yc9064.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yc9064.mapper.StudentMapper;
import top.yc9064.pojo.Student;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentMapper studentMapper;

    @Override
    public Student getStudentByID(Integer sid) {
        return studentMapper.getStudentByID(sid);
    }

}
