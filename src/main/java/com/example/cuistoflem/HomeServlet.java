package com.example.cuistoflem;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "HomeServlet", value = "/HomeServlet")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //fill les select
        //affichage vueHome tel quel
        request.getRequestDispatcher("vueHome.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //récup inputs utilisateur
        //programme Cuisto
        //return Cuisto
        //ajout attributs a ma vue
        //renvoi de la vue
    }


}
