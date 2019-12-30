class Roman {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        double m = io.getDouble();
        io.printf("%.0f", m * 5280 * 1000 / 4854);
        io.close();
    }
}