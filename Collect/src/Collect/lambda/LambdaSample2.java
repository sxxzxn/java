package Collect.lambda;

interface LA2 {
	void abc();
}

class LB2 {
	void bcd() {
		System.out.println("B 메서드 1");
	}
}

public class LambdaSample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// #1. A를 구현한 클래스에서 abc() 내부에서 B객체를 접근하는 익명 이너 클래스

		LA2 a1 = new LA2() {
			@Override
			public void abc() {
				LB2 b1 = new LB2();
				b1.bcd();
			}
		};
		
		a1.abc();
		
		// #2. 람다식
		LA2 a2 = () -> { LB2 b1 = new LB2(); b1.bcd();};
		a2.abc();

		// 추후에 확인하기 
//		// 클래스 변수 할당
//		LB2 b3 = new LB2(); 
//		//클래스 객체 선언해서 람다식으로 a3에 직접 할당
//		LA2 a3 = b3::bcd;
//		a3.abc();

	}

}
