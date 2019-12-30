import java.util.*;

class Peasoup {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int restaurants = sc.nextInt();
        ArrayList<Restaurant> arr = new ArrayList<Restaurant>();
        for (int i = 0; i < restaurants; i++) {
            int menu = sc.nextInt();
            sc.nextLine(); // This is to catch the weird Scanner nextLine() method of scanning empty strings
            String name = sc.nextLine();
            Restaurant restaurant = new Restaurant(name);
            for (int j = 0; j < menu; j++) {
                String food = sc.nextLine();
                restaurant.menus.add(food);
            }
            arr.add(restaurant);
        }

        boolean searched = false;
        for (Restaurant restaurant : arr) {
            if (restaurant.contains()) {
                System.out.println(restaurant.name);
                searched = true;
                break;
            }
        }

        if (!searched) {
            System.out.println("Anywhere is fine I guess");
        }
    }
}