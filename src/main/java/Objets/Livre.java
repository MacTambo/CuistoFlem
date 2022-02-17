package Objets;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Livre {

    List<Recette> livre;
    int index;
    List allIngredients;
    List dropdowns;

    public Livre() {
        index = 0;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cuistoflem?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "toor")) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM mytable");
            this.livre = new ArrayList<>();
            while (result.next()) {
                Recette recette = new Recette(result.getString("nom"), result.getInt("tempsprepa"), result.getString("ingredients"), result.getString("img"), result.getString("texte"));
                livre.add(recette);
            }
            System.out.println("ajouté");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public Recette getRecette(int index) {
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

    public List getAllIngredients() {

        allIngredients = new ArrayList<>();
        for (int i = 0; i < livre.size(); i++) {
            allIngredients.add(" " + livre.get(i).getIngredients());
        }



        System.out.println(allIngredients);
        return allIngredients;
    }

    public List getDropdowns() {
        String ing = String.join(",", allIngredients);
        System.out.println(ing);
        String allIng[];
        String dropdown = "";
        allIng = ing.split(",");
        System.out.println(allIng);
        for (int i = 0; i < allIng.length; i++) {
            for (int j=i+1; j < allIng.length; j++) {
                if (allIng[i].equals(allIng[j])) {
                    allIng[j] = "remove";
                }
            }
        }
        System.out.println(Arrays.toString(allIng) + "\n" + dropdown);
        for (String finalIng : allIng) {
            if (finalIng != "remove") {
                finalIng = finalIng.replaceAll(" ", ",").replaceAll("_", " ");
                dropdown = dropdown + finalIng;
            }
        }

        dropdowns = Arrays.asList(dropdown.split("\\s*,\\s*"));
        System.out.println(dropdowns);
        return dropdowns;

    }

    public Stream stream() {
        return livre.stream();
    }
}
