package chap8;

public class Student extends Human{
	Student(){
		super();
	}

	Student(int age, String name, int grade){
		super(age, name);
		
		this.grade = grade;
		
	}
	int grade;
	
	public int getGrade() {
		return this.grade;
	}
	
	public void setGrade(int grdae) {
		 this.grade = grdae;
	}
		
	public void goToSchool() {
		System.out.println(super.getName());
		System.out.println("학교가욤");
	}
	
	}

