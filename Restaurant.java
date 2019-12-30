import java.util.*;

class Restaurant {

    String name;
    ArrayList<String> menus;

    public Restaurant(String name) {
        this.name = name;
        menus = new ArrayList<String>();
    }

    public boolean contains() {
        return (menus.contains("pea soup") && menus.contains("pancakes"));
    }
}