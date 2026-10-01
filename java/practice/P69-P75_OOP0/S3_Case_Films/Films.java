package S6_S3_Case_Films;

public class Films {
    private int id;
    private String name;
    private double price;
    private double score;
    private String director;
    private String actors;
    private String info;

    public Films() {
    }

    public Films(int id, String name, double price, double score, String director, String actors, String info) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.score = score;
        this.director = director;
        this.actors = actors;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

class Operator {
    private Films[] films;

    public Operator(Films[] films) {
        this.films = films;
    }

    public void printAllFilms() {
        System.out.println("All films are here:");
        for (int i = 0; i < films.length; i++) {
            System.out.println("name: " + films[i].getName() + ", price: $" + films[i].getPrice());
        }
    }

    public void searchFilms(int id) {
        for (int i = 0; i < films.length; i++) {
            if (id == films[i].getId()) {
                System.out.println(films[i].getId());
                System.out.println(films[i].getName());
                System.out.println(films[i].getActors());
                System.out.println(films[i].getDirector());
                System.out.println(films[i].getScore());
                System.out.println("$" + films[i].getPrice());
                System.out.println(films[i].getInfo());
                return;
            }
        }
        System.out.println("Invalid");
    }
}