public abstract class BinarySearchTree<T extends Comparable<T>> {
    private BTNode<T> root;

    public BinarySearchTree(BTNode<T> root) {
        this.root = root;
    }

    public BinarySearchTree() {
    }

    public BTNode<T> getRoot() {
        return root;
    }

    public BTNode<T> find(BTNode<T> node, T value) {
        if (node == null || node.value == value)
            return node;
        else if (value.compareTo(node.value) < 0)
            return find(node.left, value);
        else
            return find(node.right, value);
    }

    public boolean contains(T value) {
        return find(root, value) != null; 
    }

    public void add(T value) {
        add(root, value);
    }

    private void add(BTNode<T> node, T value) {
        if (root == null) {
            root = new BTNode<>(value, null, null);
            return;
        }
        if (value.compareTo(node.value) < 0) {
            if (node.left == null)
                node.left = new BTNode<>(value, null, null);
            else
                add(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            if (node.right == null)
                node.right = new BTNode<>(value, null, null);
            else
                add(node.right, value);
        } else
            throw new RuntimeException("Eleman ağaçta mevcut!");
    }

    public BTNode<T> kopyala(BTNode<T> node) {
        if (node == null)
            return null;
        BTNode<T> newnode = new BTNode<T>(node.value, null, null);
        newnode.left = kopyala(node.left);
        newnode.right = kopyala(node.right);
        return newnode;
    }

    public BTNode<T> successor(T value) {
        BTNode<T> node = find(getRoot(), value);
        if (node == null || node.right == null)
            return null;
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public BTNode<T> predecessor(T value) {
        BTNode<T> node = find(getRoot(), value);
        if (node == null || node.left == null)
            return null;
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public BTNode<T> findParent(BTNode<T> node) {
        BTNode<T> parent = getRoot();
        if (node == parent)
            return null;
        while (true) {
            if ((node.value.compareTo(parent.value) > 0) && node.value.compareTo(parent.right.value) != 0) {
                parent = parent.right;
            } else if (node.value.compareTo(parent.value) < 0 && node.value.compareTo(parent.left.value) != 0)
                parent = parent.left;
            else {
                System.out.println(parent.value);
                return parent;
            }
        }

    }
    public BTNode<T> findParent2(BTNode<T> node){
        BTNode<T> parent = getRoot();
        if(node == parent)
            return null;
        while(true){
            if(node.value.compareTo(parent.value)>0 && node.value.compareTo(parent.right.value)!=0){
                parent = parent.right;
            }
            else if(node.value.compareTo(parent.value)<0 && node.value.compareTo(parent.left.value) != 0)
                parent = parent.left;
            else{
                System.out.println(parent.value);
                return parent;
            }
        }   
    }
    @Override
    protected abstract Object clone() throws CloneNotSupportedException;
}
