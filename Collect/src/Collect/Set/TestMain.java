package Collect.Set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TestMain{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		H h = new H();
//		System.out.println(h);
//		
//		A a1 = new A (3);
//		A a2 = new A (3);
//		
//		String b1 = "abc";
//		String b2 = "abc";
//		String b3 = new String("abc");
//		String b4 = new String("abc");
//		System.out.print("a1==a2 :");
//		System.out.println(a1==a2);
//		System.out.println("a1.equals(a2) :"+a1.equals(a2));
//		System.out.print("b1 == b2 :");
//		System.out.println(b1 == b2);
//		System.out.println("b1.equals(b2)"+b1.equals(b2));
//		System.out.print("b3 == b4 :");
//		System.out.println(b3 == b4);
//		System.out.println("b3.equals(b4)"+b3.equals(b4));
		
		
		Set <A> hSet1 = new HashSet <A>();
		
		B b1 = new B(3);
		B b2 = new B(3);
		
		System.out.print("b1==b2 :");
		System.out.println(b1==b2);
		System.out.println("b1.equals(b2) :"+b1.equals(b2));
		System.out.println(b1.hashCode() + " : " +b2.hashCode());
		
		
		Set <B> hSet2 = new HashSet <B>();
		hSet2.add(b1);
		hSet2.add(b2);
		System.out.println("hSet2.size() : " + hSet2.size());
		
		//Set -> 배열
		//#9 toArray
		Object [] obj = hSet2.toArray();
		System.out.println(obj); // JVM이 생성한 인스턴스 아이디
		
		}
		
	}

	class H {

}
	
class A {
	int data;
	
	public A (int data) {
		this.data = data;
	}
}

class B {
	int data;
	
	public B (int data) {
		this.data = data;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(data);
	}
	
	@Override
	public boolean equals(Object obj) {
		if( obj instanceof B) {
			if (this.data == ((B)obj).data) {
				return true;
			}
		}
		return false;
	}
}