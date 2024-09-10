package Collect;

import java.util.LinkedList;
import java.util.List;

public class LinkedListSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> linkedList = new LinkedList<Integer>();
		// #1. add(E)
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		
		System.out.println(linkedList); // 자동으로 .toString붙여줌
		
		// #2. add(index, E)
		linkedList.add(1, 4);
		linkedList.add(2, 6);
		
		System.out.println(linkedList);
		List<Integer> linkedList2 = new LinkedList<Integer>();
		linkedList2.add(10);
		linkedList2.add(20);
		linkedList2.addAll(linkedList);
		System.out.println(linkedList2);
		
		linkedList2.addAll(2, linkedList);
		System.out.println(linkedList2);
		
	
		linkedList2.removeAll(linkedList);
		System.out.println(linkedList2);

		List<Integer> linkedList3 = new LinkedList<Integer>();
		linkedList3.add(1);
		linkedList3.add(3);
		linkedList3.add(5);
		linkedList3.add(7);
		linkedList3.add(9);
		linkedList3.add(11);
		linkedList3.add(13);
		linkedList2.removeAll(linkedList3);
//		linkedList2.removeAll();
		System.out.println(linkedList3);
		System.out.println(linkedList2);
		/*clear 은 데이터를 날리고 
		 * removeAll 들어온 값에서 컬렉션에서 해당하는 값을 확인 후 지운다
		 * 배열에서 최대값, 최소값으로 정렬하기
		 */
	}

}

