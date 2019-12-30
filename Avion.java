import java.util.*;

class Avion {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        while (io.hasMoreTokens()) {
            String input = io.getWord();
            if (input.contains("FBI")) {
                sb.append(count);
                sb.append(" ");
            }
            count++;
        }
        io.println(sb.length() == 0 ? "HE GOT AWAY!" : sb.toString());
        io.close();
    }
}