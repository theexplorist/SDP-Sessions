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
************************************************************************

//BS1
class Solution {
    public int maxProfit(int[] prices) {
        
        int[][] dp = new int[prices.length + 1][2];
        
        for(int i = 0; i <= prices.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return sol(prices, 0, 1, 1, dp);
    }
    
    public int sol(int[] prices, int curr, int buy, int k, int[][] dp) {
        
        if(curr == prices.length || k == 0) {
            return 0;
        }
        
        if(dp[curr][buy] != -1) {
            return dp[curr][buy];
        }
        if(buy == 1) {
            int inc = sol(prices, curr + 1, 0, k, dp) - prices[curr];
            int exc = sol(prices, curr + 1, buy, k, dp);
            
            return dp[curr][buy] = Math.max(inc, exc);
        } else {
            int inc = sol(prices, curr + 1, buy, k - 1, dp) + prices[curr];
            int exc = sol(prices, curr + 1, buy, k, dp);
            
            return dp[curr][buy] = Math.max(inc, exc);
        }
    }
}

********************************************************************

//BS2

class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        
        for(int i = 0; i <= prices.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        
        return sol(prices, 0, 1, dp);
    }
    
    public int sol(int[] prices, int curr, int buy, int[][] dp) {
        
        if(curr == prices.length) {
            return 0;
        }
        
        if(dp[curr][buy] != -1) {
            return dp[curr][buy];
        }
        if(buy == 1) {
            int inc = sol(prices, curr + 1, 0, dp) - prices[curr];
            int exc = sol(prices, curr + 1, buy, dp);
            
            return dp[curr][buy] = Math.max(inc, exc);
        } else {
            int inc = sol(prices, curr + 1, 1, dp) + prices[curr];
            int exc = sol(prices, curr + 1, buy, dp);
            
            return dp[curr][buy] = Math.max(inc, exc);
        }
    }
}

//BS3

class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][3];
        
        for(int i = 0; i <= prices.length; i++) {
            dp[i][0][0] = -1;
            dp[i][0][1] = -1;
            dp[i][0][2] = -1;
            dp[i][1][0] = -1;
            dp[i][1][1] = -1;
            dp[i][1][2] = -1;
        }
        return sol(prices, 0, 1, dp, 0);
    }
    
    public int sol(int[] prices, int curr, int buy, int[][][] dp, int t) {
        
        if(curr == prices.length || t >= 2) {
            return 0;
        }
        
        if(dp[curr][buy][t] != -1) {
            return dp[curr][buy][t];
        }
        if(buy == 1) {
            int inc = sol(prices, curr + 1, 0, dp, t) - prices[curr];
            int exc = sol(prices, curr + 1, buy, dp, t);
            
            return dp[curr][buy][t] = Math.max(inc, exc);
        } else {
            int inc = sol(prices, curr + 1, 1, dp, t + 1) + prices[curr];
            int exc = sol(prices, curr + 1, buy, dp, t);
            
            return dp[curr][buy][t] = Math.max(inc, exc);
        }
    }
}

//BS4

class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] memo = new int[prices.length][2][k + 1];

        for (int r = 0; r < memo.length; r++) {
            for (int c = 0; c < memo[r].length; c++) {
                Arrays.fill(memo[r][c], -1);
            }
        }

        return sol(prices, 0, 1, memo, 0, k);
    }

   public int sol(int[] prices, int curr, int buy, int[][][] dp, int t, int k) {
        
        if(curr == prices.length || t >= k) {
            return 0;
        }
        
        if(dp[curr][buy][t] != -1) {
            return dp[curr][buy][t];
        }
        if(buy == 1) {
            int inc = sol(prices, curr + 1, 0, dp, t, k) - prices[curr];
            int exc = sol(prices, curr + 1, buy, dp, t, k);
            
            return dp[curr][buy][t] = Math.max(inc, exc);
        } else {
            int inc = sol(prices, curr + 1, 1, dp, t + 1, k) + prices[curr];
            int exc = sol(prices, curr + 1, buy, dp, t, k);
            
            return dp[curr][buy][t] = Math.max(inc, exc);
        }
   }
}

//BS5

class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        
        for(int i = 0; i <= prices.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        
        return sol(prices, 0, 1, dp);
    }
    
    public int sol(int[] prices, int curr, int buy, int[][] dp) {
        
        if(curr >= prices.length) {
            return 0;
        }
        
        if(dp[curr][buy] != -1) {
            return dp[curr][buy];
        }
        if(buy == 1) {
            int inc = sol(prices, curr + 1, 0, dp) - prices[curr];
            int exc = sol(prices, curr + 1, buy, dp);
            
            return dp[curr][buy] = Math.max(inc, exc);
        } else {
            int inc = sol(prices, curr + 2, 1, dp) + prices[curr];
            int exc = sol(prices, curr + 1, buy, dp);
            
            return dp[curr][buy] = Math.max(inc, exc);
        }
    }
}

//Knight Dialer

class Solution {
    
    int[] dx = {-1, 1, -2, 2, -2, 2, -1, 1};
    int[] dy = {-2, -2, -1, -1, 1, 1, 2, 2};
    public int knightDialer(int n) {
        
        int[][][] dp = new int[n + 1][4][3];
        
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < 4; j++) {
                for(int k = 0; k < 3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        int ans = 0;
        for(int r = 0; r < 4; r++) {
            for(int c = 0; c < 3; c++) {
                if((r == 3 &&  c == 0) || (r == 3 && c == 2)) {
                    
                } else {
                    ans =  (ans + knightDialerR(n - 1, r, c, dp)) % 1000000007;
                }
            }
        }
        
        return ans;
    }
    
    public int knightDialerR(int n, int r, int c, int[][][] dp) {
        
        if(r < 0 || c < 0 || r > 3 || c > 2 || (r == 3 &&  c == 0) || (r == 3 && c == 2)) {
            return 0;
        }
        if(n == 0) {
            return 1;
        }
        
        if(dp[n][r][c] != -1) {
            return dp[n][r][c];
        }
        int ct = 0;
        for(int i = 0; i < 8; i++) {
            ct = (ct + knightDialerR(n - 1, r + dx[i], c + dy[i], dp)) % 1000000007;
        }
        
        return dp[n][r][c] = (ct % 1000000007);
    }
}
