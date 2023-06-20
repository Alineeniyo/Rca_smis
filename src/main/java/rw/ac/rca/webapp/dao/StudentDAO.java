package rw.ac.rca.webapp.dao;


import rw.ac.rca.webapp.orm.Student;

import java.util.List;

public interface StudentDAO {

    public Student saveStudent (Student student);
    public  Student updateStudent(Student student);
    public  Student saveorUpdateStudent(Student student);
    public  Student getStudentById(int studentId);
    public List<Student> getAllStudents();
    public  boolean deleteStudent( Student student);


}
