package chap7.java7.chungae;

public class BooksInfo {
	String bookName;
	String writer;

	BooksInfo() {
	}

	BooksInfo(String bn, String wr) {
		this.bookName = bn;
		this.writer = wr;

	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void showBookInfo() {
		System.out.println("도서명 : " + this.bookName + "\t" + "저자 :" + this.writer);
	}

	//-------------------------------------------------------------
	
	public class people {
		String name;
		int age;

		public void eat() {

		};

		public void sleep() {

		};

	}

	public class student extends people {
		int schoolNo;

		public void goSchool() {
			
		};

	}

	public class worker extends people {
		int workNo;

		public void goWork() {
			
		};
	}
}
