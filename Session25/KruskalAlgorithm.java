package Session25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KruskalAlgorithm {

	static class EdgeList {

		class Edge {
			int u;
			int v;
			int weight;
			public Edge(int u, int v, int weight) {
				this.u = u;
				this.v = v;
				this.weight = weight;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "{" + this.u + ", " + this.v + ", " + this.weight + "}";
			}
		}

		int numV;
		List<Edge> edgeList;

		public EdgeList(int numV) {
			// TODO Auto-generated constructor stub
			this.numV = numV;
			this.edgeList = new ArrayList<>();
		}

		private void addEdge(int u, int v, int weight) {
			// TODO Auto-generated method stub

			Edge edge = new Edge(u, v, weight);
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
		
		private int kruskalAlgorithm(int[] parent) {
			// TODO Auto-generated method stub

			Collections.sort(this.edgeList, new Comparator<Edge>() {

				@Override
				public int compare(Edge o1, Edge o2) { //o1 -> curr, o2 -> curr + 1
					// TODO Auto-generated method stub
					return o1.weight - o2.weight;
				}
				
			});
			
			System.out.println(this.edgeList);
			
			int cost = 0;
			for(Edge edge : this.edgeList) {
				
				int u = edge.u;
				int v = edge.v;
				int weight = edge.weight;
				int godFatherU = this.find(parent, u);
				int godFatherV = this.find(parent, v);
				
				if(godFatherU != godFatherV) {
					cost += weight;
					this.union(parent, godFatherU, godFatherV);
				}
			}
			
			return cost;
		}
	}
	
	public static void main(String[] args) {
		EdgeList g = new EdgeList(4);
		g.addEdge(1, 2, 1);
		g.addEdge(1, 3, 2);
		g.addEdge(1, 4, 2);
		g.addEdge(2, 3, 3);
		g.addEdge(2, 4, 3);
		g.addEdge(3, 4, 2);
		
		g.display();
		int[] parent = new int[5];
		Arrays.fill(parent, -1);
		System.out.println(g.kruskalAlgorithm(parent));
	}
}
