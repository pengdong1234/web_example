package com.pengdong.easyrules.web.web_example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.pengdong.easyrules.web.web_example.SuspiciousRequestRule.SUSPICIOUS;


@WebServlet(name = "index", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        System.out.println("ok");
        if (isSuspicious(request)) {
            out.print("Access denied");
        } else {
            out.print("Welcome!");
        }
    }
    
    private boolean isSuspicious(HttpServletRequest request) {
        return request.getAttribute(SUSPICIOUS) != null;
    }
}