import java.util.Arrays;
import java.util.Scanner;

public class TillingProblem1 {


	private static int sol(int n, int[] dp) {
		// TODO Auto-generated method stub

		if(n == 1 || n == 2) {
			return n;
		}
		
		if(dp[n] != -1) {
			return dp[n];
		}
		int c1 = sol(n - 1, dp);
		int c2 = sol(n - 2, dp);
		
		return dp[n] = c1 + c2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		System.out.println(sol(n, dp));
	}

}

class Solution {
    public int minFallingPathSum(int[][] grid) {
        //return minFallingPathSum(grid, 0, 0
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] cache = new int[m][n];
        for(int[] row : cache) {
            Arrays.fill(row, -1);
        }
        
        int ans = Integer.MAX_VALUE;
        for(int cc = 0; cc < n; cc++) {
            int an = minFallingPathSum(grid, 0, cc, cache);
            ans = Math.min(ans, an);
        }
        return ans;
    }
    
    public int minFallingPathSum(int[][] grid, int cr, int cc, int[][] cache) {
        
        if(cr >= grid.length || cc > grid.length) {
            return Integer.MAX_VALUE;
        }
        
        if(cr == grid.length - 1) {
            return grid[cr][cc];
        }
        
        if(cache[cr][cc] != -1) {
            return cache[cr][cc];
        }
        
        int ans = Integer.MAX_VALUE;
        for(int col = 0; col < grid.length; col++) {
            
            if(cc != col) {
                ans = Math.min(ans, minFallingPathSum(grid, cr + 1, col, cache));
            }
        }
        
        return cache[cr][cc] = ans + grid[cr][cc];
    } 
}

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] cache = new int[m][n];
        for(int[] row : cache) {
            Arrays.fill(row, -1);
        }
        
        int ans = Integer.MAX_VALUE;
        for(int cc = 0; cc < n; cc++) {
            int an = sol(grid, 0, cc, m - 1, n - 1, cache);
            ans = Math.min(ans, an);
        }
        return ans;
    }
    
    private static int sol(int[][] cost, int cr, int cc, int er, int ec, int[][] cache) {
		// TODO Auto-generated method stub

		if(cr > er || cc > ec || cc < 0) {
			return Integer.MAX_VALUE;
		}
		if(cr == er) {
			return cost[cr][cc];
		}
        
        if(cache[cr][cc] != -1) {
            return cache[cr][cc];
        }
		int c1 = sol(cost, cr + 1, cc - 1, er, ec, cache);
		int c2 = sol(cost, cr + 1, cc, er, ec, cache);
		int c3 = sol(cost, cr + 1, cc + 1, er, ec, cache);
		return cache[cr][cc] = Math.min(c1, Math.min(c2, c3)) + cost[cr][cc];
	}
}

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);
        int c1 = minCostClimbingStairsR(cost, 0, dp);
        System.out.println(Arrays.toString(dp));
        Arrays.fill(dp, -1);
        System.out.println(Arrays.toString(dp));
        int c2 = minCostClimbingStairsR(cost, 1, dp);
        
        return Math.min(c1, c2);
    }
    
    public int minCostClimbingStairsR(int[] cost, int ci, int[] dp) {
        
        if(ci >= cost.length) {
            return 0;
        }
        
        if(ci == cost.length - 1) {
            return cost[ci];
        }
        
        if(dp[ci] != -1) {
            return dp[ci];
        }
        int l = minCostClimbingStairsR(cost, ci + 1, dp);
        int r = minCostClimbingStairsR(cost, ci + 2, dp);
        
        return dp[ci] = Math.min(l, r) + cost[ci];
    }
}
