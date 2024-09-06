package chap12;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		C cc = new C();
//		A a1 = new B();
//		cc.bcd(a1);
//		
//		cc.bcd(new B());
//		
//		// 익명 이너 클래스 이용
//		A a2 = new A() {
//			public void abc() {
//				System.out.println("a2 ==> abc()");
//			}
//		};
//		cc.bcd(a2);
//		// 익명 이너 클래스 이용2
//		cc.bcd(new A() {
//			public void abc() {
//				System.out.println("익명 이너 클래스 사용2");
//			}
//		});
		
		
//		G gg = new G();
//		gg.abc();
		
//		E.F b = new E.F() {
//			@Override
//			public void abc() {
//				// TODO Auto-generated method stub
//				System.out.println("G-> E.F -> abc()");
//			}
//		};
//		b.abc();
		
		// 일반적인 UI API 구조 예 (버튼)
		Button btn1 = new Button();
		btn1.setOnClickListener(new Button.OnClickListener(){
			
		});
	}

}
