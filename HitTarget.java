import java.util.ArrayList;

class HitTarget {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int t = io.getInt();
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            lst.add(new ArrayList<>());
        }
        for (int i = 0; i < t; i++) {
            String shape = io.getWord();
            if (shape.equals("rectangle")) {
                for (int j = 0; j < 4; j++) {
                    lst.get(i).add(io.getInt());
                }
            } else if (shape.equals("circle")) {
                for (int j = 0; j < 3; j++) {
                    lst.get(i).add(io.getInt());
                }
            }
        }
        int s = io.getInt();
        for (int i = 0; i < s; i++) {
            int res = 0;
            int x = io.getInt();
            int y = io.getInt();
            for (int j = 0; j < lst.size(); j++) {
                if (lst.get(j).size() == 3) {
                    int a = lst.get(j).get(0);
                    int b = lst.get(j).get(1);
                    int r = lst.get(j).get(2);
                    if (Math.sqrt(Math.pow(a - x, 2) + Math.pow(b - y, 2)) <= r) res++;
                } else {
                    int startx = lst.get(j).get(0);
                    int starty = lst.get(j).get(1);
                    int endx = lst.get(j).get(2);
                    int endy = lst.get(j).get(3);
                    if (startx <= x && x <= endx && starty <= y && y <= endy) res++;
                }
            }
            io.println(res);
        }
        io.close();
    }
}