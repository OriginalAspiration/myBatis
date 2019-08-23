package hubu.mybatis.dao;

import hubu.mybatis.entities.Student;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * StudentDao Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 20, 2019</pre>
 */
public class StudentDaoTest {
    StudentDao dao;

    @Before
    public void before() throws Exception {
        dao = new StudentDao();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: selectStudentById(int id)
     */
    @Test
    public void testSelectStudentById() throws Exception {
        Student entity = dao.selectStudentById(1);
        System.out.println(entity);
        Assert.assertNotNull(entity);
    }

    /**
     * Method: selectStudentsByName(String name)
     */
    @Test
    public void testSelectStudentsByName() throws Exception {
        List<Student> students = dao.selectStudentsByName("玛丽");
        System.out.println(students);
        Assert.assertNotNull(students);
    }

    /**
     * Method: insertStudent
     */
    @Test
    public void testInsertStudent() throws Exception {
        Student entity = new Student();
        entity.setName("玛丽");
        entity.setSex("girl");

        Assert.assertEquals(1, dao.insertStudent(entity));
    }

    /**
     * Method: updateStudent
     */
    @Test
    public void testUpdateStudent() throws Exception {
        Student entity = dao.selectStudentById(3);
        entity.setName("马力");
        entity.setSex("boy");

        Assert.assertEquals(1, dao.updateStudent(entity));
    }

    /**
     * Method: deleteStudent
     */
    @Test
    public void testDeleteStudent() throws Exception {
        Assert.assertEquals(1, dao.deleteStudent(5));
    }
} 
