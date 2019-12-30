import java.util.ArrayList;
import java.util.List;

class JoinString {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        //Kattio io = new Kattio(System.in);
        int num = io.getInt();
        String[] strings = new String[num];
        List<List<Integer>> idx = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            idx.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < num; i++) {
            strings[i] = io.getWord();
        }
        int temp = 0;
        for (int i = 0; i < num - 1; i++) {
            int from = io.getInt() - 1;
            temp = from;
            int to = io.getInt() - 1;
            idx.get(from).add(to);
        }
        printThis(idx, strings, temp);
        io.close();
    }

    static void printThis(List<List<Integer>> idx, String[] strings, int z) {
        io.print(strings[z]);
        for (int i : idx.get(z)) {
            printThis(idx, strings, i);
        }
    }
}