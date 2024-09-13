package Collect.lambda;

interface E {
	void method1();
}
interface F {
	void method2(int a);
}
interface C {
	int method3();
}
interface D {
	double method4(int a, double b);
}
public class LambdaTest2 {
	public static void main(String[] args) {
		
		// #1. 익명 이너 클래스
		E e1 = new E() {
			@Override
			public void method1() {
				System.out.println("입력 매개변수 X, 리턴값 X 함수");
			}
		};
		e1.method1();

		F f1 = new F() {
			@Override
			public void method2(int a) {
				System.out.println("입력 매개변수 O, 리턴값 X 함수 : " + a);
			}
		};
		f1.method2(1);
		
		
		C c1 = new C() {
			@Override
			public int method3() {
				System.out.println("입력 매개변수 X, 리턴값 O 함수");
				return 3;
			}
		};
		c1.method3();
		
		D d1 = new D() {
			@Override
			public double method4(int a, double b) {
				System.out.println("입력 매개변수 O, 리턴값 O 함수 : "+a+","+b);
				return a+b;
			}
		};
		d1.method4(4, 4.0);
		
		// #2 람다식...
		
		E e11 = () -> System.out.println(" 람다 : 입력 매개변수 X, 리턴값 X 함수");
		e11.method1();
		
		F f11 = (int a) -> System.out.println("입력 매개변수 O, 리턴값 X 함수 : " + a);
		f11.method2(2);
		
		C c11 = () -> {System.out.println("입력 매개변수 X, 리턴값 O 함수"); return 3;};
		c11.method3();
		
		C c12 = () -> {return 3;};
		c12.method3();
		
		C c13 = () ->  3;
		c13.method3();
		
		D d11 = (int a, double b) -> {return a+b;};
		d11.method4(5, 11.2);

		D d12 = (a, b) -> a+b;
		d12.method4(5, 11.2);
		System.out.println(d12.method4(5, 11.2));
		
		
	}
}
