package Collect;

import java.util.LinkedHashSet;
import java.util.Set;

public class LikenSetSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> lSet1 = new LinkedHashSet<String>();
		// #1.add(E)
		lSet1.add("가");
		lSet1.add("나");
		lSet1.add("다");
		lSet1.add("가");
		lSet1.add("나");
		lSet1.add("다");
		System.out.println(lSet1);

		Set<String> lSet2 = new LinkedHashSet<String>();
		// #1.addAll
		lSet2.add("A");
		lSet2.add("B");
		lSet2.add("C");
		lSet2.add("가");
		lSet2.add("나");
		System.out.println(lSet2);
		
		lSet2.addAll(lSet1);
		System.out.println(lSet2);
		
		// #3 remove(Object)
		lSet2.remove("나");
		System.out.println(lSet2);
	
		lSet2.clear();
		System.out.println(lSet2);
	}

}
