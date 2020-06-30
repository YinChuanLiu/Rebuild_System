package top.yc9064;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import top.yc9064.pojo.Student;
import top.yc9064.service.StudentService;

@SpringBootTest
class RebuildSystemApplicationTests {
    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentService studentService;
    @Test
    void contextLoads() {
        Student studentByID = studentService.getStudentByID(20167058);
        System.out.println(studentByID);
    }

}
