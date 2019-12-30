class Grass {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        double cost = io.getDouble();
        int l = io.getInt();
        double t = 0;
        for (int i = 0; i < l; i++) {
            double length = io.getDouble();
            double width = io.getDouble();
            t += (length * width);
        }
        io.println(t * cost);
        io.close();
    }
}