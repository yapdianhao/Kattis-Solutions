import java.util.*;

class Filip {

    public static void main(String[] args) {
        Kattio kattio = new Kattio(System.in);
        int first = kattio.getInt();
        int sec = kattio.getInt();
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        s1.append("" + first);
        s2.append("" + sec);
        s1 = s1.reverse();
        s2 = s2.reverse();
        kattio.println(Integer.parseInt(s1.toString()) > Integer.parseInt(s2.toString()) ? s1 : s2);
        kattio.close();
    }
}