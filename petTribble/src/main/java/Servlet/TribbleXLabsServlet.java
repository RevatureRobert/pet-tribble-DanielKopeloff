package Servlet;

import DB.DAO.TribbleDAO;
import DB.DAO.TribbleXLabDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/tribbleXLabs")
public class TribbleXLabsServlet extends HttpServlet {
    TribbleXLabDAO tribbleDAO;

    {
        try {
            tribbleDAO = new TribbleXLabDAO();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        tribbleDAO.readAll();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(tribbleDAO.readAll());

        writer.println( json);
    }
}
