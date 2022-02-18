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
                    ingredient3 = " ";
                    ingredient2 = " ";
                }
            }
        }
        //Set attributs & renvoi de la vue
        if (recettesAff.isEmpty()) {
            request.getRequestDispatcher("vueQueDalle.jsp").forward(request, response);
        } else {
            Recette laRecette = recettesAff.get(0);
            System.out.println(laRecette.getNom());
            int taille = recettesAff.size();
            System.out.println("taille liste résultats : "+ recettesAff.size());
            String nom = laRecette.getNom();
            Integer tempsPrepaInt = laRecette.getTempsprepa();
            String tempsPrepa = tempsPrepaInt.toString();
            String ingredients = laRecette.getIngredients().replaceAll("_", " ");
            String texte = laRecette.getTexte().replace(". ",". <br><br>");
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
            //vue recette 2
            if (recettesAff.size() >= 2) {
                Recette laRecette2 = recettesAff.get(1);
                String nom2 = laRecette2.getNom();
                Integer tempsPrepaInt2 = laRecette2.getTempsprepa();
                String tempsPrepa2 = tempsPrepaInt2.toString();
                String ingredients2 = laRecette2.getIngredients().replaceAll("_", " ");
                String texte2 = laRecette2.getTexte().replace(". ",". <br><br>");
                String img2 = laRecette2.getImg();
                request.setAttribute("nom2", nom2);
                request.setAttribute("tempsPrepa2", tempsPrepa2);
                request.setAttribute("ingredients2", ingredients2);
                request.setAttribute("texte2", texte2);
                request.setAttribute("img2", img2);

                System.out.println(laRecette2.getNom());

                if (recettesAff.size() >= 3) {
                    //vue recette 3
                    Recette laRecette3 = recettesAff.get(2);
                    String nom3 = laRecette3.getNom();
                    Integer tempsPrepaInt3 = laRecette3.getTempsprepa();
                    String tempsPrepa3 = tempsPrepaInt3.toString();
                    String ingredients3 = laRecette3.getIngredients().replaceAll("_", " ");
                    String texte3 = laRecette3.getTexte().replace(". ",". <br><br>");
                    String img3 = laRecette3.getImg();
                    request.setAttribute("nom3", nom3);
                    request.setAttribute("tempsPrepa3", tempsPrepa3);
                    request.setAttribute("ingredients3", ingredients3);
                    request.setAttribute("texte3", texte3);
                    request.setAttribute("img3", img3);

                    System.out.println(laRecette3.getNom());
                }
            }

            request.getRequestDispatcher("vueLivre.jsp").forward(request, response);
        }
    }


}
