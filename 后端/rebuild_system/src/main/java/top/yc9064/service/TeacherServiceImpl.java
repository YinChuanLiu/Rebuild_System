package top.yc9064.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yc9064.mapper.TeacherMapper;
import top.yc9064.pojo.Student;
import top.yc9064.pojo.Teacher;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;
    @Override
    public Teacher getTeacherByID(String tid) {
        return teacherMapper.getTeacherByID(tid);
    }

}
