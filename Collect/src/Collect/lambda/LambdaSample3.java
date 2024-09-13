package Collect.lambda;

interface LA3{
	void abc(int k);
}

public class LambdaSample3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// # 1. 인스턴스 메서드의 익명 이너 클래스 
		LA3 a1 = new LA3() {

			@Override
			public void abc(int k) {
				System.out.println(k);
			}
			
		};
		a1.abc(1);
	
		// #2. 람다식 변경
		
		LA3 a2 = (int k) -> {System.out.println(k);};
		a2.abc(2);

		LA3 a3 = (k) -> System.out.println(k);
		a3.abc(3);
		
		LA3 a4 = k -> System.out.println(k);
		a3.abc(4);
		
		// #3. 람다식 -> 인스턴스 메서드 참조
		LA3 a6 = System.out::println;
		a6.abc(6);

	}

}
