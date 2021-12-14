class Solution {
    static int sum = 0;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        sumNumbers(root, 0);
        return sum;
    }
    
    public void sumNumbers(TreeNode root, int ans) {
        
        if(root == null) {
            return;
        }
        
        if(root.left == null && root.right == null) {
            sum = sum + ans * 10 + root.val;
            return;
        }
        sumNumbers(root.left, ans * 10 + root.val);
        sumNumbers(root.right, ans * 10 + root.val);
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
        List<Integer> lvl = new ArrayList<>();
		while (!q.isEmpty()) {
			TreeNode front = q.remove();
            
			if (front == null) {

				if (!q.isEmpty()) {
                    
					System.out.println();
					q.add(null);
				}
                
                ans.add(lvl);
                lvl = new ArrayList<>();
			} else {
                lvl.add(front.val);
				System.out.print(front.val + " ");
				if (front.left != null) {
                    
					q.add(front.left);
				}

				if (front.right != null) {
                    //lvl.add(front.right.val);
					q.add(front.right);
				}
			}
		}
        
        return ans;
    }
}
//*****

import java.util.Scanner;

public class Main {

	private static int sol(int[] arr, int i, int j) {
		// TODO Auto-generated method stub

		if(i == j) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for(int k = i; k < j; k++) {
			int cost = sol(arr, i, k) + sol(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
			min = Math.min(min, cost);
		}
		
		return min;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		
		int a = sol(arr, 1, arr.length - 1);
		System.out.println(a);
	}

}

