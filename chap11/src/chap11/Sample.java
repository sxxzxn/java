package chap11;

import java.nio.file.spi.FileSystemProvider;

public class Sample {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		InnerClass aa = new InnerClass();
		InnerClass.B bb = aa.new B();
		System.out.println(bb.a);
		int aaa;
		System.out.println(aa.a);
	bb.abc();
	}
	
	
	

}
