package chap10;

public class Job implements Human {
	int age;
	String name;
	
	public void goToJob() {
		System.out.println("직장인이 회사를 갑니다");
	}

	@Override
	public void eat() {
		System.out.println("직장인이 회사에서 밥을 먹어요");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sleep() {
		System.out.println("직장인이 회사에서 자요");
		// TODO Auto-generated method stub
		
	}

}
