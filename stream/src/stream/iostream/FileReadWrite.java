package stream.iostream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class FileReadWrite {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File file = new File("D:\\java7\\java_test\\test.txt");
		
		// #FileReader를 이용한 파일 읽기
		try(Reader rd = new FileReader(file)){
			int data;
			while((data = rd.read()) != -1) {
				System.out.println((char)data);
			}
			
		}
		catch (IOException e) {
			
		}
		catch (Exception e) {
			
		}
		
		File ofile = new File("D:\\java7\\java_test\\test_out2.txt");
		// #FileWrite를 이용한 파일 읽기
		try(Writer wr = new FileWriter(ofile)){
			wr.write('J');
			wr.write('A');
			wr.write('V');
			wr.write('A');
			wr.write('\r');
			wr.write('\n');
			
			wr.flush();
			wr.close();
		}
	}

}
