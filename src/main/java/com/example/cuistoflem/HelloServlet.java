package com.example.cuistoflem;

import java.io.*;

import Objets.Livre;
import connectDb.Connect;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        Connect connect = new Connect();
        connect.connect();
        Livre livre = new Livre();
        System.out.println(livre.getRecette(1).getNom());
        livre.getAllIngredients();
        System.out.println(livre.getDropdowns());
    }

    public void destroy() {
    }
}