class Inverse {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        double[] arr = new double[1000001];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.log10(i) + arr[i - 1];
        }
        arr[0] = arr[1] = 1;
        double n = io.getDouble();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == Math.log10(n)) {
                io.println(i);
                break;
            }
        }
        //io.println(arr[4]);
        //io.println(Math.log(24));
        io.close();
    }
}