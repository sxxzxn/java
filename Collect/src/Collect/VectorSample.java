package Collect;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class VectorSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> vector1 = new Vector<Integer>();
		// # 1. add(E)
		vector1.add(3);
		vector1.add(4);
		vector1.add(5);
		System.out.println(vector1);
		
		
		// # 2. add(index, E)
		vector1.add(1, 6);
		System.out.println(vector1);
		
		vector1.remove(1);
		System.out.println(vector1);
		
//		vector1.clear();
//		vector1.removeAll(vector2);
		
//		System.out.println(vector1);
//		
//		
//		System.out.println(vector1.size());
//		System.out.println(vector1.isEmpty());
//
//	
		List<Integer> vector2 = new Vector<Integer>();
		vector2.add(1);
		vector2.add(2);
		System.out.println(vector2);
		vector2.addAll(vector1);
		System.out.println(vector2);
		
		vector2.removeAll(vector1);
		System.out.println(vector2);
		
//		
////		vector2.removeAll(vector1);
////		System.out.println(vector2);
//		
//		// 리스트 --> 배열
//		// toArray()
//		Object [] obj = vector2.toArray();
//		
//		System.out.println(obj.toString());
//		System.out.println(Arrays.toString(obj));
//		
//		//toArray(T[ ] t)
//		Integer[] arrInt = vector2.toArray(new Integer[0]);
////		System.out.println("toArray(T[ ] t): " + arrInt);
//		System.out.println("arrInt toArray(T[ ] t): " + Arrays.toString(arrInt));
//		
//		
//		Integer[] arrInt2 = vector2.toArray(new Integer[10]);// 참조 자료형이라 빈자리에 null이 들어감
//		
//		
//		System.out.println("arrInt2 toArray(T[ ] t): " + Arrays.toString(arrInt2));
		
	}

}
