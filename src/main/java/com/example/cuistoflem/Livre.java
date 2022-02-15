package com.example.cuistoflem;

import java.util.ArrayList;
import java.util.List;

public class Livre {

    List<Recette> livre;
    int index;

    public List<Recette> getLivre() {
        return livre;
    }

    public void setLivre(List<Recette> livre) {
        this.livre = livre;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Livre(){
        index = 0;
        livre = new ArrayList<Recette>();
    }
}
