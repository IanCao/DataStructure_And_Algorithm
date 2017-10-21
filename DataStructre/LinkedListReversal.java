package DataStructre;

public class LinkedListReversal {

    static class Node {
        int nodeValue;
        Node next;

        public Node(int nodeValue) {
            this.nodeValue = nodeValue;
        }
    }

    private static Node startNode;

    public static void main(String[] args) {
        Node node = createRandomLinkedList(10);
        printLinkedList(node);

        printLinkedList(node = reversalByIteration(node));
        reversalByRecursion(node);
        printLinkedList(startNode);
    }

    private static Node reversalByRecursion(Node node) {
        if (node.next == null) {
            startNode = node;
            return node;
        }
        Node temp = reversalByRecursion(node.next);
        temp.next = node;
        node.next = null;
        return node;
    }

    private static Node reversalByIteration(Node node) {
        Node currentNode = node;
        Node next = node.next;

        node.next = null;
        while (next != null) {
            Node temp = next.next;
            next.next = currentNode;
            currentNode = next;
            next = temp;
        }

        return currentNode;
    }

    private static Node createRandomLinkedList(int length) {
        Node preNode = null;
        for (int i = 0; i < length; i++) {
            Node node = new Node((int) (Math.random() * 20));
            node.next = preNode;
            preNode = node;
        }
        return preNode;
    }

    private static void printLinkedList(Node node) {
        System.out.println();
        while (node != null) {
            System.out.print(node.nodeValue + "-->");
            node = node.next;
        }
        System.out.println();
    }
}

