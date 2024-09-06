package chap11;

public interface C {
	
	public static final int a =1;
	//static final 컴파일러가 자동 삽입
	public int b =0;
	public static final String ip = "192.168.1.254";
	public static final int port =3306;
	
	//public void ccc(); // 이것도 가능 (컴파일러가 자동으로 abstract을 넣어준다)
//	public abstract void ccc();
	
	public abstract String getConnenction(String ip, int port) ;

}
