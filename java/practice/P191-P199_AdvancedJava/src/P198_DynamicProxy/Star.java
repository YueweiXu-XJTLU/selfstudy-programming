package P198_DynamicProxy;

public class Star implements Proxy {
    private String name;

    public Star(String name) {
        this.name = name;
    }

    public Star() {
    }

    @Override
    public String sing(String song) {
        System.out.println(name + " is singing \"" + song + "\"!");
        return "Thank U :)";
    }

    @Override
    public void dance() {
        System.out.println(name + " is dancing!");
    }
}
