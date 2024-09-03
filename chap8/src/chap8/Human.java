package chap8;

public class Human {
	Human() {
	}

	Human(int age) {
		this.age = age;
	}

	Human(int age, String name) {
		this(age);
		this.name = name;
	}

	Human(int age, String name, float weigth) {
		this(age, name);
		this.weigth = weigth;
	}

	int age; // 접근 제한자 다시 확인해보기
	String name;
	float weigth;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getWeigth() {
		return weigth;
	}

	public void setWeigth(float weigth) {
		this.weigth = weigth;
	}

	public void print() {
		System.out.println("나이 :" + age + "이름 :" + name + "몸무게 :" + weigth);
	}
	
	public void eat() {
		System.out.println("먹자");
	}

	public void sleep() {
		System.out.println("zZZ");
	}
}
