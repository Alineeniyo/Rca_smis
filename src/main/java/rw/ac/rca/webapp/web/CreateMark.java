//package rw.ac.rca.webapp.web;
//
//import rw.ac.rca.webapp.dao.CourseDAO;
//import rw.ac.rca.webapp.dao.MarkDAO;
//import rw.ac.rca.webapp.dao.StudentDAO;
//import rw.ac.rca.webapp.dao.impl.CourseDAOImpl;
//import rw.ac.rca.webapp.dao.impl.MarkDAOImpl;
//import rw.ac.rca.webapp.dao.impl.StudentDAOImpl;
//import rw.ac.rca.webapp.orm.Course;
//import rw.ac.rca.webapp.orm.Mark;
//import rw.ac.rca.webapp.orm.Student;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.List;
//
///**
// * Servlet implementation class CreateCourse
// */
//public class CreateMark extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    private MarkDAO markDAO  = MarkDAOImpl.getInstance();
//    private StudentDAO studentDAO = StudentDAOImpl.getInstance();
//    private CourseDAO courseDAO = CourseDAOImpl.getInstance();
//
//
//
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public CreateMark() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//    /**
//     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//     */
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // TODO Auto-generated method stub
//        String pageRedirect = request.getParameter("page");
//        HttpSession httpSession = request.getSession();
//        Object user = httpSession.getAttribute("authenticatedUser");
//        System.out.println("The user in session is: " + user);
//
//        if (pageRedirect != null) {
//            System.out.println("The print statement is and the only is: " + pageRedirect);
//            if (pageRedirect.equals("createmark")) {
//                 List<Student> studentList = studentDAO.getAllStudents();
//                List<Course> courseList = courseDAO.getAllCourses();
//                request.setAttribute("student" , studentList);
//                request.setAttribute("course" , courseList);
//                request.getRequestDispatcher("WEB-INF/createMark.jsp").forward(request, response);
//            } else {
//                request.setAttribute("CreateUsererror ", "No user found");
//                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
//            }
//        } else {
//            request.setAttribute("CreateUsererror ", "No user found");
//            request.getRequestDispatcher("WEB-INF/createmark.jsp").forward(request, response);
//        }
//    }
//
//    /**
//     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//     */
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String pageRedirect = request.getParameter("page");
//        HttpSession httpSession = request.getSession();
//        Object user = httpSession.getAttribute("authenticatedUser");
//
//        if (pageRedirect != null) {
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            if (pageRedirect.equals("createmark")) {
//
//                Student student = studentDAO.getStudentById(Integer.parseInt(request.getParameter("student")));
//                Course course = courseDAO.getCourseById(Integer.parseInt(request.getParameter("course")));
//                Mark mark = new Mark();
//                try {
//                   mark.setStudent(student);
//                   mark.setCourse(course);
//                    mark.setMarksScored(Integer.parseInt(request.getParameter("marksScored")));
//                    mark.setTotalMarks(Integer.parseInt(request.getParameter("totalMarks")));
//                    mark.setGrade(request.getParameter("grade"));
//
//                }catch (Exception e) {
//                    throw new RuntimeException(e);
//
//                }
//
//                try {
//                    markDAO.saveMark(mark);
//                    request.setAttribute("successMark", "Successfully created the Marks");
//                    System.out.println("Marks are created");
//                    request.getRequestDispatcher("WEB-INF/createMark.jsp").forward(request, response);
//                } catch (Exception e) {
//                    e.printStackTrace(); // Print the exception details to identify the issue
//                    request.setAttribute("CreateMarkserror", "Failed to create the Marks");
//                    request.getRequestDispatcher("WEB-INF/createMark.jsp").forward(request, response);
//                }
//            } else {
//                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
//            }
//        } else {
//            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
//        }
//    }
//}



package rw.ac.rca.webapp.web;

import rw.ac.rca.webapp.dao.CourseDAO;
import rw.ac.rca.webapp.dao.MarkDAO;
import rw.ac.rca.webapp.dao.StudentDAO;
import rw.ac.rca.webapp.dao.impl.CourseDAOImpl;
import rw.ac.rca.webapp.dao.impl.MarkDAOImpl;
import rw.ac.rca.webapp.dao.impl.StudentDAOImpl;
import rw.ac.rca.webapp.orm.Course;
import rw.ac.rca.webapp.orm.Mark;
import rw.ac.rca.webapp.orm.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class CreateMark extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final MarkDAO marksDAO = MarkDAOImpl.getInstance();
    private final StudentDAO studentDAO = StudentDAOImpl.getInstance();
    private final CourseDAO courseDAO = CourseDAOImpl.getInstance();
    public CreateMark() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageRedirect = request.getParameter("page");
        HttpSession httpSession = request.getSession();
        Object user = httpSession.getAttribute("authenticatedUser");
        System.out.println("The user in session is: " + user);
        if (pageRedirect != null) {
            System.out.println("The print statement is and the only is: " + pageRedirect);
            if (pageRedirect.equals("createmark")) {
                List<Student> students = studentDAO.getAllStudents();
                List<Course> courses = courseDAO.getAllCourses();
                httpSession.setAttribute("students", students);
                httpSession.setAttribute("courses", courses);
                request.getRequestDispatcher("WEB-INF/createMark.jsp").forward(request, response);
            } else {
                request.setAttribute("error ", "No user found");
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error ", "No user found");
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
        }
    }

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String pageRedirect = request.getParameter("page");
    HttpSession httpSession = request.getSession();
    Object user = httpSession.getAttribute("authenticatedUser");
    if (pageRedirect != null) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (pageRedirect.equals("createmark")) {
            Mark mark = new Mark();
            Student student = studentDAO.getStudentById(Integer.parseInt(request.getParameter("student")));
            Course course = courseDAO.getCourseById(Integer.parseInt(request.getParameter("course")));
            try {
                mark.setStudent(student);
                mark.setCourse(course);
                mark.setMarksScored(Integer.parseInt(request.getParameter("marksScored")));
                mark.setTotalMarks(Integer.parseInt(request.getParameter("totalMarks")));
                mark.setGrade(request.getParameter("grade"));
                mark.setGrade(request.getParameter("student"));
                mark.setGrade(request.getParameter("grade"));

                marksDAO.saveMark(mark);
                request.setAttribute("marks", marksDAO.getAllMarks());
                httpSession.setAttribute("marks", marksDAO.getAllMarks());
                request.setAttribute("success", "Successfully created the Marks");
                request.getRequestDispatcher("WEB-INF/marks.jsp").forward(request, response);

            } catch (Exception e) {
                request.setAttribute("error", "Failed to create the Course");
                request.getRequestDispatcher("WEB-INF/createMark.jsp").forward(request, response);
                throw new RuntimeException(e);
            }
        } else {
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
        }
    } else {
        request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
    }
}

}