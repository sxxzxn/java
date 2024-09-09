package chap14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

//	public static void main(String[] args) throws InterruptedException { 
//		
//		 Throwable 가 최상위 객체
//		
//		
//		throws InterruptedException { -> 동작중에 치고들어온다? 예외를 중단시킨다
//	Thread.sleep(1000);

//	public static void main(String[] args) throws ClassNotFoundException {
//		Class cls = Class.forName("java.lang.Object");
//		
//	}

//	입출력오류
//	public static void main (String[] args) throws IOException {
//		InputStreamReader isr = new InputStreamReader(System.in);
//		isr.read();
//	}

//	public static void main (String[] args) throws FileNotFoundException {
//		FileInputStream fis = new FileInputStream("text.text");	
//		}
//	
//	Exception만 사용하지 않고 상황에 맞는 오류 단위중 가장 작은걸로 처리 

//	public static void main (String[] args) {
//		int a = 3;
//		int b = 0;
//		int c = 0;
//		c = a/b;
//		System.out.println(c);
//	}

//	int sum = Integer.parseInt("10!");
//	String a = null;
//	System.out.print();

//	public static void main (String[] args) {
//	InputStreamReader isr = null;
//	try{
//		isr = new InputStreamReader(System.in);
//		System.out.println(isr.read());
//
//	}catch(IOException e){
//		//예외처리
//		
//	}finally{
//		if (isr != null) {
//			try {isr.close();
//			}catch(IOException e){
//				//예외처리
//			}
//		}
//
//	}
//	try(InputStreamReader isr2 = new InputStreamReader(System.in);
//			){
//		System.out.println(isr2.read());
//		
//	}catch(IOException e){
//		//예외처리
//		
//	}
		
//		AClose aa = null;
//		try {
//			aa = new AClose("파일1");
//			aa.abc();
//			
//		}catch (Exception e) {
//			System.out.println("예외처리1");
//		}finally {
//			if(aa.rsc != null) {
//				try {
//					aa.close();
//				}catch(Exception e) {
//					
//				}
//			}
//		}
//		
//		try(AClose aa2 = new AClose("파일2");
//		){
//			
//		}catch (Exception e){
//			System.out.println("예외처리2");
//			}
//		
		
//		MyClass my1 = new MyClass();
//		MyClass my2 = new MyClass("예외메세지");

//		throw my1;
//		throw my2;
		
//		throw new MyClass();
//		throw new MyClass("예외메세지1-1");
	


}