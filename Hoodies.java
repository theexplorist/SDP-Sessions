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
