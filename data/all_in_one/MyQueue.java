import java.util.*;

public class MyQueue<T> {
 private int front=-1;
 private int rear=-1;
 T[] dizi;

 public MyQueue() {
    dizi=(T[]) new Object[10];
 }
  public MyQueue(int boyut) {
     dizi=(T[]) new Object[boyut];
     }
public boolean isEmpty() {
    return front == -1 && rear == -1;
}
public boolean isFull() {
    return rear == dizi.length-1;
}
public void enqueue(T eleman){
    if(isFull())
     throw new RuntimeException("Queue is full");
    if(isEmpty())
     front = 0;
    dizi[++rear]=eleman;
}
public T dequeue() {
    if(isEmpty())
     throw new RuntimeException("Queue is empty");
    T donen = dizi[front++];
    if(front>rear)
     front=rear=-1;
     return donen;
}
public int count() {
    if(isEmpty())
     return 0;
    return rear-front+1;
}
public void print(){
    for(int i = front; i<= rear; i++)
    System.out.println(dizi[i]);
}

}
