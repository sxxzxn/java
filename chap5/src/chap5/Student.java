package chap5;

public class Student {
	// 클래스는 대문자 선언
	// 퍼블릭 클래스 일때 클래스의 이름과 클래스를 생성한 자바 파일 이름이 동일해야함
	
	
	// 기본 생성자는 사용자가정의하지 않았을 경우 시스템이 객체 생성시에 자동 생성 => 인자가 없다
	// 기본 생성자 : 클래스명( ) { }
	// 			1. 리턴타입이 없다
	//			2. 사용자가 정의하지 않아도 시스템에서 자동으로 생성해준다.
	// 			3. 사용자가 정의한 생성자가 존재할 경우 반드시 기본 생성자를 앞에 선언해줘야한다.
	// 			
	// 생성자는 객체를 메모리에 할당하는 역할
	// 객체명 변수명 = new 객체명 ( ) ;
	// 함수 정의
	// 		(접근제어자) void 함수명 () {  } 리턴값이 없을때
	// 		(접근제어자) 리런할 자료의 형태 함수명 () {returb 자료형의 값}
	// 함수 사용법
	// 		리턴타입이 없을때 : 함수명( );
	//		리턴타입이 있을 때 : 자료형 변수명 = 함수명( );
	
	int studentNo;
	String studentName;
	int grade;
	private char gender; // DB연동을 위해 제일 작은 타입을 사용한다
	
	
	//	Student() {} 매개변수를 지정할 경우 이 기본형을 꼭 적어준다

	
//	Student() {
//		this.grade =1;
//		this.gender ='M';
//	}
	
	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	//프로퍼티 초기화 하는getter setter
	public char getGender() {
		return this.gender; //this 는 객체 자기 자신 
	}
	
	public void setGender(char gender) { // 선언시점에는 매개변수
		this.gender = gender; // 사용시점에는 인자, 인수
	}
	
//	public String getStudentInfo() {
//		return this.studentName + ":" + this.gender + ";" + this.grade;
////		return ""; // = null
//	}
	// string 기본형 
	// string 자료형은 참조 자료형으로 선언을 하지 않았을때 기본값이 null이라 그냥 null을 넣어도 오류가 안남
	// 기본 자료형은 각 자료형에 맞는 기본값이 들어간다.
	
//	public String[] getStudentIn() {
//		return null;
//	}
	// 배열 기본형 
}
