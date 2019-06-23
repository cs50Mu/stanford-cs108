import java.util.*;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		HashMap<T, Integer> aMap = new HashMap<T, Integer>();
		HashMap<T, Integer> bMap = new HashMap<T, Integer>();
		
		for (T t : a) {
			int currentCnt = aMap.getOrDefault(t, 0);
			aMap.put(t, currentCnt+1);
		}
		
		for (T t : b) {
			int currentCnt = bMap.getOrDefault(t, 0);
			bMap.put(t, currentCnt+1);
		}
		int cnt = 0;
		for (T t: aMap.keySet()) {
			int aCnt = aMap.get(t);
			int bCnt = bMap.getOrDefault(t, 0);
			if (aCnt == bCnt) {
				cnt++;
			}
		}
		return cnt; // YOUR CODE HERE
	}
	
}
