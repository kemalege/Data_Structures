public class LinkedList<T> {
    private Node<T> head;// Başlangıç düğümü

    public LinkedList() {
    }// Yapıcı metod

    public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }// Tüm listeyi yazdır

    public Node<T> getHead() {
        return head;
    }// Ilk düğümü verir

    public void addFirst(T value) {
        Node<T> newNode = new Node<T>(value, head);
        head = newNode;
    }// Listenin ba¸sına ekler

    public void addLast(T value) {
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<>(value, null);
    }// Listenin sonuna ekler

    public void add(int index, T value) {
        Node<T> current = head;
        int currentLocation = 0;
        while (current != null && currentLocation < index) {
            current = current.next;
            currentLocation++;
        }
        if (currentLocation != index)
            throw new IndexOutOfBoundsException("Listede yeterli eleman yok");
        insertAfter(current,value);
    }// Verilen konumdan sonra ekler

    public void insertAfter(Node<T> node, T value) {

        Node<T> newNode = new Node<>(value, node.next);
        node.next = newNode;

    }// Verilen dugumden sonra ekler
    
    public T removeAfter(Node<T> node) {
        return null;
    }// Verilen d¨u˘g¨umden sonrakini

    public T removeAt(int index) {
        return null;
    }// Verilen konumdaki düğümü siler

    public T removeFirst() {
        Node<T> toDelete = head;
        head = head.next;
        return toDelete.value;
    }// Listenin başını siler

    public T removeLast() {
        Node<T> current = head;
        Node<T> previous = null;
        T r;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        if (previous != null) {
            r = previous.next.value;
            previous.next = null;
        } else {
            r = head.value;
            head = null;
        }
        return r;

    }// Listenin sonunu siler

}
