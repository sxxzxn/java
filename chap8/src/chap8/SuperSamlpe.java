package chap8;

import java.util.Scanner;

public class SuperSamlpe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. Human 객체
//		Human h = new Human(); // Human 자료형 h
//		h.setAge(20); //객체 접근 도트 .
//		h.name ="길동";
//		h.eat();
//		h.sleep();
//		
//		Student s = new Student();
//		s.setName("길순");
//		s.setAge(21);
//		s.eat();
//		s.sleep();
//		s.goToSchool();
//		
//		
//		Job j = new Job();
//		j.setName("수진");
//		j.setAge(30);
//		j.setJobNo(11);
//		j.eat();
//		j.sleep();
//		j.goToCompany();
//		

		
		Human hh1 = new Human();
		Human hh2 = new Student();
		Human hh3 = new Job();

		
		Student ss1 = new Student();
		//Student ss2 = (Student) new Human(); // 자식으로 캐스팅 해서 대입 (메서드나 필드가 더 많아서!)
		// Student ss3 = new Job(); // 자식 관계에서 대입 불가
		Student ss2 = null; 
		
		if (ss2 instanceof Human) {
			ss2 = ((Student) new Human());
		}
		
		
		//-----------------------------------
		
		Animal a = new Animal();
		Animal bird = new Bird();
		Animal cat = new Cat();
		Animal dog = new Dog();
		Animal  test = new Test();

		a.cry();
		bird.cry();
		cat.cry();
		dog.cry();
		test.cry();
		
		
		Scanner sc = new Scanner(System.in);	
		String name = sc.next();
		
		System.out.println("입력받은문자 : "+ name);
		
		
	}

}
