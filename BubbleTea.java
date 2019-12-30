import java.util.ArrayList;

class BubbleTea {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int tea = io.getInt();
        int[] teas = new int[tea];
        for (int i = 0; i < tea; i++) {
            teas[i] = io.getInt();
        }
        ArrayList<ArrayList<Integer>> toppings = new ArrayList<>();
        int trash = io.getInt();
        for (int i = 0; i < trash; i++) {
            toppings.add(new ArrayList<>());
        }
        int[] topArr = new int[trash];
        for (int i = 0; i < trash; i++) {
            topArr[i] = io.getInt();
        }
        int min = 100000;
        for (int i = 0; i < tea; i++) {
            int toppingsAvail = io.getInt();
            for (int j = 0; j < toppingsAvail; j++) {
                int f = io.getInt() - 1;
                if (teas[i] + topArr[f] < min) {
                    min = teas[i] + topArr[f];
                }
            }
        }
        int money = io.getInt();
        /*int money = io.getInt();
        int min = 2000;
        for (int i = 0; i < tea; i++) {
            for (int j = 0; j < toppings.get(i).size(); j++) {
                if (teas[i] + topArr[toppings.get(i).get(j)] < min) { 
                    min = teas[i] + topArr[toppings.get(i).get(j)];
                }
            }
        }*/
        int res = money / min;
        io.println(res - 1 >= 0 ? res - 1 : 0);
        io.close();
    }
}