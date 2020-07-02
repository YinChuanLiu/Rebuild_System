package top.yc9064;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import top.yc9064.pojo.Student;
import top.yc9064.pojo.Teacher;
import top.yc9064.service.StudentService;
import top.yc9064.service.TeacherService;

@SpringBootTest
class RebuildSystemApplicationTests {
    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentService studentService;
    @Autowired
    @Qualifier("teacherServiceImpl")
    private TeacherService teacherService;





    @Test
    void contextLoads() {
        Teacher teacherByID = teacherService.getTeacherByID("2120104");
        System.out.println(teacherByID);
    }

}
