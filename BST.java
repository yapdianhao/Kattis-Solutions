class BST {

    public static void main(String[] args) {
        Kattio kattio = new Kattio(System.in);
        int nodes = kattio.getInt();
        int count = 0;
        BinaryTree bst = new BinaryTree();
        for (int i = 0; i < nodes; i++) {
            count += bst.insert(kattio.getInt());
            kattio.println(count);
        }
        kattio.close();
    }

    static class BinaryTree {

        Node root;

        public BinaryTree() {
            this.root = null;
        }

        public int insert(int n) {
            int times = 0;
            Node newNode = new Node(n);
            if (root == null) {
                root = newNode;
                return times;
            } else {
                Node current = root;
                while (true) {
                    if (n < current.data && current.left == null) {
                        current.left = newNode;
                        times++;
                        break;
                    } else if (n > current.data && current.right == null) {
                        current.right = newNode;
                        times++;
                        break;
                    } else if (n < current.data) {
                        current = current.left;
                        times++;
                    } else if (n > current.data) {
                        current = current.right;
                        times++;
                    }
                }
                return times;
                /*
                Node current = root;
                Node parent = null;
                while (true) {
                    parent = current;
                    if (n < current.data) {
                        current = current.left;
                        if (current == null) {
                            parent.left = newNode;
                            return;
                        } 
                    } else {
                        current = current.right;
                        if (current == null) {
                            parent.right = newNode;
                            return;
                        }
                    }
                }*/
            }
        }

        /*public int height() {
            return height(root);
        }

        public int height(Node node) {
            if (node == null) {
                return 0;
            } else {
                int heightLeft = height(node.left) + 1;
                int heightRight = height(node.right) + 1;
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
        }*/
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