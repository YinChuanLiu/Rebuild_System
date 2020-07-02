package top.yc9064.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.yc9064.pojo.Student;
import top.yc9064.pojo.Teacher;

@Repository
@Mapper
public interface TeacherMapper {
    Teacher getTeacherByID(String tid);
}
