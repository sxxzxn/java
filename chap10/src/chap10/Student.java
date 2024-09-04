package chap10;

public class Student implements Human {
	int age;
	String name;
	
	public void goToSchool() {
		System.out.println("학생이 학교를 갑니다");
	}
	

	@Override
	public void eat() {
		
		System.out.println("학생이 먹는다");
	}

	@Override
	public void sleep() {
		System.out.println("학생이 잔다");
		
	}

}
