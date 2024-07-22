// Classic node implementation, not BST/AVL, contains all operations as native methods
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BinaryTree {
    //NODE SUBCLASS
    class Node {
        double value;
        Node left;
        Node right;
        Node(double value) {
            this.value=value;
            Node left=null;
            Node right=null;
        }
    }
    //ATTRIBUTES AND CONSTRUCTOR
    private Node root;
    BinaryTree(){
        Node tree=null;
    }

    //CONSTRUCTION AND MODIFICATION METHODS
    //insert Node
    public void insert(double value){
        Node newNode=new Node(value);
        if(root==null){
            root=newNode;
            return;
        }
        Queue <Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node current=queue.poll();
            if(current.left==null){
                current.left=newNode;
                return;
            }else{
                queue.add(current.left);
            }
            if(current.right==null){
                current.right=newNode;
                return;
            }else{
                queue.add(current.right);
            }
        }
    }
    //delete Node
    public void delete(double value){
        if(root==null) {
            return;
        }
        Node nodeToDelete=null;
        Node parentOfNodeToDelete=null;
        Node current=null;
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            current=queue.poll();
            if (current.value==value) {
                nodeToDelete=current;
                break;
            }
            parentOfNodeToDelete=current;
            if (current.left!=null) {
                queue.add(current.left);
            }
            if (current.right!=null) {
                queue.add(current.right);
            }
        }
        if (nodeToDelete==null) {
            return; // Node with the given value not found
        }
        // Replace the value of the node to delete with the value of the deepest node
        Node deepestNode = current; // The last node visited in the BFS traversal
        double deepestNodeValue=deepestNode.value;
        // Delete the deepest node
        deleteDeepest();
        // Replace the value of the node to delete with the value of the deepest node
        nodeToDelete.value = deepestNodeValue;
    }
    // Method to delete the deepest node in the tree
    private void deleteDeepest(){
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        Node previous=null;
        Node current=null;

        while (!queue.isEmpty()){
            previous=current;
            current=queue.poll();

            if(current.left==null){
                break;
            }else if(current.right==null){
                break;
            }
            if(current.left!=null){
                queue.add(current.left);
            }
            if(current.right!=null){
                queue.add(current.right);
            }
        }
        // Set the deepest node to null
        if(previous!=null) {
            if(current==previous.left){
                previous.left = null;
            }else{
                previous.right = null;
            }
        }
    }

    //clear entire tree
    public void clear() {
        root = null;
    }

    //PRINT TRAVERSAL METHODS
    //pre-order traversal
    public void preOrderTraversal() {
        preOrderTraversalRec(root);
    }
    private void preOrderTraversalRec(Node root) {
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
    private void printInOrderRec(Node root) {
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
    private void postOrderTraversalRec(Node root) {
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
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node current=queue.poll();
            System.out.print(current.value + " ");
            if(current.left!=null) {
                queue.add(current.left);
            }
            if(current.right!=null) {
                queue.add(current.right);
            }
        }
    }

    //SEARCH METHODS
    //contain
    public boolean contains(double value) {
        return containsRec(root, value);
    }
    private boolean containsRec(Node root, double value) {
        if(root==null){
            return false;
        }
        if(root.value == value){
            return true;
        }
        return containsRec(root.left, value) || containsRec(root.right, value);
    }
    //minimum value
    public double findMin() {
        if(root==null){
            throw new IllegalStateException("Tree is empty");
        }
        Node current=root;
        while(current.left!=null) {
            current=current.left;
        }
        return current.value;
    }
    //maximum value
    public double findMax() {
        if(root==null){
            throw new IllegalStateException("Tree is empty");
        }
        Node current=root;
        while(current.right!=null) {
            current=current.right;
        }
        return current.value;
    }

    //PROPERTY METHODS
    //number of nodes
    public int size(){
        return sizeRec(root);
    }
    private int sizeRec(Node root) {
        if(root==null){
            return 0;
        }
        return 1 + sizeRec(root.left) + sizeRec(root.right);
    }
    //height of tree
    public int height() {
        return heightRec(root);
    }
    private int heightRec(Node root) {
        if(root==null){
            return 0;
        }
        return 1 + Math.max(heightRec(root.left), heightRec(root.right));
    }
    //isEmpty
    public boolean isEmpty() {
        return root == null;
    }

    //VISUALIZATION METHODS
    //print tree art with values
    public void printTree() {
        int maxLevel=maxLevel(root);
        printNodeInternal(root,1,maxLevel);
    }

    //UTILITY METHODS
    private void printNodeInternal(Node root, int level, int maxLevel){
        if(root==null) {
            printWhitespaces((int) Math.pow(2,maxLevel-level+1)-1);
            System.out.print(" ");
            return;
        }
        if(level==maxLevel) {
            System.out.print(root.value);
            return;
        }

        int edgeLines=(int) Math.pow(2,(Math.max(maxLevel-level,0))-1);
        int firstSpaces=(int) Math.pow(2,maxLevel-level)-1;
        int betweenSpaces=(int) Math.pow(2,maxLevel-level+1)-1;

        printWhitespaces(firstSpaces);
        System.out.print(root.value);
        printWhitespaces(betweenSpaces);

        //print edges to children
        if (root.left != null || root.right != null) {
            System.out.println(); // Move to the next line
            printWhitespaces(firstSpaces - 1); // Adjust spacing
            if (root.left != null && root.right != null) {
                System.out.print("/ \\");
            } else if (root.left != null) {
                System.out.print("/");
            } else {
                System.out.print("\\");
            }
        }

        System.out.println();
        //print subtrees
        printNodeInternal(root.left, level+1, maxLevel);
        printNodeInternal(root.right, level+1, maxLevel);
    }
    private void printWhitespaces(int count) {
        for(int i=0;i<count;i++) {
            System.out.print(" ");
        }
    }
    private int maxLevel(Node node) {
        if(node==null) {
            return 0;
        }
        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }
}
class TestBinaryTree{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        BinaryTree Tree=new BinaryTree();
        //add all values to tree, does not sort them
        int choice=0;
        do{
            System.out.print("[TEST BINARY TREE]\n" +
                    " 1. Insert node\n" +
                    " 2. Delete Node\n" +
                    " 3. Clear Tree\n" +
                    " 4. Print Pre-Order/In-Order/Post-Order/Level (BFS) Order\n" +
                    " 5. Contains\n" +
                    " 6. Min\n" +
                    " 7. Max\n" +
                    " 8. Size/ Number of Nodes\n" +
                    " 9. Height\n" +
                    "10. Is Empty?\n" +
                    "11. Print Tree Image\n" +
                    "12. Tree Status\n" +
                    "13. Exit\n\n" +
                    "Choose an option: ");
            choice=sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Insert value: ");
                    double insert=sc.nextDouble();
                    Tree.insert(insert);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Delete value: ");
                    double delete=sc.nextDouble();
                    Tree.delete(delete);
                    System.out.println();
                    break;
                case 3:
                    Tree.clear();
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Pre-order : ");Tree.preOrderTraversal();
                    System.out.print("In-order  : ");Tree.printInOrder();
                    System.out.print("Post-order: ");Tree.postOrderTraversal();
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Target value: ");
                    double target=sc.nextDouble();
                    Tree.contains(target);
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Min value: "+Tree.findMin());
                    break;
                case 7:
                    System.out.println("Max value: "+Tree.findMax());
                    break;
                case 8:
                    System.out.println("Size: "+Tree.size());
                    break;
                case 9:
                    System.out.println("Height: "+Tree.height());
                    break;
                case 10:
                    System.out.println("Tree is Empty? "+Tree.isEmpty());
                    break;
                case 11:
                    Tree.printTree();
                    System.out.println("\n");
                    break;
                case 12:
                    System.out.println("[TREE STATUS]");
                    Tree.printTree();
                    System.out.println("\nTree is Empty? "+Tree.isEmpty());
                    System.out.println("Height: "+Tree.height());
                    System.out.println("Size: "+Tree.size());
                    System.out.println("Max value: "+Tree.findMax());
                    System.out.println("Min value: "+Tree.findMin());
                    System.out.print("Pre-order : ");Tree.preOrderTraversal();
                    System.out.print("\nIn-order  : ");Tree.printInOrder();
                    System.out.print("\nPost-order: ");Tree.postOrderTraversal();
                    System.out.println("\n");
                    break;
            }
        }while(choice!=0 && choice!=13);
    }
}