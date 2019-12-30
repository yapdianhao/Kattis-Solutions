import java.util.*;

class Beehive {

    double x;
    double y;
    boolean sour;

    public Beehive(double x, double y) {
        this.x = x;
        this.y = y;
        this.sour = false;
    }

    public void isSour(Beehive b, double dist) {
        double d = Math.sqrt(Math.pow(b.x - this.x, 2) + Math.pow(b.y - this.y, 2));
        if (d < dist) {
            this.sour = true;
            b.sour = true;
        }
    }

}