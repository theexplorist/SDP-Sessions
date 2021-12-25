public class cbNos {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        scn.nextInt();
        String str = scn.next();
        int count = 0;
        boolean[] visited = new boolean[str.length()];

        for (int len = 1; len <= str.length(); len++) {

            for (int si = 0; si <= str.length() - len; si++) {

                int ei = si + len;

                String ss = str.substring(si, ei);

                if (isCBNo(Long.valueOf(ss)) && isValid(visited, si, ei)) {

                    count++;

                    for (int i = si; i < ei; i++) {
                        visited[i] = true;
                    }

                }
            }

        }

        System.out.println(count);

    }

    public static boolean isValid(boolean[] visited, int start, int end) {

        for (int i = start; i < end; i++) {
            if (visited[i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean isCBNo(long n) {

        if (n == 0 || n == 1) {
            return false;
        }

        long[] arr = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };

        for (int i = 0; i < arr.length; i++) {
            if (n == arr[i]) {
                return true;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (n % arr[i] == 0) {
                return false;
            }
        }

        return true;
    }

  }

class Solution {
    public String alienOrder(String[] words) {
        
        int[] indegree = new int[26];
		Map<Character, List<Character>> adjList = new HashMap<>();
		for (String word : words) {
	        for (char c : word.toCharArray()) {
	            
	            adjList.put(c, new ArrayList<>());
	        }
	    }
		
		
		
		for (int i = 0; i < words.length - 1; i++) {
	        String word1 = words[i];
	        String word2 = words[i + 1];
	        // Check that word2 is not a prefix of word1.
	        if (word1.length() > word2.length() && word1.startsWith(word2)) {
	            return "";
	        }
	        // Find the first non match and insert the corresponding relation.
	        for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
	            if (word1.charAt(j) != word2.charAt(j)) {
	                adjList.get(word1.charAt(j)).add(word2.charAt(j));
	                indegree[word2.charAt(j) - 'a']++;
	                //counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
	                break;
	            }
	        }
	    }
		System.out.println(adjList);
		System.out.println(Arrays.toString(indegree));
		// Step 2: Breadth-first search.
	    StringBuilder sb = new StringBuilder();
	    Queue<Character> queue = new LinkedList<>();
	    for (int i = 0; i < 26; i++) {
	        if (indegree[i] == 0 && adjList.containsKey((char)(i + 'a'))) {
	            queue.add((char)(i + 'a'));
	        }
	    }
	    System.out.println(queue);
	    while (!queue.isEmpty()) {
	        Character c = queue.remove();
	        sb.append(c);
	        for (Character next : adjList.getOrDefault(c, new ArrayList<>())) {
	        	indegree[next - 'a']--;
	            if (indegree[next - 'a'] == 0) {
	                queue.add(next);
	            }
	        }
	    }
	    
	    // if(sb.length() < adjList.size()) {
	    // return "";
	    // }
	    return sb.toString();
    }
}

//["z", "x", "a", "zb"]
