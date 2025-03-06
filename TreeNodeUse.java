import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class TreeNodeUse {

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
		if (root ==null) {
            return null;
        }
        TreeNode<Integer> nodeMaxNode = root;
        int maxsum = clacSum(root);
        
               
                Queue<TreeNode<Integer>> queue = new LinkedList<>();
                queue.add(root);
        
                while (!queue.isEmpty()) {
                    TreeNode<Integer> currentNode = queue.poll();
        
                    int currentSum = clacSum(currentNode);
        
                    
                    if (currentSum > maxsum) {
                        maxsum = currentSum;
                        nodeMaxNode = currentNode;
                    }
        
                    queue.addAll(currentNode.children);
                }
        
                return nodeMaxNode;
            }
            
        
            private static int clacSum(TreeNode<Integer> root) {
                if (root == null) {
                    return 0;
                }
                int sum = root.data; 
                for (TreeNode<Integer> child : root.children) {
                    sum += child.data; 
                }
                return sum;
            }
        
        
            public static void printPostOrder(TreeNode<Integer> root){
		if (root==null) {
            return;
        }

        Stack<Integer>stack = new Stack<>();
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<Integer> currNode = queue.poll();
             stack.push(currNode.data);
            for (int i = currNode.children.size()-1; i >=0; i--) {
                queue.add(currNode.children.get(i));
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
	}


    public static int getHeight(TreeNode<Integer> root) {
        int height = 0;
        if (root == null) {
            return -1;
        }

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int childSize = queue.size();
            height++;

            for (int i = 0; i < childSize; i++) {
                TreeNode<Integer> front = queue.poll();

                for (int j = 0; j < front.children.size(); j++) {
                    queue.add(front.children.get(j));
                }
            }

        }
        return height;
    }

    public static int numNodeGreater(TreeNode<Integer> root, int x) {

        if (root == null) {
            return -1;
        }
        int count = 0;
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<Integer> front = queue.poll();
            if (front.data > x) {
                count++;
            }
            if (front.children.size() > 0) {
                for (int i = 0; i < front.children.size(); i++) {
                    queue.add(front.children.get(i));
                }
            }
        }
        return count;
    }

    @SuppressWarnings("resource")
    public static TreeNode<Integer> takeInput() {
        Scanner scn = new Scanner(System.in);
        Queue<TreeNode<Integer>> pendingQueue = new LinkedList<>();
        System.out.println("Enter root data:");
        int rootData = scn.nextInt();
        if (rootData == -1) {
            return null;
        }
        TreeNode<Integer> root = new TreeNode<Integer>(rootData);
        pendingQueue.add(root);
        while (!pendingQueue.isEmpty()) {
            TreeNode<Integer> frontNode = pendingQueue.poll();
            System.out.println("Enter number of child of " + frontNode.data);
            int child = scn.nextInt();
            for (int i = 0; i < child; i++) {
                System.out.println("Enter" + i + " child data ");
                int childData = scn.nextInt();
                TreeNode<Integer> chilNode = new TreeNode<Integer>(childData);
                frontNode.children.add(chilNode);
                pendingQueue.add(chilNode);
            }
        }
        scn.close();
        return root;
    }

    public static int NodeCount(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int count = 1;

        for (int i = 0; i < root.children.size(); i++) {
            int childCount = NodeCount(root.children.get(i));
            count += childCount;

        }
        return count;
    }

    public static void optimisedPrintTree(TreeNode<Integer> root) {

        if (root == null) {
            return;
        }
        System.out.print(root.data + ": ");

        for (int i = 0; i < root.children.size(); i++) {
            System.out.print(root.children.get(i).data + " ");
        }
        System.out.println();
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> childNode = root.children.get(i);
            optimisedPrintTree(childNode);
        }
    }

    public static void printTree(TreeNode<Integer> root) {

        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> childNode = root.children.get(i);
            printTree(childNode);
        }
    }

    public static void main(String[] args) {
        // TreeNode<Integer> rooTreeNode = new TreeNode<Integer>(10);
        // TreeNode<Integer> n1TreeNode = new TreeNode<Integer>(20);
        // TreeNode<Integer> n2TreeNode = new TreeNode<Integer>(30);
        // TreeNode<Integer> n3TreeNode = new TreeNode<Integer>(40);
        // TreeNode<Integer> n4TreeNode = new TreeNode<Integer>(50);
        // TreeNode<Integer> n5TreeNode = new TreeNode<Integer>(70);
        // TreeNode<Integer> n6TreeNode = new TreeNode<Integer>(60);

        // rooTreeNode.children.add(n1TreeNode);
        // rooTreeNode.children.add(n2TreeNode);
        // rooTreeNode.children.add(n3TreeNode);
        // n1TreeNode.children.add(n4TreeNode);
        // n2TreeNode.children.add(n6TreeNode);
        // n2TreeNode.children.add(n5TreeNode);

        // printTree(rooTreeNode);
        // System.out.println();
        // System.out.println(NodeCount(rooTreeNode));
        TreeNode<Integer> result = takeInput();
        optimisedPrintTree(result);
    }
}
