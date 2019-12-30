class Simon {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int cmd = io.getInt();
        for (int i = 0; i < cmd; i++) {
            String line = io.getLine();
            if (line.startsWith("simon says") && !line.equals("simon says")) {
                io.println(line.substring(11));
            } else io.println();
        }
        io.close();
    }
}