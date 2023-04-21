/*
 * Group Name: "Better Call Stack"
 * Group Members: Linh Pham, Huiguang Ma, Jaya Singh and Vincent Xayasak
 * Class Section: CIS 22C 46796
 * Instructor: Mirsaeid Abolghasemi
 * Date: 4/21/23
 * 
 * The Node class, which is an essential building block for a doubly linked list 
 * data structure. The class has three instance variables (data, next, and prev), 
 * a constructor to initialize these variables, and getter and setter methods 
 * for accessing and modifying them. The class provides a basic node structure to 
 * support the creation and manipulation of doubly linked lists.
 */

public class Node {
   
    private int data;
    private Node next;
    private Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}