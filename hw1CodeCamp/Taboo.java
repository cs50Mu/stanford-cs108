
/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/

import java.util.*;

public class Taboo<T> {
	
	private HashMap<T, Set<T>> tabooMap;
	
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	public Taboo(List<T> rules) {
		tabooMap = new HashMap<T, Set<T>>();
		for (int i = 0; i < rules.size() - 1; i++) {
			T current = rules.get(i);
			T next = rules.get(i+1);
			Set<T> notFollow = tabooMap.get(current);
			if (notFollow == null) {
				notFollow = new HashSet<T>();
				if (next != null) {
					notFollow.add(rules.get(i+1));
				}
			} else {
				if (next != null) {
					notFollow.add(rules.get(i+1));
				}
			}
			tabooMap.put(current, notFollow);
		}
//		for (T t: tabooMap.keySet()) {
//			Set set = tabooMap.get(t);
//			if (set.size() == 0) {
//				Set emptySet = Collections.emptySet();
//				tabooMap.put(t, emptySet);
//			}
//		}
	}
	
	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {
		Set set = tabooMap.get(elem); // YOUR CODE HERE
		if (set != null) {
			return set;
		} else {
			Set emptySet = Collections.emptySet();
			return emptySet;
		}
	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	// acbxca
	public void reduce(List<T> list) {
		int listSize = list.size();
		for (int i = 0; i < listSize-1; i++) {
			T current = list.get(i);
			T next = list.get(i+1);
			System.out.println(next);
			Set noFollows = this.noFollow(current);
			while(noFollows.contains(next)) {
				list.remove(i+1);
				// just removed last element
				// and the cursor is at the 
				// last element of the list
				if ((i+1) == list.size()) {
					break;
				}
				System.out.println(list);
				next = list.get(i+1);
				System.out.println(next);
				listSize--;
			}
		}
	}
}
