package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Hoodies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int q = s.nextInt();
		
		List<Queue<Integer>> qL = new ArrayList<>();
		Queue<Integer> order = new LinkedList<>();
		for(int i = 0; i <= 4; i++) {
			qL.add(new LinkedList<>());
		}
		while(q-- != 0) {
			char ch = s.next().charAt(0);
			
			if(ch == 'E') {
				int course = s.nextInt();
				int roll = s.nextInt();
				
				qL.get(course).add(roll);
				
				if(!order.contains(course)) {
					order.add(course);
				}
			} else {
				int course = order.peek();
				System.out.println(course + " " + qL.get(course).remove());
				
				if(qL.get(course).isEmpty()) {
					order.remove();
				}
			}
		}
	}

}

/////////////////////////////////////////

class Solution {
    static class DSUUnoptimised {

		int V;
		private int[] parent;

		public DSUUnoptimised(int V) {
			// TODO Auto-generated constructor stub
			parent = new int[V];
			Arrays.fill(parent, -1);
		}

		private int find(int u) {// O(n)
			// TODO Auto-generated method stub

			if (parent[u] == -1) {
				return u;
			}
			return parent[u] = find(parent[u]);
		}

		private void union(int u, int v) {// O(n)
			// TODO Auto-generated method stub

			// step - 1 gf(u), gf(v)
			// step - 2 gf(u) != gf(v) -> p[gf(u)] = gf(v)
			int godFatherU = find(u);
			int godFatherV = find(v);

			if (godFatherU != godFatherV) {
				parent[godFatherU] = godFatherV;
			}
		}
    }
    public int removeStones(int[][] stones) {
        
        DSUUnoptimised dsu = new DSUUnoptimised(stones.length);
			
			for(int i = 0; i < stones.length - 1; i++) {
				for(int j = i + 1; j < stones.length; j++) {
					int stone1x = stones[i][0];
					int stone1y = stones[i][1];
					
					int stone2x = stones[j][0];
					int stone2y = stones[j][1];
					
					int parent1 = dsu.find(i);//0
					int parent2 = dsu.find(j);//1
                    //System.out.println(parent1 + " " + parent2);
					
					if(parent1 != parent2) {
						if(stone1x == stone2x || stone1y == stone2y) {
							dsu.union(j, i);
                            
						}
					}
					
				}
               // System.out.println(Arrays.toString(dsu.parent));
			}
			
			int count = 0;
            for(int e : dsu.parent) {
                if(e == -1) {
                    count++;
                }
            }
        return stones.length - count;
    }
}
//////////////////////////////////////////

class Solution {
    static class DSUUnoptimised {

		int V;
		private int[] parent;

		public DSUUnoptimised(int V) {
			// TODO Auto-generated constructor stub
			parent = new int[V];
			Arrays.fill(parent, -1);
		}

		private int find(int u) {// O(n)
			// TODO Auto-generated method stub

			if (parent[u] == -1) {
				return u;
			}
			return parent[u] = find(parent[u]);
		}

		private void union(int u, int v) {// O(n)
			// TODO Auto-generated method stub

			// step - 1 gf(u), gf(v)
			// step - 2 gf(u) != gf(v) -> p[gf(u)] = gf(v)
			int godFatherU = find(u);
			int godFatherV = find(v);

			if (godFatherU != godFatherV) {
				parent[godFatherU] = godFatherV;
			}
		}

		private boolean detectCycle(int[][] edgeList) {
			// TODO Auto-generated method stub

			for (int r = 0; r < edgeList.length; r++) {// r rows * O(n) -> O(rn)
				int u = edgeList[r][0];
				int v = edgeList[r][1];

				// step - 1 gf(u) and gf(v)
				int godFatherU = find(u);
				int godFatherV = find(v);

				// step - 2 gf(u) != gf(v) -> union
				// step - 3 gf(u) == gf(v) -> return cycle hai
				if (godFatherU != godFatherV) {
					union(godFatherU, godFatherV);
				} else {
					return true;
				}
			}

			return false;
		}
	}
	
	
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int numV = accounts.size();
		DSUUnoptimised dsu = new DSUUnoptimised(numV);
		
		Map<String, Integer> emailGroup = new HashMap<>();
		for(int i = 0; i < numV; i++) {
			List<String> emailList = accounts.get(i);
			for(int j = 1; j < emailList.size(); j++) {
				if(!emailGroup.containsKey(emailList.get(j))) {
					emailGroup.put(emailList.get(j), i);
				} else {
					dsu.union(emailGroup.get(emailList.get(j)), i);
				}
			}
		}
        
        //System.out.println(emailGroup);
        
        Map<Integer, List<String>> connComp = new HashMap<>();
		for(String email : emailGroup.keySet()) {
			int group = emailGroup.get(email);
			int parentOfGroup = dsu.find(group);
			
			if(!connComp.containsKey(parentOfGroup)) {
				connComp.put(parentOfGroup, new ArrayList<>());
			}
			
			connComp.get(parentOfGroup).add(email);
		}
        
       
        List<List<String>> accountsAns = new ArrayList<>();
		
		for(int rep : connComp.keySet()) {
			List<String> emails = connComp.get(rep);
			Collections.sort(emails);
			emails.add(0, accounts.get(rep).get(0));
			accountsAns.add(emails);
		}
        return accountsAns;
    }
}
