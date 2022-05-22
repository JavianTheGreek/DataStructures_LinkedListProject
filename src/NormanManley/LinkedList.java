package NormanManley;

import java.util.Random;

public class LinkedList {
    // Attributes
    private Node head;
    private Node tail;

    //Default Constructor
    public LinkedList() {
        head = null;
        tail = null;
    }

    // Determine whether the list is empty or not.
    public boolean isEmpty() {
        return head == null;
    }

    // Determine whether the list is full or not.
    public boolean isFull() {
        return head != null;
    }

    // Inserts elements of data at the front of the list.
    public void insertPassengers(Travelers person, int position)
    {
        Node newNode = new Node(person);
        //Declare a temporary node for traversal
        Node temp = new Node();

        if (isEmpty())
        {
            head = tail = newNode;// points head and tail to the new node
        }
        else if(position == 1)
        {
            newNode.setNextNode(head);// points temp to next node.
            head.setPrevNode(newNode);
            head = newNode;// make head the new first node.
        }
        else
        {
            //Using a temporary node move to the node before the position needed
            temp = head;
            for(int count = 1; count < position - 1; count++)
            {
                if(temp != null)
                {
                    temp = temp.getNextNode();
                }
            }

            //If the node before is not null
            if(temp != null)
            {
                newNode.setNextNode(temp.getNextNode());
                newNode.setPrevNode(temp);
                temp.setNextNode(newNode);

                if(newNode.getNextNode() != null)
                {
                    newNode.getNextNode().setPrevNode(newNode);
                }
            }
            else
            {
                System.out.println("The node before is null.");
            }
        }
    }


    //Generate reports from the list
    public void Reports(int priority, String gender) {
        Node current = head;

        if (isFull()) {
            while (current != null) {
                if (current.getData().getPriority() == priority && current.getData().getGender().equals(gender)) {
                    System.out.println(current.getData());
                }
                //Move to the next node
                current = current.getNextNode();
            }
        } else {
            System.err.println("\n\n\t\t\tThe List is empty, there's nothing to display.");
        }
    }

    // Removes passengers from the list with a random generator.
    public void removePassenger() {
        Random random = new Random();
        // generate random number from 3 to 5
        int removal = random.nextInt(3, 6);
        int size = 0;

        if (isFull()) {
            Node checkSize = head;
            while (checkSize != null) {
                checkSize = checkSize.getNextNode();
                size++;
            }

            /*If the random number to be deleted is greater than the
            actual amount of passengers*/
            if (removal > size) {
                //change the number to the amount of passengers left
                removal = size;
                System.out.println("Random number exceeds number of passengers.");
            }

            System.out.println(removal + " passengers will be removed.");

            for (int count = 1; count <= removal; count++) {
                head = head.getNextNode();
                try {
                    head.setPrevNode(null);
                } catch (NullPointerException e) {
                    System.out.println("List is empty. Program will terminate.");
                    System.exit(0);
                }
            }
        }
    }

    // For displaying the data from the list.
    public void flightDisplay() {
        Node current = head;

        if (isFull()) {
            System.out.println("\n\t\t\t\t\t\t\t\t\tDEPARTURE INFORMATION");
            while (current != null) {
                System.out.println(current.getData());
                current = current.getNextNode();
            }
        } else {
            System.err.println("\n\n\t\t\tThe List is empty, theres nothing to display.");
        }

    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
}

