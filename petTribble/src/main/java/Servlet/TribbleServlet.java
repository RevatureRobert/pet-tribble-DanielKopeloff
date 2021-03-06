package Servlet;


import DB.DAO.TribbleDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/tribble")
public class TribbleServlet  extends HttpServlet {

    TribbleDAO tribbleDAO = TribbleDAO.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        tribbleDAO.readAll();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(tribbleDAO.readAll());

        writer.println( json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       while(req.getReader().readLine()!= null){
           System.out.println(req.getReader().readLine());
       }
//        tribbleDAO.add()
    }
}
