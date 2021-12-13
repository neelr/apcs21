public class Main {
    public static void main(String[] args) {
        Queue q = convert("hello world i like pie");
        circle(q);
        System.out.println(nodeToString(q.n));
    }

    public static void enqueue(Queue q, String s) {
        Node n = q.n;
        if (n == null) {
            q.n = new Node(s, null);
            return;
        }
        while (n.next != null)
            n = n.next;
        n.next = new Node(s, null);
    }

    public static String dequeue(Queue q) {
        Node n = q.n;
        q.n = q.n.next;
        return n.data;
    }

    public static Queue convert(String s) {
        Queue q = new Queue();
        for (int i = 0; i < s.length(); i++)
            enqueue(q, s.charAt(i) + "");
        return q;
    }

    public static String nodeToString(Node h) {
        return h.next == null ? String.format("[\"%s\", null]", h.data)
                : String.format("[\"%s\", =>] %s", h.data, nodeToString(h.next));
    }

    public static void circle(Queue q) {
        enqueue(q, dequeue(q));
    }
}

class Queue {
    Node n;
}

class Node {
    public String data;
    public Node next;

    Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }
}