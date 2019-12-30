import java.util.*;

class Beehives {

    public static void main(String[] args) {
        Kattio kattio = new Kattio(System.in, System.out);
        while (kattio.hasMoreTokens()) {
            double sourDistance = kattio.getDouble();
            int beehives = kattio.getInt();
            if (beehives == 0) {
                break;
            }
            int count = 0;
            ArrayList<Beehive> hives = new ArrayList<Beehive>();
            for (int i = 0; i < beehives; i++) {
                Beehive beehive = new Beehive(kattio.getDouble(), kattio.getDouble());
                hives.add(beehive);
            }
            for (int i = 0; i < beehives - 1; i++) {
                for (int j = i + 1; j < beehives; j++) {
                    hives.get(i).isSour(hives.get(j), sourDistance);
                }
            }
            for (Beehive b : hives) {
                if (b.sour) {
                    count++;
                }
            }
            kattio.println(String.format("%d sour, %d sweet", count, beehives - count));
            hives.clear();
            count = 0;
            kattio.flush();
        }
    }
}