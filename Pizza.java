class Pizza {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        double pizza = (double) io.getInt();
        double crust = (double) io.getInt();
        double percent = ((pizza - crust) * (pizza - crust) / (pizza * pizza)) * 100;
        io.println(percent);
        io.close();
    }
}