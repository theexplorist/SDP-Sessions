package DSU;

import java.util.ArrayList;
import java.util.List;

public class PrimsAlgorithm {

	static class Graph {
		int numV;
		int[][] linkCost;

		class Edge {
			int u, v;
			
			public Edge(int u, int v) {
				// TODO Auto-generated constructor stub
				this.u = u; 
				this.v = v;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "{" + this.u + ", " + this.v + "}";
			}
		}
		public Graph(int[][] matrix) {
			// TODO Auto-generated constructor stub
			this.numV = matrix.length;
			this.linkCost = new int[matrix.length][matrix[0].length];
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					if (matrix[i][j] != 0) {
						linkCost[i][j] = matrix[i][j];
					} else {
						linkCost[i][j] = Integer.MAX_VALUE;
					}
				}
			}

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {

					if (linkCost[i][j] != Integer.MAX_VALUE)
						System.out.print(linkCost[i][j] + " ");
					else
						System.out.print("* ");
				}
				System.out.println();
			}
		}
		
		private int primsAlgorithm() {
			// TODO Auto-generated method stub

			List<Edge> edgeList = new ArrayList<>(); 
			boolean[] reached = new boolean[this.numV];
			reached[0] = true;
			
			int cost = 0;
			for(int vert = 1; vert < this.numV; vert++) {
				int u = 0, v = 0;
				
				for(int i = 0; i < this.numV; i++) {
					for(int j = 0; j < this.numV; j++) {
						
						if(reached[i] && !reached[j] && this.linkCost[i][j] < linkCost[u][v]) {
							u= i;
							v = j;
						}
					}
				}
				
				System.out.println("chosen edge is " + u + "->" + v + " with weight " + linkCost[u][v]);
				cost += linkCost[u][v];
				reached[v] = true;
				edgeList.add(new Edge(u, v));
			}
			System.out.println(edgeList);
			
			return cost;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] conn = { 
				{ 0, 3, 0, 2, 0, 0, 0, 0, 4 }, // 0
				{ 3, 0, 0, 0, 0, 0, 0, 4, 0 }, // 1
				{ 0, 0, 0, 6, 0, 1, 0, 2, 0 }, // 2
				{ 2, 0, 6, 0, 1, 0, 0, 0, 0 }, // 3
				{ 0, 0, 0, 1, 0, 0, 0, 0, 8 }, // 4
				{ 0, 0, 1, 0, 0, 0, 8, 0, 0 }, // 5
				{ 0, 0, 0, 0, 0, 8, 0, 0, 0 }, // 6
				{ 0, 4, 2, 0, 0, 0, 0, 0, 0 }, // 7
				{ 4, 0, 0, 0, 8, 0, 0, 0, 0 } // 8
		};

		Graph g = new Graph(conn);
		System.out.println(g.primsAlgorithm());
	}

}

//*********************
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
    class Pair {
		TreeNode node;
		int vLvl;
		int hLvl;

		public Pair(TreeNode node, int vLvl, int hLvl) {
			this.node = node;
			this.vLvl = vLvl;
			this.hLvl = hLvl;
		}
	}

	class Lvl {
		int val;
		int hLvl;

		public Lvl(int val, int hLvl) {
			this.val = val;
			this.hLvl = hLvl;
		}
        
        @Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.val + "";
		}
	}

	public List<List<Integer>> verticalTraversal(TreeNode root) {

		Queue<Pair> bfs = new LinkedList<>();

		bfs.add(new Pair(root, 0, 0));
		Map<Integer, List<Lvl>> map = new TreeMap<>();
		while (!bfs.isEmpty()) {
			Pair front = bfs.poll();
			TreeNode curr = front.node;
			int vLvl = front.vLvl;
			int hLvl = front.hLvl;
			List<Lvl> list = map.getOrDefault(vLvl, new ArrayList<>());
			list.add(new Lvl(curr.val, hLvl));

			map.put(vLvl, list);
			if (curr.left != null) {
				bfs.add(new Pair(curr.left, vLvl - 1, hLvl + 1));
			}

			if (curr.right != null) {
				bfs.add(new Pair(curr.right, vLvl + 1, hLvl + 1));
			}
		}

        List<List<Integer>> ans = new ArrayList<>();
		for(List<Lvl> l : map.values()) {
            Collections.sort(l, new Comparator<Lvl>() {

				@Override
				public int compare(Solution.Lvl o1, Solution.Lvl o2) {
					// TODO Auto-generated method stub
                    if(o1.hLvl == o2.hLvl)
					return o1.val - o2.val;
                    return 0;
				}
			});
            
            List<Integer> res = new ArrayList<>();
            for(Lvl e : l) {
                res.add(e.val);
            }
            
            ans.add(res);
			System.out.println(res);
		}
		
		return ans;
	}
}
