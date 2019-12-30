import java.util.TreeMap;

class BST2 {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int nodes = io.getInt();
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
        long res = 0;
        for (int i = 0; i < nodes; i++) {
            int node = io.getInt();
            int depth = 0;
            if (tm.floorKey(node) == null && tm.ceilingKey(node) == null) {
                tm.put(node, depth);
            } else if (tm.floorKey(node) == null && tm.ceilingKey(node) != null) {
                tm.put(node, tm.get(tm.ceilingKey(node)) + 1);
                depth = tm.get(node);
            } else if (tm.floorKey(node) != null && tm.ceilingKey(node) == null) {
                tm.put(node, tm.get(tm.floorKey(node)) + 1);
                depth = tm.get(node);
            } else {
                int val = Math.max(tm.get(tm.ceilingKey(node)), tm.get(tm.floorKey(node))) + 1;
                depth = val;
                tm.put(node, depth);
            }
            res += depth;
            io.println(res);
        }
        io.close(); 
    }
}