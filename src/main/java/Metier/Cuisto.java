package Metier;

import Objets.Livre;

public class Cuisto {

    private String ingredient1;
    private String ingredient2;
    private String ingredient3;
    private Livre livre = new Livre();

    public Cuisto(){
    }

    public Livre cuisto(){
        Livre Livre = new Livre();
        return Livre;
    }
}
