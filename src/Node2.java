/**
 * Created by Venoth on 11/22/2016.
 */
public class Node2 {

    private int data;
    private Node2 previous; // link to previous
    private Node2 next; //link to next node

    //Consturctor
    public Node2(int d){
        data =d;
        previous= null;
        next=null;
    }

    // Getters and Setters
    public Node2 getNext() {
        return next;
    }

    public void setNext(Node2 next) {
        this.next = next;
    }

    public Node2 getPrevious() {
        return previous;
    }

    public void setPrevious(Node2 previous) {
        this.previous = previous;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
