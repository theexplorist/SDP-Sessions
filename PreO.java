/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    class BalancedPair {
        TreeNode node;
        boolean isLeftDone;
        boolean isRightDone;
        boolean isSelfDone;
        
        public BalancedPair(TreeNode node) {
            this.node = node;
        }
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList();
        if(root == null) {
            return inOrder;
        }
        Stack<BalancedPair> st = new Stack();
        st.push(new BalancedPair(root));
        
       // st.push(bp);
        
        while(!st.isEmpty()) {
            BalancedPair bp = st.peek();
            if(!bp.isSelfDone) {
                inOrder.add(bp.node.val);
                System.out.print(bp.node.val +" ");
                bp.isSelfDone = true;
            } else if(!bp.isLeftDone) {
                if(bp.node.left != null) {
                    st.push(new BalancedPair(bp.node.left));
                }
                bp.isLeftDone = true;
            } else if(!bp.isRightDone) {
                if(bp.node.right != null) {
                    st.push(new BalancedPair(bp.node.right));
                }
                bp.isRightDone = true;
            } else {
                st.pop();
            }
        }
         return inOrder;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
       boolean res = sufficientSubset(root, limit, 0);
       return res == false ? null : root;
    }
    
    public boolean sufficientSubset(TreeNode root, int limit, int cSum) {
       
        if(root == null) {
            return false;
        }
        
        if(root.left == null && root.right == null) {
            if(cSum + root.val < limit) {
                return false;
            }
            return true;
        }
        boolean l = sufficientSubset(root.left, limit, cSum + root.val);
        boolean r = sufficientSubset(root.right, limit, cSum + root.val);
        
        if(!l && !r) {
            return false;
        }
        
        if(!l) {
            root.left = null;
        }
        
        if(!r) {
            root.right = null;
        }
        
        return true;
    }
}
