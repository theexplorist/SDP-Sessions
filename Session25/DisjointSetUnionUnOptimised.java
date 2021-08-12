package Session25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisjointSetUnionUnOptimised {

	static class EdgeList {

		class Edge {
			int u;
			int v;

			public Edge(int u, int v) {
				this.u = u;
				this.v = v;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "{" + this.u + ", " + this.v + "}";
			}
		}

		int numV;
		List<Edge> edgeList;

		public EdgeList(int numV) {
			// TODO Auto-generated constructor stub
			this.numV = numV;
			this.edgeList = new ArrayList<>();
		}

		private void addEdge(int u, int v) {
			// TODO Auto-generated method stub

			Edge edge = new Edge(u, v);
			this.edgeList.add(edge);
		}
		
		//u ka godfather dhundo, aisa vertex jiks parent -1
		private int find(int[]parent, int u) {
			// TODO Auto-generated method stub

			if(parent[u] == -1) {//godfather, leader, parent of itself
				return u;
			}
			
			return find(parent, parent[u]);
		}
		
		private void union(int[] parent, int u, int v) {
			// TODO Auto-generated method stub

			//find godfather of u and v both
			
			int godFatherU = this.find(parent, u);
			int godFatherV = this.find(parent, v);
			
			if(godFatherU != godFatherV)
			parent[godFatherU] = godFatherV;
		}
		private void display() {
			
			// TODO Auto-generated method stub
			System.out.println(this.edgeList);
		}
		
		private boolean hasCycle(int[] parent) {
			// TODO Auto-generated method stub

			for(Edge edge : this.edgeList) {
				int u = edge.u;
				int v = edge.v;
				
				int godfatherU = this.find(parent, u);
				int godfatherV = this.find(parent, v);
				
				if(godfatherU != godfatherV) {
					this.union(parent, godfatherU, godfatherV);
				} else { //cycle
					return true;
				}
			}
			
			return false;
		}
	}
	
	public static void main(String[] args) {
		EdgeList graph = new EdgeList(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(1, 4);
		graph.addEdge(4, 2);
		int[] parent = new int[5];
		Arrays.fill(parent, -1);
		graph.display();
		//graph.find(parent, 0);
		System.out.println(graph.hasCycle(parent));
	}
}
