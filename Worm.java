import java.util.*;

class Worm {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int inc = io.getInt();
        int dec = io.getInt();
        int h = io.getInt();
        int curr = 0;
        int total = 0;
        while (true) {
            total++;
            curr += inc;
            if (curr >= h) break;
            curr -= dec;
        }
        io.println(total);
        io.close();
    }
}