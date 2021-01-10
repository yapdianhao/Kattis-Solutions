class LastProblem {
    
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        String word = io.getLine();
        io.println("Thank you, " + word + ", and farewell!");
        io.close();
    }
}