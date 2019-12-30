class BST {

    public static void main(String[] args) {
        Kattio kattio = new Kattio(System.in);
        int nodes = kattio.getInt();
        BinaryTree bst = new BinaryTree();
        for (int i = 0; i < nodes; i++) {
            kattio.println(true);
            //bst.insert(kattio.getInt());
            //break;
        }
        kattio.println(bst.size());
        kattio.close();
    }

    static class BinaryTree {

        Node root;

        public BinaryTree() {
            this.root = null;
        }

        public void insert(int n) {
            Node newNode = new Node(n);
            if (root == null) {
                root = newNode;
                return;
            } else {
                Node current = root;
                while (true) {
                    if (n < current.data && current.left == null) {
                        current.left = newNode;
                        return;
                    } else if (n > current.data && current.right == null) {
                        current.right = newNode;
                        return;
                    } else if (n < current.data && current.left != null) {
                        current.left = current;
                    } else if (n > current.data && current.right != null) {
                        current.right = current;
                    }
                }
            }
        }

        public int height() {
            return height(root);
        }

        public int height(Node node) {
            if (node == null) {
                return 0;
            } else {
                int heightLeft = height(node.left);
                int heightRight = height(node.right);
                return heightLeft > heightRight ? heightLeft : heightRight;
            }
        }

        public int size() {
            return size(root);
        }

        public int size(Node node) {
            if (node == null) {
                return 0;
            } else {
                return size(node.left) + size(node.right) + 1;
            }
        }

    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int n) {
            this.data = n;
        }
    }
}