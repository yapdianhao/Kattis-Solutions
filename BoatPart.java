import java.util.ArrayList;

class BoatPart {

    public static void main(String[] args) {
        Kattio kattio = new Kattio(System.in);
        int parts = kattio.getInt();
        int days = kattio.getInt();
        ArrayList<String> lst = new ArrayList<String>();
        for (int i = 0; i < days; i++) {
            String part = kattio.getWord();
            if (!lst.contains(part)) {
                lst.add(part);
                if (lst.size() == parts) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }
        if (lst.size() < parts) {
            System.out.println("paradox avoided");
        } else {
            kattio.println("shit");
        }
        kattio.close();
    }
}