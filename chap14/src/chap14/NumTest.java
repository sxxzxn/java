package chap14;


public class NumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Num n= new Num();
		 try {
			 	n.checkNum(99); // 범위를 넘는 값 테스트
	            n.checkNum(150); // 범위를 넘는 값 테스트
	            n.checkNum(-50); // 범위를 넘는 값 테스트
	        } catch (MinusException | OverException e) {
	            System.out.println(e.getMessage());

	        }

	}
}