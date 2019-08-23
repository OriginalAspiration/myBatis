package hubu.mybatis.dao;

import hubu.mybatis.entities.Student;
import hubu.mybatis.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author zhoulei
 * @version 1.0.0
 * @ClassName StudentDao.java
 * @Description TODO
 * @createTime 2019年08月20日 15:28:00
 */
public class StudentDao {

    /**
     * 根据学生编号获得学生对象
     */
    public Student selectStudentById(int id) {
        Student entity = null;
        //打开一个会话
        SqlSession session = SqlSessionFactoryUtil.openSession(true);

        //查询单个对象，指定参数为3
        entity = session.selectOne("hubu.mybatis.mapper.studentMapper.selectStudentById", id);

        //关闭
        SqlSessionFactoryUtil.closeSession(session);

        return entity;
    }


    /**
     * 根据学生姓名获得学生集合
     */
    public List<Student> selectStudentsByName(String name) {
        List<Student> entities = null;
        //打开一个会话
        SqlSession session = SqlSessionFactoryUtil.openSession(true);
        //查询多个对象，指定参数
        entities = session.selectList("hubu.mybatis.mapper.studentMapper.selectStudentsByName", name);
        //关闭
        SqlSessionFactoryUtil.closeSession(session);
        return entities;
    }


    /**
     * 添加学生
     */
    public int insertStudent(Student entity) {
        //影响行数
        int rows = 0;
        //打开一个会话
        SqlSession session = SqlSessionFactoryUtil.openSession(true);
        //执行添加
        rows = session.insert("hubu.mybatis.mapper.studentMapper.insertStudent", entity);
        //关闭
        SqlSessionFactoryUtil.closeSession(session);
        return rows;
    }

    /**
     * 更新学生
     */
    public int updateStudent(Student entity) {
        //影响行数
        int rows = 0;
        //打开一个会话
        SqlSession session = SqlSessionFactoryUtil.openSession(true);
        //执行更新
        rows = session.update("hubu.mybatis.mapper.studentMapper.updateStudent", entity);
        //关闭
        SqlSessionFactoryUtil.closeSession(session);
        return rows;
    }

    /**
     * 删除学生
     */
    public int deleteStudent(int id) {
        //影响行数
        int rows = 0;
        //打开一个会话
        SqlSession session = SqlSessionFactoryUtil.openSession(true);
        //执行删除
        rows = session.delete("hubu.mybatis.mapper.studentMapper.deleteStudent", id);
        //关闭
        SqlSessionFactoryUtil.closeSession(session);
        return rows;
    }

}
