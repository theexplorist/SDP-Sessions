import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DiagonalSorting {

	private static void solve(int si, int sj, int[][] arr) {
		// TODO Auto-generated method stub
		int i = si, j = sj;
		
		List<Integer> diagonal = new ArrayList<>();
		while(i < arr.length && j < arr[0].length) {
			diagonal.add(arr[i][j]);
			i++;
			j++;
		}
		System.out.println(diagonal);
		Collections.sort(diagonal);
		
		int idx = 0;
		
		i = si; 
		j = sj;
		
		while(i < arr.length && j < arr[0].length) {
			arr[i][j] = diagonal.get(idx++);
			i++;
			j++;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] arr = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
		for(int i = 0; i < arr.length; i++) {
			solve(i, 0, arr);
		}
		
		for(int j = 1; j < arr[0].length; j++) {
			solve(0, j, arr);
		}
		
		System.out.println(Arrays.deepToString(arr));
	}

}
