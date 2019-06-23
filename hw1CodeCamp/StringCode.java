import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		char prev = ' ';
		int currentMax = 0;
		int globalMax = 0;
		for (int i = 0; i < str.length(); i++) {
			char current = str.charAt(i);
			if (current == prev) {
				currentMax++;
			} else {
				currentMax = 1;
			}
			if (currentMax > globalMax) {
				globalMax = currentMax;
			}
			prev = current;
		}
		return globalMax; // YOUR CODE HERE
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			int next = i + 1;
			if (Character.isDigit(str.charAt(i))) {
				if (i == str.length() - 1) {
					continue;
				}
				int num = Character.getNumericValue(str.charAt(i));
				for (int j = 0; j < num; j++) {
					sb.append(str.charAt(next));
				}
			} else {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString(); // YOUR CODE HERE
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		HashSet<String> set = new HashSet();
		for (int i = 0; i < a.length(); i++) {
			if ((i+len) <= a.length()) {
			String subStr = a.substring(i, i+len);
			set.add(subStr);
			}
		}
		for (int j = 0; j < b.length(); j++) {
			if ((j+len) <= b.length()) {
			String subStr = b.substring(j, j+len);
			if (set.contains(subStr)) {
				return true;
			}
			}
		}
		return false; // YOUR CODE HERE
	}
}
