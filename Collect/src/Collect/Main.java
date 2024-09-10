package Collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		String [] arr = new String [] {"가","나","다","라","마","바","사"};
		arr[2] = null;
		arr[5] = null;
		System.out.println(arr.length);
		// 인터페이스에 부모 자료형으로 선언하고 자식
//		List<String> arrList = new ArrayList<>(Arrays.asList(arr));
		// 부모                      자식 요소 인스턴스
		
		List<String> arrList = new ArrayList<String>();
		arrList.add("가");
		arrList.add("나");
		arrList.add("다");
		arrList.add("라");
		arrList.add("마");
		arrList.add("바");
		arrList.add("사");
		
		System.out.println(arrList);
		
		
		List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		System.out.println("numbers: " + numbers.toString());

		numbers.removeIf(n -> (n % 3 == 0));
		System.out.println("numbers(after remove): " + numbers.toString());
		
		numbers.add(2);
		numbers.remove(3);
		System.out.println("numbers(after remove): " + numbers.toString());
 	}

}
