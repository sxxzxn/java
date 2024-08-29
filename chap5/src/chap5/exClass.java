package chap5;

public class exClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int a = 0;
//		int aa [] = {1, 2, 3} ;
		
		// 자료형 변수명 [ ] = new 자료형 [사이즈]  참조 자료형 선언의 기본 구문
		// 인스턴스 : 생성된 개별 공간
		
		Student st = new Student(); 
		// 기본구문 참조자료형 변수명 = NEW 참조자료형 (); 
		// st 가 Student() 인스턴스화했다 -> 메모리에 자리잡았다-> 연산 가능
		// new 를 붙이면 서로 다른곳에 저장이 됨
		Student st2 = new Student();
		Student st3 = st;
		// 힙에 있는 데이터가 변경 st 3값으로 다 변경됨..
		
		st.setGender ('F');  
		st.setStudentName("홍길순");
		st.setGrade(5);
		st.setStudentNo(1);
		
		st2.setGender ('M');  
		st2.setStudentName("홍길동");
		st2.setGrade(1);
		st2.setStudentNo(2);
		
		
		st3.setGender('M');
		st3.setGrade(3);
		st3.setStudentName("홍길순3");
		st3.setStudentNo(9);
		
		
		System.out.println("--메모리 확인--");
		System.out.println(st);
		System.out.println(st2);
		System.out.println(st3);
		// 객체의 주소값
		
		
		System.out.println("--메모리 번지수, 해쉬코드로 16진수 확인--");
		System.out.println(System.identityHashCode(st));
		System.out.println(System.identityHashCode(st2));
		System.out.println(System.identityHashCode(st3));
		// ㅁ모리 번지값
		
		System.out.println(st.getGender());
		System.out.println(st.getGrade());
		System.out.println(st.getStudentName());
		System.out.println(st.getStudentNo());
		
		System.out.println("");

		System.out.println(st2.getGender());
		System.out.println(st2.getGrade());
		System.out.println(st2.getStudentName());
		System.out.println(st2.getStudentNo());

		
		System.out.println("");
		
		System.out.println(st3.getGender());
		System.out.println(st3.getGrade());
		System.out.println(st3.getStudentName());
		System.out.println(st3.getStudentNo());


		System.out.println("");
	

	
		
	}

}
