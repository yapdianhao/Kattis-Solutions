class Beehind {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int sweet = io.getInt();
        int sour = io.getInt();
        while (sweet != 0 || sour != 0) {
            if (sweet + sour == 13) {
                io.println("Never speak again.");
            } else if (sweet > sour) {
                io.println("To the convention.");
            } else if (sweet < sour) {
                io.println("Left beehind.");
            } else {
                io.println("Undecided.");
            }
            sweet = io.getInt();
            sour = io.getInt();
        }
        io.close();
    }
}