package Collect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class LinkedHashMapSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Integer, String> lhMap1 = new LinkedHashMap<Integer, String>();
		
		// #1. put<K,V>
		lhMap1.put(2, "나다라");
		lhMap1.put(1, "가나다");
		lhMap1.put(3, "다라마");
		
		System.out.println(lhMap1);
		
//		lhMap1.clear();
//		lhMap1.put(1, "가나다");
//		lhMap1.put(2, "나다라");
//		lhMap1.put(3, "다라마");
//		System.out.println(lhMap1);
		
		// #2. putAll( Map <? extends K, ? extends V> m )
		Map<Integer, String> lhMap2 = new LinkedHashMap<Integer, String>();
		lhMap2.putAll(lhMap1);
		System.out.println(lhMap2);
		
		// #3. replace(K, V)
		lhMap2.replace(1, "가가가");
		lhMap2.replace(4, "가가가");
		System.out.println(lhMap2);
		
		// #4. replace(K, V old, V new)
		lhMap2.replace(1, "가가가", "나나나");
		lhMap2.replace(4, "가가가", "다다다");
		System.out.println(lhMap2);
		
		
		// LinkedHashMap 정렬맞추기
//		System.out.println(lhMap1.keySet());
//		List<Integer> keyList = new ArrayList<>(lhMap1.keySet());		
//		Collections.sort(keyList);
//
//		Map<Integer, String> lhMap3 = new LinkedHashMap<Integer, String>();
//		for (Integer key : keyList) {
////		    System.out.println(key + ":" + lhMap1.get(key));
//		    lhMap3.put(key, lhMap1.get(key));
//		}
//		System.out.println("확인 : "+lhMap3);
		
		
		
//		Set<Integer> keys = lhMap2.keySet();
//		System.out.println(keys);
//		ArrayList<Integer> sortedKeys = new ArrayList<Integer>(keys);
////		sortedKeys.addAll(keys);
//		System.out.println(sortedKeys);
//		Collections.sort(sortedKeys);
////		System.out.println(Arrays.toString(Collections.sort(sortedKeys)));
//		System.out.println(sortedKeys);
//		Map<Integer, String> lhMap4 = new LinkedHashMap<Integer, String>();
//		for (int i=0; i<lhMap2.size(); i++) {
//			lhMap4.put(sortedKeys.get(i), lhMap2.get(i+1));
//		}
//		System.out.println(lhMap4);
		
		
//		TreeSet<Integer> tKey = new TreeSet<Integer>();
//		tKey.addAll(lhMap2.keySet());
//
//		Map<Integer, String> lhMap5 = new LinkedHashMap<Integer, String>();
//		for (int i=1; i<=lhMap2.size(); i++) {
//			lhMap5.put(tKey.pollFirst(), lhMap2.get(i));
//		}
//		System.out.println(lhMap5);
		
		// 삭제 흐 바로확인
		Map<Integer, String> lhMap3 = new LinkedHashMap<Integer, String>(lhMap2);
		TreeSet<Integer> keys = new TreeSet<Integer>(lhMap3.keySet());
		for(Integer i : keys) {
			lhMap3.put(i, lhMap3.remove(i));
		}
		System.out.println("lhMap3 : " + lhMap3);
		
		
		
	}

}
