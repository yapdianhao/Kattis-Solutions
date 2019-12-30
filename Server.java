class Server {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int tasks = io.getInt();
        int time = io.getInt();
        int temp = 0;
        for (int i = 0; i < tasks; i++) {
            int task = io.getInt();
            if (task + temp <= time) {
                temp += task;
                /*if (temp == time) {
                    io.println(i + 1);
                }*/
            } else {
                io.println(i);
                io.close();
                return;
            }
        }
        io.println(tasks);
        io.close();
    }
}