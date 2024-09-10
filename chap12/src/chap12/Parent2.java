package chap12;

public class Parent2 {
	public static <T extends Number> void print(T t) { // 메서드임
		System.out.println(t);
	}

}
