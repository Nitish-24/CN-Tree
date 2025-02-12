import java.util.LinkedList;
import java.util.Queue;

public class TreeLevelWise {

    

    public static void printLevelWise(TreeNode<Integer> root) {

        if (root==null) {
            return;
        }
        Queue<TreeNode<Integer>> pendingIntegers = new LinkedList<>();
        pendingIntegers.add(root);
        while (!pendingIntegers.isEmpty()) {
            int printSize = pendingIntegers.size();
             for (int i = 0; i < printSize; i++) {
                 TreeNode<Integer> front = pendingIntegers.poll();
                 System.out.print(front.data+" ");
                
                 if (front.children.size()>0) {  
                    for(int j =0 ; j<front.children.size();j++){
                    pendingIntegers.add(front.children.get(j));
                    }
                 }
             }
             System.out.println();
        }

    }

    public static void main(String[] args) {
        TreeNode<Integer> root = TreeNodeUse.takeInput();

        printLevelWise(root);
    }
}
