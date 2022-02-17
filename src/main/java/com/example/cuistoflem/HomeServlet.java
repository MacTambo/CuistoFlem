package com.example.cuistoflem;

import Objets.Livre;
import Objets.Recette;
import connectDb.Connect;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "HomeServlet", value = "/HomeServlet")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connect connect = new Connect();
        connect.connect();
        //fill les select
        Livre livre = new Livre();
        livre.getAllIngredients();
        List dropdown = livre.getDropdowns();
        request.setAttribute("dropdown", dropdown);
        System.out.println(dropdown);
        System.out.println("prout");
        //affichage vueHome tel quel
        request.getRequestDispatcher("vueHome.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connect connect = new Connect();
        connect.connect();
        Livre livre = new Livre();

        //récup inputs utilisateur
        String ingredient1 = request.getParameter("ingredient1");
        String ingredient2 = request.getParameter("ingredient2");
        String ingredient3 = request.getParameter("ingredient3");

        //programme Cuisto
        List<Recette> recettesAff = new ArrayList<>();
        for (Recette recette : livre.getLivre()) {
            if (recette.getIngredients().contains(ingredient1)) {
                if (recette.getIngredients().contains(ingredient2)) {
                    if (recette.getIngredients().contains(ingredient3)) {
                        recettesAff.add(recette);
                    }
                }
            }
        }
        if (recettesAff.isEmpty()) {
            for (Recette recette : livre.getLivre()) {
                if (recette.getIngredients().contains(ingredient1)) {
                    if (recette.getIngredients().contains(ingredient2)) {
                            recettesAff.add(recette);
                            ingredient3 = " ";
                    }
                }
            }
        }
        if (recettesAff.isEmpty()) {
            for (Recette recette : livre.getLivre()) {
                if (recette.getIngredients().contains(ingredient1)) {
                        recettesAff.add(recette);
                        ingredient3 =" ";
                        ingredient2 =" ";
                }
            }
        }
        //Set attributs & renvoi de la vue
        if (recettesAff.isEmpty()) {
            request.getRequestDispatcher("vueQueDalle.jsp").forward(request, response);
        } else {
            Recette laRecette = recettesAff.get(0);
            System.out.println(laRecette.getNom());
            String nom = laRecette.getNom();
            Integer tempsPrepaInt = laRecette.getTempsprepa();
            String tempsPrepa = tempsPrepaInt.toString();
            String ingredients = laRecette.getIngredients().replaceAll("_"," ");
            String texte = laRecette.getTexte();
            String img = laRecette.getImg();

            //ajout attributs a ma vue
            request.setAttribute("nom", nom);
            request.setAttribute("tempsPrepa", tempsPrepa);
            request.setAttribute("ingredients", ingredients);
            request.setAttribute("texte", texte);
            request.setAttribute("img", img);
            request.setAttribute("ingredient1", ingredient1);
            request.setAttribute("ingredient2", ingredient2);
            request.setAttribute("ingredient3", ingredient3);

            request.getRequestDispatcher("vueLivre.jsp").forward(request, response);
        }
    }


}
