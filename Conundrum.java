class Conundrum {

    public static void main(String[] kattis) {
        Kattio io = new Kattio(System.in);
        char[] arr = io.getWord().toCharArray();
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((i + 1) % 3 == 2) {
                if (arr[i] != 'E') c++;
            }
            else if ((i + 1) % 3 == 0) {
                if (arr[i] != 'R') c++;
            } else if ((i + 1) % 3 == 1) {
                if (arr[i] != 'P') c++;
            }
        }
        io.println(c);
        io.close();
    }
}