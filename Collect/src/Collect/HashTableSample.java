package Collect;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class HashTableSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// #1. put(K,V)
		Map<Integer, String> hTable1 = new Hashtable<Integer, String>();
		hTable1.put(2, "조수진");
		hTable1.put(1, "가나다");
		hTable1.put(3, "다라마");
		hTable1.put(4, "바라사");
		hTable1.put(5, "다바아");
		
		System.out.println(hTable1);
		
		// #2. putAll(Map < ? extends K, ? extends V> m) 입력순서오 ㅏ출력순서가 동일하지 않음
		Map<Integer, String> hTable2 = new Hashtable<Integer, String>();
		hTable2.putAll(hTable1);
		
		System.out.println(hTable2);
		
		// #3. replace
		String s1 = hTable2.replace(1, "가가가");
		String s2 =hTable2.replace(4, "라라라");
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(hTable2);

		// #4. replace(K, V old, V new)
		boolean b1 = hTable2.replace(1, "가가가", "나나나");
		boolean b2 = hTable2.replace(2, "다다다", "라라라");
		boolean b3 = hTable2.replace(4, "라라라", "가가가");
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(hTable2);
		
		// #5. V get(Object K)
		System.out.println(hTable2.get(1));
		System.out.println(hTable2.get(2));
		System.out.println(hTable2.get(3));
		
		// #6. containsKey(Object K)
		System.out.println(hTable2.containsKey(1));
		System.out.println(hTable2.containsKey(4));
		
		// #7. containsKey(Object V)
		System.out.println(hTable2.containsValue("나나나")); // 1:1 aocld
		System.out.println(hTable2.containsValue("라라라"));
		
		
		// like 처럼 작동
//		hTable2.equals("나");
//		System.out.println("like : " + hTable2.equals("다바아"));
//		
//		
//		for (int i = 1; i<hTable2.size(); i++) {
//		System.out.println("확인"+hTable2.get(i).equals("조"));	
//		}
		
//		System.out.println(hTable2.entrySet());
//		Set<Entry<Integer, String>> list = hTable2.entrySet();
//		System.out.println(list);
//		
//		String searchK = "수";
		
//		for (Map.Entry<Integer, String> entry : hTable1.entrySet()) {
//            if (entry.getValue().contains(searchK)) {
//                System.out.println("검색 확인 : " + entry.getValue());
//            }
//        }
		
		// #8. Set<K> keySet()
		Set<Integer> keySet = hTable2.keySet();
		System.out.println(keySet);

		
		
		// #9.Set<Entry<K,V>)
		Set<Map.Entry<Integer, String>> entrySet = hTable2.entrySet();
		System.out.println(entrySet);
		
		
		
		// #10. size()
		System.out.println(hTable2.size());
		
		// #11. remove(Object K)
		hTable2.remove(1);
		hTable2.remove(11);
		System.out.println(hTable2);
		
		// #12. remove(Object K, Object V)
		hTable2.remove(1, "가가가");
		hTable2.remove(11);
		System.out.println(hTable2);
		
		// #13. clear()
		hTable2.clear();
		
	}

}
