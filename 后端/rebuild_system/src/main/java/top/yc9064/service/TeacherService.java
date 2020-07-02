package top.yc9064.service;

import org.springframework.stereotype.Service;
import top.yc9064.pojo.Student;
import top.yc9064.pojo.Teacher;


public interface TeacherService {
    Teacher getTeacherByID(String tid);
}
