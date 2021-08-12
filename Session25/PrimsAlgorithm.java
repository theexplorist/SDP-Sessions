package Session25;

import java.util.ArrayList;
import java.util.List;

public class PrimsAlgorithm {

	static class Graph {
		int numV;
		int[][] costMatrix;

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
				return "{" + u + ", " + v + "}";
			}
		}
		public Graph(int[][] conn) {
			// TODO Auto-generated constructor stub
			this.numV = conn.length;

			this.costMatrix = new int[conn.length][conn.length];

			// jahan 0 hai wahan edge ni hai to cost Infinity

			for (int i = 0; i < numV; i++) {
				for (int j = 0; j < numV; j++) {
					if (conn[i][j] == 0) {// no edge
						costMatrix[i][j] = Integer.MAX_VALUE;
					} else {
						costMatrix[i][j] = conn[i][j];
					}
				}
			}

			for (int i = 0; i < numV; i++) {
				for (int j = 0; j < numV; j++) {

					if (costMatrix[i][j] == Integer.MAX_VALUE)
						System.out.print("X ");
					else
						System.out.print(costMatrix[i][j] +" ");
				}
				System.out.println();
			}
		}
		
		private List<Edge> primnsAlgorithm() {
			// TODO Auto-generated method stub

			List<Edge> primsEdges = new ArrayList<>();
			// unreached/unvisited -> {1, 2, 3, 4, 5, 6, 7, 8};
			// reached/mst/vis -> {0}
			boolean[] vis = new boolean[this.numV]; //false;
			
			vis[0] = true;
			
			int cost = 0;
			for(int vertex = 1; vertex < this.numV; vertex++) {
				int u = 0, v  = 0;//infinity min cost , jisme u vis, v unvis
				
				for(int i = 0; i < this.numV; i++) {
					for(int j = 0; j < this.numV; j++) {
						if(vis[i] && !vis[j] && costMatrix[i][j] < costMatrix[u][v]) {
							u = i;
							v = j;
						}
					}
				}
				
				cost += costMatrix[u][v];
				System.out.println("Chosen edge is " + u + " -> " + v + " with weight " + costMatrix[u][v]);
				vis[v] = true;
				primsEdges.add(new Edge(u, v));
			}
			
			System.out.println(cost);
			return primsEdges;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] conn = { 
				{ 0, 3, 0, 2, 0, 0, 0, 0, 4 }, // 0 //9*9
				{ 3, 0, 0, 0, 0, 0, 0, 4, 0 }, // 1
				{ 0, 0, 0, 6, 0, 1, 0, 2, 0 }, // 2
				{ 2, 0, 6, 0, 1, 0, 0, 0, 0 }, // 3
				{ 0, 0, 0, 1, 0, 0, 0, 0, 8 }, // 4
				{ 0, 0, 1, 0, 0, 0, 8, 0, 0 }, // 5
				{ 0, 0, 0, 0, 0, 8, 0, 0, 0 }, // 6
				{ 0, 4, 2, 0, 0, 0, 0, 0, 0 }, // 7
				{ 4, 0, 0, 0, 8, 0, 0, 0, 0 }  // 8
		};

		Graph g = new Graph(conn);
		System.out.println(g.primnsAlgorithm());
	}

}
