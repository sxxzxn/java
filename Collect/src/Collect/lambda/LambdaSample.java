package Collect.lambda;

interface A {
	void abc();
}

class B implements A {

	@Override
	public void abc() {
		System.out.println(" 메서드 내용 1 ");
	}

}

public class LambdaSample {

	public static void main(String[] args) {

		// #1. 일반 클래스 인스턴스 생성
		A a1 = new B();
		a1.abc();

		// #2. 익명 이너 클래스
		A a2 = new A() {
			@Override
			public void abc() {
				System.out.println(" 메서드 내용 2 ");
			}
		};
		a2.abc();

		// #3. 람다
		A a3 = () -> {
			System.out.println("메서드 3");
		};
		A a4 = () -> System.out.println("메서드 4");
		a3.abc();
		a4.abc();
	}

}
