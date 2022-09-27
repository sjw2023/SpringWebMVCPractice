package com.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

public class HelloServlet extends HttpServlet{
    @Override
    public void init() throws ServletException{
        System.out.println("init");
    }
    //Get요청 처리
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        System.out.println("doGet");

        //컨텍스트 로더 리스너가 등록한 서블릿 컨텍스트에 추가한 애플리케이션 컨텍스트를 컨텍스트.애트리뷰트(등록한 이름을 통해 불러오는 코드)
        ApplicationContext context =(ApplicationContext) getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        //애플리케이션 컨텍스트에서 빈을 꺼내오는 코드
        HelloService helloService = context.getBean(HelloService.class);
        

        res.getWriter().println("<html>");
        res.getWriter().println("<head>");
        res.getWriter().println("<body>");
        // res.getWriter().println("<h1>hello Servlet</h1>");
        // res.getWriter().println("<h1>hello, " + getServletContext().getAttribute("name") + "</h1>");
        //서블릿에서 이름을 가져오는 코드
        // res.getWriter().println("<h1>Hello, " + getName() + "</h1>");
        // 빈에서 이름을 가져오는 코드
        res.getWriter().println("<h1>Hello, " + helloService.getName() + "</h1>");
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
