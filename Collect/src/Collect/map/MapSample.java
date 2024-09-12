package Collect.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapSample {
	public static void main(String[] args) {
		Map<Integer, String> hMap1 = new HashMap<Integer, String>();

		// #1. put(K,V>
		hMap1.put(2, "가나다");
		hMap1.put(1, "나다라");
		hMap1.put(3, "다라마");

		System.out.println(hMap1);

		// #2. putAll(Map < ? extends K, ? extends V> M)
		Map<Integer, String> hMap2 = new HashMap<Integer, String>();
		hMap2.putAll(hMap1);

		System.out.println(hMap2);

		// #3.replace(K, V) 이전 값 리턴 값은 변경됨!, 없는건 변경x
		String s1 = hMap2.replace(1, "가가가");
		String s2 = hMap2.replace(4, "라라라"); // 키값이 4가 없어서 결과는 null

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(hMap2);

		// #4.replace(K, V old, V new) // 다른값을 입력시 동작x
		boolean b1 = hMap2.replace(1, "가가가", "나나나");
		boolean b2 = hMap2.replace(2, "다다다", "라라라"); // 2의 기존값은 가나다라 변경 안됨 ->false

		System.out.println(b1);
		System.out.println(b2);
		System.out.println(hMap2);

		// #5. V get(Object Key)
		System.out.println(hMap2.get(1));
		System.out.println(hMap2.get(2));
		System.out.println(hMap2.get(3));

		// #6.containsKey(Object k)
		System.out.println(hMap2.containsKey(1)); // -> 있으면 true 없으면 false
		System.out.println(hMap2.containsKey(4));
		if(hMap2.containsKey(1)) {
			boolean tb = hMap2.replace(1, "나나나","123");
			System.out.println("tb : "+tb);
		}
		System.out.println("비밀번호 확인 후 변경 : "+ hMap2);

		// #7. containsValue (Object Value )
		System.out.println(hMap2.containsValue("나나나")); // -> 있으면 true 없으면 false
		System.out.println(hMap2.containsValue("다다다")); // -> 있으면 true 없으면 false
		
		// #8. Set<K> KeySet()
		Set<Integer> keySetList = hMap2.keySet();
		System.out.println(keySetList); //.toString () 생략되어있음 
		
		// #9. Set<Map.Entry<K,V>>entrySet()
		Set<Map.Entry<Integer, String>> entrySet = hMap2.entrySet();
		
		System.out.println(entrySet);
		
		// #10. size()
		System.out.println(hMap2.size());
		
		// #11. remove(Object K)
		System.out.println(hMap2.remove(3));
		System.out.println(hMap2);
		hMap2.put(3, "다라마");
		
		System.out.println(hMap2);

		// #12. remove(Object K, Object V) 키랑 값이 같아야만 삭제가된다
		hMap2.remove(1,"123");
		hMap2.remove(3,"다다다");
		System.out.println(hMap2);
		
//		for (Map.Entry<Integer, String> hMap2List : hMap2.entrySet()) {
//			System.out.print(hMap2List.getKey()+":"+hMap2List.getValue());
//		}
		// #13. clear()
		hMap2.clear();
		System.out.println(hMap2);
		
	}
}
