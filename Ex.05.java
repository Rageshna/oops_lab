import java.util.*;
interface QueueADT {
    void enqueue(int data);
    void dequeue();
    void display();
}
class CircularQueue implements QueueADT {
    int[] q = new int[5];
    int front = -1, rear = -1;
    public void enqueue(int data) {
        try {
            if ((rear + 1) % 5 == front)
                throw new Exception("Queue Overflow");
            if (front == -1)
                front = 0;
            rear = (rear + 1) % 5;
            q[rear] = data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void dequeue() {
        try {
            if (front == -1)
                throw new Exception("Queue Underflow");
            System.out.println("Deleted Element: " + q[front]);
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % 5;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void display() {
        if (front == -1) {
            System.out.println("Queue Empty");
            return;
        }
        System.out.print("Queue Elements: ");
        int i = front;
        while (true) {
            System.out.print(q[i] + " ");
            if (i == rear)
                break;
            i = (i + 1) % 5;
        }
        System.out.println();
    }
}
public class QueueDemo {
    public static void main(String args[]) {
        CircularQueue obj = new CircularQueue();
        obj.enqueue(10);
        obj.enqueue(20);
        obj.enqueue(30);
        obj.display();
        obj.dequeue();
        obj.display();
    }
}
Output:
Queue Elements: 10 20 30
Deleted Element: 10
Queue Elements: 20 30
