package chap7.java7.chungae;


public class People {
	People(){}
	People(String name){
		this.name = name;
	}
	String name;
	int age;

	public void eat() {
		System.out.println("먹기");
		
	};

	public void sleep() {
		System.out.println("자기");
	};
}

class Student extends People {
	Student (){
		super(); // = this
	}
	int schoolNo;

	public void goSchool() {
		System.out.println("학교가기");
	};

}

 class Worker extends People {
	 
	int workNo;

	public void goWork() {
		System.out.println("출근");
	};

	}


