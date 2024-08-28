package chap4;

public class study {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 2; i <= 5; i++) {
			System.out.print(String.format("%10s", i + "단"));
		}
		System.out.println();
		for (int j = 1; j <= 9; j++) {
		for (int i = 2; i <= 5; i++) {
				System.out.print(String.format("%10s", i + "X" + j + "=" + (i * j)));
			}
			System.out.println();

		}
		
		
//		int a;
//		System.out.print(a);
		
//		int [] a;
//		
//		a = new int(10);
		
		String a = "hello";
		String b = a;
		
		a = "hello, soojin";
		
		System.out.println(a);
		System.out.println(b);
		
	        
	       
	}

}
