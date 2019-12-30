import java.util.List;
import java.util.ArrayList;

class SecureDoor {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        List<String> lst = new ArrayList<>();
        int cases = io.getInt();
        for (int i = 0; i < cases; i++) {
            String act = io.getWord();
            String name = io.getWord();
            if (act.equals("entry")) {
                if (lst.contains(name)) {
                    io.println(name + " entered (ANOMALY)");
                } else {
                    io.println(name + " entered");
                    lst.add(name);
                }
            } else {
                if (lst.contains(name)) {
                    lst.remove(name);
                    io.println(name + " exited");
                } else {
                    io.println(name + " exited (ANOMALY)");
                }
            }
        }
        io.close();
    }
}