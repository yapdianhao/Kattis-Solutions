import java.math.BigInteger;

class Insert {

    static Kattio io = new Kattio(System.in);

    static BigInteger factorial(int n) {
        if (n <= 1) return new BigInteger("1");
        else return new BigInteger(n + "").multiply(factorial(n - 1));
    }

    static BigInteger nCr(int n, int r) {
        BigInteger num = factorial(n);
        BigInteger den1 = factorial(r);
        BigInteger den2 = factorial(n - r);
        return num.divide(den1.multiply(den2));
    }

    static class Node {
        int key;
        Node left = null;
        Node right = null;
        int size;

        public Node(int key) {
            this.key = key;
            this.size = 1;
        }

        public String toString() {
            return "" + this.size;
        }
    }

    static void printTree(Node bst) {
        if (bst == null) return;
        io.println(bst);
        printTree(bst.left);
        //io.println(bst);
        printTree(bst.right);
    }

    static Node insert(Node curr, int n) {
        if (curr == null) {
            return new Node(n);
        }
        else if (n < curr.key) {
            //curr.size++;
            curr.left = insert(curr.left, n);
        } else if (n >= curr.key) {
            //curr.size++;
            curr.right = insert(curr.right, n);
        }
        curr.size++;
        return curr;
    }


    static BigInteger solve(Node bst) {
        if (bst == null) return new BigInteger("1");
        BigInteger bg = new BigInteger("1");
        if (bst.left != null && bst.right != null) {
            bg = bg.multiply(nCr(bst.left.size + bst.right.size, bst.right.size));
            //io.println(bg + ", " + bst.key + ", " + (nCr(30, 15)));
        }
        //io.println(bg + " 1 " + bst);
        bg = bg.multiply(solve(bst.left));
        //io.println(bg + " 2 " + bst);
        bg = bg.multiply(solve(bst.right));
        //io.println(bg + " 3 " + bst);
        return bg;
    }

    public static void main(String[] args) {

        int nodes = io.getInt();
        while (nodes != 0) {
            //BST bst = new BST();
            Node bst = null;
            //BigInteger bg = new BigInteger("1");
            for (int i = 0; i < nodes; i++) {
                bst = insert(bst, io.getInt());
            }
            io.println(solve(bst));
            //printTree(bst);
            nodes = io.getInt();
        }
        io.close();
    }
}