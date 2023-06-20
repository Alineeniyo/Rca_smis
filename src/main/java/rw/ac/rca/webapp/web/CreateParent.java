package rw.ac.rca.webapp.web;

import rw.ac.rca.webapp.dao.AddressDAO;
import rw.ac.rca.webapp.dao.ParentDAO;
import rw.ac.rca.webapp.dao.StudentDAO;
import rw.ac.rca.webapp.dao.impl.AddressDAOImpl;
import rw.ac.rca.webapp.dao.impl.ParentDAOImpl;
import rw.ac.rca.webapp.dao.impl.StudentDAOImpl;
import rw.ac.rca.webapp.orm.Parent;
import rw.ac.rca.webapp.orm.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class CreateCourse
 */
public class CreateParent extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDAO studentDAO = StudentDAOImpl.getInstance();
    private ParentDAO parentDAO = ParentDAOImpl.getInstance();
    private AddressDAO addressDAO = AddressDAOImpl.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateParent() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String pageRedirect = request.getParameter("page");
        HttpSession httpSession = request.getSession();
        Object user = httpSession.getAttribute("authenticatedUser");
        System.out.println("The user in session is: " + user);

        if (pageRedirect != null) {

            if (pageRedirect.equals("createparent")) {
                List<Student> students = studentDAO.getAllStudents();

                request.setAttribute("students", students);
                request.getRequestDispatcher("WEB-INF/createParent.jsp").forward(request, response);
            } else {
                request.setAttribute("CreateUsererror ", "No user found");
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("CreateUsererror ", "No user found");
            request.getRequestDispatcher("WEB-INF/createparent.jsp").forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageRedirect = request.getParameter("page");
        HttpSession httpSession = request.getSession();
        Object user = httpSession.getAttribute("authenticatedUser");

        if (pageRedirect != null) {
            if (pageRedirect.equals("createparent")) {
                Parent parent = new Parent();

                parent.setFirstName(request.getParameter("firstName"));
                parent.setLastName(request.getParameter("lastName"));
                parent.setPhoneNumber(request.getParameter("phoneNumber"));
                parent.setNationalId(request.getParameter("nationalId"));

                try {
                    parentDAO.saveParent(parent);
                    request.setAttribute("successParent", "Successfully created the parent");
                    request.getRequestDispatcher("WEB-INF/createParent.jsp").forward(request, response);
                } catch (Exception e) {
                    request.setAttribute("CreateParenterror", "Failed to create the parent");
                    request.getRequestDispatcher("WEB-INF/createParent.jsp").forward(request, response);
                }
            } else {
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
        }
    }


}