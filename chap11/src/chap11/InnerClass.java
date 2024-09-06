package chap11;

public class InnerClass { // -> 아우터클래스
	// -> 아우터 클래스 프로퍼티
	public int	  a = 3;
	protected int b = 4;
	int			  c = 5;
	private int   d = 6;

	//-> 아우터 클래스 메서드
	public void ma() {
		
	}
	protected void mb() {
		
	}
	void mc() {
		
	}
	private void md() {
		
	}
	
	class B{ // -> 이너클래스 
		//-> 이너 클래스 메서드
		int a;
		void  abc() { // -> 여기서는 static 선언 불가 ( 클래스가 static이거나 제일 밖에 있거나)
			System.out.println("ORTER a : " +a); // -> 이너클래스
			System.out.println("ORTER a : " +this.a); // -> 이너클래스
			System.out.println("ORTER a : " +InnerClass.this.a); // -> 아우터 클래스 호출
			System.out.println("ORTER b : " +b);
			System.out.println("ORTER c : " +c);
			System.out.println("ORTER d : " +d);
			ma();
		}
	}

}
