package Objets;

import Objets.Recette;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Livre {

    List<Recette> livre;
    int index;

    public Livre(){
        index = 0;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cuistoflem?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "toor")) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM mytable");
            this.livre = new ArrayList<>();
            while (result.next()) {
                Recette recette = new Recette(result.getString("nom"),result.getInt("tempsprepa"),result.getString("ingredients"),result.getString("img"),result.getString("texte"));
                livre.add(recette);
            }
            System.out.println("ajouté");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public Recette getRecette(int index){
        return livre.get(index);
    }

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

    public List<String> getAllIngredients(){
        List<String> list = new ArrayList<>();
        for(int i=0; i<livre.size();i++){
            list.add(livre.get(i).getIngredients());
        }
        System.out.println(list);
        return list;
    }

    public Stream stream() {
        return livre.stream();
    }
}
