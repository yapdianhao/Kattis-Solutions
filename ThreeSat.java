class ThreeSAT {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int clauses = io.getInt();
        int instances = io.getInt();
        if (clauses < 8) {
            io.println("unsatisfactory");
            io.close();
            return;
        }
        boolean res = true;
        for (int i = 0; i < clauses; i++) {
            boolean temp = false;
            for (int j = 0; j < instances; j++) {
                int in = io.getInt();
                temp = temp || (in < 0 ? false : true);
            }
            io.println(temp);
            res = res && temp;
        }
        io.println(res ? "satisfatory" : " unsatisfactory");
        io.close();
    }
}