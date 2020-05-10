class DogGopher {

    static Kattio io = new Kattio(System.in);
    
    public static void main(String[] args) {
        double gx = io.getDouble();
        double gy = io.getDouble();
        double dx = io.getDouble();
        double dy = io.getDouble();
        while(io.hasMoreTokens()) {
            double hx = io.getDouble();
            double hy = io.getDouble();
            //io.println(0.5 * getDist(hx, hy, dx, dy));
            //io.println(getDist(gx, gy, hx, hy));
            if (.5 * getDist(dx, dy, hx, hy) > getDist(gx, gy, hx, hy)) {
                io.printf("The gopher can escape through the hole at (%.3f,%.3f).", hx, hy);
                io.println();
                io.close();
                return;
            }
        }
        io.println("The gopher cannot escape.");
        io.close();
    }

    static double getDist(double x1, double y1, double x2, double y2) {
        double v = y1 - y2;
        double h = x1- x2;
        return Math.sqrt(Math.pow(v, 2) + Math.pow(h, 2));
    }
}