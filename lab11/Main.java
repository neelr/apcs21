public class Main {
    public static void main(String[] args) {
        task2();
        // System.out.println("l" == "l");
        // System.out.println(nodeToString(
        // remove(new Node("h", new Node("e", new Node("l", new Node("l", new Node("o",
        // null))))), "l")));
    }

    public static String nodeToString(Node h) {
        return h.next == null ? String.format("[\"%s\", null]", h.data)
                : String.format("[\"%s\", =>] %s", h.data, nodeToString(h.next));
    }

    public static String get(Node h, int index) {
        return h.next == null ? null : (index == 0 ? h.data : get(h.next, index - 1));
    }

    public static Node add(Node h, String s) {
        if (h == null)
            return new Node(s, null);
        else if (h.next == null) {
            h.next = new Node(s, null);
        } else
            add(h.next, s);
        return h;
    }

    public static Node add(Node h, String s, int n) {
        if (h == null || n == 0)
            return new Node(s, h);
        else if (h.next == null || n == 1) {
            Node b = h.next;
            h.next = new Node(s, null);
            h.next.next = b;
        } else
            add(h.next, s, n - 1);
        return h;
    }

    public static Node remove(Node h, int index) {
        if (index == 0 || h.next == null)
            return h.next;
        else if (index == 1) {
            h.next = h.next.next;
            return h;
        } else
            remove(h.next, index - 1);
        return h;
    }

    public static void task1() {
        Node start = new Node("1", null);
        Node point = start;
        for (int i = 2; i < 101; i++) {
            point.next = new Node(String.format("%s", i), null);
            point = point.next;
        }
        for (int i = 3; i < 100; i += 3) {
            start = remove(start, i);
        }
        System.out.println(nodeToString(start));
    }

    public static void task2() {
        Node r = new Node("1", new Node("1", null));
        Node d = r.next;
        int i = 1;
        int j = 1;
        for (int x = 0; x < 20 - 2; x++) {
            d.next = new Node(i + j + "", null);
            d = d.next;
            int buf = j;
            j = i + j;
            i = buf;
        }
        System.out.println(nodeToString(r));
    }

    public static Node reverse(Node head) {
        if (head.next == null)
            return head;
        Node past = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return past;
    }

    public static Node remove(Node h, String data) {
        if (h == null)
            return null;
        Node rest = remove(h.next, data);
        h.next = rest;
        if (h.data == data)
            return rest;
        else
            return h;
    }
}

class Node {
    String data;
    Node next;

    Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }
}