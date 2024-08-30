package chap7.java7.chungae;

import java.util.ArrayList;

public class ArraySample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<BooksInfo> bookList = new ArrayList<BooksInfo>();
		bookList.add(new BooksInfo("삼체", "ㅎ")); 
		bookList.add(new BooksInfo("개미", "베르나르 베르베르"));
		bookList.add(new BooksInfo("어린왕자", "생택쥐베리"));

		
		for (int i=0; i<bookList.size(); i++) {
			BooksInfo bi = bookList.get(i);
			bi.showBookInfo();
		}
	}

}
