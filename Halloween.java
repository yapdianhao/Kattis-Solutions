class Halloween {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        String line = io.getLine();
        if (line.equals("OCT 31") || line.equals("DEC 25")) {
            io.println("yup");
        } else {
            io.println("nope");
        }
        io.close();
    }
}