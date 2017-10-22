package DataStructre;

import java.util.LinkedList;
import java.util.Stack;

public class TreeTraversal {
    private static void preTraversal(Node node) {
        Stack<Node> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {

            while (node != null) {
                System.out.println(node.value + " ");
                stack.push(node);
                node = node.leftChild;
            }

            node = stack.pop();
            node = node.rightChild;
        }
    }

    private static void midTraversal(Node node) {
        Stack<Node> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {
            stack.push(node);
            node = node.leftChild;
        }

        node = stack.pop();
        System.out.print(node.value + " ");
        node = node.rightChild;
    }

    private static void afterTraversal(Node node) {
        Stack<Node> stack = new Stack<>();
        Node lastVisit = null;

        while (node != null || !stack.isEmpty()){

            while (node != null){
                stack.push(node);
                node = node.leftChild;
            }

            node = stack.peek();
            if (node.rightChild == null || node.rightChild == lastVisit){
                System.out.print(node.value + " ");
                lastVisit = stack.pop();
                node = null;
            }else {
                node = node.rightChild;
            }
        }
    }

    private static void breadthFirstTraversal(Node node){
        LinkedList<Node> linkedList = new LinkedList<>();

        linkedList.add(node);

        while (!linkedList.isEmpty()){
            node = linkedList.poll();
            System.out.print(node.value + " ");

            if(node.leftChild != null){
                linkedList.add(node.leftChild);
            }

            if(node.rightChild != null){
                linkedList.add(node.rightChild);
            }
        }
    }
}

class Node {
    int value;
    Node leftChild;
    Node rightChild;
}


