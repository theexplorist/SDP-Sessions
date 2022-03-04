package BinaryTrees;

import java.util.Arrays;

public class KMPAlgo {

	private static int[] prefixAlgo(String pat) {
		// TODO Auto-generated method stub

		int i = 1, cmpI = 0;

		int[] lps = new int[pat.length()];
		while (i < pat.length()) {

			if (pat.charAt(i) == pat.charAt(cmpI)) {
				cmpI++;
				lps[i] = cmpI;
				i++;
			} else {
				if(cmpI > 0) {
					cmpI = lps[cmpI - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
		
		return lps;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String pat = "aaba";
		String str = "aabaacaadaabaaba";
		
		StringBuilder sb = new StringBuilder(pat);
		sb.append('#');
		sb.append(str);
		System.out.println(Arrays.toString(prefixAlgo(sb.toString())));
	}

}
