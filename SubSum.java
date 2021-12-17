public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] arr) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		List<Integer> ans = new ArrayList<>();
		int l = -1, r = -1;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if(sum == 0) {
				l = 0; r = i;
				break;
			} else if(map.containsKey(sum)) {
				l = map.get(sum) + 1;
				r = i;
			} else {
				map.put(sum, i);
			}
		}
		
		ans.add(l);
		ans.add(r);
		return ans;
    }
}

//**************************
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] arr) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		List<Integer> ans = new ArrayList<>();
		int l = -1, r = -1;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if(sum == 0) {
				l = 0; r = i;
				break;
			} else if(map.containsKey(sum)) {
				l = map.get(sum) + 1;
				r = i;
			} else {
				map.put(sum, i);
			}
		}
		
		ans.add(l);
		ans.add(r);
		return ans;
    }
}
