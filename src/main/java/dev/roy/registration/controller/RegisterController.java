package dev.roy.registration.controller;

import dev.roy.registration.dao.EmployeeDao;
import dev.roy.registration.entity.Employee;
import dev.roy.registration.helper.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final EmployeeDao employeeDao = new EmployeeDao(HibernateUtil.getSessionFactory());
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Employee employee = null;

        try {
            String name = req.getParameter("name");
            String department = req.getParameter("department");
            int salary  = Integer.parseInt(req.getParameter("salary"));
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            employeeDao.saveEmployee(new Employee(name, department, salary, email, password));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
