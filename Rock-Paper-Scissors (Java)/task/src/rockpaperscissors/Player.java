package rockpaperscissors;

public class Player {
    private String name;
    private int rating;


    public void increaseRating(int score) {
        rating += score;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }
}
