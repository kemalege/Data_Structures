import java.util.Iterator;

public abstract class DoublyLinkedList<T> implements Iterable<T> {
    /**
     * Node sınıfı, inner
     * 
     * @param <T> Generic değer
     */
    public class Node<T> {
        public T value;
        public Node<T> next;
        public Node<T> previous;

        public Node(T value, Node<T> next, Node<T> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T value) {
        Node<T> node = new Node(value, head, null);
        if (head != null)
            head.previous = node;
        head = node;
        if (tail == null)
            tail = node;
        size++;
    }

    public void addLast(T value) {
        Node<T> node = new Node(value, null, tail);
        if (tail != null)
            tail.next = node;
        tail = node;
        if (head == null)
            head = node;
        size++;
    }

    public T removeFirst() {
        Node<T> node = head;
        head = head.next;
        head.previous = null;
        size--;
        return node.value;
    }

    public T removeLast() {
        Node<T> node = tail;
        tail = tail.previous;
        tail.next = null;
        size--;
        return node.value;
    }

    public void print() {
        Node<T> node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public void reversePrint() {
        Node<T> node = tail;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.previous;
        }
        System.out.println();
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    @Override
    public Iterator<T> iterator() {
        // Interface gerçekleştiren nesne oluşturma
        Iterator<T> iterator = new Iterator<T>() {
            private Node<T> node = head;

            @Override
            public boolean hasNext() { // Sonraki değer var mı
                return node != null;
            }

            @Override
            public T next() { // Sonraki değeri döndür
                T rval = node.value;
                node = node.next; // iterator'u ilerlet
                return rval;
            }
        };
        return iterator;
    }

    @Override
    public String toString() {
        if (size == 0)
            return "";
        String r = "";
        for (T val : this)
            r += val + ", ";
        r = r.substring(0, r.length() - 2);
        return r;
    }

    public void setSize(int size) {// size değerini değiştirmek için...
        this.size = size;
    }

    public void insertAt(int index, T value) {
        if (getHead() == null || index == 0) {
            addFirst(value);
        } else if (index == size()) {
            addLast(value);
        } else {
            Node<T> eleman = getNode(index);
            Node<T> NewNode = new Node<T>(value, eleman.next, eleman.next);
            eleman.next.previous = NewNode;
            eleman.next = NewNode;
            setSize(size() + 1);
        }
    }
    public void insertAt2(int index, T value){
        if(index==0)
            addFirst(value);
        else if(index==size())
            addLast(value);
        else {
            int i = 0;
            Node<T> current= getHead();
            while(i<index-1 && current != null){
                i++;
                current=current.next;
            }
            Node<T> yeni = new Node<>(value,current.next,current);
            current.next.previous = yeni;
            current.next=yeni;
            setSize(size()+1);

        }

    }
    public T removeAt2(int index) {
        if (index == 0) {
            removeFirst();
        } else if (index == size()) {
            removeLast();
        } else {
            int i = 0;
            Node<T> current= getHead();
            while(i<index && current != null){
                i++;
                current=current.next;
            }
            current.next.previous = current.next;
            current.previous.next = current.previous.next;
            setSize(size() - 1);
            return current.value;
        }
        return null;    
    }
    public T removeAt(int index) {
        if (index == 0) {
            removeFirst();
        } else if (index == size()) {
            removeLast();
        } else {
            Node<T> removenode = getNode(index + 1);
            removenode.next.previous = removenode.next;
            removenode.previous.next = removenode.previous.next;
            setSize(size() - 1);
            return removenode.value;
        }
        return null;    
    }

    public Node<T> getNode(int index) {
        if (index > size())
            throw new IndexOutOfBoundsException();

        Node<T> p;
        p = getHead();

        for (int i = 1; i < index; i++) {
            p = p.next;
        }
        return p;
    }
    
}