class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) {
            return null;
        }
        
        if(root.val == p.val || root.val == q.val) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null) {
            return root;
        }
        
        if(left == null) {
            return right;
        }
        
        return left;
    }
}

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node temp = p;
        Node root = getRoot(temp);
        
        return lowestCommonAncestor(root, p, q);
    }
    
    public Node getRoot(Node p) {
        while(p.parent != null) {
            p = p.parent;
        }
        
        return p;
    }
    
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        
        if(root == null) {
            return null;
        }
        
        if(root.val == p.val || root.val == q.val) {
            return root;
        }
        
        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null) {
            return root;
        }
        
        if(left == null) {
            return right;
        }
        
        return left;
    }
}
