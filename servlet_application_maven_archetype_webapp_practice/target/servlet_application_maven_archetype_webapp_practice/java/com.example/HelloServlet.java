package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
    @Override
    public void init() throws ServletException{
        System.out.println("init");
    }
    //Get요청 처리
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        System.out.println("doGet");
        res.getWriter().println("<html>");
        res.getWriter().println("<head>");
        res.getWriter().println("<body>");
        res.getWriter().println("<h1>hello Servlet</h1>");
        res.getWriter().println("</body>");
        res.getWriter().println("</head>");
        res.getWriter().println("</html>");

        //super.doGet(req, resp);
    }

    @Override
    public void destroy(){
        System.out.println("destroy");
    }
}
