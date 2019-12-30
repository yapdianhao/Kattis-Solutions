import java.util.List;
import java.util.ArrayList;

class RaggedRight {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        List<String> lst = new ArrayList<>();
        String line = io.getLine();
        while(line != null) {
            lst.add(line);
            line = io.getLine();
        }
        String max = "";
        for (String s : lst) {
            if (s.length() > max.length()) {
                max = s;
            }
        }
        int res = 0;
        for (int i = 0; i < lst.size() - 1; i++) {
            res += Math.pow(lst.get(i).length() - max.length(), 2);
        }
        io.println(res);
        io.close();
    }
}