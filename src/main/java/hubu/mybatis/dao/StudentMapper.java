package hubu.mybatis.dao;

import hubu.mybatis.entities.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author zhoulei
 * @version 1.0.0
 * @ClassName StudentMapper.java
 * @Description TODO
 * @createTime 2019年08月20日 17:43:00
 */
public interface StudentMapper {
    /**
     * 根据学生编号获得学生对象
     */
    @Select("select id,name,sex from student where id=#{id}")
    Student selectStudentById(int id);

    /**
     * 根据学生姓名获得学生集合
     */
    @Select("SELECT id,name,sex from student where name like '%${value}%'")
    List<Student> selectStudentsByName(String name);
    /**
     * 添加学生
     */
    @Insert("insert into student(name,sex) values(#{name},#{sex})")
    int insertStudent(Student entity);

    /**
     * 更新学生
     */
    @Update("update student set name=#{name},sex=#{sex} where id=#{id}")
    int updateStudent(Student entity);

    /**
     * 删除学生
     */
    @Delete("delete from student where id=#{id}")
    int deleteStudent(int id);
}
