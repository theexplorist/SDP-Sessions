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
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return minDepthH(root);
    }
    
    public int minDepthH(TreeNode root) {
        
        if(root == null) {
            return Integer.MAX_VALUE;
        }
        
        if(root.left == null && root.right == null) {
            return 1;
        }
        
        int leftD = minDepthH(root.left);
        int rightD = minDepthH(root.right);
        
        int myAns = Math.min(leftD, rightD) + 1;
        
        return myAns;
    }
}

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        
        return sol(dungeon, 0, 0, dungeon.length - 1, dungeon[0].length - 1);
    }
    
    public int sol(int[][] dungeon, int cr, int cc, int er, int ec) {
        if(cr > er || cc > ec) {
            return Integer.MAX_VALUE;
        }
        
        if(cr == er && cc == ec) {
            return (dungeon[cr][cc] >= 0) ? 1 : Math.abs(dungeon[cr][cc]) + 1;
        }
        
        int c1 = sol(dungeon, cr + 1, cc, er, ec);
        int c2 = sol(dungeon, cr, cc + 1, er, ec);
        
        int minAns = Math.min(c1, c2);
        
        return (minAns - dungeon[cr][cc]) > 0 ?  minAns - dungeon[cr][cc] : 1;
    }
}

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        
        if(nums.length == 1) {
            return nums[0];
        }
        
        int[][] dp = new int[2][nums.length + 1];
        for(int[] row : dp)
        Arrays.fill(row, - 1);
        return rob(nums, 0, 0, dp);
    }
    
    public int rob(int[] nums, int i, int isTaken, int[][] dp) {
        
        if(i >= nums.length) {
            return 0;
        }
        
        if(dp[isTaken][i] != -1) {
            return dp[isTaken][i];
        }
        int a = 0;
        if(i == 0) {
            a = nums[i] + rob(nums, i + 2, 1, dp);
        } else if(i == nums.length - 1) {
            if(isTaken == 0)
            a = nums[i] + rob(nums, i + 2, isTaken, dp);
        } else {
            a = nums[i] + rob(nums, i + 2, isTaken, dp);
        }
        
        int b = rob(nums, i + 1, isTaken, dp);
        return dp[isTaken][i] = Math.max(a, b);
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
    public int rob(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int with = root.val;
        
        if(root.left != null) {
            with += rob(root.left.left);
            with += rob(root.left.right);
        }
        
        if(root.right != null) {
            with += rob(root.right.left);
            with += rob(root.right.right);
        }
        
        int without = rob(root.left) + rob(root.right);
        
        return Math.max(with, without);
    }
}
