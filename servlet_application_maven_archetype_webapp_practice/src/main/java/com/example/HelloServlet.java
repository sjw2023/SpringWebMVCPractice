package com.example;

import java.io.IOException;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        System.out.println("doGet");
        res.getWriter().println("<html>");
        res.getWriter().println("<head>");
        res.getWriter().println("<body>");
        // res.getWriter().println("<h1>hello Servlet</h1>");
        // res.getWriter().println("<h1>hello, " + getServletContext().getAttribute("name") + "</h1>");
        res.getWriter().println("<h1>Hello, " + getName() + "</h1>");
        res.getWriter().println("</body>");
        res.getWriter().println("</head>");
        res.getWriter().println("</html>");

        //super.doGet(req, resp);
    }
    //서블릿 컨텍스트에서 name 이라는 어트리뷰트를 읽어 오는 메소드.
    private Object getName(){
        return getServletContext().getAttribute("name");
    }

    @Override
    public void destroy(){
        System.out.println("destroy");
    }
}
