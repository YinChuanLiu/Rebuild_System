package top.yc9064.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.yc9064.pojo.Student;

@Repository
@Mapper
public interface StudentMapper {
    Student getStudentByID(String sid);
}
