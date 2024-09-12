package Collect.Set;

import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		TreeSet<String> tSet1 = new TreeSet<String>();
//		
//		List<String> arrList = new ArrayList<String>();
//		arrList.add("가");
//		arrList.add("나");
//		arrList.add("다");
//		arrList.add("가");
//		arrList.add("나");
//		arrList.add("다");
//		arrList.add("라");
//		System.out.println(arrList);
//
//		tSet1.addAll(arrList);
//		
//		System.out.println(tSet1);
//		arrList.clear();
//		tSet1.addAll(arrList);
//		System.out.println(tSet1);
		
		TreeSet<Integer> tSet1 = new TreeSet<Integer>();
		for (int i=0; i<50; i++) {
			tSet1.add(i);
		}
		//#1 first()
		System.out.println("first() : "+tSet1.first());

		//#2 last()
		System.out.println("last() : "+tSet1.last());
		
		//#3 lower(E)
		System.out.println("lower(25) : "+tSet1.lower(25));

		//#4 higher(E)
		System.out.println("higher(25) : "+tSet1.higher(25));
		
		//#5 floor(E)
		System.out.println("floor(25) : "+tSet1.floor(25));

		//#6 ceiling(E)
		System.out.println("ceiling(25) : "+tSet1.ceiling(25));
		
		System.out.println("ceiling(25) : "+tSet1.ceiling(25));

		// 데이터를 꺼내는 방법
		
//		//#7. pollFirst()
//		System.out.println("//#7. pollFirst()");
//		System.out.println("tSet1 : "+tSet1);
//		System.out.println("size() : "+tSet1.size());
////		for(int i=0; i<tSet1.size(); i++) {
////			System.out.println(i+" : "+tSet1.pollFirst()+" ");
////		}
////		System.out.println("pollFirst 후 size() : "+tSet1.size());
////		System.out.print("for : ");
////		for(;;) {
////			if(tSet1.size()<=0) break;
////			System.out.print(tSet1.pollFirst()+" ");
////		}
//		System.out.println();
//		System.out.println("tSet1.pollFirst() : "+tSet1.pollFirst());
//		
//		System.out.println("pollFirst() -> tSet1 : "+tSet1);
//		System.out.println("pollFirst() -> size() : "+tSet1.size());
//		//#8. pollLast()
//		System.out.println("//#8. pollLast()");
//		
//		System.out.println("size() : "+tSet1.size());
//		System.out.println("tSet1 : "+tSet1);
////		for(int i=0; i<tSet1.size(); i++) {
////			System.out.println(i+" : "+tSet1.pollLast()+" ");
////		}
//		
//		System.out.println("tSet1.pollLast() : "+tSet1.pollLast());
//		
//		System.out.println("pollLast() -> tSet1 : "+tSet1);
//		System.out.println("pollLast() -> size() : "+tSet1.size());
//		
//		System.out.print("while : ");
//		while(true) {
//			if(tSet1.size()<=0) break;
		
//			System.out.print(tSet1.pollFirst()+" ");
//		}
		// 데이터 부분 집합(subSet) todtjd
		tSet1.clear();
		for(int i=50; i>0; i-=2) {
			tSet1.add(i);
		}
		System.out.println(tSet1);
		
		SortedSet<Integer> sSet = tSet1.headSet(30, true);
		System.out.println(sSet);
		
//		TreeSet<MyClass> mySet1 = new TreeSet<MyClass>();
//		MyClass my1 = new MyClass(2,3);
//		MyClass my2 = new MyClass(2,3);
		
	}

}

class Myclass{
	int data;
	
	public void MyClass(int date) {
		this.data = date;
	}
}
