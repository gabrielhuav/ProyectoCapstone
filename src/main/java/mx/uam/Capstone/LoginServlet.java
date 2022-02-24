package mx.uam.Capstone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/one")

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post!");
    }

    @Override
    public void destroy() {
        System.out.println ("¡Destruir!");
    }

    public LoginServlet() {
        System.out.println ("¡Fuerza!");
    }

    @Override
    public void init() throws ServletException {
        System.out.println ("¡Inicializar!");
    }
}
