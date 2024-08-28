package chap4;



public class Book {

		private String bookName;
		private String author;
		
		public Book() {}

		public Book(String bookName, String author) {
			this.bookName = bookName;
			this.author = author;
		}
		
		public String getBookName(String bookName) {
			return bookName;
		}
		
		public void setBookName(String bookName) {
			this.bookName = bookName;
		}

		
		
		public String getauthor(String author) {
			return author;
		}
		
		public void setauthor(String author) {
			this.author = author;
		}
		
		public void showBookInfo() {
			
			System.out.println(bookName + ":" + author);
		}

}
