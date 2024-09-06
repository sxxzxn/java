package study;

class A { // -> 아우터 클래스
	public int a = 3;
	protected int b = 4;
	int c = 5;
	private int d = 6;		
		class B{ // -> 이너 클래스, 인스턴스 멤버 이너클래스
		}
}