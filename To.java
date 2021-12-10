//Arithmetic Slices
public class Solution {
    int sum = 0;
    public int numberOfArithmeticSlices(int[] A) {
        slices(A, A.length - 1);
        return sum;
    }
    public int slices(int[] A, int i) {
        if (i < 2)
            return 0;
        int ap = 0;
        if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
            ap = 1 + slices(A, i - 1);
            sum += ap;
        } else
            slices(A, i - 1);
        return ap;
    }
}

//Wildcard Matching
class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length() + 1][p.length() + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return sol(s, p, s.length(), p.length(), dp) == 1 ? true : false;
    }
    
    public int sol(String s, String p, int n, int m, int[][] dp) {
        
        if(n == 0) {
            if(m == 0) {
                return 1;
            }
            
            if(p.charAt(m - 1) == '*') {
                return dp[n][m] = sol(s, p, n, m - 1, dp);
            } else {
                return 0;
            }
        }
        
        if(m == 0) {
            return 0;
        }
        
        if(dp[n][m] != -1) {
            return dp[n][m];
        }
        if(s.charAt(n - 1) == p.charAt(m - 1) || p.charAt(m - 1) == '?') {
            return dp[n][m] = sol(s, p, n - 1, m - 1, dp);
        } else if(p.charAt(m - 1) == '*'){
            int c1 = sol(s, p, n - 1, m, dp);
            int c2 = sol(s, p, n, m - 1, dp);
            
            return dp[n][m] = Math.max(c1, c2);
        } else {
            return 0;
        }
    }
}
