package Objets;

import connectDb.Connect;

import java.util.ArrayList;
import java.util.List;

public class Recette {
    String nom;
    Integer tempsprepa;
    String ingredients;
    String img;
    String texte;

    public Recette(String nom, int tempsprepa, String ingredients, String img, String texte) {
        this.nom = nom;
        this.tempsprepa = tempsprepa;
        this.ingredients = ingredients;
        this.img = img;
        this.texte = texte;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTempsprepa() {
        return tempsprepa;
    }

    public void setTempsprepa(int tempsprepa) {
        this.tempsprepa = tempsprepa;
    }

    public String getIngredients() {
        return ingredients;
    }

    public List<String> getIngredientList() {
        List<String> list = new ArrayList<>();
        String sep = ", ";
        String elements[] = ingredients.split(sep);
        for (int i = 0; i < ingredients.length(); i++) {
            list.add(elements[i]);
        }
        return list;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
}
