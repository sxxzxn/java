package chap5;

public class UnivStudent extends Student {

	public UnivStudent() {
		// TODO Auto-generated constructor stub
		this.name = "수진";
	}

	public UnivStudent(int sno) {
		super(sno);
		// TODO Auto-generated constructor stub
	}

	public UnivStudent(int sno, int no) {
		super(sno, no);
		// TODO Auto-generated constructor stub
	}

	public UnivStudent(int sno, int no, char gender) {
		super(sno, no, gender);
		// super( ) : 자기자신을 참조하는거 + this 메서드의 부모
		// super( ) : 부모의 프로퍼티, 메서드를 사용
		// TODO Auto-generated constructor stub
	}
	
	public String name;
	
	
	
	@Override
	public String getRider() {
		return "버스";
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public UnivStudent (String name) {
		this.name = name;
	}
	

}