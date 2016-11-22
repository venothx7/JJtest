/**
 * Created by Venoth on 11/22/2016.
 */
public class LinkedList2 {
    Node2 head;
    Node2 tail;

    // CONSTRUCTORS
    public LinkedList2(Node2 nn) {
        head = nn;
        tail = nn;
    }

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public Node2 insert(int d) {

        Node2 temp = new Node2(d); // creates a new doubly node

        //If list is empty
        if (head == null) { // if list is empty
            head = temp;
            tail = temp;
        } else {
            //insert new node at the start of list
            if (temp.getData() <= head.getData()) {
                temp.setNext(head); // point the old node as head
                head.setPrevious(temp); // point the head prev as null
                head = temp; //set head as temp
            } else {
                Node2 prev = head; //sets the 1st element of list
                Node2 cur = head.getNext(); //gets the 2nd element of list

                //travese thru the list
                while (cur.getNext() != null) {
                    if (temp.getData() <= cur.getData()) {
                        temp.setNext(cur);
                        temp.setPrevious(cur.getPrevious());
                        cur.getPrevious().setNext(temp);
                        cur.setPrevious(temp);

                        break;
                    } else {
                        //go to the next node
                        cur = cur.getNext();
                    }
                }

                if (cur == tail) {
                    // add before tail
                    if (temp.getData() <= temp.getData()) {
                        temp.setNext(cur);
                        temp.setPrevious(cur.getPrevious());
                        cur.getPrevious().setNext(temp);
                        cur.setPrevious(temp);
                    } else {
                        // add after current tail (becomes new tail)

                        cur.setNext(temp);
                        temp.setPrevious(cur);
                        tail = temp;
                    }
                }
            }
        }
        return temp;
    }


}

