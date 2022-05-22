package NormanManley;

public class Node {
    // Attributes
    private Travelers Data;
    private Node nextNode;
    private Node prevNode;

    //Default Constructor
    public Node() {
        Data = new Travelers();
        nextNode = null;
        prevNode = null;
    }

    //Default Constructor
    public Node(Travelers data, Node nextNode, Node prevNode) {
        this.Data = data;
        this.nextNode = nextNode;
        this.prevNode = prevNode;
    }

    //Copy Constructor
    public Node(Node n) {
        this.Data = n.Data;
        this.nextNode = n.nextNode;
        this.prevNode = n.prevNode;
    }

    // Constructor
    public Node(Travelers data) {
        this.Data = data;
        this.nextNode = null;
        this.prevNode = null;
    }

    // Getters and Setters
    public Travelers getData() {
        return Data;
    }

    public void setData(Travelers data) {
        Data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    // Tostring method
    @Override
    public String toString() {
        return Data.toString();
    }
}
