// TabooTest.java
// Taboo class tests -- nothing provided.

import java.util.*;

import junit.framework.TestCase;

public class TabooTest extends TestCase {
	
	private List<String> stringToList(String s) {
		List<String> list = new ArrayList<String>();
		for (int i=0; i<s.length(); i++) {
			list.add(String.valueOf(s.charAt(i)));
			// note: String.valueOf() converts lots of things to string form
		}
		return list;
	}
	
	public void testNoFollow1() {
		List<String> rules = stringToList("acab");
		Taboo taboo = new Taboo(rules);
		Set<String> expectSet = new HashSet<String>();
		expectSet.add("c");
		expectSet.add("b");
		assertEquals(expectSet, taboo.noFollow("a"));
	}
	
	public void testNoFollow2() {
		List<String> rules = stringToList("acab");
		Taboo taboo = new Taboo(rules);
		Set emptySet = Collections.emptySet();
		assertEquals(emptySet, taboo.noFollow("x"));
	}
	
	public void testReduce1() {
		List<String> rules = stringToList("acab");
		Taboo taboo = new Taboo(rules);
		List<String> list = stringToList("acbxca");
		List<String> expectList = stringToList("axc");
		taboo.reduce(list);
		assertEquals(expectList, list);
	}
}
