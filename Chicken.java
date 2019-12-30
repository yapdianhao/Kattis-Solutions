class Chicken {

    public static void main(String[] args) {
        Kattio kattio = new Kattio(System.in, System.out);
        int need = kattio.getInt();
        int have = kattio.getInt();
        if (have - need > 1) {
            kattio.println(String.format("Dr. Chaz will have %d pieces of chicken left over!", have - need));
        }  else if (have - need == 1) {
            kattio.println("Dr. Chaz will have 1 piece of chicken left over!");
        } else if (need - have > 1) {
            kattio.println(String.format("Dr. Chaz needs %d more pieces of chicken!", need - have));
        } else {
            kattio.println("Dr. Chaz needs 1 more piece of chicken!");
        }
        kattio.close();
    }
}