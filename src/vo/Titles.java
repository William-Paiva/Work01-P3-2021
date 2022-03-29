package vo;

import java.util.ArrayList;
import java.util.Objects;

public class Titles {

    private String type, title, cast, description, genre, director, ageRating;
    private ArrayList<String> platformOfTitle;

    public Titles(String type, String title, String cast, String description,
                  String genre, String director, String ageRating, ArrayList<String> platformOfTitle){

        this.type = type;
        this.title = title;
        this.cast = cast;
        this.description = description;
        this.genre = genre;
        this.director = director;
        this.ageRating = ageRating;
        this.platformOfTitle = new ArrayList<>(platformOfTitle);
    }



    public String getType() {
        return type;
    }
    public String getTitle() {
        return title;
    }
    public String getGenre() {
        return genre;
    }
    public ArrayList<String> getPlatformOfTitle() {
        return platformOfTitle;
    }


    @Override
    public String toString() {
        return "\n--- Titles ---\n" +
                "\n\tType: " + type +
                "\n\tTitle: " + title +
                "\n\tCast: " + cast +
                "\n\tDescription: " + description +
                "\n\tGenre: " + genre +
                "\n\tDirector: " + director +
                "\n\tAgeRating: " + ageRating +
                "\n\tPlatformOfTitle: " + platformOfTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Titles titles = (Titles) o;
        return Objects.equals(type, titles.type) || Objects.equals(title, titles.title) ||
                Objects.equals(genre, titles.genre) || Objects.equals(platformOfTitle, titles.platformOfTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, title, genre, platformOfTitle);
    }
}
