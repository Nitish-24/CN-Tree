public class TreeNodeUse {

    public static void optimisedPrintTree(TreeNode<Integer> root) {

        if (root == null) {
            return;
        }
        System.out.print(root.data + ": ");

        for (int i = 0; i < root.children.size(); i++) {
            System.out.print(root.children.get(i).data+" ");
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
        TreeNode<Integer> rooTreeNode = new TreeNode<Integer>(10);
        TreeNode<Integer> n1TreeNode = new TreeNode<Integer>(20);
        TreeNode<Integer> n2TreeNode = new TreeNode<Integer>(30);
        TreeNode<Integer> n3TreeNode = new TreeNode<Integer>(40);
        TreeNode<Integer> n4TreeNode = new TreeNode<Integer>(50);
        TreeNode<Integer> n5TreeNode = new TreeNode<Integer>(70);
        TreeNode<Integer> n6TreeNode = new TreeNode<Integer>(60);

        rooTreeNode.children.add(n1TreeNode);
        rooTreeNode.children.add(n2TreeNode);
        rooTreeNode.children.add(n3TreeNode);
        n1TreeNode.children.add(n4TreeNode);
        n2TreeNode.children.add(n6TreeNode);
        n2TreeNode.children.add(n5TreeNode);

        printTree(rooTreeNode);
        System.out.println();
        optimisedPrintTree(rooTreeNode);

    }
}
