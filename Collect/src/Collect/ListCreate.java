package Collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCreate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 생성자에 아무것도 입력하지 않으면 디폴트 사이즈는 10
		List<Integer> arr1 = new ArrayList<Integer>();
		List<Integer> arr2 = new ArrayList<Integer>();
		arr1.add(11);
		arr1.add(11);
		arr1.add(11);
		arr1.add(11);
		System.out.println("arr1"+arr1.size());
//		arr1.clear();
		System.out.println("arr1"+arr1.size());
		System.out.println("arr1"+arr1.isEmpty());
		
//		List<Integer> arr3 = Arrays.asList(1,2,3,4,5);
//		arr3.set(1, 10);
//		System.out.println(arr3);
		
		// addAll(Collection<? Extends E>c)
		arr2.add(1);
		arr2.add(1);
		arr2.add(3);
		arr2.addAll(arr1);
		System.out.println("arr1"+arr1.size());
		System.out.println("arr2"+arr2);
		
//		addAll(int index Collection<? Extends E>c)
		arr2.addAll(1, arr1);
		System.out.println("arr2"+arr2);
	}

}
