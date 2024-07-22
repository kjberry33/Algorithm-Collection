//Binary Search Tree (BST)
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BST {
    Node root;
    public class Node{
        int value;
        Node left, right;
        Node(int value){
            this.value=value;
            left=right=null;
        }
    }
    BST(){
        root=null;
    }
    void insert(int value){

    }
    public void preOrderTraversal() {
        preOrderTraversalRec(root);
    }
    private void preOrderTraversalRec(BST.Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrderTraversalRec(root.left);
            preOrderTraversalRec(root.right);
        }
    }
    //in-order traversal
    public void printInOrder() {
        printInOrderRec(root);
    }
    private void printInOrderRec(BST.Node root) {
        if (root != null) {
            printInOrderRec(root.left);
            System.out.print(root.value + " ");
            printInOrderRec(root.right);
        }
    }
    // post-order traversal
    public void postOrderTraversal() {
        postOrderTraversalRec(root);
    }
    private void postOrderTraversalRec(BST.Node root) {
        if (root!=null) {
            postOrderTraversalRec(root.left);
            postOrderTraversalRec(root.right);
            System.out.print(root.value + " ");
        }
    }
    //BFS-level order traversal
    public void bFSTraversal() {
        if(root == null) {
            return;
        }
        Queue<BST.Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            BST.Node current=queue.poll();
            System.out.print(current.value + " ");
            if(current.left!=null) {
                queue.add(current.left);
            }
            if(current.right!=null) {
                queue.add(current.right);
            }
        }
    }

}

class TestBST{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        BST Tree=new BST();
        Tree.insert(25);


    }

}
