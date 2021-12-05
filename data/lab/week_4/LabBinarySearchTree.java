public class LabBinarySearchTree<T extends Comparable<T>> extends BinarySearchTree<T> {
    public LabBinarySearchTree(){
        //Bu metodu değiştirmeyin
    }
    public LabBinarySearchTree(BTNode<T> root) {
        //Bu metodu değiştirmeyin
        super(root);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new LabBinarySearchTree(kopyala(getRoot()));
    }
    
    public BTNode<T> kopyala(BTNode<T> node){
        if(node==null)
           return null;
        BTNode<T> newnode = new BTNode<T>(node.value, null, null);
        newnode.left=kopyala(node.left);
        newnode.right=kopyala(node.right);
        return newnode;
    }

    @Override
    public BTNode<T> successor(T value) {
        BTNode<T> node = find(getRoot(),value);
        if(node==null || node.right==null)
           return null;
        node=node.right;
        while(node.left!=null)
           node=node.left;
        return node;
    }

    @Override
    public BTNode<T> predecessor(T value) {
        BTNode<T> node = find(getRoot(),value);
        if(node==null || node.left==null)
           return null;
        node=node.left;
        while(node.right!=null)
           node=node.right;
        return node;
    }

    @Override
    public BTNode<T> findParent(BTNode<T> node) {
         BTNode<T> parent= getRoot();
        if(node==parent)
            return null;
        
        while(true){
            if((node.value.compareTo(parent.value)>0) && node.value.compareTo(parent.right.value)!=0){            
                parent=parent.right;            
            }
            else if(node.value.compareTo(parent.value)<0 && node.value.compareTo(parent.left.value)!=0)
                parent=parent.left;
            else {
                System.out.println(parent.value);
                return parent;                
            }
        }
    }


}