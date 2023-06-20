package rw.ac.rca.webapp.dao.impl;

import org.hibernate.Query;
import rw.ac.rca.webapp.dao.StudentDAO;
import rw.ac.rca.webapp.orm.Student;

import java.util.List;

public class StudentDAOImpl extends DAO implements StudentDAO {

    private  static  StudentDAOImpl instance;

    private  StudentDAOImpl() {

    }

    public static  StudentDAOImpl getInstance() {
        if(instance == null) {
            return  new StudentDAOImpl();
        }else {
            return  instance;
        }
    }
    @Override
    public Student saveStudent(Student student) {
        try {
            begin();
            getSession().save(student);
            commit();
            return student;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }


    @Override
    public Student updateStudent(Student student) {
        try {
            begin();
            getSession().update(student);
            commit();
            return student;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    @Override
    public Student saveorUpdateStudent(Student student) {
        try {
            begin();
            getSession().saveOrUpdate(student);
            commit();
            return student;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    @Override
    public Student getStudentById(int studentId) {
        try {
            begin();
            Query query = getSession().createQuery(
                    "from   Student where id= :ref");
            query.setInteger("ref", studentId);
            Student student = (Student) query.uniqueResult();
            commit();
            return student;
        } catch (Exception e) {
            rollback();
            return null;

        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> getAllStudents() {
        try {
            begin();
            Query query = getSession().createQuery("FROM Student");
            List<Student> students = query.list();
            commit();
            return students;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    @Override
    public boolean deleteStudent(Student student) {
        try {
            begin();
            Query query = getSession().createQuery(
                    "from student where id= :ref");
            query.setInteger("ref", student.getId());
            Student  student1 = (Student) query.uniqueResult();
            getSession().delete(student1);
            commit();
            return true;

        } catch (Exception e) {
            rollback();
            return false;
        }
    }
}
