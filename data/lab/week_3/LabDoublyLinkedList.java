public class LabDoublyLinkedList<T> extends DoublyLinkedList<T> {
    /**
     * Çift bağlı listenin istenilen konumuna eleman ekler
     * @param index konum
     * @param value eklenecek eleman
     */
    @Override
    public void insertAt(int index, T value) {

    if(getHead()==null||index==0){
            addFirst(value);
        } else if(index==size()){
            addLast(value);
            
        } else {
        Node<T> eleman= getNode(index);
        Node<T> NewNode=new Node<>(value, eleman.next, eleman);
        eleman.next.previous=NewNode;
        eleman.next=NewNode;
        setSize(size()+1);
        }            
        
    }
    public Node<T> getNode(int index){       
        
        if(index>size())
            throw new IndexOutOfBoundsException();
        
        Node<T> p;              
            
        p= getHead();

        for(int i=1; i<index; i++){
            p=p.next;             
        }
        
        return p;
        
    }

    /**
     * Verilen konumdaki elemanı siler
     * @param index silinecek elemanın konumu
     * @return silinen değer
     */
    @Override
    public T removeAt(int index) {
         if(index==0){
            removeFirst();
        } 
        else if(index==size()-1){
            removeLast();
            
        } else {
            Node<T> removenode= getNode(index+1);

            removenode.previous.next=removenode.next;
            removenode.next.previous=removenode.previous;
            setSize(size()-1);
            return removenode.value;
            
        }    
        
        return null;
    }
       
  
    
    
    
}
